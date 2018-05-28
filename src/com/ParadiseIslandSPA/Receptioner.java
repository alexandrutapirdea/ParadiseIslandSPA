package com.ParadiseIslandSPA;

import java.util.*;

public class Receptioner 
{
	
	static Map<String, Client> clientMapTmp;
		
	
	public static void setNewClient(String email, String password, String nume, String prenume)
	{	
		Client clientTmp = new Client(email, nume, prenume);
		BazaDeDate.addNewClient(clientTmp, password);		
		
		clientMapTmp.put(clientTmp.getEmail(), clientTmp);
	}
	
	
	public static boolean loginClient(String email, String password)
	{
		
		return BazaDeDate.loginValidation(email, password);
	}
	
	public static String cumparareProdus(String idProdus, int cantitate, String email)
	{				
		return getClient(email).portofelulMeu.adaugaBilant(idProdus, cantitate);
	}
	
	//TO DO with JOHN
	public static List<DetaliiProdus> afisareProduse(String tipProdus)
	{
		//return BazaDeDate.getListaProduse(tipProdus);		
	}
	
	//TO DO with JOHN
	public static Client getClient(String email)
	{
		return clientMapTmp.get(email);
	}


	public static List<ProdusCumparat> getChitanta(String email)
	{
		List<ProdusCumparat> chitantaTmp =  getClient(email).getChitanta();
		
		//afisare TO DO WITH ALL
		
		getClient(email).portofelulMeu.reset();	
		
		clientMapTmp.remove(email);
		
		return chitantaTmp;
	}
	

}

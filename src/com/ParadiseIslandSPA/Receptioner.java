package com.ParadiseIslandSPA;

import java.util.*;

public class Receptioner 
{
	private Receptioner() {}
	static Map<String, Client> clientMapTmp;
	
	
	public static boolean setNewClient(String email, String password, String nume, String prenume)
	{	
		Client clientTmp = new Client(email, nume, prenume);
		BazaDeDate.addNewClient(clientTmp, password);		
		System.out.println("email " + email + "passwrod " + password + 
				            "nume " + nume + "prenume " + prenume) ;
		
		if(BazaDeDate.addNewClient(clientTmp, password))
			{
			clientMapTmp.put(clientTmp.getEmail(), clientTmp);
			 return true;
			}
		else
			return false;
	}
	
	
	public static boolean loginClient(String email, String password)
	{
		System.out.println("email " + email + "  " + "password " + password);
		return BazaDeDate.loginValidation(email, password);
	}
	
	public static String cumparareProdus(String idProdus, int cantitate, String email)
	{				
		return getClient(email).portofelulMeu.adaugaBilant(idProdus, cantitate);
	}
	
	//TO DO with JOHN
	public static List<DetaliiProdus> afisareProduse(String tipProdus)
	{
		return BazaDeDate.getListaProduse(tipProdus);		
	}
	
	//TO DO with JOHN
	public static Client getClient(String email)
	{
		return clientMapTmp.get(email);
	}
	
	public static String requestAcces(String idZona, String email)
	{
		return getClient(email).requestAcces(idZona);
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

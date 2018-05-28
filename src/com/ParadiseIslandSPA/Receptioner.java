package com.ParadiseIslandSPA;

import java.util.*;

public class Receptioner 
{
	
	Client clientTmp;
	
	//TO DO with JOHN
	public void setNewClient(String email, String password, String nume, String prenume)
	{		
		BazaDeDate.Add(new Client(email, password, nume, prenume);
		clientTmp = BazaDeDate.getClientByEmail(email);
	}
	
	//TO DO with JOHN
	public void getClient(String email)
	{
		clientTmp = BazaDeDate.getClientByEmail(email);
	}


	public void getChitanta()
	{
		List<ProdusCumparat> chitantaTmp =  clientTmp.getChitanta();
		
		//afisare TO DO WITH ALL
		
		clientTmp.portofelulMeu.reset();	
	}	

}

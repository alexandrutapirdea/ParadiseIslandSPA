package com.ParadiseIslandSPA;

import java.util.*;

public class Receptioner 
{
	static Map<String, Client> clientMapTmp = new HashMap<String, Client>();;
	static Map<Integer, Boolean> tmpIdMap = new HashMap<Integer, Boolean>();;
	static Integer maxId = 6000;
	
	private Receptioner() 
	{
		
	}
	
	//inregistrare client
	public static boolean setNewClient(String email, String password, String nume, String prenume)
	{	
		Client clientTmp = new Client(email, nume, prenume);
		
		BazaDeDate.addNewClient(clientTmp, password);	
		
		//System.out.println("email " + email + "passwrod " + password + "nume " + nume + "prenume " + prenume) ;
		
		if(BazaDeDate.addNewClient(clientTmp, password))
		{
			clientMapTmp.put(clientTmp.getEmail(), clientTmp);
			
			return true;
		}
		else
			return false;
	}
	
	//login si asignare id-uri unice
	public static boolean loginClient(String email, String password)
	{
		//System.out.println("email " + email + "  " + "password " + password);
		
		
		if(BazaDeDate.loginValidation(email, password))
		{
			if(!clientMapTmp.containsKey(email))
			{
				Client clientTmp = new Client(email, "", "");
				clientMapTmp.put(email, clientTmp);
			}
		
			int i;
		 
				for(i = 1000; i < maxId; i++)
				{
					
					if(tmpIdMap.containsKey(i))						
					{
						if(tmpIdMap.get(i))
						{
							getClient(email).setIdTmp(i);
							tmpIdMap.put(i, false);
							break;
						}
					}
					else
					{
						tmpIdMap.put(i, true);
						getClient(email).setIdTmp(i);
						break;
					}
				}
				
			if(i == maxId)
				return false;
					
			return true;
		}
		else
			return false;
	}
	
	public static Boolean cumparareProdus(List<DetaliiProdus> dpList, String email)
	{				
		return getClient(email).cumparareProdus(dpList);
	}
	
	public static List<DetaliiProdus> afisareProduse(String tipProdus)
	{
		return BazaDeDate.getListaProduse(tipProdus);		
	}
	
	public static List<String> afisareCategorii()
	{
		List<String> typeList = new LinkedList<String>();
		typeList.add("Zona");
		typeList.add("Bar");
		typeList.add("Restaurant");
		typeList.add("Servicii");
		
		return typeList;
	}
	
	public static Client getClient(String email)
	{
		return clientMapTmp.get(email);
	}
	
	//acces in zone
	public static boolean requestAcces(String idZona, String email)
	{
		return getClient(email).requestAcces(idZona);
	}
	
	public static double getBilantClient(String email)
	{
		return getClient(email).getPortofelulMeu().getBilant();
	}

	public static List<DetaliiProdus> getChitanta(String email)
	{
		tmpIdMap.replace(getClient(email).getIdTmp(), false);
		
		List<DetaliiProdus> chitantaTmp =  getClient(email).getChitanta();
				
		
		getClient(email).getPortofelulMeu().reset();	
		
		clientMapTmp.remove(email);
		
		return chitantaTmp;
	}
	

}

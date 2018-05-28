package com.ParadiseIslandSPA;

import java.util.*;

public class Client 
{
	String email;
	String prenume;
	String nume;
	PortofelVirtual portofelulMeu;
	String zona = "";

	public Client(String e, String p, String n)
	{
		email = e;
		prenume = p;
		nume = n;
		
		portofelulMeu = new PortofelVirtual();		
	}
	
	public String getEmail()
	{
		return email;
	}

	String cumparareProdus(String idProdus, int cantitate)
	{				
		return portofelulMeu.adaugaBilant(idProdus, cantitate);
	}
	
	public List<ProdusCumparat> getChitanta()
	{
		return portofelulMeu.getChitanta();
	}
	
	//To Do return boolean
	public String requestAcces(String idZona)
	{
		try		
		{
			portofelulMeu.getProdus(idZona);
			
			String zonaTmp = zona; 
			zona = portofelulMeu.getProdus(idZona).getNumeProdus();
			
			if(zona == zonaTmp)
				return "Sunteti deja in aceasta zona";
			
			if(zona == "ZonaA")
				ZoneStats.nrPersoaneZonaA++;
			else if(zona == "ZonaB")
				ZoneStats.nrPersoaneZonaB++;
			else if(zona == "ZonaC")
				ZoneStats.nrPersoaneZonaB++;
			else if(zona == "ZonaD")
				ZoneStats.nrPersoaneZonaB++;
			
			if(zonaTmp == "ZonaA")
				ZoneStats.nrPersoaneZonaA--;
			else if(zonaTmp == "ZonaB")
				ZoneStats.nrPersoaneZonaB--;
			else if(zonaTmp == "ZonaC")
				ZoneStats.nrPersoaneZonaB--;
			else if(zonaTmp == "ZonaD")
				ZoneStats.nrPersoaneZonaB--;
			
			return "Acces aprobat";
		}catch(Exception e)
		{
			return "Accesul nu va este permis in aceasta zona";
		}
	}

}

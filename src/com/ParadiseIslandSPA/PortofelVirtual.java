package com.ParadiseIslandSPA;

import java.util.*;

public class PortofelVirtual 
{
	//TO DO commit bilant to db
	double bilant;
	Map<String,ProdusCumparat> chitanta;
	
	public PortofelVirtual()
	{
		bilant = 0;
	}
	
	public void reset()
	{
		bilant = 0;
	}
	
	public String adaugaBilant(String idProdus, int cantitate)
	{
	
		Double suma = cantitate * (BazaDeDate.getProdusById(idProdus).getPretProdus());
		
		try
		{
			ProdusCumparat produsExistent =  chitanta.get(idProdus); 
			produsExistent.setCantitateProdus(cantitate);
			chitanta.put(idProdus, produsExistent);								
				
		}catch(Exception e)
		{
			ProdusCumparat produsCumparatTmp = new ProdusCumparat(idProdus, cantitate);
			chitanta.put(idProdus, produsCumparatTmp);	
			
		}finally
		{
			bilant += suma;
		 	return "Tranzactie completatata cu succes! Bilant: " + bilant + " RON"; 
		}		
	}
	
	public ProdusCumparat getProdus(String idProdus)
	{
		return chitanta.get(idProdus);
	}
	
	public List<ProdusCumparat> getChitanta()
	{
		List<ProdusCumparat> pcListTmp = new LinkedList<ProdusCumparat>(); 
		
		for(String idTmp : chitanta.keySet())
		{
			pcListTmp.add(chitanta.get(idTmp));
		}
		
		return pcListTmp;
	}

	
}

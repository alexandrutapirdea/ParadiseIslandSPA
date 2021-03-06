package com.ParadiseIslandSPA;

import java.util.*;

public class PortofelVirtual 
{	
	private double bilant;
	private Map<String, DetaliiProdus> chitanta; 
	
	public PortofelVirtual()
	{
		bilant = 0;
		chitanta = new HashMap<String, DetaliiProdus>();
	}
	
	public void reset()
	{
		bilant = 0;
		chitanta.clear();
	}
	
	public Boolean adaugaBilant(List<DetaliiProdus> dpList)
	{
	
		for(DetaliiProdus dpTmp : dpList)
		{	
			Double suma = dpTmp.getCantitateProdus() * dpTmp.getPretProdus();
			
			if(chitanta.containsKey(dpTmp.getIdProdus()))
			{
				chitanta.get(dpTmp.getIdProdus()).updateProdus(dpTmp.getCantitateProdus());	
			}
			else
			{				
				chitanta.put(dpTmp.getIdProdus(), dpTmp);				
			}
			
				bilant += suma;			 	
			
		}
		
		return true; 
	}
	
	public DetaliiProdus getProdus(String idProdus)
	{
		return chitanta.get(idProdus);
	}
	
	public double getBilant()
	{
		return bilant;
	}
	
	public List<DetaliiProdus> getChitanta()
	{
		List<DetaliiProdus> pcListTmp = new LinkedList<DetaliiProdus>(); 
		
		for(String idTmp : chitanta.keySet())
		{
			pcListTmp.add(chitanta.get(idTmp));
		}
		
		return pcListTmp;
	}
	
	
}

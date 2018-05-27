package com.ParadiseIslandSPA;

public class DetaliiProdus 
{
	String numeProdus;
	String tipProdus;
	double pretProdus;
	
	public DetaliiProdus(String numeProdus, String tipProdus, double pretProdus) 
	{
		super();
		this.numeProdus = numeProdus;
		this.tipProdus = tipProdus;
		this.pretProdus = pretProdus;
	}

	
	public String getNumeProdus() 
	{
		return numeProdus;
	}
	
	
	public String getTipProdus() 
	{
		return tipProdus;
	}
	

	public double getPretProdus() 
	{
		return pretProdus;
	}

	
}

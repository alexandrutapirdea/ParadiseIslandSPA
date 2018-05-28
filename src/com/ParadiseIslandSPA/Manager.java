package com.ParadiseIslandSPA;

import java.util.*;

public class Manager 
{
	public Map<String,Integer> getZoneStatus()
	{
		Map<String,Integer> statsMapTmp;
		
		statsMapTmp.put("ZonaA", ZoneStats.nrPersoaneZonaA);
		statsMapTmp.put("ZonaB", ZoneStats.nrPersoaneZonaB);
		statsMapTmp.put("ZonaC", ZoneStats.nrPersoaneZonaC);
		statsMapTmp.put("ZonaD", ZoneStats.nrPersoaneZonaD);
		
		return statsMapTmp;
	}
}

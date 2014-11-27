package com.webtools.gmap.util;

import java.util.HashMap;
import java.util.Map;

public enum MapType {
	ROADMAP("roadmap"),
	SATELLITE("satellite"),
	HYBRID("hybrid"),
	TERRIAN("terrain");
	
	private String mapType;
	private static Map<String,MapType> mapTypeMap;
	private MapType(String mapType)
	{
		this.mapType=mapType;
		addMap(this.mapType,this);
	}
	
	public String toString()
	{
		return mapType;
	}
	
	public static MapType getMapType(String mapType)
	{
		return mapTypeMap.get(mapType);
	}
	/*public static MapType getMapType(String mapType)
	{
		MapType tempMapType=null;
		if("roadmap".equals(mapType))
		{
			tempMapType=MapType.ROADMAP;
		}
		else if("hybrid".equals(mapType))
		{
			tempMapType=MapType.HYBRID;
		}
		else if("satellite".equals(mapType))
		{
			tempMapType=MapType.SATELLITE;
		}
		else if("terrain".equals(mapType))
		{
			tempMapType=MapType.TERRIAN;
		}
		return tempMapType;
	}	*/
	
	private void addMap(String maptype,MapType mapTypeEnum)
	{
		if(mapTypeMap==null)
		{
			mapTypeMap=new HashMap<String,MapType>();
		}	
			mapTypeMap.put(maptype,mapTypeEnum);
			
	}
}

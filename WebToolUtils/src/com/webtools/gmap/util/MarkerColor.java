package com.webtools.gmap.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abhijeet S Kushe
 * This enum specifies the colours which are represented
 * by the marker attribute in the markers parameter used in GoogleImageAPI
 * These are the possible colours for Markers in the Google Image API
 * black, brown, green, purple, yellow, blue, gray, orange, red, white
 *
 */
public enum MarkerColor {
	
	BLACK("black"),
	BROWN("brown"),
	PURPLE("purple"),
	GREEN("green"),
	YELLOW("yellow"),
	BLUE("blue"),
	GRAY("gray"),
	ORANGE("orange"),
	RED("red"),
	WHITE("white")
	;
	
	
	private String color;
	private static Map<String,MarkerColor> markerColorMap;
	private MarkerColor(String color)
	{
		this.color=color;
		addMap(this.color,this);
	}
	
	/* 
	 * Override toString
	 */
	public String toString()
	{
		return color;
	}
	
	public static MarkerColor getMarkerColor(String markerColor)
	{
		return markerColorMap.get(markerColor);
	}	 
	private void addMap(String color,MarkerColor markerColor)
	{
		if(markerColorMap==null)
		{	
			markerColorMap=new HashMap<String,MarkerColor>();
		}	
		markerColorMap.put(color,markerColor);
	}
}

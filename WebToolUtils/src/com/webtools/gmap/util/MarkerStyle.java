package com.webtools.gmap.util;

/**
 * @author Abhijeet S Kushe
 *This class specifies the values used in the style attribute
 *in the Marker parameter .The supported values are tiny, mid, small
 */
public enum MarkerStyle {TINY("tiny"),MID("mid"),SMALL("small");

	private String style; 
	private MarkerStyle(String style)
	{
		this.style=style;
		
	}
	
	public String toString()
	{
		return style;
	}
}

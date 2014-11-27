package com.webtools.gmap.util;


import com.webtools.generic.AbstractDTO;

public class Path extends AbstractDTO {
	
	private long weight;
	private MarkerColor color;
	private MarkerColor fillColor;
	private MapAddress[] address;
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public MarkerColor getColor() {
		return color;
	}
	public void setColor(MarkerColor color) {
		this.color = color;
	}
	public MarkerColor getFillColor() {
		return fillColor;
	}
	public void setFillColor(MarkerColor fillColor) {
		this.fillColor = fillColor;
	}
	public MapAddress[] getAddress() {
		return address;
	}
	public void setAddress(MapAddress[] address) {
		this.address = address;
	}
	
}

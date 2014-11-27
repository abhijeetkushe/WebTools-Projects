package com.webtools.gmap.util;

import java.io.Serializable;
import java.util.Collection;

public class LocationMap implements Serializable{

	private String formId;
	private String description;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String width="350";
	private String height="350";
	private String zoom="15";
	private String mapType="roadmap"; 
	private String imageURL;
	private int colorCount=-1;
	private int labelCount=-1;
	private String mapName;
	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	/**
	 * @return the colorCount
	 */
	public int getColorCount() {
		return colorCount;
	}

	/**
	 * @param colorCount the colorCount to set
	 */
	public void setColorCount(int colorCount) {
		this.colorCount = colorCount;
	}

	/**
	 * @return the labelCount
	 */
	public int getLabelCount() {
		return labelCount;
	}

	/**
	 * @param labelCount the labelCount to set
	 */
	public void setLabelCount(int labelCount) {
		this.labelCount = labelCount;
	}

	private Collection<Location> locationCollection;
	/**
	 * @return the locationCollection
	 */
	public Collection<Location> getLocationCollection() {
		return locationCollection;
	}

	/**
	 * @param locationCollection the locationCollection to set
	 */
	public void setLocationCollection(Collection<Location> locationCollection) {
		this.locationCollection = locationCollection;
	}

	public String getImageURL() {
		return imageURL;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formId == null) ? 0 : formId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocationMap)) {
			return false;
		}
		LocationMap other = (LocationMap) obj;
		if (formId == null) {
			if (other.formId != null) {
				return false;
			}
		} else if (!formId.equals(other.formId)) {
			return false;
		}
		return true;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getZoom() {
		return zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	private String marker;

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	
	public void incrementCounters()
	{
		colorCount++;
		labelCount++;
	}
	
	public void clearFields()
	{
		
		description=null;
		streetAddress=null;
		city=null;
		state=null;
		zipCode=null;
		width="350";
		height="350";
		zoom="15";
		mapType="roadmap"; 
		imageURL=null;
		colorCount=-1;
		labelCount=-1;
		mapName=null;
	}
}

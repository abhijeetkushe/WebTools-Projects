package com.webtools.gmap.util;

import java.io.Serializable;

public class Location implements Serializable{

	private String markerDescription;
	private String markercolor;
	private String markerLabel;
	private String markerAddress;
	public String getMarkerAddress() {
		return markerAddress;
	}
	public void setMarkerAddress(String markerAddress) {
		this.markerAddress = markerAddress;
	}
	public String getMarkerDescription() {
		return markerDescription;
	}
	public void setMarkerDescription(String markerDescription) {
		this.markerDescription = markerDescription;
	}
	public String getMarkercolor() {
		return markercolor;
	}
	public void setMarkercolor(String markercolor) {
		this.markercolor = markercolor;
	}
	public String getMarkerLabel() {
		return markerLabel;
	}
	public void setMarkerLabel(String markerLabel) {
		this.markerLabel = markerLabel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((markerAddress == null) ? 0 : markerAddress.hashCode());
		result = prime
				* result
				+ ((markerDescription == null) ? 0 : markerDescription
						.hashCode());
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
		if (!(obj instanceof Location)) {
			return false;
		}
		Location other = (Location) obj;
		if (markerAddress == null) {
			if (other.markerAddress != null) {
				return false;
			}
		} else if (!markerAddress.equals(other.markerAddress)) {
			return false;
		}
		if (markerDescription == null) {
			if (other.markerDescription != null) {
				return false;
			}
		} else if (!markerDescription.equals(other.markerDescription)) {
			return false;
		}
		return true;
	}
	
}

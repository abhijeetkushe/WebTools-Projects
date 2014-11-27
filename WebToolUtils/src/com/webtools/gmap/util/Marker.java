package com.webtools.gmap.util;

import com.webtools.generic.AbstractDTO;

public class Marker extends AbstractDTO {

	private MarkerColor color;
	private String label;
	private MapAddress address;

	public MapAddress getAddress() {
		return address;
	}

	public void setAddress(MapAddress address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		if (!(obj instanceof Marker)) {
			return false;
		}
		Marker other = (Marker) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		return true;
	}

	private MarkerStyle style=MarkerStyle.MID;

	public MarkerColor getColor() {
		return color;
	}

	public void setColor(MarkerColor color) {
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	

	public MarkerStyle getStyle() {
		return style;
	}

	public void setStyle(MarkerStyle style) {
		this.style = style;
	}

}

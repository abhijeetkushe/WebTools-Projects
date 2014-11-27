package com.webtools.gmap.util;

import com.webtools.generic.AbstractDTO;

public class MapAddress extends AbstractDTO {

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (latitude ^ (latitude >>> 32));
		result = prime * result + (int) (longitude ^ (longitude >>> 32));
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
		if (!(obj instanceof MapAddress)) {
			return false;
		}
		MapAddress other = (MapAddress) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (latitude != other.latitude) {
			return false;
		}
		if (longitude != other.longitude) {
			return false;
		}
		return true;
	}

	private String address;
	private long longitude;
	private long latitude;
	private boolean addressEntered;

	public MapAddress(String address) {
		this.address = address;
		this.addressEntered = true;
	}

	public MapAddress(long longitude, long latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public boolean isAddressEntered() {
		return addressEntered;
	}

	public void setAddressEntered(boolean addressEntered) {
		this.addressEntered = addressEntered;
	}

	public String toString()
	{
		if(this.addressEntered)
		{
			return this.address; 
		}
		else
		{
			return this.latitude+","+this.longitude;
		}
	}
	
}

package com.webtools.gmap.util;

import com.webtools.generic.AbstractDTO;

public class Center extends AbstractDTO{

     private String address;
	 private long longitude;
     private long latitude;
     private boolean addressEntered;
     public Center(String address)
     {
    	 this.address=address;
    	 this.addressEntered=true;
     }
     
     public Center(long longitude,long latitude)
     {
    	 this.longitude=longitude;
    	 this.latitude=latitude;
     }

	public boolean isAddressEntered() {
		return addressEntered;
	}

	public void setAddressEntered(boolean addressEntered) {
		this.addressEntered = addressEntered;
	}
     
      
}

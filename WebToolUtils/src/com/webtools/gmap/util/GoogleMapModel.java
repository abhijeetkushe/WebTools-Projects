package com.webtools.gmap.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.webtools.generic.AbstractDTO;


public class GoogleMapModel extends AbstractDTO {
	public  final MarkerColor[] colorArray = MarkerColor.values();
	private  byte colorCount=-1, labelCount=-1;
	private  final String[] strArray = new String[26];

	 {
		for (int i = 65; i <= 90; i++) {
			strArray[i-65] = String.valueOf((char) i);
		}
	}

	public  MarkerColor getMarkerColor() {
		MarkerColor markerColor = null;
		colorCount = (byte) ((++colorCount) % colorArray.length);
		markerColor = colorArray[colorCount];
		return markerColor;
	}

	public  String getLabel() {
		String markerLabel = null;
		labelCount = (byte) ((++labelCount) % strArray.length);
		markerLabel = strArray[labelCount];
		return markerLabel;
	}

	public Location generateGoogleImage(LocationMap locMap,
			Collection<Location> locationCollection) {
		Location returnLocation = new Location();

		GoogleImage gimage = new GoogleImage();
		if (locMap != null) {
			gimage.setHsize((locMap.getWidth() != null || !"".equals(locMap
					.getWidth())) ? Short.parseShort(locMap.getWidth())
					: (short) 500);
			gimage.setVsize((locMap.getHeight() != null || !"".equals(locMap
					.getHeight())) ? Short.parseShort(locMap.getHeight())
					: (short) 500);
			gimage.setMapType(MapType.getMapType(locMap.getMapType()));
			gimage.setZoom((locMap.getZoom() != null || !"".equals(locMap
					.getZoom())) ? Byte.parseByte(locMap.getZoom()) : (byte) 15);
		}

		Set<Marker> markerSet = new HashSet<Marker>(10);
		if (locationCollection != null && locationCollection.size() > 0) {
			for (Location tempLocation:locationCollection) {
				if(tempLocation!=null)
				{	
					Marker marker1 = new Marker();
					marker1.setAddress(new MapAddress(tempLocation
						.getMarkerAddress()));
					marker1.setColor(getMarkerColor());
					marker1.setLabel(tempLocation.getMarkerLabel());
					markerSet.add(marker1);
				}	
			}
		}
		
		gimage.setMarkers(markerSet);
		StringBuilder imageURL = GoogleImageUtil.generateImageURL(gimage);
		locMap.setImageURL(imageURL.toString());
		return returnLocation;
	}
	
	public static String formatAddress(LocationMap locMap)
	{
		String returnAddress;
		returnAddress=locMap.getStreetAddress()+","
						+locMap.getCity()
						+","+locMap.getState()
						+","+locMap.getZipCode();
		return returnAddress;
	}
}

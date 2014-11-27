package com.webtools.gmap.util;

import java.util.ArrayList;

public class GoogleImageTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		GoogleImage gImage=new GoogleImage();
		gImage.setZoom((byte)12);
		gImage.setHsize((short)300);
		gImage.setVsize((short)300);
		
		ArrayList<Marker> markerList=new ArrayList<Marker>(4);
		Marker marker1=new Marker();
		marker1.setColor(MarkerColor.RED);
		marker1.setLabel("S");
		marker1.setAddress(new MapAddress("45 Westland Avenue,Boston,MA"));
		marker1.setStyle(MarkerStyle.MID);
		markerList.add(marker1);
		
		Marker marker2=new Marker();
		marker2.setColor(MarkerColor.BLUE);
		marker2.setLabel("B");
		marker2.setAddress(new MapAddress("38 Clearway Street,Boston,MA"));
		marker2.setStyle(MarkerStyle.MID);
		markerList.add(marker2);
		
		Marker marker3=new Marker();
		marker3.setColor(MarkerColor.RED);
		marker3.setLabel("C");
		marker3.setAddress(new MapAddress("360 Huntington Avenue,Boston,MA"));
		marker3.setStyle(MarkerStyle.MID);
		markerList.add(marker3);
		gImage.setMarkers(markerList);
		gImage.setMapType(MapType.ROADMAP);
		
		
		
		MapAddress mapAddress1=new MapAddress("45 Westland Avenue,Boston,MA");
		MapAddress mapAddress2=new MapAddress("38 Clearway Street,Boston,MA");
		MapAddress[] mapAddress=new MapAddress[]{mapAddress1,mapAddress2};
		
		//Make path
		Path p=new Path();
		p.setAddress(mapAddress);
		p.setColor(MarkerColor.BLUE);
		p.setWeight(4);
		gImage.setPath(p);
		StringBuilder sb=GoogleImageUtil.generateImageURL(gImage);
		System.out.println("The url generetaed"+sb.toString());
		
	}

}

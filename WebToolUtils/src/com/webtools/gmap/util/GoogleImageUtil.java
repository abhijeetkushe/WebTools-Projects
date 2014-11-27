package com.webtools.gmap.util;

import java.util.Collection;

/**
 * @author Admin
 *
 */
public class GoogleImageUtil {
	
	private static final String GOOGLE_MAP_ADDR="http://maps.google.com/maps/api/staticmap?"
		
		+"zoom=%1$d"
		+"&size=%2$s"
		+"&maptype=%3$s"
		+"&sensor=%4$b";
	private static final String RESOLUTION_MARKER="x";	
//	+"center=Brooklyn+Bridge,New+York,NY" 
//	+"&zoom=14"
//	+"&size=512x512" 
//	+"&maptype=roadmap"
//	+"&markers=color:blue|label:S|40.702147,-74.015794" 
//	+"&markers=color:green|label:G|40.711614,-74.012318"
//	+"&markers=color:red|color:red|label:C|40.718217,-73.998284" 
//	+"&sensor=false"
	
	public static StringBuilder generateImageURL(GoogleImage gImage)
	{
		StringBuilder returnImage=new StringBuilder(100);
		if(gImage!=null)
		{	
			returnImage.append(String.format(GOOGLE_MAP_ADDR,(int)gImage.getZoom(),gImage.getHsize()+RESOLUTION_MARKER+gImage.getVsize(),gImage.getMapType().toString(),gImage.isSensor()));
			if(gImage.getMarkers()!=null && gImage.getMarkers().size()>0)
			{
				Collection<Marker> gImageCollec=gImage.getMarkers();
				for(Marker tempMarker:gImageCollec)
				{	
					if(tempMarker!=null)
					{	
						returnImage.append("&");
						returnImage.append("markers=");
						returnImage.append("color:"+tempMarker.getColor().toString());
						returnImage.append("|");
						returnImage.append("label:"+tempMarker.getLabel());
						returnImage.append("|");
						returnImage.append(""+tempMarker.getAddress().toString());
					}
					else
					{
						break;						
					}	
				}	
			}	
			
			
			Path p=gImage.getPath();
			if(p!=null)
			{	returnImage.append("&path=");
				returnImage.append("color:"+p.getColor());
				returnImage.append("|");
				returnImage.append("weight:"+p.getWeight());
				
			
				for(int i=0;i<p.getAddress().length;i++)
				{
					returnImage.append("|");
					MapAddress mapAddr1=p.getAddress()[i];
					returnImage.append(""+mapAddr1);
				}
			}	
			
		}
		else
		{
			
		}
		return returnImage;
		
	}
}

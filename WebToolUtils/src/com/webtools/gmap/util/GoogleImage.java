/**
 * 
 */
package com.webtools.gmap.util;

import java.util.Collection;

import com.webtools.generic.AbstractDTO;

/**
 * @author Admin
 *
 */
public class GoogleImage extends AbstractDTO {
	
	 private MapAddress center;
	 private byte zoom=15;
	 private short hsize=400;
	 private short vsize=400;
	 private MapType mapType=MapType.ROADMAP;
	 private Collection<Marker> markers;
	 private Path path;
	 private boolean sensor=false;
	public boolean isSensor() {
		return sensor;
	}
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	public MapAddress getCenter() {
		return center;
	}
	public void setCenter(MapAddress center) {
		this.center = center;
	}
	public byte getZoom() {
		return zoom;
	}
	public void setZoom(byte zoom) {
		this.zoom = zoom;
	}
	public short getHsize() {
		return hsize;
	}
	public void setHsize(short hsize) {
		this.hsize = hsize;
	}
	public short getVsize() {
		return vsize;
	}
	public void setVsize(short vsize) {
		this.vsize = vsize;
	}
	public MapType getMapType() {
		return mapType;
	}
	public void setMapType(MapType mapType) {
		this.mapType = mapType;
	}
	public Collection<Marker> getMarkers() {
		return markers;
	}
	public void setMarkers(Collection<Marker> markers) {
		this.markers = markers;
	}
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}   
  
}

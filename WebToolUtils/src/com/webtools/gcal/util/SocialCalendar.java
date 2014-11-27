package com.webtools.gcal.util;

import com.webtools.generic.AbstractDTO;

public class SocialCalendar extends AbstractDTO{

	private String title;
	private String summary;
	private String timeZone;
	private boolean hidden;
	private String locationValue="";
	private String locationLabel="";
	private String color;
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}
	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}
	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	/**
	 * @return the locationValue
	 */
	public String getLocationValue() {
		return locationValue;
	}
	/**
	 * @param locationValue the locationValue to set
	 */
	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}
	/**
	 * @return the locationLabel
	 */
	public String getLocationLabel() {
		return locationLabel;
	}
	/**
	 * @param locationLabel the locationLabel to set
	 */
	public void setLocationLabel(String locationLabel) {
		this.locationLabel = locationLabel;
	}
	
	
}

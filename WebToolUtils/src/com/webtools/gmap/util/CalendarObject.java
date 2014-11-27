package com.webtools.gmap.util;

import com.webtools.generic.AbstractDTO;

public class CalendarObject extends AbstractDTO {

	private String calLabel;
	private String calValue;
	/**
	 * @return the calLabel
	 */
	public String getCalLabel() {
		return calLabel;
	}
	/**
	 * @param calLabel the calLabel to set
	 */
	public void setCalLabel(String calLabel) {
		this.calLabel = calLabel;
	}
	/**
	 * @return the calValue
	 */
	public String getCalValue() {
		return calValue;
	}
	/**
	 * @param calValue the calValue to set
	 */
	public void setCalValue(String calValue) {
		this.calValue = calValue;
	}
}

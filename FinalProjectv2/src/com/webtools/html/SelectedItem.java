package com.webtools.html;

import java.io.Serializable;

public class SelectedItem implements Serializable {

	private String label;
	private String value;
	
	public SelectedItem()
	{
		
	}
	
	public SelectedItem(String label)
	{
		this.label=label;
		this.value=label;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}

package com.webtools.gcal.util;

class Hour implements Comparable<Hour>
{
	private String hourLabel;
	private int hourValue;
	public Hour()
	{}
	
	public Hour(String hourLabel,int hourValue)
	{
		this.hourLabel=hourLabel;
		this.hourValue=hourValue;
	}
		
	/**
	 * @return the hourLabel
	 */
	public String getHourLabel() {
		return hourLabel;
	}
	/**
	 * @param hourLabel the hourLabel to set
	 */
	public void setHourLabel(String hourLabel) {
		this.hourLabel = hourLabel;
	}
	/**
	 * @return the hourValue
	 */
	public int getHourValue() {
		return hourValue;
	}
	/**
	 * @param hourValue the hourValue to set
	 */
	public void setHourValue(int hourValue) {
		this.hourValue = hourValue;
	}
	
	public int compareTo(Hour hour)
	{
		if(hour !=null)
		{
			if(this.hourValue<hour.getHourValue())
			{
				return -1;
			}
			else if(this.hourValue==hour.getHourValue())
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			return 1;
		}	
	}
}

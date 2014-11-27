package com.webtools.gcal.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

import com.webtools.gmap.util.CalendarObject;

public class CalendarConstants {

	public static final String CONSTANT_APTNO="Apt No:";
	public static final String CONSTANT_STREET="Street Address:";
	public static final String CONSTANT_CITY="City:";
	public static final String CONSTANT_STATE="State:";
	public static final String CONSTANT_ZIPCODE="Zip Code:";
	private static final Hour[] CONSTANT_HOUR_LIST=new Hour[]{
		new Hour("0",0),new Hour("1",1),new Hour("22",22),new Hour("23",23),
		new Hour("2",2),new Hour("3",3),new Hour("4",4),new Hour("5",5),
		new Hour("6",6),new Hour("7",7),new Hour("8",8),new Hour("9",9),
		new Hour("10",10),new Hour("11",11),new Hour("12",12),new Hour("13",13), 
		new Hour("14",14),new Hour("15",15),new Hour("16",16),new Hour("17",17),
		new Hour("18",18),new Hour("19",19),new Hour("20",20),new Hour("21",21)};
	
	static{
		Arrays.sort(CONSTANT_HOUR_LIST);
	}
	/**
	 * @return the constantHourList
	 */
	public Hour[] getConstantHourList() {
		return CONSTANT_HOUR_LIST;
	}
	
	public static Collection<CalendarObject> getCalendarCollection(Collection<String> colltitles)
	{
		Collection<CalendarObject> collCal=new LinkedHashSet<CalendarObject>();
		for(String calTitle:colltitles)
		{
			CalendarObject calObj=new CalendarObject();
			calObj.setCalLabel(calTitle);
			calObj.setCalValue(calTitle);
			collCal.add(calObj);
		}	
		return collCal;
	}
	
}



package com.webtools.factory.util;

public class URLFeedGenerator
{

	private static String URL_ID_CONSTANT="http://www.google.com/calendar/feeds/default/calendars/";
	private static String URL_FEED_CONSTANT="http://www.google.com/calendar/feeds/";
	
	public static String getFeedURL(String id)
	{
		String newFeedURL=id.replace(URL_ID_CONSTANT, URL_FEED_CONSTANT);
		StringBuilder newFeedURLsb=new StringBuilder(newFeedURL);
		newFeedURLsb.append("/private/full");
		return newFeedURLsb.toString();
			
	}
}

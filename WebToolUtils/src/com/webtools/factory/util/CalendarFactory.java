package com.webtools.factory.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.data.calendar.ColorProperty;
import com.google.gdata.data.calendar.HiddenProperty;
import com.google.gdata.data.calendar.TimeZoneProperty;
import com.google.gdata.data.extensions.Where;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.webtools.gcal.util.SocialCalendar;

public abstract class CalendarFactory {

	private static SocialCalendar socialCalendar=null;
	
	protected static final String URL_ALL_CALENDARS="https://www.google.com/calendar/feeds/default/allcalendars/full";
	protected static final String URL_OWN_CALENDARS="https://www.google.com/calendar/feeds/default/owncalendars/full";
	/*public static SocialCalendar getDefaultInstance()
	{
		if(socialCalendar!=null)
		{
			socialCalendar=new SocialCalendarImpl();
		}
		return socialCalendar;
	}*/
	

	
	public static Collection<CalendarEntry> getAllCalendars(String userName,String password)
	{
		Collection<CalendarEntry> calendarCollec=null;
		try
		{
			CalendarService myService = new CalendarService("exampleCo-exampleApp-1");
			myService.setUserCredentials(userName, password);

			// Send the request and print the response
			URL feedUrl = new URL(URL_ALL_CALENDARS);
			CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
			calendarCollec=resultFeed.getEntries();
		}
		catch(AuthenticationException e)
		{
			e.printStackTrace();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(ServiceException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return calendarCollec;
	}
	
	public static Collection<CalendarEntry> getPersonalCalendars(String userName,String password)
	{
		Collection<CalendarEntry> calendarCollec=null;
		try
		{
			CalendarService myService = new CalendarService("exampleCo-exampleApp-1");
			myService.setUserCredentials(userName, password);

			// Send the request and print the response
			URL feedUrl = new URL(URL_OWN_CALENDARS);
			CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
			calendarCollec=resultFeed.getEntries();
		}
		catch(AuthenticationException e)
		{
			e.printStackTrace();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(ServiceException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return calendarCollec;
	}
	
	
	public static CalendarEntry createCalendar(String username,String password)
	{
		CalendarEntry returnedCalendar =null;
		try
		{
			CalendarService calendarService=new CalendarService("exampleCo-exampleApp-1");
			calendarService.setUserCredentials(username, password);
			CalendarEntry calendar = new CalendarEntry();
			calendar.setTitle(new PlainTextConstruct("Public events"));
			calendar.setSummary(new PlainTextConstruct("This calendar contains the practice schedule and game times."));
			calendar.setTimeZone(new TimeZoneProperty("America/Los_Angeles"));
			calendar.setHidden(HiddenProperty.FALSE);
			calendar.setColor(new ColorProperty("#2952A3"));
			calendar.addLocation(new Where("","","Oakland"));

			// Insert the calendar
			URL postUrl = new URL(URL_ALL_CALENDARS);
			returnedCalendar = calendarService.insert(postUrl, calendar);
		}
		catch(AuthenticationException e)
		{
			e.printStackTrace();
		}
		catch(ServiceException e)
		{
			e.printStackTrace();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return returnedCalendar;
	}
	
	public static CalendarEntry getNamedCalendar(String title,String userName,String password)
	{
		CalendarEntry calEntry=null;
		CalendarService calService=new CalendarService("exampleCo-exampleApp-1");
		CalendarFeed calFeed=new CalendarFeed();
		
		return calEntry;
	}
//	public static SocialCalendar getCustomCalendar(Map<String,String> props)
//	{
//		
//	}
//	
}

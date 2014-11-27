package com.webtools.factory.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.TreeSet;

import com.google.gdata.client.Query;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.data.calendar.ColorProperty;
import com.google.gdata.data.calendar.HiddenProperty;
import com.google.gdata.data.calendar.TimeZoneProperty;
import com.google.gdata.data.extensions.When;
import com.google.gdata.data.extensions.Where;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.webtools.gcal.util.SocialCalendar;
import com.webtools.gcal.util.SocialCalendarEvent;

/** 
 * @author Abhijeet Kushe
 * Represents an instance of the Authenticated Calendar.Internally uses an Authenticated Calendar Service for all
 * operations.
 */
public class AuthenticatedCalendarFactory extends CalendarFactory implements Serializable{

	
	private CalendarService calendarService;
	private static String URL_PRIVATE_EVENT_CALENDAR = "https://www.google.com/calendar/feeds/%1$s/private/full";
	private static String URL_ALL_EVENT_CALENDAR="https://www.google.com/calendar/feeds/default/private/full";
	//private static String URL_ALL_WEBTOOLS_CALENDAR="http://www.google.com/calendar/feeds/fb4265k5uvdcn9jkmmbn59e6so%40group.calendar.google.com/private-2dbf33e8a8fb66076a1de6a9aa90c31e/basic";
	private static String URL_ALL_WEBTOOLS_CALENDAR="http://www.google.com/calendar/feeds/fb4265k5uvdcn9jkmmbn59e6so%40group.calendar.google.com/private/full";
	private static String FORMAT_DATE_TIME="yyyy-MM-dd HH:mm:ss-08:00";
	private static SimpleDateFormat sdf=new SimpleDateFormat(FORMAT_DATE_TIME);
	private String userName;
	private String password;
	private static ResourceBundle bundle=null; 
	private static String URL_STATIC_CALENDAR_DEFAULT="http://www.google.com/calendar/feeds/default/calendars/";
	
	{
		try
		{
			bundle=ResourceBundle.getBundle("resources.googlecalendar",new Locale("en","US"));
		}
		catch(Throwable e)
		{
			
		}
	}
	public AuthenticatedCalendarFactory(String userName,String password) throws AuthenticationException
	{
		this.userName=userName;
		this.password=password;
		calendarService=new CalendarService("exampleCo-exampleApp-1");
		calendarService.setUserCredentials(userName, password);
	}
	
	public Collection<CalendarEntry> getAllCalendars()
	{
		Collection<CalendarEntry> calendarCollec=null;
		try
		{
			// Send the request and print the response
			URL feedUrl = new URL(URL_ALL_CALENDARS);
			CalendarFeed resultFeed = calendarService.getFeed(feedUrl, CalendarFeed.class);
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
	
	public Collection<CalendarEntry> getPersonalCalendars()
	{
		Collection<CalendarEntry> calendarCollec=null;
		try
		{
			// Send the request and print the response
			URL feedUrl = new URL(URL_OWN_CALENDARS);
			CalendarFeed resultFeed = calendarService.getFeed(feedUrl, CalendarFeed.class);
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
	
	
	public CalendarEntry createCalendar(SocialCalendar socCal)
	{
		CalendarEntry returnedCalendar =null;
		try
		{
			if(socCal!=null)
			{	
				CalendarEntry calendar = new CalendarEntry();
				calendar.setTitle(new PlainTextConstruct(socCal.getTitle()));
				calendar.setSummary(new PlainTextConstruct(socCal.getSummary()));
				calendar.setTimeZone(new TimeZoneProperty(socCal.getTimeZone()));
				calendar.setHidden(HiddenProperty.FALSE);
				calendar.setColor(new ColorProperty(socCal.getColor()));
				calendar.addLocation(new Where("",socCal.getLocationLabel(),socCal.getLocationValue()));
				// Insert the calendar
				URL postUrl = new URL(URL_ALL_CALENDARS);
				returnedCalendar = calendarService.insert(postUrl, calendar);
			}	
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
	
	public CalendarEntry getNamedCalendar(String title)
	{
		CalendarEntry calEntry=null;
		try
		{
			if(title==null)
			{	
				URL url=new URL(URL_ALL_CALENDARS);
				/*CalendarQuery calQuery=new CalendarQuery(url);
				calQuery.setFullTextQuery(title);*/
				CalendarFeed feed=calendarService.getFeed(url, CalendarFeed.class);
				List<CalendarEntry> calEntryList=feed.getEntries();
				
				SINGLE:
				for(CalendarEntry tempCalentry:calEntryList)
				{
					if(tempCalentry.getTitle().getPlainText().equals(title))
					{
						calEntry=tempCalentry;
						break SINGLE;
					}
				}	
			}	
		}
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
		return calEntry;
	}
	
	public void addCalendarEvent(SocialCalendarEvent event)
	{
		try
		{
			if(event !=null)
			{
				URL url=new URL(String.valueOf(URL_ALL_WEBTOOLS_CALENDAR));
				CalendarEventEntry calevent=new CalendarEventEntry();
				calevent.setTitle(new PlainTextConstruct(event.getEventTitle()));
				calevent.setSummary(new PlainTextConstruct(event.getEventDescription().trim()));
				calevent.setContent(new PlainTextConstruct(event.getEventDescription()));
				
				//set the Location and Time
				
				
				DateTime startTime=getDateTimeFromDate(event.getEventStartTime());
				DateTime endTime=getDateTimeFromDate(event.getEventEndTime());
				
				Where where=new Where("","",event.getEventLocation());
			    When when=new When();
			    when.setStartTime(startTime);
			    when.setEndTime(endTime);
			    
			    //Add When and Where
			    calevent.addTime(when);
			    calevent.addLocation(where);
			    calendarService.insert(url, calevent);
			}    
		}
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
	}
	
	public Collection<SocialCalendarEvent> retrieveAllEvents()
	{
		Collection<SocialCalendarEvent> events=null;
		try
		{
			//URL feedUrl=new URL(String.format(URL_PRIVATE_EVENT_CALENDAR,this.userName));
			URL feedUrl=new URL(String.valueOf(URL_ALL_WEBTOOLS_CALENDAR));
			CalendarEventFeed eventFeed=calendarService.getFeed(feedUrl, CalendarEventFeed.class);
			events=mapEntries(eventFeed.getEntries());
		}
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
		return events;
	}
	
	public Collection<SocialCalendarEvent> retrieveQueriedEvents()
	{
		Collection<SocialCalendarEvent> events=null;
		try
		{
			//URL feedUrl=new URL(String.format(URL_PRIVATE_EVENT_CALENDAR,this.userName));
			URL feedUrl=new URL(String.format(URL_ALL_EVENT_CALENDAR,this.userName));
			Query myQuery = new Query(feedUrl);
			myQuery.setFullTextQuery("Web Tools");

			CalendarEventFeed eventFeed=calendarService.query(myQuery, CalendarEventFeed.class);
			events=mapEntries(eventFeed.getEntries());
		}
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
		return events;
	}
	
	private Collection<SocialCalendarEvent> mapEntries(List<CalendarEventEntry> list)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Collection<SocialCalendarEvent> socialCalSet=new TreeSet<SocialCalendarEvent>();
		for(CalendarEventEntry eventEntry:list)
		{
			SocialCalendarEvent event=new SocialCalendarEvent();
			event.setEventDescription(String.valueOf(eventEntry.getSummary()!=null?eventEntry.getSummary().getPlainText().trim():"No Description"));
			event.setEventTitle(String.valueOf(eventEntry.getTitle()!=null?eventEntry.getTitle().getPlainText().trim():"No Title"));
			event.setId(eventEntry.getId());
			List<When> whenList=eventEntry.getTimes();
			if(whenList!=null && whenList.size()>0)
			{
				When when=whenList.get(0);
				event.setEventStartTime(getDateFromDateTime(when.getStartTime()));
				event.setEventEndTime(getDateFromDateTime(when.getEndTime()));
				Calendar cal=Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
				cal.setTime(event.getEventStartTime());
				event.setEventStartHour(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
				event.setEventStartMin(String.valueOf(cal.get(Calendar.MINUTE)));
				event.setEventStartDate((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR));
				cal.setTime(event.getEventEndTime());
				event.setEventEndHour(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
				event.setEventEndMin(String.valueOf(cal.get(Calendar.MINUTE)));
				event.setEventEndDate((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR));
				
			}
			
			List<Where> whereList=eventEntry.getLocations();
			if(whereList!=null && !whereList.isEmpty())
			{
				Where where=whereList.get(0);
				event.setEventLocation(where.getValueString());
				//populateAddress(event.getEventLocation(),event);
				
			}
			socialCalSet.add(event);
		}
		
		return socialCalSet;
	}
	
	private static DateTime getDateTimeFromDate(Date date)
	{
		DateTime dateTime=new DateTime(date);
		return dateTime;
	}
	
	private static Date getDateFromDateTime(DateTime dateTime)
	{
		Date date=new Date(dateTime.getValue());
		return date;
	}
	
	

	
	public Map<String,Collection<SocialCalendarEvent>> retrieveEventsAllCalendars()
	{
		Map<String,Collection<SocialCalendarEvent>> calmap=new LinkedHashMap<String,Collection<SocialCalendarEvent>>();
		Collection<CalendarEntry> calEntries=getAllCalendars();
		for(CalendarEntry calEntry:calEntries)
		{
			Collection<SocialCalendarEvent> socCal=retrieveEventsForCalendar(calEntry.getId());
			calmap.put(calEntry.getTitle().getPlainText(), socCal);
		}	
		return calmap;
	}
	
	public Collection<SocialCalendarEvent> retrieveEventsForCalendarName(String calTitle)
	{
		Collection<SocialCalendarEvent> socEvents=new TreeSet<SocialCalendarEvent>();
		Collection<CalendarEntry> calEntries=getAllCalendars();
		String calID="";
		if(calTitle!=null)
		{	
			for(CalendarEntry calEntry:calEntries)
			{
				if(calTitle.toUpperCase().equals(calEntry.getTitle().getPlainText().toUpperCase()))
				{
					calID=calEntry.getId();
					break;
				}
			}
		}	
		socEvents=retrieveEventsForCalendar(calID);
		return socEvents;
	}
	
	private Collection<SocialCalendarEvent> retrieveEventsForCalendar(String feedURLID)
	{
		Collection<SocialCalendarEvent> socEvents=null;
		try
		{
			URL feedURL=new URL(URLFeedGenerator.getFeedURL(feedURLID));
			CalendarEventFeed eventFeed=calendarService.getFeed(feedURL, CalendarEventFeed.class);
			socEvents=mapEntries(eventFeed.getEntries());
		}	
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
		return socEvents;
	}
	
	public void addCalendarEventForNamedCalendar(SocialCalendarEvent event,String calTitle)
	{
	
		Collection<CalendarEntry> calEntries=getAllCalendars();
		String calID="";
		if(calTitle!=null)
		{	
			for(CalendarEntry calEntry:calEntries)
			{
				if(calTitle.toUpperCase().equals(calEntry.getTitle().getPlainText().toUpperCase()))
				{
					calID=calEntry.getId();
					break;
				}
			}
		}
		
		try
		{
			if(event !=null)
			{
				URL feedURL=new URL(URLFeedGenerator.getFeedURL(calID));
				CalendarEventEntry calevent=new CalendarEventEntry();
				calevent.setTitle(new PlainTextConstruct(event.getEventTitle()));
				calevent.setSummary(new PlainTextConstruct(event.getEventDescription().trim()));
				calevent.setContent(new PlainTextConstruct(event.getEventDescription()));
				
				//set the Location and Time
				
				
				DateTime startTime=getDateTimeFromDate(event.getEventStartTime());
				DateTime endTime=getDateTimeFromDate(event.getEventEndTime());
				
				Where where=new Where("","",event.getEventLocation());
			    When when=new When();
			    when.setStartTime(startTime);
			    when.setEndTime(endTime);
			    
			    //Add When and Where
			    calevent.addTime(when);
			    calevent.addLocation(where);
			    calendarService.insert(feedURL, calevent);
			}    
		}
		catch(MalformedURLException exe)
		{
			exe.printStackTrace();
		}
		catch(ServiceException exe)
		{
			exe.printStackTrace();
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
	}
	
}

package com.webtools.gcal.util;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.webtools.generic.AbstractDTO;
import com.webtools.gmap.util.CalendarObject;

public class SocialCalendarEvent extends AbstractDTO implements Comparable<SocialCalendarEvent>{

	private String calendar;
	
	
	private String eventTitle;
	
	private Date eventStartTime;
	
	private Date eventEndTime;
	
	private String eventLocation;
	
	private String eventDescription;;
	private String eventStreetAddress;
	private String eventCityAddress;
	private String eventStateAddress;
	private String eventZipCode;
	private String aptNo;
	private String id;
	private boolean marked;
	private String markedLabel;
	private boolean lastMap=false;
	private Collection<CalendarObject> calObj;
	private Collection<SocialCalendarEvent> socCalEvent;
	@Pattern(regexp="[0-1][0-9][/][0-3][0-9][/][0-2][0-9][0-9][0-9]")
	private String eventStartDate;
	private String eventStartHour;
	private String eventStartMin;
	private String imageURL;
	private String eventEndMin;
	private String eventEndHour;
	private String eventEndDate;
	
	/**
	 * @return the eventEndMin
	 */
	public String getEventEndMin() {
		return eventEndMin;
	}
	/**
	 * @param eventEndMin the eventEndMin to set
	 */
	public void setEventEndMin(String eventEndMin) {
		this.eventEndMin = eventEndMin;
	}
	/**
	 * @return the eventEndHour
	 */
	public String getEventEndHour() {
		return eventEndHour;
	}
	/**
	 * @param eventEndHour the eventEndHour to set
	 */
	public void setEventEndHour(String eventEndHour) {
		this.eventEndHour = eventEndHour;
	}
	/**
	 * @return the eventEndDate
	 */
	public String getEventEndDate() {
		return eventEndDate;
	}
	/**
	 * @param eventEndDate the eventEndDate to set
	 */
	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	
	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}
	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	/**
	 * @return the eventStartHour
	 */
	public String getEventStartHour() {
		return eventStartHour;
	}
	/**
	 * @param eventStartHour the eventStartHour to set
	 */
	public void setEventStartHour(String eventStartHour) {
		this.eventStartHour = eventStartHour;
	}
	/**
	 * @return the eventstartMin
	 */
	public String getEventStartMin() {
		return eventStartMin;
	}
	/**
	 * @param eventstartMin the eventstartMin to set
	 */
	public void setEventStartMin(String eventStartMin) {
		this.eventStartMin = eventStartMin;
	}
	

	/**
	 * @return the eventDate
	 */
	public String getEventStartDate() {
		return eventStartDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	/**
	 * @return the socCalEvent
	 */
	public Collection<SocialCalendarEvent> getSocCalEvent() {
		return socCalEvent;
	}
	/**
	 * @param socCalEvent the socCalEvent to set
	 */
	public void setSocCalEvent(Collection<SocialCalendarEvent> socCalEvent) {
		this.socCalEvent = socCalEvent;
	}
	/**
	 * @return the calObj
	 */
	public Collection<CalendarObject> getCalObj() {
		return calObj;
	}
	/**
	 * @param calObj the calObj to set
	 */
	public void setCalObj(Collection<CalendarObject> calObj) {
		this.calObj = calObj;
	}
	/**
	 * @return the lastMap
	 */
	public boolean isLastMap() {
		return lastMap;
	}
	/**
	 * @param lastMap the lastMap to set
	 */
	public void setLastMap(boolean lastMap) {
		this.lastMap = lastMap;
	}
	/**
	 * @return the markedLabel
	 */
	public String getMarkedLabel() {
		return markedLabel;
	}
	/**
	 * @param markedLabel the markedLabel to set
	 */
	public void setMarkedLabel(String markedLabel) {
		this.markedLabel = markedLabel;
	}
	/**
	 * @return the marked
	 */
	public boolean isMarked() {
		return marked;
	}
	/**
	 * @param marked the marked to set
	 */
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	/**
	 * @return the aptNo
	 */
	public String getAptNo() {
		return aptNo;
	}
	/**
	 * @param aptNo the aptNo to set
	 */
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	/**
	 * @return the eventZipCode
	 */
	public String getEventZipCode() {
		return eventZipCode;
	}
	/**
	 * @param eventZipCode the eventZipCode to set
	 */
	public void setEventZipCode(String eventZipCode) {
		this.eventZipCode = eventZipCode;
	}
	
	
	/**
	 * @return the eventStreetAddress
	 */
	public String getEventStreetAddress() {
		return eventStreetAddress;
	}
	/**
	 * @param eventStreetAddress the eventStreetAddress to set
	 */
	public void setEventStreetAddress(String eventStreetAddress) {
		this.eventStreetAddress = eventStreetAddress;
	}
	/**
	 * @return the eventCityAddress
	 */
	public String getEventCityAddress() {
		return eventCityAddress;
	}
	/**
	 * @param eventCityAddress the eventCityAddress to set
	 */
	public void setEventCityAddress(String eventCityAddress) {
		this.eventCityAddress = eventCityAddress;
	}
	/**
	 * @return the eventStateAddress
	 */
	public String getEventStateAddress() {
		return eventStateAddress;
	}
	/**
	 * @param eventStateAddress the eventStateAddress to set
	 */
	public void setEventStateAddress(String eventStateAddress) {
		this.eventStateAddress = eventStateAddress;
	}
	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}
	/**
	 * @param eventTitle the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	/**
	 * @return the eventStartTime
	 */
	public Date getEventStartTime() {
		return eventStartTime;
	}
	/**
	 * @param eventStartTime the eventStartTime to set
	 */
	public void setEventStartTime(Date eventStartTime) {
		this.eventStartTime = eventStartTime;
	}
	/**
	 * @return the eventEndTime
	 */
	public Date getEventEndTime() {
		return eventEndTime;
	}
	/**
	 * @param eventEndTime the eventEndTime to set
	 */
	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	/**
	 * @return the eventLocation
	 */
	public String getEventLocation() {
		return eventLocation;
	}
	/**
	 * @param eventLocation the eventLocation to set
	 */
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}
	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	};
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((eventDescription == null) ? 0 : eventDescription.hashCode());
		result = prime * result
				+ ((eventEndTime == null) ? 0 : eventEndTime.hashCode());
		result = prime * result
				+ ((eventLocation == null) ? 0 : eventLocation.hashCode());
		result = prime * result
				+ ((eventStartTime == null) ? 0 : eventStartTime.hashCode());
		result = prime * result
				+ ((eventTitle == null) ? 0 : eventTitle.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SocialCalendarEvent)) {
			return false;
		}
		SocialCalendarEvent other = (SocialCalendarEvent) obj;
		if (eventDescription == null) {
			if (other.eventDescription != null) {
				return false;
			}
		} else if (!eventDescription.equals(other.eventDescription)) {
			return false;
		}
		if (eventEndTime == null) {
			if (other.eventEndTime != null) {
				return false;
			}
		} else if (!eventEndTime.equals(other.eventEndTime)) {
			return false;
		}
		if (eventLocation == null) {
			if (other.eventLocation != null) {
				return false;
			}
		} else if (!eventLocation.equals(other.eventLocation)) {
			return false;
		}
		if (eventStartTime == null) {
			if (other.eventStartTime != null) {
				return false;
			}
		} else if (!eventStartTime.equals(other.eventStartTime)) {
			return false;
		}
		if (eventTitle == null) {
			if (other.eventTitle != null) {
				return false;
			}
		} else if (!eventTitle.equals(other.eventTitle)) {
			return false;
		}
		return true;
	}
	
	public int compareTo(SocialCalendarEvent o)
	{
		int returnVal=0;
		if(o != null)
		{
			SocialCalendarEvent calEve=(SocialCalendarEvent)o;
			returnVal=this.id.compareTo(calEve.id); 
		}
		else
		{
			returnVal= -1;
		}	
		return returnVal;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the calendar
	 */
	public String getCalendar() {
		return calendar;
	}
	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
}

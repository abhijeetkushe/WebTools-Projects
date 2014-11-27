package com.webtools.springfinal.dataprocess;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DataFormatter implements Formatter<Date> {

	 private String pattern;
	    
	    public DataFormatter(String pattern) {
	        this.pattern = pattern;
	    }
	    
	    public String format(Date date, Locale locale) {
	        if (date == null) {
	            return "";
	        }
	        return getDateFormat(locale).format(date);
	    }

	    public Date parse(String formatted, Locale locale) throws ParseException {
	        if (formatted.length() == 0) {
	            return null;
	        }
	        return getDateFormat(locale).parse(formatted);
	    }

	    protected DateFormat getDateFormat(Locale locale) {
	        DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
	        dateFormat.setLenient(false);
	        return dateFormat;
	    }

		@Override
		public String print(Date arg0, Locale arg1) {
			// TODO Auto-generated method stub
			return null;
		}

}

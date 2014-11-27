<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag" prefix="calendar" %>

<calendar:Calendar style="dd-MMM-yyyy">
   <calendar:setTitleStyle>font-size:10pt; color:#FF0000</calendar:setTitleStyle>
   <calendar:setHeaderStyle>color:#0000FF; text-decoration:none</calendar:setHeaderStyle>
  
   <!--<calendar:setLink day="5">http://www.servletsuite.com</calendar:setLink>
   <calendar:setLink day="15">http://www.servletsuite.com/jsp.htm?$d</calendar:setLink>
   <calendar:setDateClass day="10">test</calendar:setDateClass>
  <calendar:setTarget>_blank</calendar:setTarget>
   <calendar:setNextMonth>cal.jsp?m=11</calendar:setNextMonth>
   <calendar:setPrevMonth>http://www.servletsuite.com?$m</calendar:setPrevMonth> --> 	
  <calendar:setField>getElementById('form1')[window.name]</calendar:setField>
</calendar:Calendar> 
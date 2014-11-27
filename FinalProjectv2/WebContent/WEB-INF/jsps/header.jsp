<%@ page language="java" contentType="text/html" autoFlush="true"
	isELIgnored="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag"
	prefix="calendar"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<resource:urlResourceBundle baseName="resources.messages"  var="bundle"/>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="content-script-type" content="text/javascript">
<title><c:out value="${pageTitle}" /></title>
<script type="text/javascript" src="js/jsapi"></script>
<script type="text/javascript" src="js/uds"></script>
<script type="text/javascript" src="js/default,corechart.I.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/ui.all.css"
	rel="stylesheet" type="text/css" />
<script src="jquery.ui.datetimepicker.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/layouts.css" />
<link rel="stylesheet" type="text/css" href="css/newlay.css"></link>
<link href="css/style2.css" type="text/css" rel="stylesheet" />
<link href="css/A2JCoreLayout.css" type="text/css" rel="stylesheet" />
<link href="css/A2J-Main.css" type="text/css" rel="stylesheet" />
<link href="css/A2J-Navigation.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" media="all" href="css/node.css">
<link type="text/css" rel="stylesheet" media="all" href="css/poll.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/defaults.css">
<link type="text/css" rel="stylesheet" media="all" href="css/system.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/system-menus.css">
<link type="text/css" rel="stylesheet" media="all" href="css/user.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/content-module.css">
<link type="text/css" rel="stylesheet" media="all" href="css/date.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/datepicker.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/timeentry.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/filefield.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/imagefield.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/calendar.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/farbtastic.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/fieldgroup.css">
<link type="text/css" rel="stylesheet" media="all"
	href="css/default.css">
<link type="text/css" rel="stylesheet" media="all" href="css/pretty.css">
<link type="text/css" rel="stylesheet" media="screen"
	href="css/sifr3-screen.css">
<link type="text/css" rel="stylesheet" media="print"
	href="css/print.css">
<script type="text/javascript" src="js/toggle.js"></script>
<script type="text/javascript" src="js/AJS.js"></script>
<script type="text/javascript" src="js/googiespell.js"></script>
<script type="text/javascript" src="js/googiespell_multiple.js"></script>
<script type="text/javascript" src="js/cookiesupport.js"></script>
<script type="text/javascript" src="js/healthcare.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.js"></script>

<script type="text/javascript">
$(document).ready(function(){

	$("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)

	$("ul.topnav li span").click(function() { //When trigger is clicked...

		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click

		$(this).parent().hover(function() {
		}, function(){
			$(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up
		});

		//Following events are applied to the trigger (Hover events for the trigger)
		}).hover(function() {
			$(this).addClass("subhover"); //On hover over, add class "subhover"
		}, function(){	//On Hover Out
			$(this).removeClass("subhover"); //On hover out, remove class "subhover"
	});

});
</script>
<style type="text/css">
ul#navigation {

	padding: 0;

	margin: 0;

	background-color: #3b5998;

	color: #fff;

	float: left;

	width: 100%;

}

ul#navigation li { display: inline; }

ul#navigation li a {

  padding: .25em 1em;

  background-color: #3b5998;

  color: #fff;

  text-decoration: none;

  float: left;

  border-bottom: solid 1px #fff;

  border-top: solid 1px #fff;

  border-right: solid 1px #fff;

}

a:link, a:visited { color: #fff; }

ul#navigation li a:hover {

	color: #000;

	background-color: #fff;

}

p a:link, p a:visited { color: #000; }

</style>


</head>
<body>

<ul id="navigation">
	<sec:authorize access="hasAnyRole('ROLE_PATIENT','ROLE_DOCTOR')">
      <li><a href="loginConfirm.html">Home</a></li>
     </sec:authorize> 
	  <sec:authorize access="hasRole('ROLE_PATIENT')">
	      <li><a href="createAppointment.html">Create Appointment</a></li>
      </sec:authorize>
     <sec:authorize access="hasAnyRole('ROLE_PATIENT','ROLE_DOCTOR')"> 
      <li><a href="edit.html">Edit Personal Details</a></li>
      <li><a href="logout.html">Log Out</a></li>
     </sec:authorize> 
</ul>


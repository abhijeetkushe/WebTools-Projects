<%@ page language="java" isELIgnored="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!-- saved from url=(0043)http://jqueryui.com/demos/tabs/default.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>jQuery UI Tabs - Default functionality</title>
	<link rel="stylesheet" href="http://jqueryui.com/themes/base/jquery.ui.all.css">
	<script src="js/jquery-1.4.4.js"></script>
	<script src="js/jquery.ui.core.js"></script>
	<script src="js/jquery.ui.widget.js"></script>
	<script src="js/jquery.ui.tabs.js"></script>
	<link rel="stylesheet" href="http://jqueryui.com/demos/demos.css">
	<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	</script>
</head>
<body>

<div class="demo">

<div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
	<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
		<li class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active"><a href="#tabs-1">Patient Information</a></li>
		<li class="ui-state-default ui-corner-top"><a href="#tabs-2">Physician Information</a></li>
		<li class="ui-state-default ui-corner-top"><a href="#tabs-3">Appointment Details</a></li>
	</ul>
	<div id="tabs-1" class="ui-tabs-panel ui-widget-content ui-corner-bottom">
		<p><table  width="100%" >
		<tbody>
			<!--<caption class="captionClass">Personal Info</caption>-->
			<tr class="captionRow" >
				<td width="100%" colspan=4 style="color:white;"><b>Patient Information</b></td>
			</tr>
			<tr class="oddrow">
				<td width="15%"><b>Name</b></td>
				<td width="35%" ><c:out
					value="${userInfo.title} ${userInfo.firstName} ${userInfo.lastName}" /></td>
				<td width="15%"><b>Gender</b></td>
				<c:choose>
					<c:when test="${userInfo.gender == 'M'}">
						<td width="35%">Male</td>
					</c:when>
					<c:otherwise>
						<td width="35%">Female</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr class="evenrow">
				<td width="15%"><b>Address Line1</b></td>
				<td width="35%"><c:out value="${userInfo.addressLine1}" /></td>
				<td width="15%"><b>Address Line2</b></td>
				<td width="35%"><c:out value="${userInfo.addressLine2}" /></td>
			</tr>

			<tr class="oddrow">
				<td width="15%"><b>City/State/Zip </b></td>
				<td width="35%"><c:out
					value="${userInfo.city}/${userInfo.state}/${userInfo.zipCode}" /></td>
				<td width="15%"><b>Home Phone</b></td>
				<td width="35%"><c:out value="${userInfo.homephone}" /></td>
			</tr>
			<tr class="evenrow">
				<td width="15%"><b>Cell Phone</b></td>
				<td width="35%"><c:out value="${userInfo.cellphone}" /></td>
				<td width="15%"><b>Work Phone</b></td>
				<td width="35%"><c:out value="${userInfo.cellphone}" /></td>
			</tr>
			<tr class="oddrow">
				<td width="15%"><b>Email</b></td>
				<td width="35%"><c:out value="${userInfo.email}" /></td>
				<td width="15%"><b></b></td>
				<td width="35%"></td>
			</tr>
		</tbody>
	</table>
</p>
	</div>
	<div id="tabs-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
		<p>
			<table  width="100%" >
		<tbody>
			<!--<caption class="captionClass">Personal Info</caption>-->
			<tr class="captionRow" >
				<td width="100%" colspan=4 style="color:white;"><b>Physician Information</b></td>
			</tr>
			<tr class="oddrow">
				<td width="15%"><b>Name</b></td>
				<td width="35%" ><c:out
					value="${puserInfo.title} ${puserInfo.firstName} ${puserInfo.lastName}" /></td>
				<td width="15%"><b>Gender</b></td>
				<c:choose>
					<c:when test="${puserInfo.gender == 'M'}">
						<td width="35%">Male</td>
					</c:when>
					<c:otherwise>
						<td width="35%">Female</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr class="evenrow">
				<td width="15%"><b>Address Line1</b></td>
				<td width="35%"><c:out value="${puserInfo.addressLine1}" /></td>
				<td width="15%"><b>Address Line2</b></td>
				<td width="35%"><c:out value="${puserInfo.addressLine2}" /></td>
			</tr>

			<tr class="oddrow">
				<td width="15%"><b>City/State/Zip </b></td>
				<td width="35%"><c:out
					value="${puserInfo.city}/${puserInfo.state}/${puserInfo.zipCode}" /></td>
				<td width="15%"><b>Home Phone</b></td>
				<td width="35%"><c:out value="${puserInfo.homephone}" /></td>
			</tr>
			<tr class="evenrow">
				<td width="15%"><b>Cell Phone</b></td>
				<td width="35%"><c:out value="${puserInfo.cellphone}" /></td>
				<td width="15%"><b>Work Phone</b></td>
				<td width="35%"><c:out value="${puserInfo.cellphone}" /></td>
			</tr>
			<tr class="oddrow">
				<td width="15%"><b>Email</b></td>
				<td width="35%"><c:out value="${puserInfo.email}" /></td>
				<td width="15%"><b></b></td>
				<td width="35%"></td>
			</tr>
		</tbody>
	</table>
		</p>
	</div>
	<div id="tabs-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
		<form:form id="createDiag" action="createAppointment.html" method="POST"
	commandName="diagnosis">
	<form:errors path="*" cssClass="validation"></form:errors>
	<fieldset id="fsLoginInfo"
		style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
		title="Create Login Information"><legend><b>View
	Appointment Info</b></legend>
	<table>
		<tr>
			<td>
			<table border="0" width="474"
				style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
				<tbody>
					<tr>
						<td nowrap="nowrap"><form:label id="name"
							path="appointment.symptoms">Name of the Patient :<font
								color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${appointment.patientbean.title} ${appointment.patientbean.firstName} ${appointment.patientbean.lastName}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label id="appointment.creationDate"
							path="appointment.creationDate">Date Appointment Submitted :<font
								color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><fmt:formatDate
							value="${appointment.creationDate}"
							pattern="dd-MMM-yyyy" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label id="appointment.symptoms"
							path="appointment.symptoms">Symptoms :<font
								color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${appointment.symptoms}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.natureOfIllness">
	                   Nature of Illness :<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${appointment.natureOfIllness}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.illnessStartDate">
	                   Illness Started From <font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><fmt:formatDate
							value="${appointment.illnessStartDate}"
							pattern="dd-MMM-yyyy" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.physicianCategory">
	                   Physician Category<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${appointment.physicianCategory}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.appointmentType">
	                   Appointment Type<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${appointment.appointmentType}" /></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
</form:form>
		
	</div>
</div>

</div><!-- End demo -->



<div class="demo-description">
<p>Click tabs to swap between content that is broken into logical sections.</p>
</div><!-- End demo-description -->



</body></html>
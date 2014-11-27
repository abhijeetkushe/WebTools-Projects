<%@ page language="java" isELIgnored="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag"
	prefix="calendar"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript">
$(function() {
	$("#GetPhysician").click(getPhysician);
	$("#GetDirections").click(getMap);
	$('#illnessStartDate').datepicker();
	//$("#GetDirections").click(getMap);
	});

	google.load('visualization', '1', {'packages' : [ 'map' ]});
</script>
<form:form id="appointment" action="createAppointment.html"
	method="POST" commandName="appointment">
	<form:errors path="*" cssClass="validation"></form:errors>
	<fieldset id="fsLoginInfo"
		style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
		title="Create Login Information"><legend><b>Information
	Regarding Ailment</b></legend>
	<table border="0" width="474"
		style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
		<tbody>
			<tr>
				<td nowrap="nowrap"><form:label id="symptoms" path="symptoms">Symptoms <font
						color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:input path="symptoms" maxlength="50"
					id="symptoms" cssClass="text"></form:input></td>
			</tr>
			<tr>
				<td nowrap="nowrap"><form:label path="natureOfIllness">
                   Nature of Illness: <font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:select path="natureOfIllness"
					id="natureOfIllness" cssClass="selectionAlt"
					cssStyle="width: 100px;">
					<form:option label="Heart" value="Heart" />
					<form:option label="CardioVascular" value="CardioVascular" />
					<form:option label="Brain" value="Brain" />
					<form:option label="Optical" value="Optical" />
				</form:select></td>
			</tr>
			<tr>
				<td nowrap="nowrap"><form:label path="illnessStartDate">
                   Illness Started From <font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:input path="illnessStartDate"
					id="illnessStartDate" maxlength="50" cssClass="text" value="" /></td>
			</tr>
			<tr>
				<td nowrap="nowrap"><form:label path="physicianCategory">
                   Physician Category<font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:select path="physicianCategory"
					id="physicianCategory" cssClass="selectionAlt"
					cssStyle="width: 100px;">
					<form:option label="Adult-Men" value="ADULT-MEN" />
					<form:option label="Child" value="CHILD" />
					<form:option label="Adult-Women" value="ADULT-WOMEN" />
				</form:select></td>
			</tr>
			<tr>
				<td nowrap="nowrap"><form:label path="appointmentType">
                   Appointment Type<font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:select path="appointmentType"
					id="appointmentType" cssClass="selectionAlt"
					cssStyle="width: 100px;">
					<form:option label="Immediate" value="IMMEDIATE" />
					<form:option label="Scheduled" value="SCHEDULED" />
				</form:select></td>
			</tr>

			<tr>
				<td nowrap="nowrap"><form:label path="physicianName">
                   Search Physician<font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:input path="physicianName"
					id="physicianName" maxlength="50" cssClass="text" value="" />&nbsp;
				<input type="button" name="GetPhysician" id="GetPhysician"
					value="Get Physician"
					style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />
				</td>
			</tr>
			<tr>
				<td>
				<div id="physicianInfo"></div>
				</td>
				<td>
					<input type="button" name="GetDirections" id="GetDirections"
					value="Get Physician"
					style="display:none;width: 100px; height: 30px; background-image: url('images/submit.GIF');" />&nbsp;&nbsp;<div id="map">
					
</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="submit" value="Submit"
					style="width: 100px; height: 30px; background-image: url('images/submit.GIF');"
					value="Submit" /></td>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="reset" value="Reset"
					style="width: 100px; height: 30px; background-image: url('images/reset_submit.GIF');"
					value="Cancel" /></td>
			</tr>
		</tbody>
	</table>
	</fieldset>
</form:form>

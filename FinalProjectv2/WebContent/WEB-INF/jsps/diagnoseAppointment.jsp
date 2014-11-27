<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag"
	prefix="calendar"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
	href="http://jqueryui.com/themes/base/jquery.ui.all.css">
<script src="js/jquery-1.4.4.js"></script>
<script src="js/jquery.ui.core.js"></script>
<script src="js/jquery.ui.widget.js"></script>
<script src="js/jquery.ui.tabs.js"></script>
<link rel="stylesheet" href="http://jqueryui.com/demos/demos.css">
<script type="text/javascript">


	var loaded = false;
	var showChart = false;
	$(function() {
		$("#addmed").click(addMed);
		$("#generateChart").click(drawChart);
	});
	google.load('visualization', '1', {
		'packages' : [ 'corechart', 'gauge' ]
	});
	$(function() {
		$("#tabs").tabs();
	});
</script>


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
							value="${diagnosis.appointment.patientbean.title} ${diagnosis.appointment.patientbean.firstName} ${diagnosis.appointment.patientbean.lastName}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label id="appointment.creationDate"
							path="appointment.creationDate">Date Appointment Submitted :<font
								color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><fmt:formatDate
							value="${diagnosis.appointment.creationDate}"
							pattern="dd-MMM-yyyy" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label id="appointment.symptoms"
							path="appointment.symptoms">Symptoms :<font
								color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${diagnosis.appointment.symptoms}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.natureOfIllness">
	                   Nature of Illness :<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${diagnosis.appointment.natureOfIllness}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.illnessStartDate">
	                   Illness Started From <font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><fmt:formatDate
							value="${diagnosis.appointment.illnessStartDate}"
							pattern="dd-MMM-yyyy" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.physicianCategory">
	                   Physician Category<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${diagnosis.appointment.physicianCategory}" /></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><form:label
							path="appointment.appointmentType">
	                   Appointment Type<font color="orangered">*</font>
						</form:label></td>
						<td nowrap="nowrap"><c:out
							value="${diagnosis.appointment.appointmentType}" /></td>
					</tr>
				</tbody>
			</table>
			</td>
			<td>

			<div id="tabs"
				class="ui-tabs ui-widget ui-widget-content ui-corner-all"
				style='display: none'>
			<ul
				class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
				<li
					class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active"><a
					href="#tabs-1">Weight</a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-2">Temperature</a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-3">Blood
				Pressure</a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-4">Pulse
				Rate</a></li>
			</ul>
			<div id="tabs-1"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom"></div>
			<div id="tabs-2"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">

			</div>
			<div id="tabs-3"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
			</div>
			<div id="tabs-4"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
			</div>
			</div>
			</td>
		</tr>
	</table>
	</fieldset>
</form:form>

Previous Diagnois History
<table class="tableboxborder" style="margin-top: 20px; color: white;"
	width="95%">
	<tbody>
		<tr class="captionRow">
			<th width="8%">Weight</th>
			<th width="8%">Temperature</th>
			<th width="20%">Blood Pressure</th>
			<th width="8%">Pulse Rate</th>
			<th width="8%">Comments</th>			
		</tr>
		<c:forEach var="diag" items="${diagnosis.appointment.diagnosisList}" 
			 varStatus="rowcount">
			<c:choose>
				<c:when test="${rowcount.count mod 2 ==0}">
					<tr class="oddrow">
				</c:when>
				<c:otherwise>
					<tr class="evenrow">
				</c:otherwise>
			</c:choose>
			<td width="15%"><c:out value="${diag.weight}" /></td>
			<td width="35%"><c:out value="${diag.temperature}" /></td>
			<td width="15%"><c:out value="${diag.bloodPressure}" /></td>
			<td width="15%"><c:out value="${diag.pulse}" /></td>
			<td width="15%"><c:out value="${diag.description}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>



		<form:form id="createDiagnosis" action="createDiagnosis.html"
						method="POST" commandName="diagnosis" cssStyle="margin-top:20px;">
						<form:errors path="*" cssClass="validation"></form:errors>
						<fieldset id="fsLoginInfo"
							style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
							title="Create Login Information"><legend><b>Diagnose
						Disease</b></legend>
						<table border="0" width="474"
							style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
							<input type="text" name="appointmentId"
								value="<c:out value='${diagnosis.appointment.appointmentId}'/>"
								style="display: none" />
							<tbody>
								<tr>
									<td nowrap="nowrap"><form:label path="weight">
	                   Weight :<font color="orangered">*</font>
									</form:label></td>
									<td nowrap="nowrap"><form:input path="weight"
										maxlength="50" cssClass="text" value="" /></td>
								</tr>
								<tr>
									<td nowrap="nowrap"><form:label path="temperature">
	                   Temperature :<font color="orangered">*</font>
									</form:label></td>
									<td nowrap="nowrap"><form:input path="temperature"
										maxlength="50" cssClass="text" value="" /></td>
								</tr>
								<tr>
									<td nowrap="nowrap"><form:label path="bloodPressure">
	                   Blood Pressure:<font color="orangered">*</font>
									</form:label></td>
									<td nowrap="nowrap"><form:input path="bloodPressure"
										maxlength="50" cssClass="text" value="" /></td>
								</tr>
								<tr>
									<td nowrap="nowrap"><form:label path="pulse">
	                   Pulse Rate :<font color="orangered">*</font>
									</form:label></td>
									<td nowrap="nowrap"><form:input path="pulse"
										maxlength="50" cssClass="text" value="" /> &nbsp;<input
										type="button" name="generateChart" id="generateChart"
										value="Generate Chart"
										style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />
									</td>
								</tr>
								<td nowrap="nowrap" colspan="3">Medicines Prescribed :<font
									color="orangered">*</font> &nbsp; <input type="submit"
									name="addmed" id="addmed" value="Add Medicines"
									style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />
								</td>
								</tr>
							</tbody>
						</table>
						<div id="medList">
						<table border="0" width="474"
							style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
							<tbody>
								<c:forEach var="medicine" items="${diagnosis.medicineList}"
									varStatus="rowCount" >
									<tr>
										<td nowrap="nowrap"><form:label
											path="medicineList[${rowCount.count-1}].medicineName">
		                 	 Medicine Name<font color="orangered">*</font>
										</form:label> &nbsp; <form:input
											path="medicineList[${rowCount.count-1}].medicineName"
											maxlength="50" cssClass="text" value="" /></td>
										<td nowrap="nowrap"><form:label
											path="medicineList[${rowCount.count-1}].medicineIngredients">
		                	 	 Medicine Ingredients<font color="orangered">*</font>
										</form:label>&nbsp; <form:input
											path="medicineList[${rowCount.count-1}].medicineIngredients"
											maxlength="50" cssClass="text" value="" /></td>
										<td nowrap="nowrap"><form:label
											path="medicineList[${rowCount.count-1}].quantity">
		                	 	 Medicine Quantity<font color="orangered">*</font>
										</form:label>&nbsp; <form:input
											path="medicineList[${rowCount.count-1}].quantity"
											maxlength="50" cssClass="text" value="" /></td>
									</tr>
									<c:set var="totalMedCount" value="${rowCount.count}"
										scope="page" />
								</c:forEach>
							</tbody>
						</table>

						</div>
						
										
						<tr>
							<td nowrap="nowrap" colspan="3"><form:label
								path="description">
	                   Description <font color="orangered">*</font>
							</form:label> <form:textarea path="description" rows="6" cols="25" /></td>
						</tr>
						<tr>
							<td nowrap="nowrap" style="padding: 0px !important;" colspan="3"
								align="center"><input type="submit" value="Submit"
								style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />&nbsp;
							<input type="reset" value="Cancel"
								style="width: 100px; height: 30px; background-image: url('images/reset_submit.GIF');" />
				</td>
				<%--<td nowrap="nowrap" style="padding: 0px !important;"></td>--%>
			</tr>
			
	</tbody>
	</table>
	</fieldset>
</form:form>
<script type="text/javascript">
var medCount=<c:out value='${totalMedCount}'/>;
	var googie5 = new GoogieSpellMultiple("googiespell/",
			"https://www.google.com/tbproxy/spell?lang=");

	//New menu item "Add"
	var add_checker = function(elm) {
		return true;
	};
	var add_item = function(elm, current_googie) {
		googie5.ignoreAll(elm);
	};
	googie5.appendNewMenuItem("Add", add_item, add_checker);

	var fn_no_more_errors = function(e) {
		alert('No errors detected');
	}

	googie5.setDependent();
	googie5.setCustomAjaxError(function(req) {
		alert('Error in Calling Ajax');
	});
	googie5.useCloseButtons();
	googie5.noMoreErrorsCallback(fn_no_more_errors);
	googie5.setSpellContainer("global_spell_container");
	googie5.decorateTextareas("ta5_1", AJS.$("ta5_2"), "ta5_3", "ta5_6");
</script>
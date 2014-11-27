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
	for(i=0;i<20;i++)
	{	
		$('#insuranceList'+i+'.endDate').datepicker();
		$('#insuranceList'+i+'.startDate').datepicker();			
	}
	//$("#GetDirections").click(getMap);
	});


</script>

<form:form id="createUser" action="createUser.html" method="POST"
	commandName="userInfo" enctype="multipart/form-data">

	<fieldset id="fsLoginInfo"
		style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
		title="Create Login Information"><legend><b>Create
	Login Information</b></legend>
	<table border="0" width="474"
		style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
		<tbody>
		<tr>
				<td nowrap="nowrap" colspan="2">
					<form:errors path="*" cssClass="validation"></form:errors>
				</td>
				
			</tr>
				
			<tr>
				<td nowrap="nowrap"><form:label id="userName"
					path="userAccount.userName">User Name: <font
						color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:input path="userAccount.userName"
					maxlength="50" id="userAccount.userName" cssClass="text"></form:input>
				&nbsp;<input type="button" value="Check User" id="checkUser"
					style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />
				&nbsp;
				<div id="userex" style="display: none; color: orangered">The
				User Name already exists.Please try a different User Name</label><label
					id="userex2" style="display: none; color: blue">The User
				Name already exists.Please try a different User Name</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><form:label path="userAccount.password">
                                Password: <font color="orangered">*</font>
				</form:label></td>
				<td nowrap="nowrap"><form:password path="userAccount.password"
					id="userAccount.password" maxlength="50" cssClass="text" value="" /></td>
			</tr>
			<tr>
				<td nowrap="nowrap" style="padding: 0px !important;"><form:label
					path="userAccount.userType">User Type: <font
						color="orangered">*</font>
				</form:label></td>
				<td><form:select onChange="submitForm()"
					path="userAccount.userType" id="userAccount.userType"
					cssClass="selectionAlt" cssStyle="width: 100px;">
					<form:option label="Select" value="-1" />					
					<form:option label="Patient" value="ROLE_PATIENT" />
					<form:option label="Physician" value="ROLE_DOCTOR" />
				</form:select></td>
			</tr>
		</tbody>
	</table>
	</fieldset>

	<fieldset id="fsAccInfo"
		style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
		title="Enter Account Information"><legend
		id="legendAccInfo" style="font-weight: bold">Enter Account
	Information</legend>
	<table border="0" width="474"
		style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
		<tbody>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="title">Upload Photo:</form:label></td>
				<td align="left" colspan="3" valign="top" width="75%"><input
					type="text" name="fileName" /> <input type="file" name="userImage" />
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="title">Title:</form:label></td>
				<td align="left" colspan="3" valign="top" width="75%"><form:select
					path="title" items="${userInfo.options}" onchange="setSex();"
					id="cboTitle" class="selectionAlt" itemLabel="label"
					itemValue="value">
				</form:select></td>
			</tr>
			<tr>
				<td align="left" style="width: 25%" valign="top"><form:label
					path="firstName">First Name: </form:label><font color="orangered">*</font></td>
				<td align="left" colspan="3" valign="top" width="75%"><form:input
					path="firstName" maxlength="15" size="18" id="firstName"
					cssClass="text" cssStyle="width: 100px;" /></td>
			</tr>
			<tr>
				<td align="left" style="width: 25%" valign="top"><form:label
					path="lastName">Last Name: </form:label><font color="orangered">*</font></td>
				<td align="left" colspan="3" valign="top" width="75%"><form:input
					path="lastName" maxlength="15" size="19" id="lastName"
					cssClass="text" cssStyle="width: 110px;" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="gender">Gender: </form:label></td>
				<td align="left" colspan="3" valign="top" width="75%"><span
					id="gender" class="text2" onclick="setTitle();"> <form:radiobutton
					path="gender" id="rdoPatSex_0" value="M" /> <label
					for="rdoPatSex_0">Male</label><form:radiobutton path="gender"
					id="rdoPatSex_1" name="gender" value="F" /> <label
					for="rdoPatSex_1">Female</label> </span></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					id="txtAddress1" path="addressLine1">Address 1: </form:label><font
					color="orangered">*</font></td>
				<td align="left" colspan="3"
					style="font-weight: bold; color: #333333" valign="top" width="75%">
				<form:input path="addressLine1" maxlength="50" size="54"
					id="txtAddress1" cssClass="text" cssStyle="width: 270px;" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="addressLine2">Address 2:</form:label></td>
				<td align="left" colspan="3" style="color: #333333" valign="top"
					width="75%"><form:input path="addressLine2" type="text"
					maxlength="50" size="54" id="txtAddress2" class="text"
					style="width: 270px;" /></td>
			</tr>
			<tr>
				<td align="left" style="width: 25%" valign="top"><form:label
					path="city">City </form:label> <form:label path="state">State </form:label><form:label
					path="zipCode">Zip: </form:label><font color="orangered">*</font></td>

				<td align="left" colspan="3" style="color: #333333" valign="top"
					width="75%"><form:input path="city" maxlength="50"
					id="txtCity" cssClass="text" /><form:select path="state"
					id="cboState" cssClass="selectionAlt" cssStyle="width: 50px;"
					items="${userInfo.stateOptions}" itemLabel="label"
					itemValue="value" /><form:input path="zipCode" maxlength="10"
					size="20" id="txtZip" cssClass="text"
					onchange="return validateZipCode(document.Form_Register_Step2_AccInfo.txtCity, document.Form_Register_Step2_AccInfo.cboState, this, false);"
					cssStyle="width: 95px;" /><!-- path="https://www.dentisoftonline.com/ValidateZip.asp"--></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%;"><form:label
					path="homephone">Home Phone: </form:label><font color="orangered">*</font></td>
				<td align="left" valign="top" colspan="3"><form:input
					path="homephone" maxlength="10" id="txtHomePhone" class="text" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="workphone">Work Phone: </form:label></td>
				<td align="left" valign="top" colspan="3"><form:input
					path="workphone" maxlength="10" id="txtWorkPhone" cssClass="text" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="cellphone">Cell Phone: </form:label></td>
				<td align="left" valign="top" colspan="3"><form:input
					path="cellphone" maxlength="10" id="txtCellPhone" cssClass="text" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"><form:label
					path="email">Email: </form:label><font color="orangered">*</font></td>
				<td align="left" valign="top" colspan="3"><form:input
					path="email" maxlength="50" id="txtEmail" cssClass="text"
					onchange="return CheckEMail(document.Form_Register_Step2_AccInfo.txtEmail, true);" /></td>
			</tr>
			<tr>
				<td align="left" valign="top" style="width: 25%"></td>
				<td colspan="3" width="75%"></td>
			</tr>
		</tbody>
	</table>
	<c:if test="${userInfo.userType eq 'PATIENT'}">
		<script type="text/javascript">
	$(function() {
		$("#addIns").click(addInsurance);
	});
</script>
		<table border="0" width="474"
			style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
			<tbody>
				<tr>
					<td align="left" valign="top" style="width: 25%"><form:label
						path="allergies">Allergies </form:label><font color="orangered">*</font></td>
					<td align="left" valign="top" colspan="3"><form:input
						path="allergies" maxlength="50" id="allergies" cssClass="text" /></td>
				</tr>
			</tbody>
		</table>

	<table border="0" width="474"
			style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
			<tbody>
				<tr>
					<td nowrap="nowrap" colspan="3">Insurance Details :<font
						color="orangered">*</font> &nbsp; <input type="submit"
						name="addIns" id="addIns" value="Add Insurance"
						style="width: 100px; height: 30px; background-image: url('images/submit.GIF');" />
					</td>
				</tr>
			</tbody>
		</table>
		<div id="insList">
		<table border="0" width="474"
			style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
			<tbody>
				<c:forEach var="insurance" items="${userInfo.insuranceList}"
					varStatus="rowCount" step="1">
					<tr>
						<td nowrap="nowrap"><form:checkbox
							path="insuranceList[${rowCount.count-1}].checked" /></td>
						<td nowrap="nowrap"><form:label
							path="insuranceList[${rowCount.count-1}].insuranceName">
		                 	 Insurance Name<font color="orangered">*</font>
						</form:label> &nbsp; <form:input
							path="insuranceList[${rowCount.count-1}].insuranceName"
							maxlength="50" cssClass="text" value="" /></td>
						<td nowrap="nowrap"><form:label
							path="insuranceList[${rowCount.count-1}].policyName">
		                	 	Policy Name<font color="orangered">*</font>
						</form:label>&nbsp; <form:input
							path="insuranceList[${rowCount.count-1}].policyName"
							maxlength="50" cssClass="text" value="" /></td>
						<td nowrap="nowrap"><form:label
							path="insuranceList[${rowCount.count-1}].startDate">
		                	 	 Start Date<font color="orangered">*</font>
						</form:label>&nbsp; <form:input
							path="insuranceList[${rowCount.count-1}].startDate"
							maxlength="50" cssClass="text" value="" /></td>
						<td nowrap="nowrap"><form:label
							path="insuranceList[${rowCount.count-1}].endDate">
		                	 	 End Date<font color="orangered">*</font>
						</form:label>&nbsp; <form:input
							path="insuranceList[${rowCount.count-1}].endDate" maxlength="50"
							cssClass="text" value="" /></td>
					</tr>
					<c:set var="totalMedCount" value="${rowCount.count}" scope="page" />
				</c:forEach>
			</tbody>
		</table>
		</div>
		<input type="hidden" id="totalInsCount" name="totalInsCount"
			value="<c:out value='${pageScope.totalInsCount}'/>" />
	</c:if> 
	<c:if test="${userInfo.userType eq 'DOCTOR'}">
		<table border="0" width="474"
			style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
			<tbody>
				<tr>
					<td align="left" valign="top" style="width: 25%"><form:label
						path="field">Field:</form:label></td>
					<td align="left" colspan="3" style="color: #333333" valign="top"
					width="75%"><form:input path="field" type="text"
					maxlength="50" size="54" id="field" class="text"
					style="width: 270px;" /></td>
				</tr>
				<tr>
					<td align="left" valign="top" style="width: 25%">
						<form:label path="degree">Degree:</form:label>
					</td>
					<td align="left" colspan="3" style="color: #333333" valign="top"
					width="75%">
						<form:input path="degree" type="text" maxlength="50" size="54" id="degree" class="text"
						style="width: 270px;" />
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" style="width: 25%">
						<form:label path="degree">Physician Category</form:label><font color="orangered">*</font></td>
					<td align="left" valign="top" colspan="3">
						<form:radiobutton path="physicianCategory" name="physicianCategory" value="CHILD" label="Child"/>
						<form:radiobutton path="physicianCategory" name="physicianCategory" value="ADULT-MEN" label="Men"/>
						<form:radiobutton path="physicianCategory" name="physicianCategory" value="ADULT_WOMEN" label="Women"/>										
					</td>
				</tr>
						
			</tbody>
		</table>
	</c:if>
	<table style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
		<tbody>
			<c:if test="${enableCaptha eq 'true'}">
				<tr>
					<td align="left" valign="top" style="width: 25%">
						<form:label path="capthaText">Please Enter text from Image:</form:label>
						<c:if test="${not empty captchaError  }">
							<c:out value="${captchaError}"/>					
						</c:if>
					</td>
					<td align="left" colspan="3" style="color: #333333" valign="top"
					width="75%">
						<form:input path="capthaText" type="text" maxlength="50" size="54" id="degree" class="text"
						style="width: 270px;" />&nbsp;<img src="<c:out value='http://www.opencaptcha.com/img/1123413.jpgx'/>" />
					</td>
				</tr>
			</c:if>		
			<tr>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="submit" name="submit"
					style="width: 100px; height: 30px; background-image: url('images/submit.GIF');"
					value="Submit" /></td>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="reset" name="cancel"
					style="width: 100px; height: 30px; background-image: url('images/reset_submit.GIF');"
					value="Cancel" />
					<input
					type="submit" name="onChange"
					style="display:none"
					value="Submit" />
				</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
</form:form>

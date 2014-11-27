<%@ page language="java" isELIgnored="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag" prefix="calendar"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<resource:urlResourceBundle baseName="resources.messages" var="bundle" />--%>
<%--<fmt:setBundle basename="resources.messages_${lang}"   var="format" scope="page" />--%>
<table  width="95%">
	<tr>
		<td width="10%" align="left" class="tableboxborder">
			<img src="displayImage.html"  height="10%" width="100%"/>
		</td>
	<td align="left" valign="top" class="tableboxborder">
	<table  width="100%" >
		<tbody>
			<!--<caption class="captionClass">Personal Info</caption>-->
			<tr class="captionRow" >
				<td width="100%" colspan=4 style="color:white;"><b>Personal Information</b></td>
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
	</td>
	</tr>
</table>

<table class="tableboxborder" style="margin-top: 20px;color:white;"  width="95%" >
	<tbody>

		<tr class="captionRow">
			<c:choose>
				<c:when test="${userInfo.userType eq 'DOCTOR'}">
					<th width="4%" >Appointment No</th>
					<th width="10%">Patient Name</th>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			<th width="8%">Appointment Type</th>
			<th width="8%">Nature Of Illness</th>
			<th width="20%">Symptoms</th>
			<th width="8%">Physician Category</th>
			<th width="25%">Physician Name</th>
			<th width="25%">Illness Start Date</th>
			<th width="25%">Appointment Logged Date</th>
			<th width="25%">Report</th>
			
		</tr>
		
		<c:forEach var="apt" items="${userInfo.appointmentList}" 
			 varStatus="rowcount">
			<c:choose>
				<c:when test="${rowcount.count mod 2 ==0}">
					<tr class="oddrow">
				</c:when>
				<c:otherwise>
					<tr class="evenrow">
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${userInfo.userType eq 'DOCTOR'}">
					<td width="15%"><c:out value="${apt.appointmentId}" /></td>
					<td width="35%" ><a style="color: #000000;" 
						href="<c:out value='createDiagnosis.html?aptno=${apt.appointmentId}'/>"><c:out
						value="${apt.patientbean.title} ${apt.patientbean.firstName} ${apt.patientbean.lastName}" /></a>
					</th>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			<td width="15%"><c:out value="${apt.appointmentType}" /></td>
			<td width="35%"><c:out value="${apt.natureOfIllness}" /></td>
			<td width="15%"><c:out value="${apt.symptoms}" /></td>
			<td width="15%"><c:out value="${apt.physicianCategory}" /></td>
			<td width="15%"><c:out
				value="${apt.physician.title} ${apt.physician.firstName} ${apt.physician.lastName}" /></td>
			<td width="15%"><fmt:formatDate value="${apt.illnessStartDate}"
				pattern="dd-MMM-yyyy" /></td>
			<td width="15%">
			<fmt:formatDate value="${apt.creationDate}"
				pattern="dd-MMM-yyyy" /></td>
			<td width="15%"><a
						href="<c:out value='generatePdf.html?aptno=${apt.appointmentId}'/>"><img src="images/pdficon.jpeg"/></a></td>	
			</tr>
		</c:forEach>
	</tbody>
</table>


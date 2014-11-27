<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<list>
<c:forEach var="diag" items="${diagnosis.appointment.diagnosisList}" >
    <c:if test="${not empty diag}">
		<diagnosis>
		<date>
			<fmt:formatDate value="${diag.dateDiagnosis}"
					pattern="MM-dd-yyyy" />
		</date>
		<weight>
		<fmt:formatNumber minFractionDigits="0" maxFractionDigits="0" value="${diag.weight}"/>
		</weight>
		<temperature>
		<fmt:formatNumber minFractionDigits="0" maxFractionDigits="0" value="${diag.temperature}"/>		
		</temperature>
		<bloodpressure>
			<fmt:formatNumber minFractionDigits="0" maxFractionDigits="0" value="${diag.bloodPressure}"/>
		</bloodpressure>
		<pulse>
			<fmt:formatNumber minFractionDigits="0" maxFractionDigits="0" value="${diag.pulse}"/>	
		</pulse>
		</diagnosis>
	</c:if>
</c:forEach>
</list>
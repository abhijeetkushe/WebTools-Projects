<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<list>
	<patient>
		<name>
			<c:out value="${userInfo.title} ${userInfo.firstName} ${userInfo.lastName}"/>
		</name>
		<address>
			<c:out value="${userInfo.addressLine1},${userInfo.city},${userInfo.state},${userInfo.zipCode}"/>
		</address>
	</patient>
	<doctor>
		<name>
			<c:out value="${physician.title} ${physician.firstName} ${physician.lastName}"/>
		</name>
		<address>
			<c:out value="${physician.addressLine1},${physician.city},${physician.state},${physician.zipCode}"/>
		</address>
	</doctor>
</list>
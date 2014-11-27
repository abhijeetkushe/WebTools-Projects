<%@ page language="java" isELIgnored="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag"
	prefix="calendar"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<resource:urlResourceBundle baseName="resources.messages" var="bundle" />--%>
<jsp:useBean id="userAccount" class="com.webtools.springfinal.bean.UserAccountBean" scope="request">
</jsp:useBean>
<%--<fmt:setBundle basename="resources.messages_${lang}"   var="format" scope="page" />--%>
<c:if test="${requestScope.invalidLogin}">
	<font color="orangered"><c:out
		value="Invalid User Name/ Password" /></font>
</c:if>
<form:form action="j_spring_security_check" method="POST" commandName="userAccount">
	<form:errors path="*" cssClass="validation" />
	<fieldset id="fsLoginInfo"
		style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px; width: 90%; padding-top: 10px"
		title="Create Login Information"><legend><b>Create
	Login Information</b></legend>
	<table border="0" width="474"
		style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
		<tbody>
			<tr>
				<td nowrap="nowrap"><label id="j_username" >User Name: <font
						color="orangered">*</font>
						
				</label></td>
				<td nowrap="nowrap"><input type="text" maxlength="50"
					id="j_username" name="j_username" class="text"/></td>
				
			</tr>
			<tr>
				<td nowrap="nowrap"><label id="j_password">
                                Password: <font color="orangered">*</font>
                </label></td>
                 <td nowrap="nowrap"><input type="password"
					id="j_password" name="j_password" maxlength="50" class="text" value="" /></td>
				
			</tr>
			<tr>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="submit" value="Submit"
					style="width: 100px; height: 30px; background-image: url('images/submit.GIF');"
					/></td>
				<td nowrap="nowrap" style="padding: 0px !important;"><input
					type="submit" value="Reset"
					style="width: 100px; height: 30px; background-image: url('images/reset_submit.GIF');"
					/></td>
			</tr>
			<tr>
				<td nowrap="nowrap" style="height: 18px"><a
					href="createUser.html" id="linkSignIn" class="altlink">New
				User? Click Here to Register</a></td>
			</tr>

		</tbody>
	</table>
	</fieldset>
</form:form>
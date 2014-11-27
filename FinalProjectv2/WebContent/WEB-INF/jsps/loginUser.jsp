<%@ page language="java" isELIgnored="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/caltag" prefix="calendar" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<resource:urlResourceBundle baseName="resources.messages"  var="bundle"/>
<%--<html>
<head>
   	<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
</head>--%>  
<%--<fmt:setBundle basename="resources.messages_${lang}"   var="format" scope="page" />--%>
	<c:if test="${requestScope.invalidLogin}">
	<font color="orangered"><c:out value="Invalid User Name/ Password"/></font>
	</c:if>
	<form:form action="login.html" method="POST" commandName="userAccount">
	<form:errors path="*" cssClass="validation"/>
		<fieldset id="fsLoginInfo" style="padding-right: 10px; padding-left: 10px; float: left; padding-bottom: 10px;
                width: 90%; padding-top: 10px" title="Create Login Information">
                <legend><b>Create Login Information</b></legend>
                <table border="0" width="474" style="margin-top: 10px; margin-bottom: 10px;margin-left: 10px">
                    <tbody>
                    <tr>
                        <td nowrap="nowrap">
                            <form:label id="userName" path="userName">User Name: <font color="orangered">*</font></form:label>
                        </td>
                        <td nowrap="nowrap">
                            <form:input path="userName"  maxlength="50" id="userName" cssClass="text"></form:input>
                            &nbsp;<input type="button" value="Check User" style="width:100px;height:30px;background-image:url('images/submit.GIF');" onclick="return checkUserName(this.form.userName)" />
                         </td>
                         
                    </tr>
                    <tr>
                        <td nowrap="nowrap">
                            <form:label path="password">
                                Password: <font color="orangered">*</font></form:label></td>
                        <td nowrap="nowrap">
                            <form:password path="password" id="password" maxlength="50" cssClass="text" value=""/></td>
                    </tr>
                    
                    <tr>
						<td nowrap="nowrap" style="padding:0px !important;">
							<input type="submit"  style="width:100px;height:30px;background-image:url('images/submit.GIF');" value="Submit"/>
						</td>
						<td nowrap="nowrap" style="padding:0px !important;">
							<input type="submit" style="width:100px;height:30px;background-image:url('images/reset_submit.GIF');" value="Cancel"/>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap" style="height: 18px"><a href="createUser.html" id="linkSignIn" class="altlink">New User? Click Here to Register</a></td>
					</tr>
         	          
                </tbody></table>
            </fieldset>
	</form:form>
	<script type="text/javascript">
		function checkUser(username)
		{
			$.get(
				    "http://localhost:8085/HealthCarev1/checkUser.html",
				    "{username:"+username+"}",
				    function(data) { alert(data); },
				    "html"
				);	
		}
	</script>
<%--</html>--%>	
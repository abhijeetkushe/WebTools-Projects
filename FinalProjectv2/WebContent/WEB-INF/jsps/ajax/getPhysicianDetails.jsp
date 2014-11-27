<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<table class="tableboxborder" style="margin-top: 20px; color: white;" width="95%">
	<tbody>
		<tr class="captionRow">
			<th width="8%">Select</th>
			<th width="8%">First Name</th>
			<th width="20%">Last Name</th>
			<th width="8%">Degree</th>
			<th width="8%">Speciality</th>			
		</tr>    
	<c:forEach var="physician" items="${physicianList}" step="1" begin="1" varStatus="rowcount">
	<c:choose>
		<c:when test="${rowcount.count mod 2 ==0}">
			<tr class="oddrow">
				</c:when>
				<c:otherwise>
					<tr class="evenrow">
				</c:otherwise>
			</c:choose>
		<td nowrap="nowrap"><input type="radio" name="physicianID" value="<c:out value='${physician.userID}'/>" />
		<td width="15%"><c:out value="${physician.firstName}" /></td>
		<td width="35%"><c:out value="${physician.lastName}" /></td>
		<td width="15%"><c:out value="${physician.degree}" /></td>
		<td width="15%"><c:out value="${physician.field}" /></td>
	</tr>
</c:forEach>
	</tbody>
</table>
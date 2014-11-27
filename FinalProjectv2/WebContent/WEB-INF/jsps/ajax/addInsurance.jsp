<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<c:forEach var="insurance" items="${insuranceList}" varStatus="rowCount">
	<tr>
		<td nowrap="nowrap"><input id="insuranceList<c:out value="${rowCount.count-1}"/>.checked"
			name="insuranceList[<c:out value="${rowCount.count-1}"/>].checked" type="checkbox" value="true"><input
			type="hidden" name="_insuranceList[<c:out value="${rowCount.count-1}"/>].checked" value="on"></td>
		<td nowrap="nowrap"><label for="insuranceList<c:out value="${rowCount.count-1}"/>.insuranceName">
		Insurance Name<font color="orangered">*</font> </label> &nbsp; <input
			id="insuranceList<c:out value="${rowCount.count-1}"/>.insuranceName"
			name="insuranceList[<c:out value="${rowCount.count-1}"/>].insuranceName" class="text" type="text"
			value="" maxlength="50"></td>
		<td nowrap="nowrap"><label for="insuranceList<c:out value="${rowCount.count-1}"/>.policyName">
		Policy Name<font color="orangered">*</font> </label>&nbsp; <input
			id="insuranceList<c:out value="${rowCount.count-1}"/>.policyName" name="insuranceList[<c:out value="${rowCount.count-1}"/>].policyName"
			class="text" type="text" value="" maxlength="50"></td>
		<td nowrap="nowrap"><label for="insuranceList<c:out value="${rowCount.count-1}"/>.startDate">
		Start Date<font color="orangered">*</font> </label>&nbsp; <input
			id="insuranceList<c:out value="${rowCount.count-1}"/>.startDate" name="insuranceList[<c:out value="${rowCount.count-1}"/>].startDate"
			class="text" type="text" value="" maxlength="50"></td>
		<td nowrap="nowrap"><label for="insuranceList<c:out value="${rowCount.count-1}"/>.endDate">
		End Date<font color="orangered">*</font> </label>&nbsp; <input
			id="insuranceList<c:out value="${rowCount.count-1}"/>.endDate" name="insuranceList[<c:out value="${rowCount.count-1}"/>].endDate"
			class="text" type="text" value="" maxlength="50"></td>
	</tr>
</c:forEach>
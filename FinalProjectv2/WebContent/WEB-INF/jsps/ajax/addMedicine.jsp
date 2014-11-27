<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<c:forEach var="medicine" items="${medicineList}" varStatus="rowCount" >
	<tr>
		<td nowrap="nowrap"><label for="medicineList<c:out value="${rowCount.count-1}"/>.medicineName">
		Medicine Name<font color="orangered">*</font> </label> &nbsp; <input
			id="medicineList<c:out value="${rowCount.count-1}"/>.medicineName" name="medicineList[<c:out value="${rowCount.count-1}"/>].medicineName"
			class="text" type="text" value="" maxlength="50" /></td>
		<td nowrap="nowrap"><label
			for="medicineList<c:out value="${rowCount.count-1}"/>.medicineIngredients"> Medicine Ingredients<font
			color="orangered">*</font> </label>&nbsp; <input
			id="medicineList<c:out value="${rowCount.count-1}"/>.medicineIngredients"
			name="medicineList[<c:out value="${rowCount.count-1}"/>].medicineIngredients" class="text" type="text"
			value="" maxlength="50" /></td>
		<td nowrap="nowrap"><label for="medicineList<c:out value="${rowCount.count-1}"/>.quantity">
		Medicine Quantity<font color="orangered">*</font> </label>&nbsp; <input
			id="medicineList<c:out value="${rowCount.count-1}"/>.quantity" name="medicineList[<c:out value="${rowCount.count-1}"/>].quantity"
			class="text" type="text" value="0" maxlength="50" /></td>
	</tr>
</c:forEach>
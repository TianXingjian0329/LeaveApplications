<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Leave Type page</h3>
<form:form method="POST" commandName="leavetype"
	action="${pageContext.request.contextPath}/admin/leavetype/create">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="Leave Id" /></td>
				<td><form:input path="leaveId" value="${id }" /></td>
				<td><form:errors path="leaveId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Leave Type" /></td>
				<td><form:input path="leaveName" /></td>
				<td><form:errors path="leaveName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Role Name" /></td>
				<td><form:input path="roleName" /></td>
				<td><form:errors path="roleName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Number Of Days" /></td>
				<td><form:input path="days" /></td>
				<td><form:errors path="days" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>


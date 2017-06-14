
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<a href="${pageContext.request.contextPath}/admin/create">Add
	User</a>
<c:if test="${fn:length(employeeList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="EmployeeID" /></th>
				<th><spring:message code="EmployeeName" /></th>
				<th><spring:message code="Manager" /></th>
				<th><spring:message code="Role" /></th>
				<th><spring:message code="Edit" /></th>
				<th><spring:message code="Delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employeeList}">
				<tr class="listRecord">
					<td>${employee.empId}</td>
					<td>${employee.empName}</td>
					<td>${employee.managerName}</td>
					<td>${employee.roleName}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/managestaff/edit/${employee.empId}"><spring:message
								code="Edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/deleteemployee/${employee.empId}"><spring:message
								code="Delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
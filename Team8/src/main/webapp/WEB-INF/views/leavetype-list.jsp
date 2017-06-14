
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>Leave Type List page </h3>
<a href="${pageContext.request.contextPath}/admin/leavetype/create">Add
	Leave Type</a>

<c:if test="${fn:length(LeaveTypeList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="Leave ID" /></th>
				<th><spring:message code="Leave Type" /></th>
				<th><spring:message code="Role Name" /></th>
				<th><spring:message code="Number Of Days" /></th>
				<th><spring:message code="Edit" /></th>
				<th><spring:message code="Delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="leavetype" items="${LeaveTypeList }">
				<tr class="listRecord">
					<td>${leavetype.leaveId}</td>
					<td>${leavetype.leaveName}</td>
					<td>${leavetype.roleName}</td>
					<td>${leavetype.days}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/leavetype/edit/${leavetype.leaveId}"><spring:message
								code="Edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/leavetype/delete/${leavetype.leaveId}"><spring:message
								code="Delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
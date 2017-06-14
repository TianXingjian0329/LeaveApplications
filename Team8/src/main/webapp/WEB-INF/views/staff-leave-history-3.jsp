<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>
	<h3>
		Employee Leave History
	</h3>
	<c:if test="${fn:length(history) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr class="listHeading">
				<th><spring:message code="Leave ID" /></th>
				<th><spring:message code="User ID" /></th>
				<th><spring:message code="Leave ID" /></th>
				<th><spring:message code="Start Date" /></th>
				<th><spring:message code="End Date" /></th>
				<th><spring:message code="Total Number of Leaves" /></th>
				<th><spring:message code="Status" /></th>
				<th><spring:message code="Manage" /></th>
				<th><spring:message code="Delete" /></th>
			</tr>
			<c:forEach var="leave" items="${history}">
				<tr class="listRecord">
					<td>${leave.application_id}</td>
					<td>${leave.user_id}</td>
					<td>${leave.leave_id}</td>
					<td>${leave.date_of_application}</td>
					<td>${leave.date_of_application}+>${leave.period}</td>
					<td>${leave.period}</td>
					<td>${leave.status}</td>
					<c:if
						test="${leave.status eq 'SUBMITTED' || leave.status eq 'UPDATED' }">
						<td><a
							href="${pageContext.request.contextPath}/employee/manage${leave.leaveId}.html"><spring:message
									code="fieldLabel.update" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/employee/withdraw${leave.leaveId}.html"><spring:message
									code="fieldLabel.withdraw" /></a></td>
					</c:if>
					<c:if
						test="${leave.status eq 'WITHDRAWN' || leave.status eq 'APPROVED' ||leave.status eq 'REJECTED' }">
						<td></td>
						<td></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
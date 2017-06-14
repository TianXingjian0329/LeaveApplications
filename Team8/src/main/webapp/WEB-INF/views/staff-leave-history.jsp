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
				<th><spring:message code="Application ID" /></th>
				<th><spring:message code="Leave Type" /></th>
				<th><spring:message code="Start Date" /></th>
				<th><spring:message code="Leave Period" /></th>
				<th><spring:message code="Status" /></th>
				<th><spring:message code="Reason" /></th>
				<th><spring:message code="Comment by manager" /></th>
				<th><spring:message code="Manage" /></th>
				<th><spring:message code="Withdraw" /></th>
			</tr>
			<c:forEach var="leave" items="${history}">
				<tr class="listRecord">
					<td>${leave.applicationId}</td>
					<td>${leave.leaveType}</td>
					<td>${leave.startDate}</td>
					<td>${leave.days}</td>
					<td>${leave.status}</td>
					<td>${leave.reason}</td>
					<td>${leave.comment}</td>					
				</tr>
			</c:forEach>
			<c:if test="${fn:length(future) gt 0}">
			<c:forEach var="leave" items="${future}">		
				<tr class="listRecord">
				<td>${leave.applicationId}</td>
					<td>${leave.leaveType}</td>
					<td>${leave.startDate}</td>
					<td>${leave.days}</td>
					<td>${leave.status}</td>
					<td>${leave.reason}</td>
					<td>${leave.comment}</td>	
					<c:if
						test="${leave.status eq 'SUBMITTED' || leave.status eq 'UPDATED' }">
						<td><a
							href="${pageContext.request.contextPath}/employee/manage/${leave.applicationId}"><spring:message
									code="Update" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/employee/withdraw/${leave.applicationId}"><spring:message
									code="Withdraw" /></a></td>
					</c:if>
					<c:if
						test="${leave.status eq 'WITHDRAWN' || leave.status eq 'APPROVED' ||leave.status eq 'REJECTED' }">
						<td></td>
						<td></td>
					</c:if>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</c:if>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Application</title>
</head>
<body>
	<style>
	.btn {
    background-color: #99ccff;
    border: none;
    color: black;
    padding: 6px 8px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 3px 2px;
    cursor: pointer;
	}
</style>
	<table width="100%" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr bgcolor="pink">
			<h3>Application Form</h3>
		</tr>
	</table>
	<form:form method="POST" >
			
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr>
				<th>ApplicationID</th>
				<th>UserName</th>
				<th>LeaveType</th>
				<th>Date</th>
				<th></th>
				<th>Period</th>
				<th>Reason<th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="application" items="${pendingApproval}">
		<tr>
			<td>${application.appId}</td>
			<td>${application.userName}</td>
			<td>${application.leaveName}</td>
			<td>${application.date}</td><td></td>
			<td>${application.period}</td>
			<td>${application.reason}</td><td></td>
			<td>${application.status}</td>
			<td>
				<%-- <c:url	value="/manager/application/display/${application.appId}" var="detail" />
					<button class="btn btn-detail" onclick="location.href='${detail}'">Detail</button> --%>
				<a href="${pageContext.request.contextPath}/manager/application/display/${application.appId}"><spring:message
								code="detail" /></a>
				<%-- <c:url	value="/manager/application/history/${application.appId}" var="history" />
					<button class="btn btn-history" onclick="location.href='${history}'">History</button> --%>
				<a href="${pageContext.request.contextPath}/manager/application/history/${application.appId}"><spring:message
								code="history" /></a>	
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	</form:form>
</body>
</html>
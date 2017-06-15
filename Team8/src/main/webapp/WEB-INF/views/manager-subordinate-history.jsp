
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Application</title>
</head>
<body>
	<table width="100%" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr bgcolor="pink">
			<h3>Leave History</h3>
		</tr>
	</table>
	<form:form method="GET" >
			
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr>
				<th>ApplicationID</th>
				<th>UserName</th>
				<th>LeaveType</th>
				<th>Date</th>
				<th>Period</th>
				<th>Reason<th>
				<th>Status</th>
				<th>ManagerComment</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="application" items="${subordinateHistory}">
		<tr>
			<td>${application.appId}</td>
			<td>${application.userName}</td>
			<td>${application.leaveName}</td>
			<td>${application.date}</td>
			<td>${application.period}</td>
			<td>${application.reason}</td><td></td>
			<td>${application.status}</td>
			<td>${application.comment}</td>
			
		</c:forEach>
		</tbody>
	</table>
	
	</form:form>
</body>
</html>
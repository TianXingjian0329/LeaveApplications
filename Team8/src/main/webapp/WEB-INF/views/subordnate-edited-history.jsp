
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Subordinate History</title>
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
			<h3>All Subordinate History</h3>
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
				<th>Comment</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="application" items="${editedApproval}">
		<tr>
			<td>${application.appId}</td>
			<td>${application.userName}</td>
			<td>${application.leaveName}</td>
			<td>${application.date}</td><td></td>
			<td>${application.period}</td>
			<td>${application.reason}</td><td></td>
			<td>${application.status}</td>
			<td>${application.comment}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/; charset=ISO-8859-1">
<title>All Leave Application List</title>
</head>
<body>
<h3>Leave Entitlement List</h3>
<table style="cellspacing: 2; cellpadding: 2; border: 1;" >
<thead>
<tr class="listHeading">
<td>Application Id</td>
<td>User Id</td>
<td>Leave Id</td>
<td>Leave Date</td>
<td>Leave Period</td>
<td>Status</td>
<td>Reason</td>
<td>Comment</td>
<td>Edit</td>
<td>Delete</td>
</tr>
</thead>
<c:forEach var="application" items="${allApplication}">
<tr class="listRecord">
<td><c:out value = "${application.applicationId}"/></td>
<td><c:out value = "${application.userId}"/></td> 
<td><c:out value = "${application.leaveId} "/></td>
<td><c:out value = "${application.leaveDate}"/></td>
<td><c:out value = "${application.leavePeriod}"/></td>
<td><c:out value = "${application.status}"/></td>
<td><c:out value = "${application.reason}"/></td>
<td><c:out value = "${application.comment}"/></td>

<td><a href="${pageContext.request.contextPath}/admin/entitlement/update/${application.applicationId}">
<spring:message code="Update" /></a>
</td>
<td><a href="${pageContext.request.contextPath}/admin/entitlement/delete/${application.applicationId}">
<spring:message code="Delete" /></a>
</td>
 </tr>
</c:forEach> 
 </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Application Entitlement</h1>
<form:form  method="POST" commandName="application" 
           action="${pageContext.request.contextPath}/entitlement/update/${ application.applicationId }">
<table>
<tbody>
<tr>
<td>ApplicationID:</td>
<td><form:input path="applicationId" readonly="true" /></td>
</tr>
<tr>
<td>UserId :</td>
<td><form:input path="userId" value="${application.userId }"/></td>
</tr>
<tr>
<td>LeaveId :</td>
<td><form:input path="leaveId"  value="${application.leaveId }"/></td>
</tr>
<tr>
<td>LeaveDate :</td>
<td><form:input path="leaveDate" value="${application.leaveDate }"/></td>
</tr>
<tr>
<td>LeavePeriod :</td>
<td><form:input path="leavePeriod" value="${application.leavePeriod }"/></td>
</tr>
<tr>
<td>Status :</td>
<td><form:input path="status" value="${application.status }"/></td>
</tr>
<tr>
<td>Reason :</td>
<td><form:input path="reason" value="${application.reason }"/></td>
</tr>
<tr>
<td>Comment :</td>
<td><form:input path="reason" value="${application.comment }"/></td>
</tr>
<tr>
<td><input type="submit" value="Update" /></td>
</tr>
</tbody>
</table>
</form:form>
<br/>
<a href="${pageContext.request.contextPath}/entitlement/list">Go to Entitlement List</a><br/>
</body>
</html>



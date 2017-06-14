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
<h1>Delete Application Entitlement</h1>
<form:form  method="POST" commandName="application" action="${pageContext.request.contextPath}/entitlement/delete/${param['applicationid']}">
<table>
<tbody>
<tr>
<td><form:hidden path="applicationId" /></td>
</tr>
<tr>
<td>UserId :</td>
<td><form:input path="userId" readonly="true"/></td>
</tr>
<tr>
<td>LeaveId :</td>
<td><form:input path="leaveId" readonly="true"/></td>
</tr>
<tr>
<td>LeaveDate :</td>
<td><form:input path="leaveDate" readonly="true"/></td>
</tr>
<tr>
<td>LeavePeriod :</td>
<td><form:input path="leavePeriod" readonly="true"/></td>
</tr>
<tr>
<td>status :</td>
<td><form:input path="status" readonly="true"/></td>
</tr>
<tr>
<td>reason :</td>
<td><form:input path="reason" readonly="true"/></td>
</tr>
<tr>
<tr>
<td><form:hidden path ="deletedby" value= "test"/></td>
</tr>
<tr>
<td><form:hidden path ="datedeleted" value= "2017-12-01"/></td>
</tr>
<tr>
<td><input type="submit" value="Delete" /></td>
</tr>
</tbody>
</table>
</form:form>
<br/>
<a href="${pageContext.request.contextPath}/entitlement/list">Go to Entitlement List</a><br/>
</body>
</html>





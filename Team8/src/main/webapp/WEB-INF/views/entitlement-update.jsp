<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>

<h3>Edit Application Entitlement</h3>
<form:form  method="POST" commandName="application" 
           action="${pageContext.request.contextPath}/admin/entitlement/update/${ application.applicationId }">
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
<td><form:input path="leaveDate" value="${application.leaveDate }" type="date"
					id="datepicker1" /></td>
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

</body>
</html>


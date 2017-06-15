<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table width="100%" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr bgcolor="pink">
			<h3>Application Details</h3>
		</tr>
	</table>
	<table>
		<tr>
			<th align="right">Application ID : </th>
			<td colspan="3"><c:out value="${application.applicationId}" /></td>
		</tr>
		<tr>
			<th align="right">Date : </th>
			<td><fmt:formatDate value="${application.leaveDate}"/>
			</td>
		</tr>
		<tr>
			<th align="right">Period : </th>
			<td colspan="3"><c:out value="${application.leavePeriod}" /></td>
		</tr>
		<tr>
			<th  align="right">UserName : </th>
			<td colspan="3"><c:out value="${application.user.getUserName()}" /></td>
		</tr>
		<tr>
			<th align="right">LeaveType : </th>
			<td colspan="3"><c:out value="${application.leaveType.getLeaveName()}" /></td>
		</tr>
	</table>
	
	<form:form method="POST" modelAttribute="approve"
		action="${pageContext.request.contextPath}/manager/application/edit/${application.applicationId}.html">
		<table>
			<tr>
				<td>
					<label class="radio-inline">
					<form:radiobutton path="decision" value="APPROVED" id="decision"/> Approved
					</label>
					<form:radiobutton path="decision" value="REJECTED" id="decision" />Reject
				</td>
			</tr>
			<tr>
				<td>
					<form:textarea path="comment" cols="60" rows="4" id="comment"/>
				</td>
			</tr>
		</table>
		<form:button name="submit" type="submit" value="Save">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				width="59" height="22" alt="" border="0">
		</form:button>
	</form:form>
</body>
</html>
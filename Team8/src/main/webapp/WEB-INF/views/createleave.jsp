
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<h3>Leave Application Page</h3>
<form:form method="POST" commandName="newleave"
	action="${pageContext.request.contextPath}/employee/createleave">

	<table>
	
		<tr>
		<tr>
			<td><spring:message code="Application No" /></td>
			<td colspan="3"><form:input size="40" path="applicationId" value="${appid }" readonly="true"/> <form:errors
					path="applicationId" cssStyle="color: red;" /></td>
		</tr>
		<tr>
		<td><spring:message code="Leave Type" /></td>
		<td colspan="3"><form:select path="leavetype">
					<form:option value="" label="LeaveType" />
						<form:options items="${leavetypes}" />
				</form:select> <form:errors path="leavetype" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="From" /></td>
			<td><form:input size="16" path="leaveDate" id="datepicker1" />
				<form:errors path="LeaveDate" cssStyle="color: red;" /></td>
			<%-- <td><spring:message code="To" /></td>
			<td><form:input size="16" path="toDate" id="datepicker2" />
				<form:errors path="toDate" cssStyle="color: red;" /></td> --%>
		</tr>
		<tr>
			<td><spring:message code="Total days" /></td>
			<td colspan="3"><form:input size="40" path="leavePeriod" /> <form:errors
					path="LeavePeriod" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="Reason" /></td>
			<td colspan="3"><form:textarea cols="100" rows="5"
					path="reason" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2" align="left"><br></br> <form:button
					type="submit">
					<img
						src="${pageContext.request.contextPath}/image/button_submit.gif"
						alt="" align="middle">
				</form:button>&nbsp; <a href="javascript:history.back();"> <img
					src="${pageContext.request.contextPath}/image/button_cancel.gif"
					alt="" align="middle" border="0">
			</a></td>
		</tr>

	</table>
</form:form>

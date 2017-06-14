<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Employee page</h3>
<form:form method="POST" commandName="createEmployee"
	action="${pageContext.request.contextPath}/admin/create">
	<table>
		<tbody>
			
			<tr>
				<td>Employee Id</td>
				<td><form:input path="employeeId" value="${employeeId}" readonly="true"/></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Employee Name</td>
				<td><form:input path="empName"/></td>
				<td><form:errors path="empName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><form:input path="passWord"/></td>
				<td><form:errors path="passWord" cssStyle="color: red;" /></td>
			</tr>
					
			<tr>
				<td>Manager Name</td>
				<td>
				
					<form:select path="managerName">
						
						<form:option value="" label="ManagerName" />
						<form:options items="${managerList}" />
					</form:select>
					
					</td>
				<td><form:errors path="managerName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Role Name</td>
				<td><form:select path="roleName">
						<form:option value="" label="RoleName" />
						<form:options items="${roleNameList}" />
					</form:select></td>
				<td><form:errors path="roleName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
			
		</tbody>
	</table>
</form:form>

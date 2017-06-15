<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Employee page</h3>
<form:form method="POST" commandName="createEmployee"
	action="${pageContext.request.contextPath}/admin/employee/edit/${createEmployee.employeeId}">
	<table>
		<tbody>
			
			<tr>
				<td>Employee Id</td>
				<td><form:input path="employeeId" value="${createEmployee.employeeId}" readonly="true"/></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Employee Name</td>
				<td><form:input path="empName" value="${createEmployee.empName}"/></td>
				<td><form:errors path="empName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><form:input path="passWord" value="${createEmployee.passWord}"/></td>
				<td><form:errors path="passWord" cssStyle="color: red;" /></td>
			</tr>
					
			<tr>
				<td>Manager Name</td>
				<td>
				
					<form:select path="managerName">
						
						<form:option value="${createEmployee.managerName}" label="${createEmployee.managerName}" />
						<form:options items="${managerList}" />
					</form:select>
					
				</td>
				<td><form:errors path="managerName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Role Name</td>
				<td><form:select path="roleName">
						
						<form:option value="${createEmployee.roleName}" label="${createEmployee.roleName}" />
						<form:options items="${roleNameList}" />
					</form:select></td>
				<td><form:errors path="roleName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save Changes" /></td>
				<td></td>
				<td></td>
			</tr>
			
		</tbody>
	</table>
</form:form>

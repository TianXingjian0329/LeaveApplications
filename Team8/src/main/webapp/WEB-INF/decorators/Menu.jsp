<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:if test="${sessionScope.USERSESSION.user.roleSet.size() gt 0}">
	<ul>
		<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
			<c:choose>
				<c:when test="${role.RoleId eq 'admin' }">
					<li>
							<input id="" type="button" value="Manager Leave Types">
					</li>
					<li>
							<input id="" type="button" value="Manager Staff">
					</li>
					<li>
							<input id="" type="button" value="Manage Leave Entitlement">
					</li>
					<li>
							<input id="" type="button" value="Manage Approval Hierachy">
					</li>
				</c:when>
				<c:when test="${role.RoleId eq 'staff' }">
					<li>
					</li>
				</c:when>
				<c:when test="${role.RoleId eq 'Manager' }">
					<li>
					</li>
				</c:when>
			</c:choose>
		</c:forEach>
		</ul>
	</c:if>
<table>
  <tr>
    <td>Please Login</td>
  </tr>
</table>



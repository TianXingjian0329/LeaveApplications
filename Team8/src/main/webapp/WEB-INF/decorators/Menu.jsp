<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:if test="${sessionScope.USERSESSION.type != null}">
	<ul>
		
			
				<c:if test="${sessionScope.USERSESSION.type == 'admin' }">
					<li>
							<a href="${pageContext.request.contextPath}/admin/managelt">Manage Leave Types </a>
					</li>
					<li>
							<a href="${pageContext.request.contextPath}/admin/managestaff">Manage Staff</a>
					</li>
					<li>
							<a href="${pageContext.request.contextPath}/admin/managele">Manage Leave Entitlement</a>
					</li>
				</c:if>
				<c:if test="${sessionScope.USERSESSION.type == 'manager' }">
					<li>
					</li>
				</c:if>
				<c:if test="${sessionScope.USERSESSION.type == 'employee' }">
					<li>
					</li>
				</c:if>
			
		
		</ul>
	</c:if>
	<c:if test="${sessionScope.USERSESSION.type == null}">
		<table>
 		 <tr>
    		<td>Please Login</td>
  		</tr>
		</table>
		</c:if>



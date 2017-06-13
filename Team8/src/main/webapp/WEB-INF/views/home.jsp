<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Leave Application!
</h1>
<h2><a href="${pageContext.request.contextPath}/home/login">Login </a></h2>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

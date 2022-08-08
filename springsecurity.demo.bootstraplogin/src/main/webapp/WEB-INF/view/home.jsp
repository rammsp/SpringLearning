<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<p style="text-align:right;">Hi
		<security:authentication property="principal.username" />
		,
		<br/>
		<security:authentication property="principal.authorities" />
	</p>
	<h1>WELCOME TO HOME PAGE</h1>
</td>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
	</body>
</html>
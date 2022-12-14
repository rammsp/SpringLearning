<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
	<c:if test="${param.error != null}">
		<i class = "error">Sorry UserName / Password combination incorrect</i>
	</c:if>
		<p>UserName: <input type = "text" name = "username"/></p>
		<p>Password: <input type = "password" name = "password"/></p>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>
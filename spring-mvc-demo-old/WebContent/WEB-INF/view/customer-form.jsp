<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer - Form</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<form:form modelAttribute="customer" action="processCustomerForm">
		First Name (*):<form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		<br>
		Passes (*): <form:input path="passes" />
		<form:errors path="passes" cssClass="error"/>
		<br>
		<br>
		Postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/>
		<br>
		<br>
		Course Code: <form:input path="tutorial" />
		<form:errors path="tutorial" cssClass="error"/>
		<br>
		<br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>
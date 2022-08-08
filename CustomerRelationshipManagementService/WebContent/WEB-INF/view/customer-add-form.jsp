<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Relationship Manager</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Customer Relationship Manager</h1>
			<h2>Add New Customer Form</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form:form action="saveCustomer" modelAttribute="customer"
				method="post">
				<form:hidden path="id"/>
				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<a href="${pageContext.request.contextPath}/customer/list">Return to Customer List</a>
		</div>
	</div>
</body>
</html>
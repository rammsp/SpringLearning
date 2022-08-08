<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Added</title>
</head>
<body>
	<p> The Customer is added: ${customer.firstName} ${customer.lastName}</p>
	<br>
	<p>No of Passes: ${customer.passes} </p>
	<br>
	<p>Postal Code: ${customer.postalCode} </p>
	<br>
	<p>Course Code: ${customer.tutorial} </p>
	<br>
</body>
</html>
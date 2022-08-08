<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student - Enrollment Form</title>
</head>
<body>
	<h2>Student Enrollment Form</h2>
	<form:form modelAttribute="student" action="enrollmentSuccess">
		First Name: <form:input path="firstName" />
		<br>
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		<br>
		Gender: 
		<form:select path="gender">
			<form:option value="Male" label="M"></form:option>
			<form:option value="Female" label="F"></form:option>
		</form:select>
		<br>
		<br>
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br>
		<br>
		Current State:
		<form:select path="currentState">
			<form:options items="${states}"/>
		</form:select>
		<br>
		<br>
		Language:
		<form:radiobuttons path="language" items="${student.languageOptions}"/>
		<br>
		<br>
		OS:
		<form:checkbox path="os" value="Windows" label="Windows"/>
		<form:checkbox path="os" value="Linux" label="Linux"/>
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
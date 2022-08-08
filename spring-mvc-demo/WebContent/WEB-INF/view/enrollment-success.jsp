<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Enrollment Success</title>
</head>
<body>
	The Student is enrolled!!!
	<br>
	<br> 
	Name: ${student.firstName} ${student.lastName}
	<br>
	<br>
	Gender: ${student.gender}
	<br>
	<br>
	Country: ${student.country}
	<br>
	<br>
	State: ${student.currentState}
	<br>
	<br>
	Language: ${student.language}
	<br>
	<br>
	OS:
	<ul>
	<c:forEach var="temp" items="${student.os}">
		<li>${temp}</li>
	</c:forEach>
	</ul>
</body>
</html>
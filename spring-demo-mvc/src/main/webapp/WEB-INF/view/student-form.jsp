<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student | Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student" method="POST">
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" />
		<br>

		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" />
		<br>

		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>

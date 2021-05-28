<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<br>

		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" />
		<br>
		<br>

		<form:label path="countryA">Country A</form:label>

		<!-- way 1: Hard Code -->
		<%-- 
		<form:select path="country">
			<form:option value="AR" label="Argentina"/>
			<form:option value="BE" label="Belgium"/>
			<form:option value="CR" label="Costa Rica"/>
			<form:option value="DK" label="Denmark" />
		</form:select> 
		--%>

		<!-- way 2: Load from data Java Source -->
		<form:select path="countryA">
			<form:options items="${student.countryOptionsA}" />
		</form:select>

		<!-- way 2: Load from data properties -->
		<form:label path="countryB">Country B</form:label>
		<form:select path="countryB">
			<form:options items="${countryOptionsB}" />
		</form:select>

		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>

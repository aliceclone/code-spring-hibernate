<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
.error {
	color: red;
}
</style>

<title>Customer | Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="customer" method="POST">
		<form:label path="firstName">First Name: </form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>

		<form:label path="lastName">Last Name (*): </form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		<br>

		<form:label path="freePass">Free Pass: </form:label>
		<form:input path="freePass" />
		<form:errors path="freePass" cssClass="error" />
		<br>
		<br>

		<form:label path="postalCode">Postal Code: </form:label>
		<form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br>
		<br>
		
		<form:label path="courseCode">Course Code: </form:label>
        <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error" />
        <br>
        <br>
        
		<input type="submit" value="Submit">
	</form:form>


</body>
</html>
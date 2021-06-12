<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<hr>

<!-- ❗️username & password form Spring -->
	<form:form action="${pageContext.request.contextPath}/auth" method="POST">
	
	<!-- No need to bind model attribute, just html tag is OK -->
		<label id="username">Name:</label>
		<input type="text" name="username"/>
		<br><br>
		<label id="password">Password:</label>
		<input type="password" name="password"/>
		<br><br>
		<input type="submit" value="Login">
	</form:form>

</body>
</html>
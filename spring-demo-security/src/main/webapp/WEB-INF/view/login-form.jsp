<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.err {
color: red;
}
</style>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<hr>
	<c:if test="${param.error != null}">
	<h3 class="err"> Invalid User!</h3>
	</c:if>
	

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
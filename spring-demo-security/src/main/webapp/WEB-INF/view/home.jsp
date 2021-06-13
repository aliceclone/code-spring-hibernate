<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<!-- <input type="submit" value="Logout"> -->
		<a href="#" onclick="submit()"> Logout </a>
	</form:form>
	<hr>
	<h1>Hello! ようこそ!</h1>

	<i> Welcome Back, <sec:authentication property="name" />!
	</i>
	<p>
		User Name:
		<sec:authentication property="principal.username" />
		<br> <br> Roles:
		<sec:authentication property="principal.authorities" />
	</p>

</body>
</html>
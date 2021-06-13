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
	<hr>
	<!-- restrict content  -->
	<sec:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/managers">Leadership
			Meeting</a>
	</sec:authorize>

	<sec:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems">IT System
			Meeting</a>
	</sec:authorize>
	<!-- restrict content  -->

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<!-- <input type="submit" value="Logout"> -->
		<a href="#" onclick="submit()"> Logout </a>
	</form:form>
	<hr>
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

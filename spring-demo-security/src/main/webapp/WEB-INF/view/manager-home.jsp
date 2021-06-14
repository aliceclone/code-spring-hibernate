<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leadership | Home</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<a href="#" onclick="submit()">Logout</a>
	</form:form>
	<hr>
	Welcome back,
	<sec:authentication property="name" />

	<p>What is leadership? Learn more about Meaning, Theories in annual
		trip! ✈️</p>

	<a href="${pageContext.request.contextPath}/home"> Back</a>
</body>
</html>

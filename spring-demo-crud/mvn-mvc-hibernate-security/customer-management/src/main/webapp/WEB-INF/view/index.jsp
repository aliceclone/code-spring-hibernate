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
<title>Welcome</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Management System</h2>
		</div>
	</div>

	<sec:authorize access="isAuthenticated()">
       Welcome Back, <sec:authentication property="name" />
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<a href="#" onclick="submit()"> Logout </a>
		</form:form>
	</sec:authorize>

	<sec:authorize access="!isAuthenticated()">
		<p>
			If you are already a member, please <a
				href="${pageContext.request.contextPath}/login"> login</a>
		</p>
	</sec:authorize>

</body>
</html>

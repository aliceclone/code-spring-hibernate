<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greet Form</title>
</head>
<body>
	<%--  <form action="greet" method="GET" --%>
	<%-- way 1  --%>
	<!-- <form action="servletShout" method="GET"> -->
	
	<%-- way 2: project name will be shown in HTML page! --%>
	<%-- <form action="${pageContext.request.contextPath}/hi/shout" method="GET"> --%>
	
	<%-- way 3: project name will be shown in HTML page! --%>
	<%-- <form action="<c:url value="/hi/shout"/>" method="GET"> --%>
    <form action="shout" method="GET"> 
		<input type="text" name="name" placeholder="What's is your name" />
		<input type="submit">
	</form>
	
</body>
</html>
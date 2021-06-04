<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- include css link with JSTL --%>
<%-- <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> --%>

<%-- include css link with spring --%>
<spring:url value="/resources/css/style.css" var="mainCss"></spring:url>
<link type="text/css" rel="stylesheet" href="${mainCss}" />
  
  
<title>Customer | List</title>
</head>
<body>

	<div id="wrapper">
	<div id="header">
			<h2>Customer Management</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>

				<!-- fetch data  -->
				<tbody>
					<c:forEach var="customer" items="${customers}" >
					
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
						</tr>
						
					</c:forEach>
				</tbody>

			</table>

		</div>

	</div>


</body>
</html>
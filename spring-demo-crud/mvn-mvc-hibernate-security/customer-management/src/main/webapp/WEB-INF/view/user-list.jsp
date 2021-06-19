<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- include css link with JSTL --%>
<%-- <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> --%>

<%-- include css link with spring --%>
<spring:url value="/static/css/style.css" var="mainCss"></spring:url>
<link type="text/css" rel="stylesheet" href="${mainCss}" />


<title><spring:message code="customer.title" /></title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Management</h2>
		</div>
	</div>

	<!-- return false -> cancel default behavior (in this case: prevent submitting) -->
	<!-- 	<input type="button" value="Add Customer"
		onclick="window.location.href='form'; return false;"
		class="add-button"> -->

	<a href="users/add" style="text-decoration: none; color: #7aa1f4">New User</a>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <a href="#" style="text-decoration: none; color: #7aa1f4" onclick="submit()"> Logout </a>
    </form:form>

	<div id="container">

		<div id="content">

			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>User Name</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>

				<!-- fetch data  -->

				<tbody>
					<c:forEach var="user" items="${users}">

						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>${user.userName}</td>
							<td><a href="users/${user.id}/update">Update</a></td>
							<td>
							<!-- way II with spring url --> 
							<spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
							<a href="${deleteUrl}" onclick="if(!confirm('Are you sure?')) return false;">Delete</a>
							</td>
						</tr>

						<!-- way III with c:url -->
						<%-- 	
						<c:url var="updateLink" value="formUpdate">
							<c:param name="customerId" value="${customer.id}">
							</c:param>
						</c:url> 
						--%>
						<!-- way II -->

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
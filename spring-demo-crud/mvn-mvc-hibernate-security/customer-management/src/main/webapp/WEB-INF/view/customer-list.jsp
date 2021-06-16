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
<spring:url value="/resources/css/style.css" var="mainCss"></spring:url>
<link type="text/css" rel="stylesheet" href="${mainCss}" />


<title> <spring:message code="customer.title" /> </title>
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

	<a href="customers/add" style="text-decoration: none; color: #7aa1f4"
		class="add-button">New Customer</a>


	<div id="container">

		<div id="content">

			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>

				<!-- fetch data  -->

				<tbody>
					<c:forEach var="customer" items="${customers}">

						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a href="customers/${customer.id}/update">Update</a></td>
							<td>
								<!-- way II with spring url --> <spring:url
									value="/customers/${customer.id}/delete" var="deleteUrl" /> <a
								href="${deleteUrl}"
								onclick="if(!confirm('Are you sure?')) return false;">Delete</a>
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
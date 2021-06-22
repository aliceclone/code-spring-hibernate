<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/add-customer-style.css" />
<title>Customer | Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
		<%--  <spring:url value="/customers" var="customerActionUrl" /> --%>
		<form:form modelAttribute="customerForm"
			action="${pageContext.request.contextPath}/customers" method="POST">
			<%-- ❗ without hidden (id) update won't work --%>
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><form:label path="firstName"> First Name:</form:label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><form:label path="lastName"> Last Name:</form:label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><form:label path="email"> Email:</form:label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
			<br>
			<br>
		</form:form>
	</div>

	<a href="${pageContext.request.contextPath}/customers">Back</a>
	<!-- WORK too <a href="list">Back</a> -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer | List</title>
</head>
<body>

	<div id="wrap">
		<h2>Customer Management</h2>
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
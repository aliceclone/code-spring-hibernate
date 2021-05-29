<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student | Confirmation</title>
</head>
<body>

	Confirmed: ${student.firstName} ${student.lastName}
	<br>
	<br> CountryA: ${student.countryA}
	<%-- <c:set var = "countryA" value = "${student.countryOptionsA[student.countryA]}"/> --%>
	${student.countryOptionsA[student.countryA]}
	
	<br> CountryB: ${student.countryB} ${countryOptionsB}

	<hr>
	Favorite Language: ${student.favoriteLanguage}
	<br>
	<br> Operation Systems:

	<ul>
		<c:forEach var="os" items="${student.operatingSystems}">
			<li>${os}</li>
		</c:forEach>
	</ul>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>All Users</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Birthday</td>
			<td>Sex</td>
			<td>Enabled</td>
			<td></td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.birthday}" /></td>
				<td><c:out value="${user.sex}" /></td>

			</tr>
		</c:forEach>
	</table>
	<form action="<c:url value="/printTable" />" method="GET">
		<input type="submit" name="action" value="Print Table" />
	</form>
	<br />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In Page</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id" />
		<center>
			<table style="width: 30%" border="1" cellpadding="3">
				<thead>
					<tr>
						<th colspan="2">Login Page</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="name">Username: </label></td>
						<td><form:input path="name" id="name" /></td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="password">Password: </label></td>
						<td><form:input path="password" id="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">You have no account? <a href="/third2/new">Register
								Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>

	<h1>Home Page</h1>
	<br />
	<h2>Welcome ${success}</h2>
	<br />

	<c:choose>
		<c:when test="${role}">
			Admin Page <br/>
			<a href="/third2/listuser">List Users</a>
		</c:when>
		<c:otherwise>
			User Page
		</c:otherwise>
	</c:choose>

</body>
</html>
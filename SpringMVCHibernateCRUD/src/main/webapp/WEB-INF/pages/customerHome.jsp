<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>This is customer home</h3>
		<form:form action="postcomment" method="post"
			modelAttribute="userComment">
			<form:textarea path="userComment" placeholder="enter comment" />
			<br><br>
			<input type="submit" value="Post Comment">
			<br><br>
			<a href=viewComment>analysis</a>
		</form:form>
	</div>
</body>
</html>
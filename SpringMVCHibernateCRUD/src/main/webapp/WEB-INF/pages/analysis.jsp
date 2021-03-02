<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>This is comment table</h3><a href="CustomerHome">Back</a>
		<table border="1">
			<th>Comments</th>
			<th>Rating</th>
			<th>Commented by</th>
			<c:forEach var="userComment" items="${listComment}">
				<tr>
					<td>${userComment.userComment}</td>
					<td>${userComment.commentValue}</td>
					<td>${userComment.commentedBy}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
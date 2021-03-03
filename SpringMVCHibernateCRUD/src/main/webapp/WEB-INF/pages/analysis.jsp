<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.navigation{
 overflow: hidden;
  background-color: #333;
}
.navigation a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.navigation a:hover {
  background-color: #ddd;
  color: black;
}
.navigation a.active {
  background-color: #4CAF50;
  color: white;
}
.comment-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
</style>
</head>
<body>

<div class="navigation">
		<a href="CustomerHome">Home</a>
		<a href="about">About</a> 
		<a href="contact">Contact</a> 
		
		<a href="backtologin">SignOut</a>
	</div>

	<div align="center">
		<table border="1" class="comment-table">
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
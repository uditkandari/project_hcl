<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body{
background-color: silver;
}
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
textarea {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

textarea:focus{
  background-color: #ddd;
  outline: none;
}
.button{
background-color: gray;
        border: none;
        color: white;
        padding: 10px 10px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 10px;
        margin: 4px 2px;
        cursor: pointer;
}
</style>
</head>
<body>
	<div class="navigation">
		<a href="about">About</a> 
		<a href="contact">Contact</a> 
		<a href="viewComment">View Report</a>
		<a href="backtologin">Signout</a>
	</div><br><br>

	<div align="center">
		<h3>WELCOME TO COMMENT REVIEW</h3>
		<br><br>
		<form:form action="postcomment" method="post"
			modelAttribute="userComment">
			<form:textarea path="userComment" placeholder="Enter Comment" />
			<br>
			<br>
			<input type="submit" value="Post Comment" class="button">
			<br>
			<br>
			
		</form:form>
	</div>
</body>
</html>
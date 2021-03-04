<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login details</title>


<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-color: silver;
}

.navigation {
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

input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

.button {
	background-color: gray;
	border: none;
	color: white;
	padding: 10px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	cursor: pointer;
}

.error {
	color: red;
}
</style>

</head>
<body>
	<div class="navigation">
		<a href="viewusers">View Users</a>
	</div>
	<h2 align="center">WELCOME TO COMMENT REVIEW</h2>
	<div align="center" class="loginform">
		<form:form action="signinValidation" method="post"
			modelAttribute="login">
			<table>
				<tr>
					<td>CUSTOMER LOGIN</td>
				</tr>

				<tr>
					<td><form:input path="username" type="text"
							placeholder="Username" name="username" /> <form:errors
							path="username" class="error" /></td>
				</tr>
				<tr>
					<td><form:input path="password" type="password"
							placeholder="Password" /> <form:errors path="password"
							class="error" /></td>

				</tr>

			</table>
			<div>
				<h4 class="error">${loginerror}</h4>
				<input type="submit" value="SignIn" class="button"> <a
					href="newCustomer" class="button">SignUp</a>

			</div>

		</form:form>
	</div>
</body>
</html>
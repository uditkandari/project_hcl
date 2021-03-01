<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login details</title>
</head>
<body>
	<h2>WELCOME TO COMMENT REVIEW</h2>
	<div>
		<form:form action="signinValidation" method="post"
			modelAttribute="login">

			<table>

				<tr>
					<td>CUSTOMER LOGIN</td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" type="text" placeholder="username"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password" placeholder="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="SignIn"></td>
					<td><a href="newCustomer">SignUp</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="viewusers">View
							Users</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="CustomerHome">customer home</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
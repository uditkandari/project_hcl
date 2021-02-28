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
	<h2>WELCOME TO COMMENT REVIEW</h2>
	<div>
		<form:form action="signin" method="post" modelAttribute="login">

			<table>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" type="text" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="SignIn"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="newCustomer">SignUp</a></td>
				</tr>
			</table>


		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<script src="<c:url value="/resources/js/signupvalidation.js" />"></script>
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
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 2px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
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
        font-size: 20px;
        margin: 4px 2px;
        cursor: pointer;
}
</style>

</head>
<body onload="document.registration.firstName.focus();">
	<div class="navigation">
		<a href="about">About</a> 
		<a href="contact">Contact</a> 
		<a href="viewusers">View Users</a>
	</div>
	<div align="center">
		<h1>New/Edit Customer</h1>
		<form:form action="saveCustomer" method="post"
			modelAttribute="customer" name="registration"
			onSubmit="return formValidation();" id="form">
			
			<table>
				<form:hidden path="id" />
				<tr>
					<td><form:input path="firstName" placeholder="First Name"
							name="firstName" type="text"/></td>
				</tr>
				<tr>
					<td><form:input path="lastName" placeholder="Last Name"
							name="lastName" type="text"/></td>
				</tr>
				<tr>
					<td><form:input path="email" placeholder="Email" name="email" type="text"/></td>
				</tr>
				<tr>
					<td><form:input path="username" placeholder="Username"
							name="username" type="text"/></td>
				</tr>
				<tr>
					<td><form:input path="password" type="password"
							placeholder="Password" name="password" /></td>
				</tr>
				<tr>
					<td><form:input path="address" placeholder="Address"
							name="address" type="text"/></td>
				</tr>
				<tr>
					<td><form:input path="telephone" placeholder="Telephone"
							name="telephone" type="text"/></td>
				</tr>

				<tr>
					<td align="center"><input type="submit" value="SignUp" class="button"></td>
				</tr>
				<tr>
					<td align="center">Already a user? <a href="backtologin">Sign
							in</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
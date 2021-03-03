<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Management Screen</title>
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

.button {
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
		<a href="backtologin">Login</a>
	</div>
	<br>
	<br>
	<div align="center">
		<h1>Customer List</h1>
		<table border="1">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>
			<c:forEach var="customer" items="${listCustomer}">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td>${customer.telephone}</td>
					<td><a href="editCustomer?id=${customer.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteCustomer?id=${customer.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
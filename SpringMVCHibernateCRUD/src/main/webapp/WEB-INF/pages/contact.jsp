<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info</title>
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
</style>
</head>
<body>
	<div class="navigation">
	<a href="CustomerHome">Home</a>
		<a href="about">about</a> 
		<a href="contact">contact</a> 
		<a href="backtologin">SignOut</a>
	</div>
	<div align="center">
		<fieldset>
			<ol>
				<h2>Try out below numbers to contact</h2>
				<li><h2>Name: Udit Kandari</h2></li>


				<li><h2>Contact:983776565</h2></li>


				<li><h2>Address: Noida</h2></li>

			</ol>

		</fieldset>
	</div>
</body>
</html>
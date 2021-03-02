<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Customer</h1>
        <form:form action="saveCustomer" method="post" modelAttribute="customer" >
        <table>
            <form:hidden path="id"/>
            <tr>
                <td><form:input path="firstName" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td><form:input path="lastName" placeholder="Last Name"/></td>
            </tr>
            <tr>
                <td><form:input path="email" placeholder="Email"/></td>
            </tr>
            <tr>
                <td><form:input path="username" placeholder="Username"/></td>
            </tr>
            <tr>
                <td><form:input path="password" type="password" placeholder="Password"/></td>
            </tr>
            <tr>
                <td><form:input path="address" placeholder="Address"/></td>
            </tr>
            <tr>
                <td><form:input path="telephone" placeholder="Telephone"/></td>
            </tr>
            
            <tr>
                <td align="center"><input type="submit" value="SignUp"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>
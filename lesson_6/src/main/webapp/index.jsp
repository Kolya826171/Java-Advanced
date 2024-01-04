<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start page</title>
</head>
<body>

	<form action="registration" method="post">
		<label>First name :</label> <input name="firstName">
		<br> <label>Last name :</label> <input name="lastName"> 
		<br> <label>Email :</label> <input name="email"> 
		<br> <label>Password:</label> <input name="password"> 
		<br> <input type="submit" value="Submit"></input>
	</form>

</body>
</html>
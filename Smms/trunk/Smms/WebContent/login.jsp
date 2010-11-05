<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div id="message">${globalMessage}</div>
<form action="j_spring_security_check" method="post">
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username" />
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>
		<input type="submit" value="Login"/>
</form></body>
</html>
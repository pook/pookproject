<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="styles/login.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>
<body>
<div id="login">
<div id="msgerr" style="color: red">${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message,
'Bad credentials', 'Username / Password are incorrect ')}</div>
<form action="j_spring_security_check" method="post">
<table>
	<tr>
		<td><label for="j_username">Username :</label></td>
		<td><input type="text" name="j_username" id="j_username" width="80" /></td>
	</tr>
	<tr>
		<td><label for="j_password">Password :</label></td>
		<td><input type="password" name="j_password" id="j_password" width="80" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input id="submit" type="submit" value="Login"  />
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>
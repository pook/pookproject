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

<link rel="stylesheet" href="styles/font.css" type="text/css" />
<title>Login</title>
</head>
<body>
<center>
<div style=" background-image:url(images/login_bg.jpg); width:1001px; height:822px;">
<div id="msgerr" align="center" style="padding-top:300px;">

<table cellspacing="1" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td align="left" valign="top">   
    <form action="j_spring_security_check" method="post">
<table cellspacing="10" cellpadding="5" bgcolor="#c2e5f8">
<tr>
		<td align="left" valign="top" colspan="2">
<p> ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message,
'Bad credentials', 'Username / Password are incorrect ')}</p>
</td>
</tr>
	<tr>
		<td align="left" valign="top"><label for="j_username"><strong>Username :</strong></label></td>
		<td align="left" valign="top"><input type="text" name="j_username" id="j_username"
			width="80" /></td>
	</tr>
	<tr>
		<td align="left" valign="top"><label for="j_password"><strong>Password :</strong></label></td>
		<td align="left" valign="top"><input type="password" name="j_password" id="j_password"
			width="80" /></td>
	</tr>
	<tr>
		<td align="left" valign="top" colspan="2"><input id="submit" type="submit" style="width:75px;"
			value="Login" /></td>
	</tr>
</table>
</form>
</td>
  </tr>
</table>

</div>
</div>
<div class="copyright" align="left">&copy; 2011 Smile Plus Network  
&nbsp;&nbsp;&nbsp; 
<a href="http://www.smileplusnetwork.com" >หน้าแรก</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a href="http://www.smileplusnetwork.com/aboutus.html">เกี่ยวกับเรา</a>  &nbsp;&nbsp;|&nbsp;&nbsp; <a href="http://www.smileplusnetwork.com/product.html">สินค้าและบริการ</a>  &nbsp;&nbsp;|&nbsp;&nbsp; <a href="http://www.smileplusnetwork.com/smms">สมาชิก</a>  &nbsp;&nbsp;|&nbsp;&nbsp; <a href="http://www.smileplusnetwork.com/contactus.html">ติดต่อเรา</a></div>
</center>
</body>
</html>
<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="th">
<head>
<title>Smile Plus Company co.ltd</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/patch_layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="/Smms/struts/themes/ui-lightness/jquery-ui.css" type="text/css" />
<script type="text/javascript" src="/Smms/struts/utils.js"></script>
<script type="text/javascript" src="/Smms/struts/xhtml/validation.js"></script>
<sj:head debug="true" compressed="false" jquerytheme="ui-lightness"
	customBasepath="themes" loadFromGoogle="%{google}"
	ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator"
	defaultLoadingText="Please wait ..." />
<script type="text/javascript" src="js/showcase.js"></script>
<script type="text/javascript" src="js/extendplugin.js"></script>
<script type="text/javascript">
	function okButton() {
		$.ajax({
			url : "j_spring_security_logout",
			success : function(data) {
				window.location.replace("login.jsp");
			}
		});
		$('#mybuttondialog').dialog('close');
	};
	function cancelButton() {

		$('#mybuttondialog').dialog('close');
	};
</script>

</head>
<body>
<div class="page_margins">
<div class="page">
<div id="header" class="ui-widget-header">
<div id="themebox">
<%	Logger log = Logger.getLogger("Default");
	SmileUser u =null;
	String displayName = "evolix";
	try{
		u = (SmileUser) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
			displayName =u.getNode().getDisplayName();
	}catch (ClassCastException e){
		log.error("Unknow login");
	}
%>
<div id="infoUser" style="background:#fff">
 <span class="ui-state-default"
	style="background: none; border: none; font-size: -1">
	<%=displayName %>
	</span><br />
<br />
<span class="ui-state-default"
	style="background: none; border: none; font-size: -2"> <sj:dialog
	id="mybuttondialog"
	buttons="{ 
    		'OK':function() { okButton(); },
    		'Cancel':function() { cancelButton(); } 
    		}"
	autoOpen="false" modal="true" title="ออกจากระบบ">
    คุณต้องการที่จะออกจากระบบ ?
	</sj:dialog> <sj:a openDialog="mybuttondialog" button="true"
	buttonIcon="ui-icon-extlink">
    	Logout
    </sj:a> </span></div>
    </div>
<div id="headline">
<h1 class="ui-state-default" style="background: none; border: none;">Sale
And MemberShip Management</h1>
<!-- 
	        <h4 class="ui-state-default" style="background: none; border: none;">Version 2.4.0</h4>
	        --> <img id="myDefaultIndicator" src="images/ajax-loader.gif"
	alt="Loading..." style="display: none" /></div>
</div>
<div id="nav">
<div class="hlist ui-widget-header">
<ul>
	<li class="ui-widget-header"><s:url id="urlindex" action="index" /><sj:a
		id="indexlink" href="%{urlindex}" targets="main">&nbsp;ข่าวสารสมาชิก&nbsp;</sj:a></li>
	<li class="ui-widget-header"><s:url id="urlmember" action="member" /><sj:a
		id="memberlink" href="%{urlmember}" targets="main">&nbsp;ทะเบียนสมาชิก&nbsp;</sj:a>
	</li>
	<li class="ui-widget-header"><s:url id="urlregister"
		action="register" /><sj:a id="registerlink" href="%{urlregister}"
		targets="main">ลงทะเบียนสมาชิกใหม่</sj:a></li>
	<li class="ui-widget-header"><s:url id="urlorganization"
		action="organization" /><sj:a id="organizationlink"
		href="%{urlorganization}" targets="main">&nbsp;ผังองค์กร&nbsp;</sj:a>
	</li>
	<li class="ui-widget-header"><s:url id="urlorder" action="order" /><sj:a
		id="orderlink" href="%{urlorder}" targets="main">&nbsp;ประวัติการสั่งชื้อสินค้า&nbsp;</sj:a>
	</li>
	<!-- 
           <li class="ui-widget-header"><s:url id="urllogin" action="login"/><sj:a id="loginlink" href="%{urllogin}" targets="main">&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;</sj:a> </li>
           -->
	<li class="ui-widget-header"><s:url id="urlchgpassword"
		action="chgpassword" /><sj:a id="chgpasswordlink"
		href="%{urlchgpassword}" targets="main">&nbsp;เปลี่ยนรหัสผ่าน&nbsp;</sj:a>
	</li>
	<li class="ui-widget-header"><s:url id="urlblackoffice"
		action="blackoffice" /><sj:a id="blackofficelink"
		href="%{urlblackoffice}" targets="main">&nbsp;จัดการการชื้อสินค้า&nbsp;</sj:a>
	</li>
	<li class="ui-widget-header"><s:url id="urleditproduct"
		action="editproduct" /><sj:a id="editproduct"
		href="%{urleditproduct}" targets="main">&nbsp;ตั้งค่าผลิตภัณฑ์&nbsp;</sj:a></li>
	<li class="ui-widget-header"><s:url id="urlsmmsrole"
		action="smmsrole" /><sj:a id="smmsrole" href="%{urlsmmsrole}"
		targets="main">&nbsp;กำหนดสิทธิ์&nbsp;</sj:a></li>
	<sec:authorize access="hasRole('ROLE_STAFF')">
		<li class="ui-widget-header"><s:url id="urlcommission"
			action="commission" /><sj:a id="commission" href="%{urlcommission}"
			targets="main">&nbsp;คอมมิสชั่นที่ตัดบัญชี&nbsp;</sj:a></li>
	</sec:authorize>
</ul>
</div>
</div>
<sj:div id="main" href="%{urlindex}">
	<img id="indicator" src="images/indicator.gif" alt="Loading..." />
</sj:div> <!-- begin: #footer -->
<div id="footer"><a href="" title="Smile Plus Company co.ltd">Smile
Plus Company co.ltd</a></div>
</div>
</div>

<script type="text/javascript">
	jQuery(document).ready(function() {
		if (jQuery.struts2_jquery.ajaxhistory) {
			var topic = $.bbq.getState('main');
			if (topic !== undefined && topic != '') {
				jQuery.publish(topic);
			}
		}
	});
</script>

</body>
</html>

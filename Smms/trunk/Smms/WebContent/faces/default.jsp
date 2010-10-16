<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Sale And Membership Management Sytem</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid" />
	<meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin" />
	<link href="styles/layout.css" rel="stylesheet" type="text/css" />
	<!--[if lte IE 7]>
	<link href="styles/patch_layout.css" rel="stylesheet" type="text/css" />
	<![endif]-->
<link rel="stylesheet" href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css"/>

	<!-- This files are needed for AJAX Validation of XHTML Forms -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
       <sj:head debug="true" compressed="false" jquerytheme="dark-hive" customBasepath="themes" loadFromGoogle="%{google}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator" defaultLoadingText="Please wait ..."/>
 <!--  
  <s:if test="%{theme == 'dark-hive' || theme == null}">
      <sj:head debug="true" compressed="false" jquerytheme="dark-hive" customBasepath="themes" loadFromGoogle="%{google}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator" defaultLoadingText="Please wait ..."/>
  </s:if>
  <s:else>
      <sj:head debug="true" compressed="false" jquerytheme="%{theme}" loadFromGoogle="true" loadFromGoogle="%{google}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator" defaultLoadingText="Please wait ..."/>
  </s:else>
  -->

	<!-- This file includes necessary functions/topics for validation and all topic examples -->
	<script type="text/javascript" src="js/showcase.js"></script>
	<!-- Extend the Struts2 jQuery Plugin with an richtext editor -->
	<script type="text/javascript" src="js/extendplugin.js"></script>
</head>
<body>
  <div class="page_margins">
    <div class="page">
      <div id="header" class="ui-widget-header">
      <!-- 
        <div id="themebox">
            <s:form id="themeform" action="default" theme="simple">
                <div>   
                <s:checkbox id="google" name="google"/><label for="google" style="padding: 3px;">Load jQuery from Google CDN</label><br/>
                <s:checkbox id="ajaxhistory" name="ajaxhistory"/><label for="ajaxhistory" style="padding: 3px;">Use Ajaxhistory (BETA)</label><br/>
                <s:submit value="Change Theme" cssClass="buttonlink ui-state-default ui-corner-all"/>
                </div>
            </s:form>
        </div>
        -->
        <div id="headline">
	        <h1 class="ui-state-default" style="background: none; border: none;">Sale And MemberShip Management</h1>
	        <!-- 
	        <h4 class="ui-state-default" style="background: none; border: none;">Version 2.4.0</h4>
	        -->
        	<img id="myDefaultIndicator" src="images/ajax-loader.gif" alt="Loading..." style="display:none"/>
        </div>
      </div>
      <div id="nav">
        <div class="hlist ui-widget-header">
          <ul>         
            <li class="ui-widget-header"><s:url id="urlindex" action="index"/><sj:a id="indexlink" href="%{urlindex}" targets="main">&nbsp;&nbsp;&nbsp;หน้าแรก&nbsp;&nbsp;&nbsp;</sj:a></li>
           <li class="ui-widget-header"><s:url id="urlmember" action="member"/><sj:a id="memberlink" href="%{urlmember}" targets="main">&nbsp;&nbsp;&nbsp;Member&nbsp;&nbsp;&nbsp;</sj:a> </li>
           <li class="ui-widget-header"><s:url id="urlregister" action="register"/><sj:a id="registerlink" href="%{urlregister}" targets="main">&nbsp;&nbsp;&nbsp;Register&nbsp;&nbsp;&nbsp;</sj:a> </li>
           <li class="ui-widget-header"><s:url id="urlorganization" action="organization"/><sj:a id="organizationlink" href="%{urlorganization}" targets="main">&nbsp;&nbsp;&nbsp;ผังองค์กร&nbsp;&nbsp;&nbsp;</sj:a> </li>
           <li class="ui-widget-header"><s:url id="urlpurchase" action="purchase"/><sj:a id="purchaselink" href="%{urlpurchase}" targets="main">&nbsp;&nbsp;&nbsp;สั่งชื้อสินค้า&nbsp;&nbsp;&nbsp;</sj:a> </li>
           <li class="ui-widget-header"><s:url id="urllogin" action="login"/><sj:a id="loginlink" href="%{urllogin}" targets="main">&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;</sj:a> </li>
           <li class="ui-widget-header"><s:url id="urlchgpasswd" action="chgpasswd"/><sj:a id="chgpasswdlink" href="%{urlchgpasswd}" targets="main">&nbsp;&nbsp;&nbsp;เปลี่ยนรหัสผ่าน&nbsp;&nbsp;&nbsp;</sj:a> </li>
          
          </ul>
        </div>
      </div>
      <sj:div id="main" href="%{urlindex}">
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
      </sj:div>
      <!-- begin: #footer -->
      <div id="footer">
      <!-- 
        Written by  <a href="http://www.jgeppert.com" title="Java Developer Blog">Johannes Geppert</a><br/>
        Hosted by  <a href="http://www.weinfreund.de" title="Wein vom Weingut, Weinforum, Wein Community">weinfreund.de</a><br/>
       --> 
        Layout Footer <a href="" title="OpenSource CSS Layout">Footer</a>
       
      </div>
    </div>
  </div>
  <script type="text/javascript">
   jQuery(document).ready(function() {
  	 if (jQuery.struts2_jquery.ajaxhistory) {
  		 var topic = $.bbq.getState( 'main' );
  		 if(topic !== undefined && topic != '') {
  			 jQuery.publish(topic);
  		 }
  	 }
  });
  </script>
</body>
</html>

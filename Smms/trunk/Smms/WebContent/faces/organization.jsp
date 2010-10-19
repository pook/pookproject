<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css" />
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/patch_layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Smms/struts/utils.js"></script>
<script type="text/javascript" src="/Smms/struts/xhtml/validation.js"></script>

<s:property value="echo" escape="%{escape}" />
<s:div id="formResult">
	<s:form id="form" action="organization" theme="simple" cssClass="yform">

		<fieldset><legend><b>ผังองค์กร</b></legend>

		<div class="type-button">
		<div class="type-button"><label for="echo">Member #: </label> <s:select
			label="Member" name="member" headerKey="-1"
			headerValue="Select Member Down Line"
			list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
			value="selectedMonth" required="true" /></div>
		<sj:submit targets="formResult"
			class="ui-button ui-widget ui-state-default ui-corner-all"
			value="ย้อนกลับ" indicator="indicator" /> <s:url id="simpleecho"
			value="/simpleecho.action" /> <sj:submit targets="formResult"
			class="ui-button ui-widget ui-state-default ui-corner-all"
			value="กลับไปชั้นสมาชิก" indicator="indicator" /> <sj:submit
			targets="formResult" value="ย้อนกลับไป 6 ชั้น" indicator="indicator" />
		<!-- 
	            <label for="echo">Echo: </label>
	            <s:textfield id="echo" name="echo" value="Hello World!!!"/>
	            --> <img id="indicator" src="images/legend7.gif"
			alt="Loading..." align="right" /></div>
		</fieldset>
	</s:form>
</s:div>
<s:div id="orgchart">
	<img id="indicator" src="images/Org-Chart7.gif" alt="Loading..." />
</s:div>

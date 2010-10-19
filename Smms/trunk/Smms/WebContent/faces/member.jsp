<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css" />
<s:property value="echo" escape="%{escape}" />
<s:form id="formValidateCustom" action="login" theme="simple"
	cssClass="yform">
	<s:div class="type-test">member page</s:div>
<fieldset><legend>Member</legend>
	<table align="center" width="540px" height="300px">
		<s:iterator value="memb.entrySet()">
			<tr>
				<td><s:property value="key" /></td>
				<td><s:property value="value" /></td>
			</tr>
		</s:iterator>
	</table>
	</fieldset>
	
</s:form>

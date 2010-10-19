<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css" />
<s:property value="echo" escape="%{escape}" />
<s:form id="formValidateCustom" action="login" theme="simple"
	cssClass="yform">
	<fieldset><legend>Member</legend>
	<table
		style="align: center; width: 540px; margin-left: 280px; border: 1px solid #000000;"
		cellspacing="10px">
		<tr>
			<td colspan="1"><b>Member Profile</b></td>

		</tr>
		<tr>
				<td>&nbsp;&nbsp;&nbsp;<s:text  name="xxxx5" >ชื่อผู้แนะนำ :</s:text></td>
				<td>&nbsp;&nbsp;&nbsp;<s:text  name="xxxx5" >xxxxxx</s:text></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<s:text  name="xxxx5" >ชื่อ up line :</s:text></td>
				<td>&nbsp;&nbsp;    <s:select label="ชื่อ up line"
        name="member"
        headerKey="-1" headerValue="Select Member Up Line"
        list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
        value="selectedMonth"
        required="true"
 /></td>
			</tr>
			
		<s:iterator value="memb.entrySet()">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<s:property value="key" /></td>
				<td>&nbsp;&nbsp;&nbsp;<s:property value="value" /></td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="1"><b>ข้อมูลการเงิน</b></td>

		</tr>

		<s:iterator value="memb2.entrySet()">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<s:property value="key" /></td>
				<td>&nbsp;&nbsp;&nbsp;<s:property value="value" /></td>
			</tr>
		</s:iterator>
	</table>
	</fieldset>

</s:form>

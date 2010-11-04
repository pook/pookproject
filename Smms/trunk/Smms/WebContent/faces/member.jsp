<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />

 
<table	style="align: center; width: 590px; margin-left: 280px; border: 1px solid #000000;margin-top: 50px;cellspcacing:50px;">
	<s:form id="formV" action="login" theme="simple"  >
		<tr>
			<td colspan="2"><b>Member Profile</b></td>

		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;<s:text name="xxxx5">ชื่อผู้แนะนำ :</s:text></td>
			<td>&nbsp;&nbsp;&nbsp;<s:text name="xxxx56">xxxxxx</s:text></td>
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
		
	</s:form>
</table>




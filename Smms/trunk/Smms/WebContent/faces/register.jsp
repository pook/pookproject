<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>
<script type="text/javascript" src="js/register.js"></script>
<link href="styles/register.css" rel="stylesheet" type="text/css" />
<%
	Logger log = Logger.getLogger("Register");
	SmileUser u = null;
	String displayName = "";
	String id = "";
	try {
		u = (SmileUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		id = u.getSmileid();
		displayName = u.getDisplayName();
	} catch (ClassCastException e) {
		log.error("Unknow login");
	}
%>
<div id="main-regist">
<div id="input-form"><s:url id="checkurl"
	action="check-displayname-member" /> <s:url id="uplineurl"
	action="json-fetch-upline-member" /> <s:url id="provinceurl"
	action="json-fetch-province-member" /> <s:url id="branceurl"
	action="json-fetch-brance-member" />
<form id="form1" action="javascript:void(0)">
<fieldset>
<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header">
			<th colspan="6" class="th2">Register</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="ui-widget-footer ">
			<th colspan="6" class="tf"><input type="submit" id="fsubmit1"
				class="ui-button ui-widget ui-state-default ui-corner-all"
				value="ยืนยัน" onmouseover="ui-state-hover" /></th>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td colspan="6">
			<div class="ui-widget">
			<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;">
			</div>
			</div>
			<div class="ui-widget">
			<div id="messageError" style="padding: 0pt 0.7em;"></div>
			</div>
			</td>
		</tr>
		<tr>
			<td><label for="upline">ชื่อ up line <span class="field_req">
			*</span>:</label></td>
			<td colspan="2"><sj:select href="%{uplineurl}" id="upline"
				name="echo" list="uplines" headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" /></td>
			<td><label for="inviter">ชื่อผู้แนะนำ <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="inviter" id="inviter"
				readonly="readonly" disabled="disabled"
				class="text ui-widget-content ui-corner-all" value=<%=displayName%> />
			<div id="inviter1" style="display: none"></div>
			</td>
		</tr>
		<tr>
			<td><label for="name">ชื่อ <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="name" id="name"
				class="text ui-widget-content ui-corner-all required" /></td>
			<td><label for="surename">นามสกุล <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="surename" id="surename"
				class="text ui-widget-content ui-corner-all" /></td>
			<td><label for="displayName">ชื่อแสดงในสายงาน <span class="field_req">*</span>:</label></td>
			<td colspan="2"><input type="text" name="displayName"
				id="displayName" class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="codeIdentification">รหัสบัตรประชาชน <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="codeIdentification"
				id="codeIdentification" class="text ui-widget-content ui-corner-all" /></td>

			<td><label for="tel">เบอร์โทรศัพท์ <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="tel" id="tel"
				class="text ui-widget-content ui-corner-all" /></td>
			<td><label for="tel2">เบอร์โทรศัพท์(สำรอง) :</label></td>
			<td><input type="text" name="tel2" id="tel2"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="email">email :</label></td>
			<td><input type="text" name="email" id="email"
				class="text ui-widget-content ui-corner-all" /></td>
			<td><label for="brance">สาขาทีสมัคร <span class="field_req">*</span>:</label></td>
			<td><sj:select href="%{branceurl}" id="brance" name="brance"
				headerKey="-1" headerValue="กรุณาเลือก" list="brances"
				cssClass="selectop" /></td>
			<td><label for="branceCard">สาขาทีรับบัตรสมาชิก <span class="field_req">*</span>:</label></td>
			<td><sj:select href="%{branceurl}" id="branceCard"
				name="branceCard" headerKey="-1" headerValue="กรุณาเลือก"
				list="brances" cssClass="selectop" /></td>
		</tr>
		<tr>
			<td><label for="address">ที่อยู่ <span class="field_req">*</span>:</label></td>
			<td><textarea rows="2" cols="5" name="address" id="address"
				class="text ui-widget-content ui-corner-all"></textarea></td>
			<td><label for="province">จังหวัด <span class="field_req">*</span>:</label></td>
			<td><sj:select href="%{provinceurl}" id="province" value="10"
				name="province" list="provinces" cssClass="selectop" sortable="true" /></td>
			<td><label for="address2">ที่อยู่ส่งของ :</label></td>
			<td><textarea rows="2" cols="5" name="address2" id="address2"
				class="text ui-widget-content ui-corner-all"></textarea></td>
		</tr>
		<tr>
			<td><label for="bank">ธนาคาร <span class="field_req">*</span>:</label></td>
			<td><select name="bank" id="bank" class="selectop" >
				<option value="ธนาคารไทยพาณิชย์" selected="selected">ธนาคารไทยพาณิชย์</option>
				<option value="ธนาคารกรุงเทพ">ธนาคารกรุงเทพ</option>
				<option value="ธนาคารกรุงไทย">ธนาคารกรุงไทย</option>
				<option value="ธนาคารกสิกรไทย">ธนาคารกสิกรไทย</option>
				<option value="ธนาคารกรุงศรีอยุธยา">ธนาคารกรุงศรีอยุธยา</option>
				<option value="ธนาคารออมสิน">ธนาคารออมสิน</option>
				<option value="ธนาคารทหารไทย">ธนาคารทหารไทย</option>
				<option value="ธนาคารนครหลวงไทย"> ธนาคารนครหลวงไทย</option>
				<option value="ธนาคารอาคารสงเคราะห์">ธนาคารอาคารสงเคราะห์</option>
				<option value="ธนาคารธนชาติ">ธนาคารธนชาติ</option>
			</select></td>
		</tr>
		<tr>
			<td><label for="bankAccount">เลขที่บัญชี <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="bankAccount" id="bankAccount"
				class="text ui-widget-content ui-corner-all" /></td>
			<td><label for="bankBrance">สาขาธนาคาร <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="bankBrance" id="bankBrance"
				class="text ui-widget-content ui-corner-all" /></td>
			<td><label for="typeOfAccount">ประเภทบัญชี <span class="field_req">*</span>:</label></td>
			<td><input type="text" name="typeOfAccount" id="typeOfAccount"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
	</tbody>
</table>
</fieldset>
</form>
</div>
</div>
<div id="dialog" title="แจ้งให้ทราบ"></div>
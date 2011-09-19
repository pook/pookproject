<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/member.js"></script>
<div id="main-member">
<div id="userinf"><s:url id="uplineurl"
	action="json-fetch-upline-member" /> <s:url id="showdownlineurl"
	action="showdownline" /> <s:url id="teamsurl" action="teams" /> <s:url
	id="chgpasswdurl" action="chgpasswd" /> <sj:dialog width="450"
	id="btndialog"
	buttons="{ 
    		'OK':function() { okButton1(); },
    		'Cancel':function() { cancelButton1(); } 
    		}"
	autoOpen="false" modal="true" title="Create Account">
	<table class="tbd">
		<tr>
			<td colspan="2">
			<div class="ui-widget">
			<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;">
			</div>
			</div>
		<tr>
			<td style="width: 180px"><label for="upline">ชื่อ up
			line <font color="red"> *</font>:</label></td>
			<td><sj:select href="%{uplineurl}" id="upline" name="echo"
				list="uplines" headerKey="-2" headerValue="Auto Assign" /></td>
		</tr>
		<tr>
			<td><label for="displayName">ชื่อแสดงในสายงาน *:</label></td>
			<td><input type="text" name="displayName" id="displayName" /></td>
		</tr>
	</table>
</sj:dialog>


<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header">
			<th colspan="2" class="th2">ข้อมูลสมาชิก</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="2"><sj:a id="downlinelink"
				href="%{showdownlineurl}" indicator="indicator"
				targets="main" button="true" buttonIcon="ui-icon-gear">
	ดูผู้ที่เราแนะนำ
	</sj:a> <sj:a id="teamlink" href="%{teamsurl}" indicator="indicator"
				targets="main" button="true" buttonIcon="ui-icon-gear">
	ดูลูกทีม
	</sj:a> <sj:a id="chgpasswlink" href="%{chgpasswdurl}" indicator="indicator"
				targets="main" button="true" buttonIcon="ui-icon-gear">
	Change Password
	</sj:a> <sj:submit id="sdialog" cssClass="hide" openDialog="btndialog"
				value="Create Account" button="true" /></td>
		</tr>
	</tfoot>
	<tr>
		<td width="200px">ชื่อผู้แนะนำ :</td>
		<td id="f1">f1</td>
	</tr>
	<tr>
		<td>รหัสสมาชิก :</td>
		<td id="f2">f2</td>
	</tr>
	<tr>
		<td>รหัสบัตรประชาชน :</td>
		<td id="f3">f3</td>
	</tr>
	<tr>
		<td>ชื่อ :</td>
		<td id="f4">f4</td>
	</tr>
	<tr>
		<td>นามสกุล :</td>
		<td id="f5">f5</td>
	</tr>
	<tr>
		<td>ชื่อแสดงในสายงาน :</td>
		<td id="f6">f6</td>
	</tr>
	<tr>
		<td>เบอร์โทรศัพท์ :</td>
		<td id="f7">f7</td>
	</tr>
	<tr>
		<td>เบอร์โทรศัพท์(สำรอง)</td>
		<td id="f8">f8</td>
	</tr>
	<tr>
		<td>E-mail :</td>
		<td id="f9">f9</td>
	</tr>
	<tr>
		<td>ที่อยู่ :</td>
		<td id="f10">f10</td>
	</tr>
	<tr>
		<td>จังหวัด :</td>
		<td id="f11">f11</td>
	</tr>
	<tr>
		<td>ที่อยู่ส่งของ :</td>
		<td id="f12">f12</td>
	</tr>
	<tr>
		<td>สาขาที่รับบัตรสมาชิก</td>
		<td id="f13">f13</td>
	</tr>
	<tr>
		<td>จำนวนบัญชี</td>
		<td id="f501">f501</td>
	</tr>
	<tr>
		<td>Total Team SV</td>
		<td id="f502">f502</td>
	</tr>
	<tr>
		<td>Total Team SV(เดือนที่ผ่านมา)</td>
		<td id="f503">f503</td>
	</tr>
</table>
</div>
<div id="status">
<table id="tstatus" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th colspan="2" class="th2">ข้อมูลการเงิน</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</tfoot>

	<tr>
		<td width="200px">ธนาคาร :</td>
		<td id="f14">f14</td>
	</tr>
	<tr>
		<td>บัญชีธนาคาร :</td>
		<td id="f15">f15</td>
	</tr>
	<tr>
		<td>สาขาบัญชี :</td>
		<td id="f16">f16</td>
	</tr>
	<tr>
		<td>ประเภทบัญชี :</td>
		<td id="f17">f17</td>
	</tr>

	<tr>
		<td>โบนัส ทีมธุรกิจ :</td>
		<td id="f18">f18</td>
	</tr>
	<tr>
		<td>โบนัส ผู้นำ :</td>
		<td id="f19">f19</td>
	</tr>
	<tr>
		<td>โบนัส รวม :</td>
		<td id="f20">f20</td>
	</tr>
	<tr>
		<td>โบนัส รวม(เดือนที่ผ่านมา) :</td>
		<td id="f21">f21</td>
	</tr>
</table>
</div>
</div>
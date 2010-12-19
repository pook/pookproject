<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$.getJSON("json-member.action", function(data) {
			profile(data.userModel);
		});
	});
	function profile(dat){
		$("#f1").empty().append(dat.node1.inviter);
		$("#f2").empty().append(dat.userId);
		$("#f3").empty().append(dat.codeIdentification);
		$("#f4").empty().append(dat.name);
		$("#f5").empty().append(dat.surename);
		$("#f6").empty().append(dat.node1.displayName);
		$("#f7").empty().append(dat.tel);
		$("#f8").empty().append(dat.tel2);
		$("#f9").empty().append(dat.email);
		$("#f10").empty().append(dat.address);
		$("#f11").empty().append(dat.province.pname);
		$("#f12").empty().append(dat.address2);
		$("#f13").empty().append(dat.branceCard);
		$("#f14").empty().append(dat.bank);
		$("#f15").empty().append(dat.bankAccount);
		$("#f16").empty().append(dat.bbrance);
		$("#f17").empty().append(dat.typeOfAccount);
		$("#f18").empty().append(dat.bonusTeam);
		$("#f19").empty().append(dat.bonusInv);
		$("#f20").empty().append(dat.bonusTeam+dat.bonusInv);
		$("#f21").empty().append(dat.bonusLast);
	}
</script>

<style type="text/css">
#main{
 height: 980px
}

.th2 {
	height: 30px;
}
table td {
	width: 200px;
	padding: 7px 20px 10px 50px;
}

table {
	margin-top: 50px;
	margin-left: 120px;
	margin-bottom: 20px;
	width:720px
}
</style>
<div id="main-member">
<div id="userinf">
<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th colspan="2" class="th2">ข้อมูลสมาชิก</th>
		</tr>
	</thead>
	<tr>
		<td>ชื่อผู้แนะนำ :</td>
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
</table>
</div>
<div id="status">
<table id="tstatus" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th colspan="2" class="th2">ข้อมูลการเงิน</th>
		</tr>
	</thead>
	<tr>
		<td>ธนาคาร :</td>
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
		<td>โบนัส รวม(ย้อนหลัง 2 เดือน) :</td>
		<td id="f21">f21</td>
	</tr>
</table>
</div>

</div>




<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	$(function() {
		$.getJSON("json-member.action", function(data) {
			$("table tr").addClass("ui-widget-content");
			$("table tfoot tr").removeClass("ui-widget-content");
			profile(data.userModel);
		});
	});	
	function profile(dat){
		$("#f1").empty().append(dat.node1.inviter);
		$("#f2").empty().append(dat.node1.smileId);
		$("#f3").empty().append(dat.detail.codeIdentification);
		$("#f4").empty().append(dat.detail.name);
		$("#f5").empty().append(dat.detail.surename);
		$("#f6").empty().append(dat.node1.displayName);
		$("#f7").empty().append(dat.detail.tel);
		$("#f8").empty().append(dat.detail.tel2);
		$("#f9").empty().append(dat.detail.email);
		$("#f10").empty().append(dat.detail.address);
		$("#f11").empty().append(dat.detail.province.pname);
		$("#f12").empty().append(dat.detail.address2);
		$("#f13").empty().append(dat.branceCard);
		$("#f14").empty().append(dat.detail.bank);
		$("#f15").empty().append(dat.detail.bankAccount);
		$("#f16").empty().append(dat.detail.bbrance);
		$("#f17").empty().append(dat.detail.typeOfAccount);
		$("#f18").empty().append(dat.bonusTeam);
		$("#f19").empty().append(dat.bonusInv);
		$("#f20").empty().append(dat.bonusTeam+dat.bonusInv);
		$("#f21").empty().append(dat.bonusLast);
		$("#f501").empty().append(dat.detail.numOfAccount);
		$("#f502").empty().append(dat.node1.totalSv);	
		$.ajax({
			url :"check-account",					
			success : function(res) {					
				if(res == 0)
					$("#sdialog").show();					
				else
					$("#sdialog").hide();							
			}		
		});      	   				
	}
	$("#displayName").live("focusout", checkDisplayName);
	function okButton1(){
		var displayName = $("#displayName");
		var valid = true;
		valid = valid&&checkLength(displayName," ชื่อแสดงในสายงาน ", 3, 30);		
		if(valid){
			$.ajax({
				url :"save2.action",
				data :"displayName="+displayName.val()+"&upline="+$("#upline").val(),		
				success : function(res) {	
					if(res.length>0){
						showmsgInf(res);	
					}							
				}		
			});
			$('#btndialog').dialog('close');
		}						
			
	};
	
	function cancelButton1(){	  
		$('#btndialog').dialog('close');
	};
	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			showmsgInf("ข้อมูล  " + n + " ที่กรอกควรมีความยาวระหว่าง " + min
					+ " และ " + max + ".");
			return false;
		} else {
			return true;
		}
	}
	function showmsgInf(msgInf) {
		$("#messageInfo").addClass("ui-state-highlight ui-corner-all").empty().append(
						"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
								+ "<strong>ข้อความ</strong> "							
								+ msgInf							
								+ "</p>");
	}
	function checkDisplayName() {
		$(this).removeClass("ui-state-error");
		$.ajax({
			type : "post",
			url : "check-displayname.action",
			data : "displayName=" + $(this).val(),
			success : function(res) {				
				if (res.length>0) {	
					showmsgInf(res);			
					$("#displayName").addClass("ui-state-error");
					$("#displayName").focus();				
					return false;
				}
			}	
		});	
		return true;
	}
		
</script>

<style type="text/css">
#main {
	height: 1069px
}
.th2 {
	height: 30px;
}
table td {	
	padding: 7px 20px 10px 50px;
}
.tbd td{	
	padding: 5px 5px 5px 10px;
}
table tfoot td{	
	padding: 2px 2px 2px 10px;
}
.hide{
	display: block
}
table {
	margin-top: 50px;
	margin-left: 120px;
	margin-bottom: 20px;
	width:720px
}
.tbd  {
	margin-top: 5px;
	margin-left: 10px;
	margin-bottom: 10px;
	width:400px
}

#downlinelink{
	padding: 0px 0px 0px 0px;
	margin: 0px 0px 0px 0px;
}
</style>
<div id="main-member">
<div id="userinf">
<s:url id="uplineurl"
	action="json-fetch-upline.action" />
<s:url id="showdownlineurl" action="showdownline"/>
<s:url id="teamsurl" action="teams"/>
<s:url id="chgpasswdurl" action="chgpasswd"/>
<sj:dialog 
		width="450"
    	id="btndialog" 
    	buttons="{ 
    		'OK':function() { okButton1(); },
    		'Cancel':function() { cancelButton1(); } 
    		}" 
    	autoOpen="false" 
    	modal="true" 
    	title="Create Account" 
    >
    <table class="tbd">
    <tr>
			<td colspan="2">
			<div class="ui-widget">
			<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;">
			</div></div>
    <tr>
    <td style="width: 180px"><label for="upline">ชื่อ up line <font color="red">
			*</font>:</label></td>
			<td><sj:select href="%{uplineurl}" id="upline"
				name="echo" list="uplines" headerKey="-2" 
				headerValue="Auto Assign" /></td></tr><tr>
				<td><label for="displayName">ชื่อแสดงในสายงาน *:</label></td>
			<td><input type="text" name="displayName"
				id="displayName"  /></td>
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
      <td colspan="2">	<sj:a id="downlinelink" href="%{showdownlineurl}" indicator="indicator"
						targets="main-member" button="true" buttonIcon="ui-icon-gear">
	ดูผู้ที่เราแนะนำ
	</sj:a>	<sj:a id="teamlink" href="%{teamsurl}" indicator="indicator"
						targets="main-member" button="true" buttonIcon="ui-icon-gear">
	ดูลูกทีม
	</sj:a>
		<sj:a id="chgpasswlink" href="%{chgpasswdurl}" indicator="indicator"
						targets="main" button="true" buttonIcon="ui-icon-gear">
	Change Password
	</sj:a>
 <sj:submit id= "sdialog"
    	openDialog="btndialog" 
    	value="Create Account" 
    	button="true" 
    />
	</td>     
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
		<td>โบนัส รวม(ย้อนหลัง 2 เดือน) :</td>
		<td id="f21">f21</td>
	</tr>
</table>
</div>

</div>




<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/ext.css" rel="stylesheet" type="text/css" />
<div id="div1">
<table
	style="align: center; width: 440px; margin-left: 280px; border: 1px solid #000000; margin-top: 50px;">
	<tr>
		<td colspan="2" bgcolor="#EB8F00"><b>Register</b></td>
	</tr>
	<tr>
		<td><s:form id="formx" action="save" theme="xhtml" style="cellspacing:25px">
			<s:select label="ชื่อ up line" name="upline" headerKey="-1"
				headerValue="Auto Assign Upline"
				list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				value="none" required="true" />	
			<sj:textfield label="ชื่อ" name="name" required="true" value="=ชื่อ ผู้สมัคร" />
			<sj:textfield label="นามสกุล" name="surename" required="true" value="นามสกุลผู้สมัคร" />
			<sj:textfield label="ชื่อแสดงในสายงาน" name="displayName" required="true" value="=ชื่อ แสดงในสายงาน" />
			<sj:textfield label="รหัสบัตรประชาชน" name="codeIdentification" required="true" value="รหัสบัตรประชาชน"/>
			<sj:textfield label="เบอร์โทรศัพท์" name="tel" required="true" value="เบอร์โทร"/>
			<sj:textfield label="เบอร์โทรศัพท์(สำรอง)" name="tel2"  value="เบอร์โทรสำรอง"/>			
			<sj:textfield label="ชื่อผู้แนะนำ" name="inviter" disabled="true" require="true"
				value="ดลยา" />
				<s:select label="สาขาทีรับบัตรสมาชิก " name="branceCard" headerKey="-1"
				headerValue="สำนักงานใหญ่"
				list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				value="ชื่อ  สำนักงาน" required="true" />
			<sj:textarea label="ที่อยู่" name="address" required="true" value="ที่อยู่"/>
			<s:select label="จังหวัด " name="province" headerKey="กรุงเทพมหานคร"
				headerValue="aaaa"
				list="#{ 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				 required="true" />	
			
			<sj:textarea label="ที่อยูส่งของ" name="ที่อยู่ส่งของ" value="ที่อยู่ส่งของ"/>
		<sj:textfield label="e-mail" name="email"value=" อีเมลล์" />
			<s:select label="ธนาคาร " name="bank" headerKey="ธนาคารโลก"
				headerValue="AAAA" 
				list="#{'zzzz':'ZZZZ', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
			     required="true" />	
				
			
			<sj:textfield label="เลขบัญชี" name="bankAccount" required="true" value="1234567890"/>
			<sj:textfield label="สาขาธนาคาร" name="brance" required="true"value="บ้านแหลม"/>
			<sj:textfield label="ประเภทบัญชี" name="typeOfAccount" required="true" value="ฝากตลอดชีวิต"/>
		</s:form></td>
	</tr>
	<tr>
		<td align="center" colspan="1">
		<sj:a id="ajaxformlink"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover" formIds="formx" targets="div1"
			indicator="indicator" button="true" buttonIcon="ui-icon-gear">
      ยืนยัน
    </sj:a> <sj:a id="ajaxformlink2" formIds="formx" targets="formResult"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover" indicator="indicator" button="true"
			buttonIcon="ui-icon-gear">
      ยกเลิก
    </sj:a> 
    <img id="indicator" src="images/indicator.gif" alt="Loading..."
			style="display: none" /></td>
	</tr>

</table>
<div id="div1" style="position:absolute;  left:564px;top:151px;z-index: 5"; ><a href=""><font color="green"></font>ลิ้งไปผังองค์กร</a></div>


</div>
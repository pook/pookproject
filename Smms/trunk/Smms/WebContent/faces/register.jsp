<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>
<style type="text/css">
input.text {
	margin: 2px 30px 2px 39px;
	width: 230px;
	padding: 1px 5px 1px 5px;
}
.selectop{
	margin: 2px 30px 2px 39px;
	width: 160px;
}
.th2{
	height:30px;
}
.tf{
	margin: 7px 30px 7px 35px;
	padding-left:90px;
	padding-top:9px;
	padding-bottom: 9px;
}
label{
	padding-left: 10px;
}
textarea.text{
	margin: 2px 30px 2px 39px;
	width: 180px;
}
select.text {
	margin: 2px 30px 2px 39px;
	width: 160px;
}
.inviner{
	colour:red;
}
fieldset { padding:0; border:0; margin-top:25px; }
#main-regist{

}

</style>
<%	Logger log = Logger.getLogger("Default");
	SmileUser u =null;
	String displayName = "evolix";
	try{
		u = (SmileUser) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
			displayName =u.getNode().getDisplayName();
	}catch (ClassCastException e){
		log.error("Unknow login");
	}
%>
<div id="main-regist">
<s:url id="uplineurl"
	action="json-fetch-upline.action" />
<div id="input-form">
<form>
<fieldset>
<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th colspan="2" class="th2">Register</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="ui-widget-footer ">
			<th colspan="2" class="tf">
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
    </sj:a> <img id="indicator" src="images/indicator.gif" alt="Loading..."
			style="display: none" />
			</th>
		</tr>
	</tfoot>
	
	<tbody>
		<tr>
			<td colspan="2"><p class="validateTips">All form fields are required.</p></td>
		</tr>		
		<tr>
			<td><label for="upline">ชื่อ up line <font color="red"> *</font>:</label></td>
			<td><sj:select href="%{uplineurl}" id="echo2" name="echo"
				list="uplines"  headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" />
			</td>
		</tr>
		<tr>
			<td><label for="name">ชื่อ *:</label></td>
			<td><input type="text" name="name" id="email"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="surename">นามสกุล *:</label></td>
			<td><input type="text" name="surename" id="surename"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="displayName">ชื่อแสดงในสายงาน *:</label></td>
			<td><input type="text" name="displayName" id="displayName"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="codeIdentification">รหัสบัตรประชาชน  *:</label></td>
			<td><input type="text" name="displayName" id="codeIdentification"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="tel">เบอร์โทรศัพท์  *:</label></td>
			<td><input type="text" name="tel" id="tel"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="tel2">เบอร์โทรศัพท์(สำรอง)  :</label></td>
			<td><input type="text" name="tel2" id="tel2"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="inviter">ชื่อผู้แนะนำ  *:</label></td>
			<td><input type="text" name="inviter" id="inviter" readonly="readonly" disabled="disabled" 
				value=<%=displayName %> class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="brance">สาขาทีสมัคร  *:</label></td>
			<td><sj:select href="%{uplineurl}" id="echo3" name="echo"
				list="products"  headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" />
			</td>
		</tr>
		<tr>
			<td><label for="branceCard">สาขาทีรับบัตรสมาชิก  *:</label></td>
			<td><sj:select href="%{uplineurl}" id="echo4" name="echo" 
				list="products"  headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" /></td>
		</tr>
		<tr>
			<td><label for="address">ที่อยู่  *:</label></td>
			<td><textarea rows="4" cols="4"  name="address" id="address" 
				class="text ui-widget-content ui-corner-all" ></textarea></td>
		</tr>
		<tr>
			<td><label for="bank">จังหวัด  *:</label></td>
			<td><sj:select href="%{uplineurl}" id="bank" name="bank1"
				list="products"  headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" />
			</td>
		</tr>
		
		<tr>
			<td><label for="address2">ที่อยู่ส่งของ  :</label></td>
			<td><textarea rows="4" cols="4"  name="address2" id="address2" 
				class="text ui-widget-content ui-corner-all" ></textarea></td>
		</tr>
		<tr>
			<td><label for="email">email  :</label></td>
			<td><input type="text" name="email" id="email"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="bank">ธนาคาร  *:</label></td>
			<td><sj:select href="%{uplineurl}" id="bank" name="bank"
				list="products"  headerKey="-2" cssClass="selectop"
				headerValue="Auto Assign" />
			</td>
		</tr>
		<tr>
			<td><label for="bankAccount">เลที่บัญชี  *:</label></td>
			<td><input type="text" name="bankAccount" id="bankAccount"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="bankBrance">สาขาธนาคาร *:</label></td>
			<td><input type="text" name="bankBrance" id="bankBrance"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="typeOfAccount">ประเภทบัญชี *:</label></td>
			<td><input type="text" name="typeOfAccount" id="typeOfAccount"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		
	</tbody>
</table>



</fieldset>
</form>
</div>

</div>
<div id="div1">
<table
	style="align: center; width: 440px; margin-left: 280px; border: 1px solid #000000; margin-top: 50px;">
	<tr>
		<td colspan="2" bgcolor="#EB8F00"><b>Register</b></td>
	</tr>
	<tr>
		<td><s:form id="formx" action="save" theme="xhtml"
			style="cellspacing:25px">
			<s:select label="ชื่อ up line" name="upline" headerKey="-1"
				headerValue="Auto Assign Upline"
				list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				value="none" required="true" />
			<sj:textfield label="ชื่อ" name="name" required="true"
				value="=ชื่อ ผู้สมัคร" />
			<sj:textfield label="นามสกุล" name="surename" required="true"
				value="นามสกุลผู้สมัคร" />
			<sj:textfield label="ชื่อแสดงในสายงาน" name="displayName"
				required="true" value="=ชื่อ แสดงในสายงาน" />
			<sj:textfield label="รหัสบัตรประชาชน" name="codeIdentification"
				required="true" value="รหัสบัตรประชาชน" />
			<sj:textfield label="เบอร์โทรศัพท์" name="tel" required="true"
				value="เบอร์โทร" />
			<sj:textfield label="เบอร์โทรศัพท์(สำรอง)" name="tel2"
				value="เบอร์โทรสำรอง" />
			<sj:textfield label="ชื่อผู้แนะนำ" name="inviter" disabled="true"
				require="true" value="ดลยา" />
			<s:select label="สาขาทีรับบัตรสมาชิก " name="branceCard"
				headerKey="-1" headerValue="สำนักงานใหญ่"
				list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				value="ชื่อ  สำนักงาน" required="true" />
			<sj:textarea label="ที่อยู่" name="address" required="true"
				value="ที่อยู่" />
			<s:select label="จังหวัด " name="province" headerKey="กรุงเทพมหานคร"
				headerValue="aaaa"
				list="#{ 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}" required="true" />

			<sj:textarea label="ที่อยูส่งของ" name="ที่อยู่ส่งของ"
				value="ที่อยู่ส่งของ" />
			<sj:textfield label="e-mail" name="email" value=" อีเมลล์" />
			<s:select label="ธนาคาร " name="bank" headerKey="ธนาคารโลก"
				headerValue="AAAA"
				list="#{'zzzz':'ZZZZ', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
				required="true" />


			<sj:textfield label="เลขบัญชี" name="bankAccount" required="true"
				value="1234567890" />
			<sj:textfield label="สาขาธนาคาร" name="brance" required="true"
				value="บ้านแหลม" />
			<sj:textfield label="ประเภทบัญชี" name="typeOfAccount"
				required="true" value="ฝากตลอดชีวิต" />
		</s:form></td>
	</tr>
	<tr>
		<td align="center" colspan="1"><sj:a id="ajaxformlink"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover" formIds="formx" targets="div1"
			indicator="indicator" button="true" buttonIcon="ui-icon-gear">
      ยืนยัน
    </sj:a> <sj:a id="ajaxformlink2" formIds="formx" targets="formResult"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover" indicator="indicator" button="true"
			buttonIcon="ui-icon-gear">
      ยกเลิก
    </sj:a> <img id="indicator" src="images/indicator.gif" alt="Loading..."
			style="display: none" /></td>
	</tr>

</table>
<div id="div1"
	style="position: absolute; left: 564px; top: 151px; z-index: 5"; ><a
	href=""><font color="green"></font>ลิ้งไปผังองค์กร</a></div>


</div>
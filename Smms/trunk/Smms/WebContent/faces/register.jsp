<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>
<script type="text/javascript">
	$(function() {		
		var name = $("#name"),surename = $("#surename"),displayName = $("#displayName")
		,codeIdentification = $("#codeIdentification"),tel = $("#tel"),tel2 = $("#tel2"),email = $("#email")
		,inviter = $("#inviter"),address = $("#address"),address2 = $("#address2")
		,bank = $("#bank"),bankAccount = $("#bankAccount")
		,bankBrance = $("#bankBrance"),typeOfAccount = $("#typeOfAccount");
		var allFields = $([]).add(name).add(surename).add(displayName).add(codeIdentification).add(tel)
		.add(address).add(address2).add(bankAccount).add(bankBrance).add(typeOfAccount).add(email);
		allFields.removeClass( "ui-state-error" );	
		$("#displayName").live("focusout",checkDisplayName);
	//$("#name").live("click",function(){			});
		function checkDisplayName(){	
			$(this).removeClass( "ui-state-error" );			
			$.ajax({
				type : "post",				
				url : "check-displayname.action",
				data : "displayName=" + $(this).val(),
				success : function(res) {
					showmsgInf(res);
					if($("#testResult").html()=='false'){
						 $("#displayName").addClass("ui-state-error");
						 $("#displayName").focus();
						 return false;
					};
				}
			});
			return true;
		}
		$("#fsubmit1").submit(function() {	
			clrErrInf();	
			allFields.removeClass( "ui-state-error" );					
			var valid =true;
			valid =  checkLength(name," ชื่อ ",3,30);
			valid = valid && checkLength(surename," นามสกุล ",3,30);
			valid = valid && checkLength(displayName," ชื่อแสดงในสายงาน ",3,30);	
			valid = valid && checkLength(codeIdentification," รหัสบัตรประชาชน ",12,13)&&checkidentifier(codeIdentification);	
			valid = valid && checkLength(tel," เบอร์โทรศัพท์ ",9,10);	
			valid = valid && checkLength(address," ที่อยู่  ",5,30);	
			valid = valid && checkEmail(email);	
			valid = valid && checkLength(bankAccount," บัญชีธนาคาร ",8,30);
			valid = valid && checkLength(bankBrance," สาขาธนาคาร ",3,30);
			valid = valid && checkLength(typeOfAccount," ประเภทบัญชี ",3,30);
			if(valid){
				var uri = "upline="+$("#upline").val()
				+"&name="+name.val()
				+"&surename="+surename.val()
				+"&displayName="+displayName.val()
				+"&codeIdentification="+codeIdentification.val()
				+"&tel="+tel.val()
				+"&tel2="+tel2.val()
				+"&inviter="+$("#inviter2").val()
				+"&brance="+$("#brance").val()
				+"&branceCard="+$("#branceCard").val()
				+"&address="+address.val()
				+"&province="+$("#province").val()
				+"&address2="+address2.val()
				+"&email="+email.val()
				+"&bank="+bank.val()
				+"&bankAccount="+bankAccount.val()
				+"&bankBrance="+bankBrance.val()
				+"&typeOfAccount="+typeOfAccount.val()
				;
				//alert(""+uri);
				$.ajax({
					type : "post",
					contentType :"application/x-www-form-urlencoded;charset=UTF-8"	,			
					url : "save",
					data : uri,
					success : function(res) {
						showmsgInf(res);
						if($("#testResult").html()=='true'){
							$(':input','#form1')
							 .not(':button, :submit, :reset, :hidden,#inviter,#inviter2,#brance,#branceCard,#province,#bank')
							 .val("");;
						};	
						allFields.val( "" ).removeClass( "ui-state-error" );				 										    
					}
				});
			}				
		}); 
		function checkidentifier(ci){
			var c = true;c=checkIdent(ci.val());
			if(!c){
				ci.addClass( "ui-state-error" );
				showmsgInf("<li>รหัสบัตรประชาชนไม่ถูกต้อง</li>");	
			}else{
				ci.removeClass( "ui-state-error" );
			}
			return c;
		}
		function checkIdent(id){			
			if(id.length != 13) return false;
			for(var i=0, sum=0; i < 12; i++)sum += parseFloat(id.charAt(i))*(13-i);
			if((11-sum%11)%10!=parseFloat(id.charAt(12)))return false;
			return true;
		}
		function checkEmail(o){
			clrErrInf();
			var v = o.val();
			if(v.length>0)return checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. mail@evolix.biz" );
			return true;
		}
		function checkRegexp( o, regexp, n ) {
			if ( !( regexp.test( o.val() ) ) ) {
				o.addClass( "ui-state-error" );
				showmsgInf(n);
				return false;
			} else {
				return true;
			}
		}
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
			$("#messageInfo")
					.addClass("ui-state-highlight ui-corner-all")
					.empty()
					.append(
							"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
									+ "<strong>ข้อความ</strong> "
									+ ""
									+ msgInf
									+ "" + "</p>");

		}
		function clrErrInf() {
			$("#messageInfo").removeClass("ui-state-highlight ui-corner-all")
					.empty();
			
		}
		function rmAllfielderr(){
			allFields.removeClass( "ui-state-error" );
		}

	});
</script>
<style type="text/css">
input.text {
	margin: 2px 30px 2px 39px;
	width: 230px;
	padding: 1px 5px 1px 5px;
}

.selectop {
	margin: 2px 30px 2px 39px;
	width: 160px;
}

.th2 {
	height: 30px;
}

.tf {
	margin: 7px 30px 7px 35px;
	padding-left: 90px;
	padding-top: 9px;
	padding-bottom: 9px;
}

label {
	padding-left: 10px;
}

textarea.text {
	margin: 2px 30px 2px 39px;
	width: 180px;
}

select.text {
	margin: 2px 30px 2px 39px;
	width: 160px;
}

.inviner {
	colour: red;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

#main-regist {
	
}
</style>
<%
	Logger log = Logger.getLogger("Default");
	SmileUser u = null;
	String displayName = "evolix";
	String id = "";
	try {
		u = (SmileUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		id = u.getUserid();
		displayName = u.getNode().getDisplayName();
	} catch (ClassCastException e) {
		log.error("Unknow login");
	}
%>

<div id="main-regist"><s:url id="checkurl"
	action="check-displayname.action" /> <s:url id="uplineurl"
	action="json-fetch-upline.action" /> <s:url id="provinceurl"
	action="json-fetch-province.action" /> <s:url id="branceurl"
	action="json-fetch-brance.action" />
<div id="test"></div>
<div id="input-form">
<form id="form1"action="javascript:void(0)" >
<fieldset>
<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th colspan="2" class="th2">Register</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="ui-widget-footer ">
			<th colspan="2" class="tf"><input type="submit" id="fsubmit1"
				class="ui-button ui-widget ui-state-default ui-corner-all"
				value="ยืนยัน" onmouseover="ui-state-hover" /> <input type="button"
				class="ui-button ui-widget ui-state-default ui-corner-all"
				value="ยกเลิก" onmouseover="ui-state-hover" /></th>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td colspan="2">
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
			<td><label for="upline">ชื่อ up line <font color="red">
			*</font>:</label></td>
			<td><sj:select href="%{uplineurl}" id="upline" name="echo"
				list="uplines" headerKey="-2" cssClass="selectop"   
				headerValue="Auto Assign" /></td>
		</tr>
		<tr>
			<td><label for="name">ชื่อ *:</label></td>
			<td><input type="text" name="name" id="name"
				class="text ui-widget-content ui-corner-all required" /></td>
		</tr>
		<tr>
			<td><label for="surename">นามสกุล *:</label></td>
			<td><input type="text" name="surename" id="surename"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="displayName">ชื่อแสดงในสายงาน *:</label></td>
			<td><input type="text"	name="displayName" id="displayName"
				class="text ui-widget-content ui-corner-all" /> 
			</td>
		</tr>
		<tr>
			<td><label for="codeIdentification">รหัสบัตรประชาชน *:</label></td>
			<td><input type="text" name="codeIdentification"
				id="codeIdentification"
				class="text ui-widget-content ui-corner-all validate[required]" /></td>
		</tr>
		<tr>
			<td><label for="tel">เบอร์โทรศัพท์ *:</label></td>
			<td><input type="text" name="tel" id="tel"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="tel2">เบอร์โทรศัพท์(สำรอง) :</label></td>
			<td><input type="text" name="tel2" id="tel2"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="inviter">ชื่อผู้แนะนำ *:</label></td>
			<td><input type="text" name="inviter" id="inviter"
				readonly="readonly" disabled="disabled" value=<%=displayName%>
				class="text ui-widget-content ui-corner-all" /><div id="inviter1" style="display: none"><input value=<%=id%> id="inviter2"/></div></td>
		</tr>
		<tr>
			<td><label for="brance">สาขาทีสมัคร *:</label></td>
			<td><sj:select href="%{branceurl}" id="brance" name="brance" value="1"
				list="brances" cssClass="selectop" /></td>
		</tr>
		<tr>
			<td><label for="branceCard">สาขาทีรับบัตรสมาชิก *:</label></td>
			<td><sj:select href="%{branceurl}" id="branceCard" name="branceCard" value="1"
				list="brances" cssClass="selectop" /></td>
		</tr>
		<tr>
			<td><label for="address">ที่อยู่ *:</label></td>
			<td><textarea rows="4" cols="4" name="address" id="address"
				class="text ui-widget-content ui-corner-all"></textarea></td>
		</tr>
		<tr>
			<td><label for="province">จังหวัด *:</label></td>
			<td><sj:select href="%{provinceurl}" id="province" value="10"
				name="province" list="provinces"  cssClass="selectop"
				 /></td>
		</tr>

		<tr>
			<td><label for="address2">ที่อยู่ส่งของ :</label></td>
			<td><textarea rows="4" cols="4" name="address2" id="address2"
				class="text ui-widget-content ui-corner-all"></textarea></td>
		</tr>
		<tr>
			<td><label for="email">email :</label></td>
			<td><input type="text" name="email" id="email"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="bank">ธนาคาร *:</label></td>
			<td><s:select  id="bank" name="bank" list="#{'ธนาคารไทยพานิชย์':'ธนาคารไทยพานิชย์'}" 
				 cssClass="selectop" value="ธนาคารไทยพานิชย์"
				 /></td>
		</tr>
		<tr>
			<td><label for="bankAccount">เลที่บัญชี *:</label></td>
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


</div>
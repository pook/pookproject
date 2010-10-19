<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css"/>
<s:form id="formValidateCustom" action="register" theme="xhtml"
	cssClass="yform">
	
	<table
		style="align: center; width: 440px; margin-left: 280px; border: 1px solid #000000;margin-top: 90px;"
		cellspacing="9px">
		<tr>
		<td colspan="1">
			<b>Register</b></td>
		</tr>		
			<tr><td>
					<sj:textfield label="ชื่อ" name="xxxx1" required="true"/>
				<sj:textfield label="นามสกุล" name="xxxx2" required="true"/>
					<sj:textfield label="รหัสบัตรประชาชน" name="xxxx3" required="true"/>
							<sj:textfield label="เบอร์โทรศัพท์" name="xxxx4"/>
								<sj:textfield label="เบอร์โทรศัพท์มือถือ" name="xxxx5" required="true"/>
						<sj:textfield label="เบอร์แฟกส์" name="xxxx5"/>
						<sj:textfield label="ชื่อผู้แนะนำ" name="xxxx5" disabled="true"/>
								      <s:select label="ชื่อ up line"
        name="member"
        headerKey="-1" headerValue="Select Member Up Line"
        list="#{'aaa':'AAAA', 'bbb':'BBBB', 'ccc':'CCCC', 'ddd':'DDDD'}"
        value="selectedMonth"
        required="true"
 />
									<sj:textfield label="e-mail" />
								<sj:textarea label="ที่อยู่" name="xxxx5"/>
									<sj:textarea label="ที่อยูส่งของ" name="xxx5"/>
								<sj:textfield label="บัญชีธนาคาร" name="xxxx5"/>
									<sj:textfield label="เลขบัญชี" name="xxxx5"/>
								<sj:textfield label="สาขาธนาคาร" name="xxxx5"/>
								<sj:textfield label="ประเภทบัญชี" name="xxxx5"/>
								</td></tr><tr><td align="right" colspan="1">
							<sj:a 
    	id="ajaxformlink" 
    	formIds="form" 
    	targets="formResult" 
    	indicator="indicator" 
    	button="true" 
		buttonIcon="ui-icon-gear"
    >
      ยืนยัน
    </sj:a>
    <sj:a 
    	id="ajaxformlink2" 
    	formIds="form" 
    	targets="formResult" 
    	indicator="indicator" 
    	button="true" 
		buttonIcon="ui-icon-gear"
    >
      ยกเลิก
    </sj:a>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
									
								
				</td>
			</tr>	
			</table>
	

</s:form>


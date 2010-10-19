<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css"/>
<sj:head locale="th" jqueryui="true" jquerytheme="dark-hive" />
<sj:div id="sjdiv" jquerytheme="dark-hive">
<s:form id="form" theme="xhtml" >
<s:textfield name="username" label="ชื่อ ล็อกอิน  "/>
<s:textfield name="password" label="รหัสผ่าน  "/>
<s:textfield name="repassword" label="ยืนยันรหัสผ่าน  "/>
<s:textfield name="fname" label="ชื่อ :"/>
<s:textfield name="lname" label="นามสกุล "/>
<s:textfield name="email" label="e-mail "/>
<s:textfield name="tel" label="เบอร์โทรศัพท์ "/>
<sj:submit targets="sjdiv"
				button="true"
				validate="true" 
				validateFunction="customeValidation"
				onBeforeTopics="removeErrors" 
				onSuccessTopics="removeErrors"
		value="Submit" indicator="indicator" />
</s:form>
</sj:div>

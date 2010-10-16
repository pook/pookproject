<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="themes/showcase/jquery-ui.css" type="text/css"/>
<sj:head locale="th" jqueryui="true" jquerytheme="dark-hive" />
<script type="text/javascript">
 $(document).ready( function() {
	$.subscribe('removeErrors', function(event,data) {
		$('.errorLabel').html('').removeClass('errorLabel');
		$('#formerrors').html('');
	});
});	

function customeValidation(form, errors) {
	
	//List for errors
	var list = $('#formerrors');
	
	//Handle non field errors 
	if (errors.errors) {
		$.each(errors.errors, function(index, value) { 
			list.append(''+value+'# \n');
		});
	}
	
	//Handle field errors 
	if (errors.fieldErrors) {
		$.each(errors.fieldErrors, function(index, value) { 
			var elem = $('#'+index+'Error');
			if(elem)
			{
				elem.html(value[0]);
				elem.addClass('errorLabel');
			}
		});
	}
}

</script>
</head>
<body>
<div id="result" class="result ui-widget-content ui-corner-all">Login
Form.</div>
<ul id="formerrors" class="errorMessage"></ul>
<s:form id="formValidateChgPasswd" action="chgPassword" theme="simple"
	cssClass="yform">
	<fieldset><legend>Login</legend>
	<div class="type-text"><label for="echo">Current Password: <span
		id="passwdError"></span></label> <s:password id="passwd"
		name="passwd" /></div>
	<div class="type-text"><label for="echo">New Password: <span
		id="newPasswdError"></span></label> <s:password id="newPasswd"
		name="newPassword" /></div>
	<div class="type-text"><label for="echo">Re-New Password: <span
		id="reNewPasswdError"></span></label> <s:password id="reNewPasswd"
		name="reNewPasswd" /></div>
	<div class="type-button"><sj:submit targets="result"
		button="true" validate="true" validateFunction="customeValidation"
		onBeforeTopics="removeErrors" onSuccessTopics="removeErrors"
		value="Submit" indicator="indicator" /></div>
	</fieldset>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..."
	style="display: none" />
</body>
</html>
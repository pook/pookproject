<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css"/>
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
<div id="result" class="result ui-widget-content ui-corner-all">Login
Form.</div>
<ul id="formerrors" class="errorMessage"></ul>
<s:form id="formValidateCustom" action="login" theme="simple"
	cssClass="yform">
	<fieldset><legend>Login</legend>
	<div class="type-text"><label for="echo">User: <span
		id="loginuserError"></span></label> <s:textfield id="loginuser"
		name="loginuser" /></div>
	<div class="type-text"><label for="echo">Password: <span
		id="loginpasswordError"></span></label> <s:password id="loginpassword" 
		name="loginpassword" /></div>
	<div class="type-button"><sj:submit targets="result"
		button="true" validate="true" validateFunction="customeValidation"
		onBeforeTopics="removeErrors" onSuccessTopics="removeErrors"
		value="Submit" indicator="indicator" /></div>
	</fieldset>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..."
	style="display: none" />

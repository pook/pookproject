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

<div id="result">
<ul id="formerrors" class="errorMessage"></ul>
<s:form id="formValidateCustom" action="chgpassword" theme="simple"
	cssClass="yform">
	<fieldset><legend>Chang Password</legend>
	<div class="type-text"><label for="echo">Password: <span
		id="passwordError"></span></label> <s:password id="password"
		name="password" /></div>
	<div class="type-text"><label for="echo">New Password: <span
		id="newpasswordError"></span></label> <s:password id="newpassword" 
		name="newpassword" /></div>
		<div class="type-text"><label for="echo">Re New Password: <span
		id="renewpasswordError"></span></label> <s:password id="renewpassword" 
		name="renewpassword" /></div>
	<div class="type-button">
	<sj:submit targets="result"
				button="true"
				validate="true" 
				validateFunction="customeValidation"
				onBeforeTopics="removeErrors" 
				onSuccessTopics="removeErrors"
		value="Submit" indicator="indicator" /></div>
	</fieldset>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..."
	style="display: none" />
</div>
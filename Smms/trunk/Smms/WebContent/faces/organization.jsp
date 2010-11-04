<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:property value="echo" escape="%{escape}" />
<s:div id="formResult">
	<s:form id="form" action="organization" theme="simple" cssClass="yform">

		<fieldset><legend><b>ผังองค์กร</b></legend>

		
		<div class="type-buttom">
		
		<label for="ech" style="color:black">Member#AD1000000009  |Targeted SV :2,200| Team Smile Value :99</label><br> 
			<input style="width: 120px"/>
			<input type ="button" style="width:130px;height: 20px " value="ค้นหาจากรหัสสมาชิก" cssClass="ui-button ui-widget ui-state-default ui-corner-all"/>
			</div>
		<div class="type-button">
						
						
		<sj:submit targets="formResult"
			id="ajaxbutton"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover"
			
			value="เริ่มต้น" indicator="indicator" buttonIcon="ui-icon-gear" /> <s:url id="simpleecho"
			value="/simpleecho.action" />
			
			 <sj:submit id="xxx" targets="formResult"
			 buttonIcon="ui-icon-gear"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover"
			value="ถอยกลับ 1 ชั้น" indicator="indicator" /> <sj:submit
			buttonIcon="ui-icon-gear"
			cssClass="ui-button ui-widget ui-state-default ui-corner-all"
			onmouseover="ui-state-hover"
			targets="formResult" value="ถอยกลับ 6 ชั้น" indicator="indicator" />
		<!-- 
	            <label for="echo">Echo: </label>
	            <s:textfield id="echo" name="echo" value="Hello World!!!"/>
	            --> <img id="indicator1" src="images/legend7.gif"
			alt="Loading..." align="right" />
			</div>
		</fieldset>
	</s:form>
</s:div>
<s:div id="orgchart">
	<img id="indicator" src="images/Org-Chart7.gif" alt="Loading..." />
</s:div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />

<style type="text/css">
div#main1 div {
	clear:both;
	
}
</style>
<div id="main1">
<div id="inner1">
		<s:url id="remoteurl" action="json-ordering" />					
					<s:url id="editpurcheseurl" action="edit-grid-purchese" />
					<s:url id="editorderurl" action="edit-grid-order" />
					<sjg:grid id="gridedittable" caption=""  dataType="json"
						href="%{remote2url}" pager="true" navigator="true"
						navigatorSearch="false"							
						navigatorView="false"
						navigatorDelete="false"
						navigatorAdd="false"
						navigatorEdit="false"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924"
						editurl="%{editpurcheseurl}" 
						onSelectRowTopics="rowselect">						
						
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="120"
								index="sku.sid" />
							<sjg:gridColumn name="sku.name" title="ชื่อผสิตภัณฑ์"
								edittype="select" editable="true"
								editoptions="{ dataUrl : '%{selectskuurl}' }" />
							<sjg:gridColumn name="sku.description" edittype="textarea" width="350"
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" />
							<sjg:gridColumn name="quantity" title="จำนวน" editable="true"
								required="true"
								editrules="{integer:true,minValue:1,required:true}"
								formatter="integer" />
							<sjg:gridColumn name="purchesePrice" title="ราคา"
								formatter="currency" align="right" />							
							<sjg:gridColumn name="psv" title="smile value" align="center"
								formatter="integer" />
						</sjg:grid>	
</div>
</div>
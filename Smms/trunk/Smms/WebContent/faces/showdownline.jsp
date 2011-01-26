<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/showdownline.css" rel="stylesheet" type="text/css" />
<div id="m1">
<div id="main1">
<div id="inner1">
		<s:url id="remoteurl" action="json-downline-member" />					
					<sjg:grid id="gridedittable" caption="-"  dataType="json"
						href="%{remoteurl}" pager="true" navigator="true"
						navigatorSearch="false"							
						navigatorView="false"
						navigatorDelete="false"
						navigatorAdd="false"
						navigatorEdit="false"						
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924"						
						>						
							<sjg:gridColumn name="smileId" title="รหัสสมาชิก" width="70" sortable="false" align="center"
								index="sku.sid" />
							<sjg:gridColumn name="name" title="ชือสมาชิก" sortable="false"
								 editable="false" />
								 <sjg:gridColumn name="displayName" title="ชื่อในสายงาน" sortable="false"
								 editable="false" />
							<sjg:gridColumn name="status" title="สถานะ" align="center" sortable="false" width="80"
								 editable="false" />
							
						</sjg:grid>	
</div>
</div>
</div>
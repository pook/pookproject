<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />

<style type="text/css">
#main{
	height: 450px
}
div#main1 div {
	clear:both;			
}
div#inner1{
	margin: 35px 40px 50px 60px;
}
</style>
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
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924"						
						>						
							<sjg:gridColumn name="smileId" title="รหัสสมาชิก" width="120"
								index="sku.sid" />
							<sjg:gridColumn name="name" title="ชือสมาชิก"
								 editable="false" />
								 <sjg:gridColumn name="displayName" title="ชื่อในสายงาน"
								 editable="false" />
							<sjg:gridColumn name="address" edittype="textarea" width="350"
								title="ที่อยู่" sortable="false" />
								<sjg:gridColumn name="status" title="สถานะ" align="center"
								 editable="false" />
							
						</sjg:grid>	
</div>
</div>
</div>
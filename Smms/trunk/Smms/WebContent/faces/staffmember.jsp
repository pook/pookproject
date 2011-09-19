<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#main-staff {
	margin: 35px 50px 50px 75px;
}
</style>
<div id="main-staff"><sj:div id="div0">
	<div id="div2"><s:url id="roleurl"
		action="json-user-regist-staff.action" /> <s:url id="editroleurl"
		action="edit-user-register-staff.action" /> <sjg:grid
		id="gridedittable2" caption="สิทธิ์การสมัคร" dataType="json"
		href="%{roleurl}" pager="true" navigator="true"
		navigatorSearchOptions="{sopt:['eq'],reloadAfterSubmit:true,closeAfterEdit:true}"
		navigatorEdit="true" navigatorView="false"
		navigatorEditOptions="{reloadAfterSubmit:true,closeAfterEdit:true}"
		navigatorSearch="true" navigatorDelete="false" navigatorAdd="false"
		rownumbers="-1" gridModel="gridModel" rowList="15,30" rowNum="15"
		width="880" editurl="%{editroleurl}">
		<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก"
			align="center" sortable="true" editable="false" width="55" />
		<sjg:gridColumn name="name" index="name" title="ชื่อ สมาชิก"
			sortable="false" editable="false" />
		<sjg:gridColumn name="displayName" index="displayName"
			editoptions="{ readonly: true,disabled:'disabled'}"
			title="ชื่อ แสดงในสายงาน" sortable="false" editable="true"
			search="true" />
		<sjg:gridColumn name="date" title="วันที่สมัคร" width="70"
			editable="false" search="false" formatter="date" sortable="false"
			align="center" />
		<sjg:gridColumn name="maxuser" index="maxuser" width="70"
			search="false" title="สมาชิกที่เพิ่ม" edittype="select"
			sortable="false"
			editoptions="{value:'1:1;2:2;3:3;4:4;5:5;6:6;7:7;8:8;9:9;10:10;11:11;12:12;13:13;14:14;15:15;16:16;17:17;18:18;19:19;20:20;21:21;22:22;23:23;24:24;25:25;26:26;27:27;28:28;29:29;30:30;31:31;32:32;33:33;34:34;35:35;36:36;37:37;38:38;39:39;40:40;41:41;42:42;43:43;44:44;45:45;46:46;47:47;48:48;49:49;50:50'}"
			editable="true" formatter="" align="center" />
	</sjg:grid> <br />
	<br />
	</div>
</sj:div></div>
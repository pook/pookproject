<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css" >
#main-staff{
	margin: 35px 50px 50px 75px;
}
</style>
<div id="main-staff">
<sj:div id="div0">					
					<div id="div2">
						<s:url id="roleurl" action="json-user-regist-staff.action" />
						<s:url id="editroleurl" action="edit-user-register-staff.action" />
						<sjg:grid id="gridedittable2" caption="สิทธิ์การสมัคร" dataType="json"
							href="%{roleurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq'],reloadAfterSubmit:true}"
							navigatorEdit="true" navigatorView="false"
							navigatorDelete="false" navigatorAdd="false" rownumbers="15"							
							gridModel="gridModel" rowList="15,30" rowNum="15" 
							width="880" editurl="%{editroleurl}"
							>
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก"
								sortable="false" editable="false" width="100"/>
							<sjg:gridColumn name="name" index="name"
								title="ชื่อ สมาชิก" sortable="false" editable="false" />
							<sjg:gridColumn name="displayName" editoptions= "{ readonly: true,disabled:'disabled'}" 
								title="ชื่อ แสดงในสายงาน" sortable="false" editable="true" />
							<sjg:gridColumn name="date"  title="วันที่สมัคร" width="100"
								editable="false" search="false" formatter="date" 
								 align="center" />
							<sjg:gridColumn name="maxuser" index="maxuser" width="120" search="false"
								title="สมาชิกที่เพิ่ม" edittype="select" sortable="false" editoptions="{value:'1:1;2:2;3:3;4:4;5:5;6:6;7:7;8:8;9:9;10:10;15:15;20:20;25:25;30:30;35:35;40:40;45:45;50:50'}"
								editable="true" formatter="" align="center" />
						</sjg:grid>
						<br />
						<sj:submit id="grid_edit_searchbutton45" value="Search"
							onClickTopics="searchgrid" button="true" />
						<sj:submit id="grid_edit_colsbutton35" value="Show/Hide Columns"
							onClickTopics="showcolumns" button="true" />
										<br/>
						<br/>
					</div>
				</sj:div>
				</div>
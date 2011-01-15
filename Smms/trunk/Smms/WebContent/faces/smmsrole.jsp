<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$.subscribe('getselectedids2', function(event,data) {
	var s;
	s = $("#gridmultitable").jqGrid('getGridParam','selarrrow');
	$.ajax({
		type : "get",
		url : "edit-card",
		data : "rows="+s,
		success: function(dat) {			
		}		
	});
	$("#div4").load("smmsrole.action");
});

</script>
<div id="test"></div>
<div id="div4">
	<table
		style="align: center; width:924px; margin-left: 60px; border: 0px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<td><sj:tabbedpanel id="localtabs" selectedTab="0">
				<sj:tab id="tab2" target="ttwo" label="จัดการการออกบัตร"
					tabindex="0" />
				<sj:tab id="tab3" target="ttree" label="ตั้งค่าสาขา" tabindex="1" />
				<sj:tab id="tab1" target="tone" label="กำหนดสิทธิ์" tabindex="2" />
				<div id="ttwo"><sj:div id="div01">
					<sj:div id="div11"></sj:div>
					<sj:div id="div21">
						<s:url id="cardremoteurl" action="json-card" />
						<s:url id="cardediturl" action="edit-card"/>
						<sjg:grid id="gridmultitable" caption="จัดการการออกบัตร"
							dataType="json" href="%{cardremoteurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq']}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="false" navigatorView="false" navigatorAdd="false"
							navigatorDelete="false" rownumbers="true" gridModel="gridModel"
							multiselect="true" 
							rowList="15,30" rowNum="15" width="880" editurl="%{cardediturl}"
							onSelectRowTopics="rowselect">							
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก" width="100"
								sortable="false"  editable="false"/>
							<sjg:gridColumn name="name" 
								title="ชื่อ สมาชิก" sortable="false"/>
							<sjg:gridColumn name="surename" 
								title="นามสกุล" sortable="false"/>
							<sjg:gridColumn name="displayName" 
								title="ชื่อแสดงในสายงาน" sortable="false"/>
							<sjg:gridColumn name="brance" index="brance"
								title="สาขาที่ลงทะเบียน" sortable="false"/>
							<sjg:gridColumn name="branceCard" index="branceCard"
								title="สาขาที่รับบัตร" sortable="false"/>
						</sjg:grid>
						<br />
							<sj:submit  value="ออกบัตร"
							id="grid_multi_getselectedbutton"  onClickTopics="getselectedids2" button="true"/>						
						<sj:submit id="grid_edit_searchbutton1" value="Search"
							onClickTopics="searchgrid" button="true" />
						<sj:submit id="grid_edit_colsbutton1" value="Show/Hide Columns"
							onClickTopics="showcolumns" button="true" />						
						<br />
						<br />
					</sj:div>
				</sj:div></div>
				<div id="ttree"><sj:div id="div011">
					<sj:div id="div111"></sj:div>					
					<sj:div id="div211">
						<s:url id="selectprovinceurl" action="fetch-province" />
						<s:url id="branceurl" action="json-brance" />
						<s:url id="editbranceurl" action="edit-grid-brance" />						
						<sjg:grid id="gridedittable11" caption="ตั้งค่าสาขา"
							dataType="json" href="%{branceurl}" pager="true" navigator="true" 
							navigatorSearchOptions="{sopt:['eq']}" 
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="true" navigatorView="false"
							navigatorDelete="false" navigatorAdd="true" rownumbers="true"
							gridModel="gridModel" rowList="15,30" rowNum="15"
							 width="880" editurl="%{editbranceurl}"
							onSelectRowTopics="rowselect">
							<sjg:gridColumn name="branceCode" index="branceCode" title="รหัสสาขา"
								sortable="false"   editable="false"  
								 />
							<sjg:gridColumn name="BName" 
								title="ชือสาขา"  editable="true"  editrules="{minlength:4,required:true}"  />
							<sjg:gridColumn name="BTel" 
								title="เบอร์โทร"  editable="true" editrules="{minlength:8,integer:true,required:true}"/>
							<sjg:gridColumn name="BAddress" edittype="textarea"
								title="ที่อยู่"  editable="true" editrules="{minlength:5,required:true}"/>
							<sjg:gridColumn name="province.pname" 
								title="จังหวัด"   edittype="select" editable="true"  
								editoptions="{ dataUrl : '%{selectprovinceurl}' }"/>
							<sjg:gridColumn name="postcode"
								title="รหัสไปรษณีย์"  editable="true" editrules="{integer:true,minlength:5,required:true}"/>
						</sjg:grid>
						<br />	<sj:submit id="grid_edit_searchbutton10" value="Add"
							onClickTopics="searchgrid" button="true" />
						
						<sj:submit id="grid_edit_searchbutton11" value="Search"
							onClickTopics="searchgrid" button="true" />
						<sj:submit id="grid_edit_colsbutton11" value="Show/Hide Columns"
							onClickTopics="showcolumns" button="true" />
											<br />
						<br />
					</sj:div>
				</sj:div></div>
				<div id="tone"><sj:div id="div0">					
					<sj:div id="div2">
						<s:url id="roleurl" action="json-role" />
						<s:url id="editroleurl" action="edit-role1" />
						<sjg:grid id="gridedittable2" caption="กำหนดสิทธิ์" dataType="json"
							href="%{roleurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq'],reloadAfterSubmit:true}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"											
							navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
							navigatorEdit="false" navigatorView="false"
							navigatorDelete="false" navigatorAdd="false" rownumbers="15"							
							gridModel="gridModel" rowList="15,30" rowNum="15" editinline="true"
							width="880" editurl="%{editroleurl}"
							onSelectRowTopics="rowselect">
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก"
								sortable="false" editable="false" width="80"/>
							<sjg:gridColumn name="name" index="name"
								title="ชื่อ สมาชิก" sortable="false" editable="false" />
							<sjg:gridColumn name="tel"  title="เบอร์โทร" width="80"
								editable="false" search="false"
								 align="center" />
							<sjg:gridColumn name="date"  title="วันที่สมัคร" width="100"
								editable="false" search="false" formatter="date" 
								 align="center" />
							<sjg:gridColumn name="admin" index="admin" title="admin" width="80"
								edittype="checkbox" sortable="false" editable="true" search="false"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="staff" index="staff" title="staff"  search="false"
								sortable="false" edittype="checkbox" editable="true" width="80"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="member" index="member" title="member"  search="false"
								sortable="false" edittype="checkbox" editable="true" width="80"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="maxuser" index="maxuser" width="120" search="false"
								title="สมาชิกที่เพิ่ม" edittype="select" sortable="false" editoptions="{value:'1:1;2:2;3:3;4:4;5:5;6:6;7:7;8:8;9:9;10:10;15:15;20:20;25:25;30:30;35:35;40:40;45:45;50:50'}"
								editable="true" formatter="" align="center" />
						</sjg:grid>
						<br />
						<sj:submit id="grid_edit_searchbutton45" value="Search"
							onClickTopics="searchgrid" button="true" />
						<sj:submit id="grid_edit_colsbutton35" value="Show/Hide Columns"
							onClickTopics="showcolumns" button="true" />
						<sj:submit id="grid_multi_getselectedbuttonxxs13"
							value="Reset Password" onClickTopics="getselectedids"
							button="true" />
						<br/>
						<br/>
					</sj:div>
				</sj:div></div>
			</sj:tabbedpanel></td>
		</tr>
	</table>
</div>
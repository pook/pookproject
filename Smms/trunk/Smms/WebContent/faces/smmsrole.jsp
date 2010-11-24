<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Smms/struts/utils.js"></script>
<script type="text/javascript">
function xxx(){
	$("#test").html("bbbbb") ; 
}
</script>
<div id="test"></div>
<sj:div id="div4">
	<table
		style="align: center; background: #FDF5CE; width: 540px; margin-left: 100px; border: 1px solid #000000; margin-top: 50px"
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
						<s:url id="remoteurl" action="jsonsmmsrole" />
						<s:url id="editurl" action="edit-grid-entry" />
						<sjg:grid id="gridedittable1" caption="จัดการการออกบัตร"
							dataType="json" href="%{remoteurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="false" navigatorView="false" navigatorAdd="false"
							navigatorDelete="false" rownumbers="true" gridModel="gridModel"
							multiselect="true" 
							rowList="10,15,20" rowNum="15" width="1024" editurl="%{editurl}"
							onSelectRowTopics="rowselect">
							<sjg:gridColumn name="id2" index="id2" title="รหัสสมาชิก"
								sortable="false" editable="false" />
							<sjg:gridColumn name="member" index="productName"
								title="ชื่อ สมาชิก" sortable="false" editable="true" />
							<sjg:gridColumn name="productName" index="productName"
								title="นามสกุล" sortable="false" editable="true" />
							<sjg:gridColumn name="productName" index="productDetail"
								title="ชื่อแสดงในสายงาน" sortable="false" editable="true" />
							<sjg:gridColumn name="productName" index="price"
								title="สาขาที่ลงทะเบียน" sortable="false" editable="true" />
							<sjg:gridColumn name="productName" index="unit"
								title="สาขาที่รับบัตร" sortable="false" editable="true" />

						</sjg:grid>
						<br />
							<sj:submit id="grid_edit_searchbutton199" value="ออกบัตร"
							onClickTopics="searchgrid" button="true" />
						
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
						<s:url id="remoteurl" action="jsonsmmsrole" />
						<s:url id="editurl" action="edit-grid-entry" />
						<sjg:grid id="gridedittable11" caption="ตั้งค่าสาขา"
							dataType="json" href="%{remoteurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="false" navigatorView="false"
							navigatorDelete="false" navigatorAdd="true" rownumbers="true"
							gridModel="gridModel" rowList="10,15,20" rowNum="15"
							 width="1024" editurl="%{editurl}"
							editinline="true" onSelectRowTopics="rowselect">
							<sjg:gridColumn name="bid" index="bid" title="รหัสสาขา"
								sortable="false" editable="false" />
							<sjg:gridColumn name="member" index="productName"
								title="ชือสาขา" sortable="false" editable="true" />
							<sjg:gridColumn name="productName" index="productName"
								title="เบอร์โทร" sortable="false" editable="true" />
							<sjg:gridColumn name="productDetail" index="productDetail"
								title="ที่อยู่" sortable="false" editable="true" />
								<sjg:gridColumn name="productDetail" index="productDetail"
								title="จังหวัด" sortable="false" editable="true" />
	<sjg:gridColumn name="bid" index="productDetail"
								title="รหัสไปรษณีย์" sortable="false" editable="true" />


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
					<sj:div id="div1"></sj:div>
					<sj:div id="div2">
						<s:url id="remoteurl" action="jsonsmmsrole" />
						<s:url id="editurl" action="edit-grid-entry" />
						<sjg:grid id="gridedittable" caption="USER(CRUD)" dataType="json"
							href="%{remoteurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
											
							navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
							navigatorEdit="false" navigatorView="false"
							navigatorDelete="false" navigatorAdd="true" rownumbers="true"
							
							gridModel="gridModel" rowList="10,15,20" rowNum="15"
							multiselect="true" width="1024" editurl="%{editurl}"
							editinline="true" onSelectRowTopics="rowselect">
							<sjg:gridColumn name="id2" index="id2" title="รหัสสมาชิก"
								sortable="false" editable="false" />
							<sjg:gridColumn name="member" index="productName"
								title="ชื่อ สมาชิก" sortable="false" editable="true" />
							<sjg:gridColumn name="a" index="productDetail" title="admin"
								edittype="checkbox" sortable="false" editable="true"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="b" index="price" title="staff" onselect="xxx" onChangeTopics="xxx"
								sortable="false" edittype="checkbox" editable="true"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="c" index="unit" title="member" 
								sortable="false" edittype="checkbox" editable="true"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="a" index="productDetail"
								title="อนุญาติใช้งานระบบ" edittype="checkbox" sortable="false"
								editable="true" formatter="checkbox" align="center" />


						</sjg:grid>
						<br />
						<sj:submit id="grid_edit_searchbutton" value="Search"
							onClickTopics="searchgrid" button="true" />
						<sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns"
							onClickTopics="showcolumns" button="true" />
						<sj:submit id="grid_multi_getselectedbutton"
							value="Reset Password" onClickTopics="getselectedids"
							button="true" />
						<br />
						<br />
					</sj:div>
				</sj:div></div>


			</sj:tabbedpanel></td>
		</tr>
	</table>
</sj:div>
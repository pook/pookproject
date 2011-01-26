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
		url : "edit-card-admin",
		data : "rows="+s,
		success: function(dat) {			
		}		
	});
	$("#gridmultitable").trigger('reloadGrid'); 
});
$.subscribe('getselectedids3', function(event,data) {
	var s;
	s = $("#gridedittable2").jqGrid('getGridParam','selarrrow',{reloadAfterSubmit:true});
	$.ajax({
		type : "get",
		url : "resetpasswd-admin",
		data : "rows="+s,
		success: function(dat) {			
		}		
	});	
	$("#gridedittable2").trigger('reloadGrid'); 
});

</script>
<style>
#div4 {
	font-size: -2;
	margin: 40px 50px 30px 35px;
}
</style>
<div id="div4">	
			<sj:tabbedpanel id="localtabs" selectedTab="0">
				<sj:tab id="tab2" target="ttwo" label="จัดการการออกบัตร"
					tabindex="0" />
					<sj:tab id="tab1" target="tone" label="กำหนดสิทธิ์" tabindex="1" />
				<sj:tab id="tab3" target="ttree" label="ตั้งค่าสาขา" tabindex="2" />
				<sj:tab id="tab4" target="tfour" label=" ตั้งค่า Staff " tabindex="3" />
				<div id="ttwo"><sj:div id="div01">
					<sj:div id="div11"></sj:div>
					<sj:div id="div21">
						<s:url id="cardremoteurl" action="json-card-admin" />
						<s:url id="cardediturl" action="edit-card-admin"/>
						<sjg:grid id="gridmultitable" caption="จัดการการออกบัตร"
							dataType="json" href="%{cardremoteurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq']}"							
							navigatorSearch="false"
							navigatorEdit="false" navigatorView="false" navigatorAdd="false"
							navigatorDelete="false" rownumbers="true" gridModel="gridModel"
							multiselect="true" 
							rowList="15,30" rowNum="15" width="925" editurl="%{cardediturl}"
							onSelectRowTopics="rowselect">							
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก" width="120"
								sortable="false"  editable="false"/>
							<sjg:gridColumn name="name" 
								title="ชื่อ สมาชิก" sortable="false"/>
							<sjg:gridColumn name="surename" 
								title="นามสกุล" sortable="false"/>
							<sjg:gridColumn name="displayName" 
								title="ชื่อแสดงในสายงาน" sortable="false"/>
								<sjg:gridColumn name="date"  title="วันที่สมัคร" width="100"
								editable="false" search="false" formatter="date" 
								 align="center" />
							<sjg:gridColumn name="brance" index="brance"
								title="สาขาที่ลงทะเบียน" sortable="false"/>
							<sjg:gridColumn name="branceCard" index="branceCard"
								title="สาขาที่รับบัตร" sortable="false"/>
						</sjg:grid>
						<br />
							<sj:submit  value="ออกบัตร"
							id="grid_multi_getselectedbutton"  onClickTopics="getselectedids2" button="true"/>											
						<br />
						<br />
					</sj:div>
				</sj:div></div>
				<div id="ttree"><sj:div id="div011">
					<sj:div id="div111"></sj:div>					
					<sj:div id="div211">
						<s:url id="selectprovinceurl" action="fetch-province-member" />
						<s:url id="branceurl" action="json-brance-admin" />
						<s:url id="editbranceurl" action="edit-grid-brance-admin" />						
						<sjg:grid id="gridedittable11" caption="ตั้งค่าสาขา"
							dataType="json" href="%{branceurl}" pager="true" navigator="true" 
							navigatorSearchOptions="{sopt:['eq']}" 
							navigatorSearch="false"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="true" navigatorView="false"
							navigatorDelete="false" navigatorAdd="true" rownumbers="true"
							gridModel="gridModel" rowList="15,30" rowNum="15"
							 width="925" editurl="%{editbranceurl}"
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
						<br />			
						<br />
					</sj:div>
				</sj:div></div>
				<div id="tone"><sj:div id="div0">					
					<div id="div2">
						<s:url id="roleurl" action="json-role-admin" />
						<s:url id="editroleurl" action="edit-role1-admin" />
						<sjg:grid id="gridedittable2" caption="กำหนดสิทธิ์" dataType="json"
							href="%{roleurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq'],reloadAfterSubmit:true}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:true,closeAfterEdit:true}"						
							navigatorEdit="true" navigatorView="false"
							navigatorSearch="true"
							navigatorDelete="false" navigatorAdd="false" rownumbers="15"							
							gridModel="gridModel" rowList="15,30" rowNum="15" 
							width="925" editurl="%{editroleurl}" multiselect="true" 
							onSelectRowTopics="rowselect">
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก" editoptions= "{ readonly: true,disabled:'disabled'}"
								sortable="false" editable="true" width="100"/>
							<sjg:gridColumn name="name" editrules="{ minlength:5,required:true}"
								title="ชื่อ สมาชิก" sortable="false" editable="true" />
							<sjg:gridColumn name="surename"  editrules="{ edithidden:true,minlength:5,required:true}" hidden="true"
								title="นามสกุล" sortable="false" editable="true" />
							<sjg:gridColumn name="address"  editrules="{ edithidden:true,minlength:5,required:true}" hidden="true"
								title="ที่อยู่" sortable="false" editable="true" edittype="textarea"/>
							<sjg:gridColumn name="bankAccount"  editrules="{ edithidden:true,integer:true,minlength:5,required:true}" hidden="true"
								title="บัญชีธนาคาร " sortable="false" editable="true" />
							<sjg:gridColumn name="bankBrance"  editrules="{ edithidden:true,minlength:5,required:true}" hidden="true"
								title="สาขาบัญชี " sortable="false" editable="true" />							
							<sjg:gridColumn name="tel"  title="เบอร์โทร" width="80"
								editable="false" search="false"
								 align="center" />
							<sjg:gridColumn name="date"  title="วันที่สมัคร" width="100"
								editable="false" search="false" formatter="date" 
								 align="center" />
							<sjg:gridColumn name="admin" index="admin" title="admin" width="80" editoptions ="{value:'Yes:No'}" 
								edittype="checkbox" sortable="false" editable="true" search="false"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="staff" index="staff" title="staff"  search="false" editoptions ="{value:'Yes:No'}" 
								sortable="false" edittype="checkbox" editable="true" width="80"
								formatter="checkbox" align="center" />
							<sjg:gridColumn name="member" index="member" title="member"  search="false" editoptions ="{value:'Yes:No'}" 
								sortable="false" edittype="checkbox" editable="true" width="80"
								formatter="checkbox" align="center" />							
						</sjg:grid>
						<br />						
						<sj:submit id="grid_multi_getselectedbuttonxxs13"
							value="Reset Password" onClickTopics="getselectedids3" 
							button="true" />
						<br/>
						<br/>
					</div>
				</sj:div></div>
				<div id="tfour"><sj:div id="div8">					
					<sj:div id="div44">
						<s:url id="staffurl" action="json-stff-admin" />
						<s:url id="selectbranceeurl" action="fetch-brance-member" />
						<s:url id="editstaffurl" action="edit-stff-admin" />
						<sjg:grid id="gridedittable4" caption="staff" dataType="json"
							href="%{staffurl}" pager="true" navigator="true"
							navigatorSearchOptions="{sopt:['eq'],reloadAfterSubmit:true}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false,closeAfterEdit:true}"											
							navigatorEdit="true" navigatorView="false"
							navigatorSearch="false"
							navigatorDelete="false" navigatorAdd="false" rownumbers="15"							
							gridModel="gridModel" rowList="15,30" rowNum="15"
							width="925" editurl="%{editstaffurl}"  
							>
							<sjg:gridColumn name="smileId" index="smileId" title="รหัสสมาชิก" editoptions= "{ readonly: true,disabled:'disabled'}"
								sortable="false" editable="true" width="100"/>
							<sjg:gridColumn name="name" index="name"
								title="ชื่อ สมาชิก" sortable="false" editable="false" />
							
							<sjg:gridColumn name="date"  title="วันที่สมัคร" width="100"
								editable="false" search="false" formatter="date" 
								 align="center" />							
							<sjg:gridColumn name="brance" index="brance" width="120" search="false"
								title="สาขา" edittype="select" editable="true"  
								editoptions="{ dataUrl : '%{selectbranceeurl}' }" align="center" />
						</sjg:grid>
						<br />					
						<br/>
					</sj:div>
				</sj:div></div>
			</sj:tabbedpanel>		
</div>
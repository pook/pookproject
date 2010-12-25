<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>	
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
div#div4 div {
	clear: both;
}
</style>
<%	Logger log = Logger.getLogger("BlackOffice");
	SmileUser u =null;
	String brance = "";
	try{
		u = (SmileUser) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
		brance = u.getBrance();		
	}catch (ClassCastException e){
		log.error("Unknow login");
	}
%>
<s:url id="ajax" value="order-purchese" />
<s:url id="prochesedetail" action="showordered" />
<sj:div id="div4">

	<table
		style="align: center; width: 924px; margin-left: 60px; border: px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<s:div id="gridinfo"></s:div>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-ordering" />
					<s:url id="remote2url" action="json-grid-purchese" />
					<s:url id="selectskuurl" action="json-customer-loadskuss" />
					<s:url id="editpurcheseurl" action="edit-grid-purchese" />
					<s:url id="editorderurl" action="edit-grid-order" />
					<sjg:grid id="gridedittable" caption="สาขาพระราม 3"  dataType="json"
						href="%{remoteurl}" pager="true" navigator="true"
						navigatorSearch="false"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
						navigatorEdit="true" navigatorView="false" navigatorDelete="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924"
						editurl="%{editorderurl}" editinline="true"
						onSelectRowTopics="rowselect">						
						<sjg:gridColumn name="orderId" index="orderId"
							title="sale order ID" formatter="integer" sortable="true" />
						<sjg:gridColumn name="user.userId" title="รหัสสมาชิก"
							editable="true" editrules="{required:true}" />
						<sjg:gridColumn name="user.name" title="ชื่อสมาชิก" />
						<sjg:gridColumn name="totalQuantity" title="จำนวน"
							formatter="integer" search="false" />
						<sjg:gridColumn name="date" title="วันที่" formatter="date" formatoptions="{newformat : 'd/m/Y', srcformat : 'Y-m-d-H:i:s'}" align="center" search="false"/>
						<sjg:gridColumn name="totalPrice" title="ราคารวม"
							formatter="currency" search="false"/>
						<sjg:gridColumn name="totalSv" index="totalPV" search="false"
							title="Total Smile Value" formatter="integer" width="235" />
							
							<sjg:grid id="subgridtable" subGridUrl="%{remote2url}"
							gridModel="gridModel" rowNum="-1" navigator="true"
							rownumbers="true" width="650" editurl="%{editpurcheseurl}"
							userDataOnFooter="true" navigatorAdd="true"  page="false" pager="false"
							>
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="300"
								index="sku.sid" />
							<sjg:gridColumn name="sku.name" title="ชื่อผสิตภัณฑ์"
								edittype="select" editable="true"
								editoptions="{ dataUrl : '%{selectskuurl}' }" />
							<sjg:gridColumn name="sku.description"
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
					</sjg:grid>
					
					<br />
					<sj:submit id="grid_edit_addbutton" value="Add New"
						onClickTopics="rowadd" button="true" />
					<sj:submit id="grid_edit_searchbutton" value="Search"
						onClickTopics="searchgrid" button="true" />
					<sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns"
						onClickTopics="showcolumns" button="true" />
					<sj:a id="ajaxlink" href="%{ajax}" indicator="indicator" 
						targets="div4" button="true" buttonIcon="ui-icon-gear">
	สั่งสินค้า
	</sj:a>
					<sj:a id="ajaxlink2" href="%{prochesedetail}" indicator="indicator"
						targets="div4" button="true" buttonIcon="ui-icon-gear">
	ดูประวัติการสั่งชื้อ
	</sj:a>

					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
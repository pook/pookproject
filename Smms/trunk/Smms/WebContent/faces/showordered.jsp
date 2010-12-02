<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />

<style type="text/css">
div#gridinfo div {
	clear:both;
	
}
</style>
<s:url id="ajax" value="blackoffice" />
<sj:div id="div4">
	<table
		style="align: center; width:820px; margin-left: 100px; border: px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<s:div id="gridinfo"></s:div>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-list-order" />	<!-- ShowOrdered -->
					<s:url id="editurl" action="edit-order-grid" />
					<s:url id="subgridurl" action="json-list-purchese2" />													
					<sjg:grid id="gridedittable" caption="พระราม 3 " dataType="json"
						href="%{remoteurl}" pager="true" 
						navigator="true"
						navigatorDelete="true"
						navigatorAdd="false"	
						navigatorEdit="false"								
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="15,30" rowNum="15" width="820" 						
						onSelectRowTopics="rowselect" >
						<sjg:grid id="subgridtable"  subGridUrl="%{subgridurl}" 
							dataType="json" gridModel="gridModel" footerrow="true" rownumbers="1" rowNum="0"				
							 width="750">
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="300" />
							<sjg:gridColumn name="sku.name"   title="ชื่อผสิตภัณฑ์" width="300" edittype="select" 
						   editoptions ="{ dataUrl : '%{selectskuurl}' }"   />							
							<sjg:gridColumn name="sku.description" 
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" width="330" />
							<sjg:gridColumn name="quantity" title="จำนวน" 
								formatter="integer" />
							<sjg:gridColumn name="purchesePrice" title="ราคา"
								formatter="currency" align="right" />
							<sjg:gridColumn name="psv" title="smile value" align="center"
								formatter="integer" />
						</sjg:grid>
						<sjg:gridColumn name="orderId" index="orderId"
							title="sale order ID" formatter="integer" sortable="true" />
						<sjg:gridColumn name="user.userId" title="รหัสสมาชิก"
							editable="true" editrules="{required:true}" />
						<sjg:gridColumn name="user.name" title="ชื่อสมาชิก" />
						<sjg:gridColumn name="totalQuantity" title="จำนวน"
							formatter="integer" />
						<sjg:gridColumn name="totalPrice" title="ราคารวม"
							formatter="currency" />
						<sjg:gridColumn name="totalSv" index="totalPV"
							title="Total Smile Value" formatter="integer" width="235" />
					</sjg:grid>
					<br />				
					
					<sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns"
						onClickTopics="showcolumns" button="true" />					
					<sj:a id="ajaxlink" href="%{ajax}" indicator="indicator"
						targets="div4" button="true" buttonIcon="ui-icon-gear">
	กลับไปหน้าชื้อสินค้า
	</sj:a>

					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
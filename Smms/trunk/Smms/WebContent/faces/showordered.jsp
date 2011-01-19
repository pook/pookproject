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
					<s:url id="remoteurl" action="json-list-order-staff" />	<!-- ShowOrdered -->
					<s:url id="editurl" action="edit-order-grid-staff" />
					<s:url id="subgridurl" action="json-list-purchese2-staff" />													
					<sjg:grid id="gridedittable" caption="-" dataType="json"
						href="%{remoteurl}" pager="true" 
						navigator="true" editurl="%{editurl}"
						navigatorDelete="true"
						navigatorAdd="false"	
						navigatorEdit="false"	
						navigatorSearchOptions="{sopt:['eq']}"													
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="15,30" rowNum="15" width="820" 						
						 >
						<sjg:grid id="subgridtable"  subGridUrl="%{subgridurl}" 
							dataType="json" gridModel="gridModel" footerrow="true" rownumbers="1" rowNum="0"				
							 width="750">
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="300" />
							<sjg:gridColumn name="sku.name"   title="ชื่อผสิตภัณฑ์" width="300" edittype="select" 
						   editoptions ="{ dataUrl : '%{selectskuurl}' }"  search="false" />							
							<sjg:gridColumn name="sku.description" 
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" width="330" />
							<sjg:gridColumn name="quantity" title="จำนวน" align="right"
								formatter="integer" />
							<sjg:gridColumn name="purchesePrice" title="ราคา" formatoptions="{decimalSeparator:'.',thousandsSeparator: ',', decimalPlaces: 2}"
								formatter="currency" align="right" />
							<sjg:gridColumn name="psv" title="smile value" align="center" formatoptions="{thousandsSeparator: ','}"
								formatter="integer" align="right" />
						</sjg:grid>
						<sjg:gridColumn name="date" index="date" align="center" width="100"
							title="วันที่" formatter="date" sortable="true" />
						<sjg:gridColumn name="orderId" index="orderId"
							title="sale order ID" formatter="integer" sortable="true" />
						<sjg:gridColumn name="user.userId" title="รหัสสมาชิก"
							editable="true" editrules="{required:true}"  />
						<sjg:gridColumn name="user.detail.name" title="ชื่อสมาชิก" />
						<sjg:gridColumn name="totalQuantity" title="จำนวน" align="right"
							formatter="integer" search="false"/>
						<sjg:gridColumn name="totalPrice" title="ราคารวม" sortable="false" formatoptions="{decimalSeparator:'.',thousandsSeparator: ',', decimalPlaces: 2}"
							formatter="currency" search="false" align="right" />
						<sjg:gridColumn name="totalSv" index="totalPV" formatoptions="{thousandsSeparator: ','}"
							title="Total Smile Value" formatter="integer" width="150" search="false" align="right"/>
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
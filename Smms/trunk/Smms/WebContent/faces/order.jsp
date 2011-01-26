
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%><%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:property value="echo" escape="%{escape}" />
<style type="text/css">
div#div4 div{
	clear: both;
	
}
</style>
<sj:div id="div4">
	<table
		style="align: center; width:880px; margin-left: 70px; border: px solid #000000; margin-top:50px"
		cellspacing="10px">
		<tr>
			<s:div id="gridinfo"></s:div>
			<td><sj:div id="div0">				
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-list-order1-member" />	<!-- ShowOrdered -->
					<s:url id="subgridurl" action="json-list-purchese1-member" />																		
					<sjg:grid id="gridedittable" caption="รายการสั่งชื้อ" dataType="json"
						href="%{remoteurl}" pager="true" 
						navigator="true"
						navigatorSearch="false"
						navigatorDelete="false"
						navigatorAdd="false"	
						navigatorEdit="false"
						gridModel="gridModel" rowList="15,30" rowNum="15" width="880"						
						 rownumbers="false">
						<sjg:grid id="subgridtable1"  subGridUrl="%{subgridurl}"  caption="+"
							dataType="json" gridModel="gridModel" rowNum="0"footerrow="true"					
							rownumbers="1" width="750">
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
							title="sale order ID" formatter="integer" sortable="true" width="120" align="right" />
						<sjg:gridColumn name="user.node1.smileId" title="รหัสสมาชิก"
							editable="true" editrules="{required:true}" />
						<sjg:gridColumn name="user.detail.name" title="ชื่อสมาชิก" />						
						<sjg:gridColumn name="totalQuantity" title="จำนวน" formatoptions="{thousandsSeparator: ','}" align="right"
							formatter="integer" />
						<sjg:gridColumn name="totalPrice" title="ราคารวม" formatoptions="{decimalSeparator:'.',thousandsSeparator: ',', decimalPlaces: 2}"
							formatter="currency" align="right" />
						<sjg:gridColumn name="totalSv" index="totalPV" formatoptions="{thousandsSeparator: ','}"
							title="Total Smile Value" formatter="integer" width="235" align="right" />
					</sjg:grid>									
					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
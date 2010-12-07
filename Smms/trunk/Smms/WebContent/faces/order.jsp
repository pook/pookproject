
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
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-list-order1" />	<!-- ShowOrdered -->
					<s:url id="subgridurl" action="json-list-purchese1" />																		
					<sjg:grid id="gridedittable" caption="พระราม 3 " dataType="json"
						href="%{remoteurl}" pager="true" 
						navigator="true"
						navigatorDelete="true"
						navigatorAdd="false"	
						navigatorEdit="false"								
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="15,30" rowNum="15" width="880"						
						onSelectRowTopics="rowselect" rownumbers="false">
						<sjg:grid id="subgridtable"  subGridUrl="%{subgridurl}"  
							dataType="json" gridModel="gridModel" rowNum="0"footerrow="true"					
							rownumbers="true" width="750">
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
							title="sale order ID" formatter="integer" sortable="true" width="120" align="center" />
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
				
					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
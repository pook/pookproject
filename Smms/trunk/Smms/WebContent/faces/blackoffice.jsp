<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
</style>
<script type="text/javascript">
	$.subscribe('rowselect', function(event, data) {
		$("#gridinfo").html(
				'<p>Edit Mode for Row : ' + event.originalEvent.id + '</p>');
	});
	$.subscribe('rowadd', function(event, data) {
		$("#gridedittable").jqGrid('editGridRow', "new", {
			height : 280,
			reloadAfterSubmit : false
		});

	});
	$.subscribe('searchgrid', function(event, data) {
		$("#gridedittable").jqGrid('searchGrid', {
			sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
		});
	});
	$.subscribe('showcolumns', function(event, data) {
		$("#gridedittable").jqGrid('setColumns', {});
	});

	$.subscribe('getselectedids', function(event, data) {
		var s;
		s = $("#gridmultitable").jqGrid('getGridParam', 'selarrrow');
		alert('Selected Rows : ' + s);
	});
	$.subscribe('refreshdiv', function(event, data) {
		$.publish('reloaddiv1');
	});
	function selectsku(elem){
		 $(elem).empty()
         .append("<option value='1'>Apples</option>")
         .append("<option value='2'>Oranges</option>");
	}
</script>
<s:url id="ajax" value="order-purchese" />
<sj:div id="div4">

	<table
		style="align: center; width:820px; margin-left: 100px; border: px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<s:div id="gridinfo"></s:div>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-ordering" />
					<s:url id="remote2url" action="json-grid-purchese" />					
					<s:url id="selectskuurl" action="customer-loadskuss" />
					<s:url id="editpurcheseurl" action="edit-grid-purchese" />
					<s:url id="editorderurl" action="edit-grid-order" />
					<sjg:grid id="gridedittable" caption="พระราม 3 " dataType="json"
						href="%{remoteurl}" pager="true" navigator="true"
						navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
						navigatorEdit="false" navigatorView="false" navigatorDelete="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="820"
						editurl="%{editorderurl}" editinline="true" 
						onSelectRowTopics="rowselect" rownumbers="false">
						<sjg:grid id="subgridtable" subGridUrl="%{remote2url}"
							dataType="json" gridModel="gridModel" rowNum="-1"
							navigator="true" editurl="%{editpurcheseurl}" navigator="true"
							rownumbers="true" width="750"
							navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="true" navigatorView="false" navigatorDelete="true"
							navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}">
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="300" 
							editable="true" />
							<sjg:gridColumn name="sku.name" title="ชื่อผสิตภัณฑ์" width="300" edittype="select" 
						  editable="true" editoptions ="{ dataUrl : '%{selectskuurl}' }"   />
							<sjg:gridColumn name="sku.description" 
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" width="330" />
							<sjg:gridColumn name="quantity" title="จำนวน" editable="true"
								formatter="integer" />
							<sjg:gridColumn name="purchesePrice" title="ราคา"
								formatter="currency" align="right" />
							<sjg:gridColumn name="psv" title="smile value" align="center"
								formatter="integer" />
						</sjg:grid>
						<sjg:gridColumn name="orderId" index="orderId"
							title="sale order ID" formatter="integer" sortable="true" />
						<sjg:gridColumn name="user.userId" title="รหัสสมาชิก"
							editable="true" />
						<sjg:gridColumn name="user.name" title="ชื่อสมาชิก" />
						<sjg:gridColumn name="totalQuantity" title="จำนวน"
							formatter="integer" />
						<sjg:gridColumn name="totalPrice" title="ราคารวม"
							formatter="currency" />
						<sjg:gridColumn name="totalSv" index="totalPV"
							title="Total Smile Value" formatter="integer" width="235" />
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
	ชื้อสินค้า
	</sj:a>

					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
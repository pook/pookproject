<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
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
	$.subscribe('test', function(event, data) {
		alert('you success');
	});
</script>
<s:property value="echo" escape="%{escape}" />
<sj:div id="div4">
	<table
		style="align: center; width: 540px; margin-left: 100px; border: 1px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-ordering" />
					<s:url id="orderdetailsurl" action="json-loadskus" />
					<s:url id="editpurcheseurl" action="edit-grid-purchese" />
					<s:url id="editorderurl" action="edit-grid-order" />
					<sjg:grid id="gridedittable" caption="พระราม 3 " dataType="json"
						href="%{remoteurl}" pager="true" navigator="true"
						navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
						navigatorEdit="false" navigatorView="false" navigatorDelete="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:false}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="1024"
						editurl="%{editorderurl}" editinline="true"
						onSelectRowTopics="rowselect" rownumbers="true">

						<sjg:grid id="orderssubgridtable" subGridUrl="%{remoteurl}"
							gridModel="gridModel" rowNum="-1" navigator="true"
							editurl="%{editpurcheseurl}" navigator="true" rownumbers="true"
							width="750" pager="false" page="false" footerrow="false"
							navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
							navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
							navigatorEdit="true" navigatorView="false" navigatorDelete="true"
							navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}">
							<sjg:gridColumn name="purchese.pId" title="รหัสการชื้อ" width="300" 
								editable="true" />
							<sjg:gridColumn name="purchese.sku.sid" title="รหัสผสิตภัณฑ์" width="300" 
								editable="true" />
							<sjg:gridColumn name="purchese.sku.name" title="ชื่อผสิตภัณฑ์" width="300"
								editable="false" />
							<sjg:gridColumn name="purchese.sku.description" 
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" editable="true"
								width="330" />
							<sjg:gridColumn name="purchese.quantity" title="จำนวน" formatter="integer"
								align="center" editable="true" />
							<sjg:gridColumn name="purchese.purchesePrice" title="ราคา"
								formatter="currency" align="right" editable="true" />
						</sjg:grid>

						<sjg:gridColumn name="orderId" index="orderId"
							title="sale order ID" formatter="integer" sortable="true" />
						<sjg:gridColumn name="user.userId" title="รหัสสมาชิก"
							sortable="false" editable="true" />
						<sjg:gridColumn name="user.name" title="ชื่อสมาชิก"
							sortable="false" editable="true" editable="true" />
						<sjg:gridColumn name="price" index="price" title="ราคา"
							sortable="false" editable="true" />
						<sjg:gridColumn name="unit" index="unit" title="จำนวน"
							sortable="false" editable="true" />
						<sjg:gridColumn name="commision" index="ราคารวม" title="ราคารวม"
							sortable="false" editable="true" />
						<sjg:gridColumn name="totalPV" index="totalPV"
							title="Total Smile Value" formatter="integer" sortable="false"
							editable="true" width="235" />

					</sjg:grid>
					<br />
					<sj:submit id="grid_edit_addbutton" value="Add New"
						onClickTopics="rowadd" button="true" />
					<sj:submit id="grid_edit_searchbutton" value="Search"
						onClickTopics="searchgrid" button="true" />
					<sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns"
						onClickTopics="showcolumns" button="true" />
					<br />
					<br />
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
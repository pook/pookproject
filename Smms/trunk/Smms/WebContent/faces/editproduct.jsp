<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
div#div4 div {
	clear:both;
	width:400px;
}
</style>
<sj:div id="div4">
	<table id = "table"
		style="align: center; width:400px; margin-left: 100px; border: 1px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="jsoneditproduct" />
					<s:url id="orderdetailsurl" action="jsonloadskus" />
					<s:url id="editurl" action="add-sku-grid" />
					<sjg:grid id="gridedittable1" caption="พระราม 4 " dataType="json"
						href="%{remoteurl}" pager="true" navigator="true" width="100"
						navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:true}"
						navigatorDelete="true" navigatorEdit="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15"  
						editurl="%{editurl}" editinline="true" onSelectRowTopics="rowselect"
						rownumbers="true" >

						<sjg:gridColumn name="sid" index="sid" title="รหัส ผลิตภัณฑ์"
							sortable="true" editable="true" />
						<sjg:gridColumn name="name" index="name" title="ชื่อ ผลิตภัณฑ์" 
							editable="true" width="200"/>
						<sjg:gridColumn name="priceDiscount" title="รายละเอียด ผลิตภัณฑ์" formatter="currency"
							editable="true" width="300" />
						<sjg:gridColumn name="price" title="ราคากลางต่อหน่วย" formatter="currency"
							editable="true" width="180" />
						<sjg:gridColumn name="memberPrice" title="ราคาสมาชิกต่อหน่วย" formatter="currency"
							editable="true" width="180" />
						<sjg:gridColumn name="discount" title="ส่วนลดพิเศษ%" formatter="integer"
							editable="true" />
						<sjg:gridColumn name="priceDiscount" formatter="currency"
							title="ราคาต่อหน่วยหลังหักส่วนลด" width="250" />
						<sjg:gridColumn name="sv" index="sv" title="Smile Value"
							formatter="integer" sortable="false" editable="true" width="200" />

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
div#div4 div {
	clear:both;
}
</style>
<sj:div id="div4">
	<table id = "table"
		style="align: center; width:930px; margin-left: 70px; border: 1px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="jsoneditproduct" /><!-- EditProduct -->					
					<s:url id="editurl" action="add-sku-grid" /><!-- AddSkuAct    (insert,update,del) -->
					<sjg:grid id="gridedittable" caption="พระราม 4 " dataType="json"
						href="%{remoteurl}" pager="true" navigator="true" width="930"
						navigatorEdit="true"  
						navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:true}"
						navigatorDelete="true" 						
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true,msg:'ต้องการลบเรคคอร์ดนี้ ?'}"
						gridModel="gridModel" rowList="5,10,30" rowNum="5"  
						editurl="%{editurl}" editinline="false" onSelectRowTopics="rowselect"
						 >
						<sjg:gridColumn name="sid" index="sid" title="รหัส ผลิตภัณฑ์"
							sortable="true" />
						<sjg:gridColumn name="name" index="name" title="ชื่อ ผลิตภัณฑ์" editrules="{required:true}"
							editable="true" width="200"/>
						<sjg:gridColumn name="description" title="รายละเอียด ผลิตภัณฑ์"  editrules="{required:true}"
							editable="true" width="250" search="false"/>
						<sjg:gridColumn name="price" title="ราคากลางต่อหน่วย" formatter="currency" required="true" editrules="{number:true,required:true}"
							editable="true" width="180" search="false"/>
						<sjg:gridColumn name="memberPrice" title="ราคาสมาชิกต่อหน่วย" formatter="currency" editrules="{number:true,required:true}"
							editable="true" width="180" search="false" />
						<sjg:gridColumn name="discount" title="ส่วนลดพิเศษ%" formatter="integer" editrules="{integer:true}"
							editable="true"  search="false"/>
						<sjg:gridColumn name="priceDiscount" formatter="currency" editrules="{number:true,required:true}"
							title="ราคาต่อหน่วยหลังหักส่วนลด" width="250" search="false"/>
						<sjg:gridColumn name="sv" index="sv" title="Smile Value" editrules="{integer:true,required:true}"
							formatter="integer" sortable="false" editable="true" width="160" search="false"/>
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
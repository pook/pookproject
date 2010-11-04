<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />	
	<script type="text/javascript" src="/Smms/struts/utils.js"></script>
<sj:div id="div4" >
<table
		style="align: center; width: 540px; margin-left: 100px; border: 1px solid #000000;margin-top: 50px"
		cellspacing="10px">
<tr><td>
<sj:div id="div0" jquerytheme="dark-hive" >
<sj:div id="div1"></sj:div>
<sj:div id="div2">
<s:url id="remoteurl" action="jsoneditproduct"/> 
    <s:url id="editurl" action="edit-grid-entry"/> 
    <sjg:grid 
      	id="gridedittable" 
    	caption="พระราม 3 " 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	navigator="true"
    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
    	navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
    	navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEdit="false"
    	navigatorView="false"
    	navigatorDelete="true"
    	navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	width="1024"
    	editurl="%{editurl}"
    	editinline="true"
    	onSelectRowTopics="rowselect"
    	rownumbers="true"
    	
    >   
    	<sjg:gridColumn name="productCode" index="productCode" title="รหัส ผลิตภัณฑ์" sortable="false" editable="true" />
    	<sjg:gridColumn name="productName" index="productName" title="ชื่อ ผลิตภัณฑ์" sortable="false" editable="true" />
    	<sjg:gridColumn name="productDetail" index="productDetail" title="รายละเอียด ผลิตภัณฑ์" sortable="false" editable="true" width="300"/>
    	<sjg:gridColumn name="price" index="price" title="ราคากลางต่อหน่วย" sortable="false" editable="true" width="180"/>
    	<sjg:gridColumn name="price" index="price" title="ราคาสมาชิกต่อหน่วย" sortable="false" editable="true" width="180"/>
        	<sjg:gridColumn name="discount" index="ราคารวม" title="ส่วนลดพิเศษ%" sortable="false" editable="true"/>
    	<sjg:gridColumn name="commision" index="com" title="ราคาต่อหน่วยหลังหักส่วนลด" sortable="false" editable="true" width="250"/>    	
    	<sjg:gridColumn name="totalPV" index="totalPV" title="Smile Value" formatter="integer" sortable="false"editable="true" width="200"/>

    </sjg:grid>
	<br/>
    <sj:submit id="grid_edit_addbutton" value="Add New" onClickTopics="rowadd" button="true"/>
    <sj:submit id="grid_edit_searchbutton" value="Search" onClickTopics="searchgrid" button="true"/>
    <sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns" onClickTopics="showcolumns" button="true"/>
	<br/>
	<br/>
 </sj:div>
    </sj:div>
    </td>
    </tr>
    </table>
</sj:div>
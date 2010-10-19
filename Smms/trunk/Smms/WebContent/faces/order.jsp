<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link rel="stylesheet"	href="/Smms/struts/themes/dark-hive/jquery-ui.css" type="text/css" />
<s:property value="echo" escape="%{escape}" />
<s:div id="div1">
<s:url id="remoteurl" action="jsonorder"/> 
    <sjg:grid 
    	id="gridtable" 
    	caption="Customer Examples" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	rownumbers="true"
    	width="700"
    >
    	<sjg:gridColumn name="id" index="id" title="ID" formatter="integer" sortable="false"/>
    	<sjg:gridColumn name="date" index="date"  title="วันที่" sortable="false" width="270" />
    	<sjg:gridColumn name="productCode" index="productCode" title="รหัส ผลิตภัณฑ์" sortable="false"/>
    	<sjg:gridColumn name="productName" index="productName" title="ชื่อ ผลิตภัณฑ์" sortable="false"/>
    	<sjg:gridColumn name="productDetail" index="productDetail" title="รายละเอียด ผลิตภัณฑ์" sortable="false"/>
    	<sjg:gridColumn name="price" index="price" title="ราคา" sortable="false"/>
    	<sjg:gridColumn name="unit" index="unit" title="จำนวน" sortable="false" />
    	<sjg:gridColumn name="totalPV" index="totalPV" title="Point Value" formatter="integer" sortable="false"/>
    </sjg:grid>
</s:div>
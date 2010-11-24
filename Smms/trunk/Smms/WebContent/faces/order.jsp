
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:property value="echo" escape="%{escape}" />
<sj:div id="div4">
	<table
		style="align: center; width: 540px; margin-left: 100px; border: 1px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>
			<td><sj:div id="div0">
				<sj:div id="div1"></sj:div>
				<sj:div id="div2">
					<s:url id="remoteurl" action="jsonorder" />
					<sjg:grid id="gridtable" caption="รายการสินค้าที่ สั่งชื้อ"
						dataType="json" href="%{remoteurl}" pager="true"
						gridModel="gridModel" rowList="10,15,20" rowNum="15"
						rownumbers="true" width="990">
						<sjg:gridColumn name="id" index="id" title="sale order ID"
							formatter="integer" sortable="false" width="200" />
						<sjg:gridColumn name="id2" index="id2" title="รหัสสมาชิก"
							sortable="false" width="200" />
						<sjg:gridColumn name="date" index="date" title="วันที่"
							sortable="false" width="280" />
						<sjg:gridColumn name="bid" index="productCode" title="สาขา"
							sortable="false" width="200" />
						<sjg:gridColumn name="productCode" index="productCode"
							title="รหัส ผลิตภัณฑ์" sortable="false" width="200" />
						<sjg:gridColumn name="productName" index="productName"
							title="ชื่อ ผลิตภัณฑ์" sortable="false" width="200" />
						<sjg:gridColumn name="productDetail" index="productDetail"
							title="รายละเอียด ผลิตภัณฑ์" sortable="false" width="320" />
						<sjg:gridColumn name="price" index="price" title="ราคา"
							sortable="false" />
						<sjg:gridColumn name="unit" index="unit" title="จำนวน"
							sortable="false" />
						<sjg:gridColumn name="commision" index="commision" title="ราคารวม"
							sortable="false" />
						<sjg:gridColumn name="totalPV" index="totalPV" title="Total SV"
							formatter="integer" sortable="false" width="200" />
					</sjg:grid>
				</sj:div>
			</sj:div></td>
		</tr>
	</table>
</sj:div>
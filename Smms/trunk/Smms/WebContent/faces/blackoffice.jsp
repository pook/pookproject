<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="biz.evolix.secure.SmileUser"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/backoffice.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/backoffice.js"></script>
<%	Logger log = Logger.getLogger("BlackOffice");
	SmileUser u =null;
	String brance = "";
	try{
		u = (SmileUser) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
		brance = u.getBrance();		
	}catch (ClassCastException e){
		log.error("Unknow login");
	}
%>
<sj:div id="div4">
	<s:url id="addorder" value="edit-grid-order-staff" />
	<s:url id="buyurl" value="order-purchese-staff" />
	<s:url id="prochesedetail" action="showordered" />
	<s:url id="ajax1" value="showorderd2" />
	<s:url id="ajax" value="blackoffice" />
	<div id="main5">
	<div id="member-contain">
	<table id="users" class="ui-widget ui-widget-content">
		<thead class="ui-widget-header">
			<tr class="ui-widget ui-widget-header">
				<th colspan="6" class="th2" align="left"><%=brance%></th>
			</tr>
		</thead>
		<tfoot>
			<tr class="ui-widget-footer">
				<td colspan="6" height="20"></td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td colspan="6">
				<div class="ui-widget">
				<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;">
				</div>
				</div>
				</td>
			</tr>
			<tr>
				<td><label for="orderId">Sale Order ID :</label></td>
				<td><input id="orderId" type="text"
					class="text ui-widget-content ui-corner-all" style="color: #30f"
					readonly="readonly" disabled="disabled" /></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td><label for="smileId"></label>รหัสสมาชิก :</td>
				<td><input id="smileId" type="text" value=""
					class="text ui-widget-content ui-corner-all" disabled="disabled" />

				</td>
				<td><label for="name"></label>ชื่อสมาชิก :</td>
				<td><input id="name" type="text"
					class="text ui-widget-content ui-corner-all" style="color: #30f"
					readonly="readonly" disabled="disabled" /></td>
				<td><label for="date">วันที่ :</label></td>
				<td><input id="date" type="text"
					class="text ui-widget-content ui-corner-all" style="color: #30f"
					readonly="readonly" disabled="disabled" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a id="create-order" href="javascript:void(0)"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
					class="ui-button-text">Create New Order</span></a></td>
				<td><label for="totalprice">ราคารวม :</label></td>
				<td><input id="totalprice" type="text" style="color: #30f"
					class="text ui-widget-content ui-corner-all" readonly="readonly"
					disabled="disabled" /></td>
				<td><label for="totalsv"></label>Total Smile value :</td>
				<td><input id="totalsv" type="text"
					class="text ui-widget-content ui-corner-all" style="color: #30f"
					readonly="readonly" disabled="disabled"></td>
			</tr>
			<tr>
				<td colspan="3"></td>
				<td colspan="3"><a id="refresh" href="javascript:void(0)"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
					class="ui-button-text">Refresh</span></a><sj:a id="ajaxlink3"
					href="%{prochesedetail}" indicator="indicator" targets="main"
					button="true" buttonIcon="ui-icon-gear">
	ดูประวัติการสั่งชื้อ
	</sj:a> <sj:a id="ajaxlink1" href="%{ajax1}" indicator="indicator"
					targets="main" button="true" buttonIcon="ui-icon-gear">
	ดูรายการยกเลิกสั่งชื้อ
				</sj:a></td>
			</tr>
		</tbody>
	</table>
	</div>
	</div>
	<div id="divp" class="hide1"><sj:div id="div2">
		<s:url id="remote2url" action="json-grid-purchese-staff" />
		<s:url id="selectskuurl" action="json-customer-loadskuss-staff" />
		<s:url id="editpurcheseurl" action="edit-grid-purchese-staff" />
		<sjg:grid id="gridedittable" caption="+" dataType="json"
			href="%{remote2url}" pager="true" navigator="true"
			navigatorSearch="false"
			navigatorEditOptions="{height:200,reloadAfterSubmit:true}"
			navigatorAddOptions="{height:200,reloadAfterSubmit:true}"
			navigatorEdit="true" navigatorView="false" navigatorDelete="true"
			navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
			gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924"
			editurl="%{editpurcheseurl}" onSelectRowTopics="rowselect">
			<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="120"
				index="sku.sid" />
			<sjg:gridColumn name="sku.name" title="ชื่อผสิตภัณฑ์"
				edittype="select" editable="true"
				editoptions="{ dataUrl : '%{selectskuurl}' }" />
			<sjg:gridColumn name="sku.description" edittype="textarea"
				width="350" title="รายละเอียด ผลิตภัณฑ์" sortable="false" />
			<sjg:gridColumn name="quantity" title="จำนวน" editable="true"
				required="true" editrules="{integer:true,minValue:1,required:true}"
				formatter="integer" />
			<sjg:gridColumn name="purchesePrice" title="ราคา"
				formatoptions="{decimalSeparator:'.',thousandsSeparator: ',', decimalPlaces: 2}"
				formatter="currency" align="right" />
			<sjg:gridColumn name="psv" title="smile value" align="center"
				formatoptions="{thousandsSeparator: ','}" formatter="integer" />
		</sjg:grid>
		<br />
		<sj:submit id="grid_edit_addbutton" value="Add New"
			onClickTopics="rowadd1" button="true" />
		<sj:a id="buylink" href="%{buyurl}" indicator="indicator"
			targets="div4" button="true" buttonIcon="ui-icon-gear">
	สั่งสินค้า
	</sj:a>
		<sj:a id="ajaxlink2" href="%{prochesedetail}" indicator="indicator"
			targets="main" button="true" buttonIcon="ui-icon-gear">
	ดูประวัติการสั่งชื้อ
	</sj:a>

		<br />
		<br />
	</sj:div></div>
</sj:div>
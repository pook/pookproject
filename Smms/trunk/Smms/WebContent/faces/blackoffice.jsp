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
<style type="text/css">
div#div4 div {
	clear: both;
}
table#member td{
	text-align:center;	
	border-collapse:collapse;
}
.hide{
	display: none;
}
input.text {
	margin: 5px 9px 5px 9px;
	width: 150px;
	padding: 1px 5px 1px 5px;
}
label {
	padding-left: 7px;
	
}
#member-contain{
	margin-left: 95px;
	margin-top: 50px
}
#create-order{	
	margin: 5px 9px 5px 9px;
	width: 150px;
	padding: 1px 5px 1px 5px;
}

</style>
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
<script type="text/javascript">
$(function(){
	var auto = setInterval(function(){
		 $.getJSON('json-ordering-staff', function(data) {			 
			 fetchData(data.gridModel[0]);
		 });
		}
	,7200);
	$("table tr").addClass("ui-widget-content");
	$("table tfoot tr").removeClass("ui-widget-content");
	$.ajax({
		type : "get",
		url : "json-ordering-staff",				
		success : function(res) {			
			if(res.gridModel.length == 0){
				$("#create-order").show();
				$("#div2").addClass("hide");
				$("#smileId").enable();
				$("#smileId").focus();						
			}else{				
				$("#div2").removeClass("hide");									
				$("#create-order").hide();				
				fetchData(res.gridModel[0]);		
			}
		}
	});	
	$("#refresh").live("click",function(){
		 $.getJSON('json-ordering-staff', function(data) {			 
			 fetchData(data.gridModel[0]);
		 });
	}
	);
	
	$("#smileId").live("focusout",clrErrInf);
	var ck_search = /[A-Za-z]{2}[0-9]{10}$/;
	$("#create-order").click(function() {		 
		clrErrInf();		
		var s = $("#smileId");
		var m = s.val();
		if (ck_search.test(m)) {
			$.ajax({
				type : "get",
				url : "edit-grid-order-staff",
				data : "oper=add&smileId="+$("#smileId").val(),
				success : function(dat) {					
					$("#smileId").empty().val("");					
					if(dat.length==0)$("#main").load("blackoffice.action");
					else showmsgInf(dat);
				}					
			});				
		}else{		
			showmsgInf("รหัสสมาชิก ผิดพลาด");			
		}				
	});
	function fetchData(data){
		var d = data.date.substring(8,10);
		var m =	data.date.substring(6,7);
		var y =	data.date.substring(0,4);		
		$("#orderId").empty().val(""+data.id);				
		$("#smileId").empty().val(data.smileId);
		$("#name").empty().val(data.name);
		$("#date").empty().val(""+d+"/"+m+"/"+y);
		$("#totalprice").empty().val(data.totalPrice);
		$("#totalsv").empty().val(data.totalSv);		 	
	}
	function showmsgInf(msgInf) {
		$("#messageInfo")
				.addClass("ui-state-highlight ui-corner-all")
				.empty()
				.append(
						"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
								+ "</strong> " + msgInf + "</p>");

	}
	function clrErrInf() {
		$("#messageInfo").removeClass("ui-state-highlight ui-corner-all")
				.empty();		
	}
});
$.subscribe('rowadd1', function(event,data) {
    	$("#gridedittable").jqGrid('editGridRow',"new",{height:200,reloadAfterSubmit:true});    	
});	
</script>
<s:url id="addorder" value="edit-grid-order-staff" />
<s:url id="buyurl" value="order-purchese-staff" />
<s:url id="prochesedetail" action="showordered" />	
<sj:div id="div4"><div id="#test"></div>
<div id="main5"> 
<div id="member-contain" >
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
	<tbody><tr>
			<td colspan="6">
			<div class="ui-widget">
			<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;">
			</div>
			</div>			
			</td>
		</tr>
		<tr>
		<td><label for="orderId">Sale Order ID :</label></td><td><input id="orderId" type="text" class="text ui-widget-content ui-corner-all" style="color:#30f" readonly="readonly" disabled="disabled"/></td><td colspan="4"></td>
		</tr>	
	<tr>
	<td><label for="smileId"></label>รหัสสมาชิก :</td><td><input id="smileId" type="text" value="" class="text ui-widget-content ui-corner-all"  disabled="disabled"/>
	
	</td><td><label for="name"></label>ชื่อสมาชิก :</td><td><input id="name" type="text" class="text ui-widget-content ui-corner-all" style="color:#30f" readonly="readonly" disabled="disabled" /></td><td><label for="date" >วันที่ :</label></td><td><input id="date" type="text" class="text ui-widget-content ui-corner-all" style="color:#30f" readonly="readonly" disabled="disabled" /></td>
	</tr>
	<tr>
	<td></td><td>
	 <a id="create-order" href="javascript:void(0)"	
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">Create New Order</span></a> 
	</td><td><label for="totalprice">ราคารวม :</label></td><td><input id="totalprice" type="text" style="color:#30f" class="text ui-widget-content ui-corner-all" readonly="readonly" disabled="disabled"/></td><td><label for="totalsv"></label>Total Smile value :</td><td><input id="totalsv" type="text" class="text ui-widget-content ui-corner-all" style="color:#30f" readonly="readonly" disabled="disabled"></td>
	</tr>
	<tr>
	<td colspan="5"></td><td><a id="refresh"  href="javascript:void(0)" 
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">Refresh</span></a></td>
	</tr>
	</tbody>
	</table>
</div>
</div>
	<table
		style="align: center; width: 900px; margin-left: 60px; border: px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>			
			<td>				
				<sj:div id="div2">					
					<s:url id="remote2url" action="json-grid-purchese-staff" />
					<s:url id="selectskuurl" action="json-customer-loadskuss-staff" />
					<s:url id="editpurcheseurl" action="edit-grid-purchese-staff" />									
					<sjg:grid id="gridedittable" caption="+"  dataType="json"
						href="%{remote2url}" pager="true" navigator="true"
						navigatorSearch="false"
						navigatorEditOptions="{height:200,reloadAfterSubmit:true}"
						navigatorAddOptions="{height:200,reloadAfterSubmit:true}"						
						navigatorEdit="true" navigatorView="false" navigatorDelete="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="924" 
						editurl="%{editpurcheseurl}" 
						onSelectRowTopics="rowselect">						
							<sjg:gridColumn name="sku.sid" title="รหัสผสิตภัณฑ์" width="120"
								index="sku.sid" />
							<sjg:gridColumn name="sku.name" title="ชื่อผสิตภัณฑ์"
								edittype="select" editable="true"
								editoptions="{ dataUrl : '%{selectskuurl}' }" />
							<sjg:gridColumn name="sku.description" edittype="textarea" width="350"
								title="รายละเอียด ผลิตภัณฑ์" sortable="false" />
							<sjg:gridColumn name="quantity" title="จำนวน" editable="true"
								required="true"
								editrules="{integer:true,minValue:1,required:true}"
								formatter="integer" />
							<sjg:gridColumn name="purchesePrice" title="ราคา" formatoptions="{decimalSeparator:'.',thousandsSeparator: ',', decimalPlaces: 2}"
								formatter="currency" align="right" />							
							<sjg:gridColumn name="psv" title="smile value" align="center" formatoptions="{thousandsSeparator: ','}"
								formatter="integer" />
						</sjg:grid>						
					<br />
					<sj:submit id="grid_edit_addbutton" value="Add New"  
						onClickTopics="rowadd1" button="true" />
					<sj:a id="buylink" href="%{buyurl}" indicator="indicator"  
						targets="div4" button="true" buttonIcon="ui-icon-gear">
	สั่งสินค้า
	</sj:a>
					<sj:a id="ajaxlink2" href="%{prochesedetail}" indicator="indicator"
						targets="div4" button="true" buttonIcon="ui-icon-gear">
	ดูประวัติการสั่งชื้อ
	</sj:a>

					<br />
					<br />
				</sj:div>
			</td>
		</tr>
	</table>
</sj:div>
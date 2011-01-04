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
.display{
	display: none;
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
	$.ajax({
		type : "get",
		url : "json-ordering.action",		
		success : function(res) {
			if(res.gridModel.length ==0){
				$("#create-order").show();
				$("#div2").addClass("display");			
			}else{				
				$("#div2").removeClass("display");									
				$("#create-order").hide();				
				fetchData(res.gridModel[0]);		
			}
		}
	});
	
	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 350,
		width: 400,
		modal: true,
		buttons: {
			"Create order": function() {				
				$.ajax({
					type:"get",
					url : "edit-grid-order.action",	
					data :"oper=add&smileId="+$("#smileId").val(),	
					success : function(res) {								
						$("#result").empty().append(res);
											
						
								
					}					
	            });
				if($("#success >li >span").text()=='Found')
				$( this ).dialog( "close" );
					
			},
			Cancel: function() {
				$( this ).dialog( "close" );				
			}	
		}					
	});
	$( "#create-order" ).button().click(function() {
		$( "#dialog-form" ).dialog( "open" );
	});
	function fetchData(data){
		var d = data.date.substring(8,10);
		var m =	data.date.substring(6,7);
		var y =	data.date.substring(0,4);
		$("#member tbody").append( "<tr>" +
				"<td>"+data.orderId+"</td>" +
				"<td>"+data.user.smile.smileId+"</td>" + 
				"<td>"+data.user.smile.name+"</td>" +
				"<td>"+d+"/"+m+"/"+y+"</td>" +
				"<td>"+data.totalPrice + "</td>" +
				"<td>"+data.totalSv+ "</td>" +
			"</tr>" ); 	
	}
});
</script>
<s:url id="ajax" value="order-purchese" />
<s:url id="prochesedetail" action="showordered" />
<sj:div id="div4"><div id="#test"></div>
<div id="main5"> 
<div id="member-contain" >
	<h1><%=brance%></h1>
	<table id="member" class="ui-widget ui-widget-content">
		<thead>
			<tr class="ui-widget-header ">
				<th width="120">Sale Order ID</th>
				<th width="150">รหัสสมาชิก</th>
				<th width="200">ชื่อสมาชิก</th>
				<th width="150">วันที่</th>
				<th width="120">ราคารวม</th>
				<th width="150">Total Smile Value</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>
<a id="create-order" href="javascript:void(0)" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">Create new order</span></a>
</div>
<div id="dialog-form" title="Create new order">
	<p class="validateTips">กรอกรหัสสมาชิก</p>

	<form>
	<fieldset>
	<div id="result" style="padding: 0pt 0.7em;"></div>
		<label for="name">รหัสสมาชิก</label>
		<input type="text" name="smileId" id="smileId" class="text ui-widget-content ui-corner-all" />		
	</fieldset>
	</form>
</div>

	<table
		style="align: center; width: 924px; margin-left: 60px; border: px solid #000000; margin-top: 50px"
		cellspacing="10px">
		<tr>			
			<td>				
				<sj:div id="div2">
					<s:url id="remoteurl" action="json-ordering" />
					<s:url id="remote2url" action="json-grid-purchese" />
					<s:url id="selectskuurl" action="json-customer-loadskuss" />
					<s:url id="editpurcheseurl" action="edit-grid-purchese" />
					<s:url id="editorderurl" action="edit-grid-order" />
					<sjg:grid id="gridedittable" caption="สาขาพระราม 3"  dataType="json"
						href="%{remote2url}" pager="true" navigator="true"
						navigatorSearch="false"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
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
							<sjg:gridColumn name="purchesePrice" title="ราคา"
								formatter="currency" align="right" />							
							<sjg:gridColumn name="psv" title="smile value" align="center"
								formatter="integer" />
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
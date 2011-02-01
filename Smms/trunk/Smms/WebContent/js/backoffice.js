$(function(){	
	$("table tr").addClass("ui-widget-content");
	$("table tfoot tr").removeClass("ui-widget-content");
	$.ajax({
		type : "get",
		url : "json-ordering-staff",				
		success : function(res) {			
			if(res.gridModel.length != 0){
				$("#divp").removeClass("hide1");									
				$("#create-order").hide();							
				fetchData(res.gridModel[0]);									
			}else{				
				$("#create-order").show();				
				$("#smileId").focus();
				$("#smileId").removeAttr("disabled");		
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

$.subscribe('rowadd1', function(event,data) {
    	$("#gridedittable").jqGrid('editGridRow',"new",{height:200,reloadAfterSubmit:true});    	
});	
setInterval(function(){
	 $.getJSON('json-ordering-staff', function(data9) {			 
		 fetchData(data9.gridModel[0]);
	 });
	}
,7200);

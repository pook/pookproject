$(function() {
		$.getJSON("json-member", function(data) {
			$("table tr").addClass("ui-widget-content");
			$("table tfoot tr").removeClass("ui-widget-content");
			profile(data.userModel);
		});
	});	
	function profile(dat){
		$("#f1").empty().append(dat.node1.inviter);
		$("#f2").empty().append(dat.node1.smileId);
		$("#f3").empty().append(dat.detail.codeIdentification);
		$("#f4").empty().append(dat.detail.name);
		$("#f5").empty().append(dat.detail.surename);
		$("#f6").empty().append(dat.node1.displayName);
		$("#f7").empty().append(dat.detail.tel);
		$("#f8").empty().append(dat.detail.tel2);
		$("#f9").empty().append(dat.detail.email);
		$("#f10").empty().append(dat.detail.address);
		$("#f11").empty().append(dat.detail.province.pname);
		$("#f12").empty().append(dat.detail.address2);
		$("#f13").empty().append(dat.branceCard);
		$("#f14").empty().append(dat.detail.bank);
		$("#f15").empty().append(dat.detail.bankAccount);
		$("#f16").empty().append(dat.detail.bbrance);
		$("#f17").empty().append(dat.detail.typeOfAccount);
		$("#f18").empty().append(dat.bonusTeam);
		$("#f19").empty().append(dat.bonusInv);
		var x = dat.bonusTeam+dat.bonusInv;
		$("#f20").empty().append(x);
		$("#f21").empty().append(dat.bonusLast);
		$("#f501").empty().append(dat.detail.numOfAccount);
		$("#f502").empty().append(dat.node1.totalSv);
		$("#f503").empty().append(dat.lstTotalSV);
		$("#sdialog").hide();
		$.ajax({
			url :"check-account-member",					
			success : function(res) {				
				if(res == -1){
					$("#sdialog").show();	  // this function enable for 3 id	
					chkMax();		
				}						
			}		
		});      	   				
	}
	$("#displayName").live("focusout", checkDisplayName);
	function okButton1(){				
		var displayName = $("#displayName");
		var valid = true;
		valid = valid&&checkLength(displayName," ชื่อแสดงในสายงาน ", 3, 30);		
		if(valid){
			$.ajax({
				type : "post",
				url :"save2-member",
				data :"displayName="+displayName.val()+"&upline="+$("#upline").val(),		
				success : function(res) {	
					if(res.length>0){
						showmsgInf(res);	
					}							
				}		
			});
			$('#btndialog').dialog('close');
			$('#main').load("member.action");
		}						
			
	};
	
	function cancelButton1(){	  
		$('#btndialog').dialog('close');
	};
	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			showmsgInf("ข้อมูล  " + n + " ที่กรอกควรมีความยาวระหว่าง " + min
					+ " และ " + max + ".");
			return false;
		} else {
			return true;
		}
	}
	function showmsgInf(msgInf) {
		$("#messageInfo").addClass("ui-state-highlight ui-corner-all").empty().append(
						"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
								+ "<strong>ข้อความ</strong> "							
								+ msgInf							
								+ "</p>");
	}
	function checkDisplayName() {
		$(this).removeClass("ui-state-error");
		$.ajax({
			type : "post",
			url : "check-displayname-member",
			data : "displayName=" + $(this).val(),
			success : function(res) {				
				if (res.length>0) {	
					showmsgInf(res);			
					$("#displayName").addClass("ui-state-error");
					$("#displayName").focus();				
					return false;
				}
			}	
		});	
		return true;
	}
	function chkMax(){	
		$.ajax({
			url : "max-register-member",		
			success : function(res) {			
				if(res == 0){					
					var upline = $("#upline"), displayName = $("#displayName");
					var allFields = $([]).add(upline).add(displayName);
					allFields.attr("disabled","disabled");
					showmsgInf("คุณมีสิทธิ์การสมัคร  0 ต้องลงทะเบียนเพื่อขอสิทธิ์");			
				}else if(res >0){
					showmsgInf("คุณเหลือสิทธิ์การสมัคร  "+res);
				}			
			}		
		});	
	}	
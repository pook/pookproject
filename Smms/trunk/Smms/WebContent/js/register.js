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
				$("#fsubmit1").remove();
				var name = $("#name"), surename = $("#surename"), displayName = $("#displayName"), codeIdentification = $("#codeIdentification"), tel = $("#tel"), tel2 = $("#tel2"), email = $("#email"), inviter = $("#inviter"), address = $("#address"), address2 = $("#address2"), bank = $("#bank"), bankAccount = $("#bankAccount"), brance = $("#brance"), branceCard = $("#branceCard"), bankBrance = $("#bankBrance"), typeOfAccount = $("#typeOfAccount");
				var allFields = $([]).add(name).add(surename).add(displayName).add(
						codeIdentification).add(tel).add(tel2).add(email).add(brance).add(branceCard).add(address).add(address2).add(
						bankAccount).add(typeOfAccount).add(bankBrance).add("#upline").add("#bank").add("#province");
				allFields.attr("disabled","disabled");
				showmsgInf("คุณมีสิทธิ์การสมัคร  0 ต้องลงทะเบียนเพื่อขอสิทธิ์");			
			}else if(res >0){
				showmsgInf("คุณเหลือสิทธิ์การสมัคร  "+res);
			}			
		}		
	});	
}

function chkLevel(){
	$.ajax({
		type : "get",		
		url : "check-level-member.action",		
		success : function(res) {	
			if(res.length>0)
				showmsgInf(res);
		}		
	});
}
function clrErrInf2(){	
	clrErrInf();
}
function regis() {
	//chkLevel();
	chkMax();
	$("#displayName").live("focusout", checkDisplayName);
	$("#codeIdentification").live("focusout",clrErrInf2);
	$("#tel").live("focusout",clrErrInf2);$("#tel2").live("focusout",clrErrInf2);$("#name").live("focusout",clrErrInf2);$("#address").live("focusout",clrErrInf2);$("#bank").live("focusout",clrErrInf2);
	$("#fsubmit1").click(
					function() {
					var name = $("#name"), surename = $("#surename"), displayName = $("#displayName"), codeIdentification = $("#codeIdentification"), tel = $("#tel"), tel2 = $("#tel2"), email = $("#email"), inviter = $("#inviter"), address = $("#address"), address2 = $("#address2"), bank = $("#bank"), bankAccount = $("#bankAccount"), brance = $("#brance"), branceCard = $("#branceCard"), bankBrance = $("#bankBrance"), typeOfAccount = $("#typeOfAccount");
					var allFields = $([]).add(name).add(surename).add(displayName).add(
				codeIdentification).add(tel).add(tel2).add(email).add(brance).add(branceCard).add(address).add(address2).add(
				bankAccount).add(typeOfAccount).add(bankBrance);
						clrErrInf();
						allFields.removeClass("ui-state-error");
						var valid = true;
						valid = checkLength(name, " ชื่อ ", 3, 30);
						valid = valid&& checkLength(surename, " นามสกุล ", 3, 30);
						valid = valid&& checkLength(displayName," ชื่อแสดงในสายงาน ", 3, 30);
						valid = valid&& checkidentifier(codeIdentification);
						valid = valid&& checkLength(tel, " เบอร์โทรศัพท์ ", 9, 10);
						valid = valid&& ckBrance(brance);
						valid = valid&& ckBrance(branceCard);
						valid = valid&& checkLength(address, " ที่อยู่  ", 5, 500);
						valid = valid&& checkEmail(email);
						valid = valid&& checkLength(bankAccount, " บัญชีธนาคาร ", 8,30);
						valid = valid&& checkLength(bankBrance, " สาขาธนาคาร ", 3,30);
						valid = valid&& checkLength(typeOfAccount, " ประเภทบัญชี ",	3, 30);
						if (valid) {						
							$("#main-regist").load("save-member", {"upline":""+$("#upline").val(),"name":""+name.val(),"surename":""+ surename.val() ,"displayName":""+displayName.val(),
								"codeIdentification":""+ codeIdentification.val(),"tel":""+ tel.val(),"brance":"" + brance.val(),"tel2":"" + tel2.val()	,
								"branceCard":"" + branceCard.val(),"address" :""+ address.val(),"province":"" + $("#province").val(),"address2":"" + address2.val(),
								"email":""+ email.val(),"bank":"" + bank.val(),"bankAccount":"" + bankAccount.val(), "bankBrance" :""+ bankBrance.val(), "typeOfAccount" :""+ typeOfAccount.val()});							
						}
						valid = false;
					});
}
function ckBrance(b1) {
	if (b1.val() == -1) {
		showmsgInf("กรุณาเลือกข้อมูลสาขา");
		return false;
	}
	return true;
}
function checkidentifier(ci) {
	var c = true;
	c = checkIdent(ci.val());
	if (!c) {
		ci.addClass("ui-state-error");
		showmsgInf("<li>รหัสบัตรประชาชนไม่ถูกต้อง</li><li>ข้อมูล รหัสบัตรประชาชนควรมีเท่ากับ 13</li>");
	} else {
		ci.removeClass("ui-state-error");
	}
	return c;
}
function checkIdent(id) {
	if (id.length != 13)
		return false;
	for ( var i = 0, sum = 0; i < 12; i++)
		sum += parseFloat(id.charAt(i)) * (13 - i);
	if ((11 - sum % 11) % 10 != parseFloat(id.charAt(12)))
		return false;
	return true;
}
function checkEmail(o) {
	clrErrInf();	
	if (o.val().length > 0)
		return checkRegexp(
				o,
				/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
				"eg. mail@evolix.biz");
	return true;
}
function checkRegexp(o, regexp, n) {	
	if (!(regexp.test(o.val()))) {
		o.addClass("ui-state-error");
		showmsgInf(n);
		return false;
	} else {
		return true;
	}
}
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
function clrErrInf() {
	$("#messageInfo").removeClass("ui-state-highlight ui-corner-all").empty();

}
function rmAllfielderr() {
	allFields.removeClass("ui-state-error");
}

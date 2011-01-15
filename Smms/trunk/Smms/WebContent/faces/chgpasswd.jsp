<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
table {
	padding: 10px 20px 5px 20px;
}

#inp {
	margin-left: 169px;
}

#result1 {
	margin-left: 259px;
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	function checkdup(o){		
		var np = $("#newpasswd"),rnp = $("#renewpasswd");		
		if( np.val()!=rnp.val()){
			o.addClass("ui-state-error");
			showmsgInf("ข้อมูล รหัสผ่านใหม่ ไม่ตรงกัน");
			return false;			
		}else{
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
	function ckvalid(){
		var v =true,t=$(this);
		v =  checkLength(t," รหัสผ่าน ",3,30);
		if(!v){t.focus();}
		else{
			t.removeClass( "ui-state-error" );
			clrErrInf();
			}
		
	}
	function ckvalid3(){
		var v =true,t=$(this);
		v =  checkLength(t," รหัสผ่านใหม่อีกครั้ง ",3,30);
		v =  v && checkdup(t);
		if(!v){t.focus();}
		else{
			t.removeClass( "ui-state-error" );
			clrErrInf();
			return true;
		}
		return false;	
	}	
	$("#oldpasswd").live("focusout",ckvalid);
	$("#newpasswd").live("focusout",ckvalid);
	$("#renewpasswd").live("focusout",ckvalid3);
	function showmsgInf(msgInf) {
		$("#messageInfo")
				.addClass("ui-state-highlight ui-corner-all")
				.empty()
				.append(
						"<p><span style='float: left; margin-right: 0.3em;' class='ui-icon ui-icon-info'></span>"
								+ "<strong>ข้อความ</strong> "
								+ ""
								+ msgInf
								+ "" + "</p>");

	}
	function clrErrInf() {
		$("#messageInfo").removeClass("ui-state-highlight ui-corner-all")
				.empty();
		
	}
	$("#chgpasswd").submit(function(){
		var dat = "newpasswd="+$("#newpasswd").val()+"&oldpassword="+$("#oldpasswd").val();			
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : "changepasswd",
			data :dat,
			success : function(res) {
				$("#result1").html(res);
			}
		});
	});
</script>
<div id="result1">
<ul id="formerrors" class="errorMessage"></ul>
<form id="chgpasswd" action="javascript:void(0)">
<table id="tchgpass" width="450" class="ui-widget ui-widget-content">
	<tfoot>
		<tr>
			<td colspan="2"><input id="inp" type="submit" value="ตกลง" 
				class="ui-button ui-widget ui-state-default ui-corner-all"
				onmouseover="ui-state-hover" /></td>

		</tr>

	</tfoot>
	<tr>
		<td colspan="2"><div class="ui-widget">
			<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;"></div>
			</div></td>
			</tr>
	
	<tr>
		<td>รหัสผ่าน :</td>
		<td width="256"><input type="password" id="oldpasswd"
			class="text ui-widget-content ui-corner-all" /></td>
	</tr>
	<tr>
		<td>รหัสผ่านใหม่ :</td>
		<td><input type="password" id="newpasswd"
			class="text ui-widget-content ui-corner-all" /></td>
	</tr>
	<tr>
		<td>รหัสผ่านใหม่อีกครั้ง :</td>
		<td><input type="password" id="renewpasswd"
			class="text ui-widget-content ui-corner-all" /></td>
	</tr>
</table>
</form>
</div>
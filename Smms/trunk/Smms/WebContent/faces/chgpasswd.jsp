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
	function checkdup(){		
		var np = $("#newpasswd"),rnp = $("#renewpasswd");		
		if( np.val()!=rnp.val()){			
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
		var valid = true;var newp =$("#newpasswd"),oldp =$("#oldpasswd"),renewp=$("#renewpasswd");
		valid = valid && checkLength(oldp, " รหัสผ่าน  ", 3, 30);
		valid = valid && checkLength(newp, " รหัสผ่านใหม่  ", 3, 30);
		valid = valid && checkLength(renewp, " รหัสผ่านใหม่อีกครั้ง   ", 3, 30);
		valid = valid && checkdup();
		if(valid){
			var dat = "newpasswd="+newp.val()+"&oldpassword="+oldp.val();			
			$.ajax({
				type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : "changepasswd-member",
			data :dat,
			success : function(res) {
				$("#result1").html(res);
			}
		});
		}
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
		<td colspan="2">
		<div class="ui-widget">
		<div id="messageInfo" style="margin-top: 5px; padding: 0pt 0.7em;"></div>
		</div>
		</td>
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
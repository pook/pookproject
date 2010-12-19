<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script type="text/javascript">
	$("a#load").live("click", function() {
		var m = '-1';
		//m = $("#month").val();
		m=1;
		var a = a = "commission"+m+"-cvs.action";					
		$("a#load").attr("href", a);
	});
</script>
<div id="div0">
	<s:form>
		<table
			style="align: center; width: 470px; margin-left: 350px; border: 1px solid #000000; margin-top: 50px"
			cellspacing="10px">
			<tr>
				<td><b>นำออกเอกสาร CVS</b> <s:label for="month">
				</s:label> <s:select label="เดือน" name="mount" headerKey="-1" id="month"
					list="#{'1':'มกราคม', '2':'กุมภาพันธ์', '3':'มีนาคม', '4':'เมษายน', '5':'พฤษภาคม', '6':'มิถุนายน', '7':'กรกฎาคม', '8':'สิงหาคม', '9':'กันยายน', '10':'ตุลาคม', '11':'พฤศจิกายน', '12':'ธันวาคม'}" />
				</td>
			</tr>
			<tr>
				<td><a id="load"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
					class="ui-button-text">Export</span></a></td>
			</tr>
		</table>
	</s:form>
</div>
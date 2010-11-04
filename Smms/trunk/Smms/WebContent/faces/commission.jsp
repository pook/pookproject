<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Smms/struts/utils.js"></script>
<sj:div id="div0">
	<s:form>
		<table
			style="align: center; width: 540px; margin-left: 350px; border: 1px solid #000000; margin-top: 50px"
			cellspacing="10px">
			<tr>
				<td>
				<s:label><b>นำออกเอกสาร CVS</b></s:label>
				<s:select label="เดือน" name="mount" headerKey="-1"
					list="#{'a1':'มกราคม', 'a2':'กุมภาพันธ์', 'a3':'มีนาคม', 'a4':'เมษายน', 'a5':'พฤษภาคม', 'a6':'มิถุนายน', 'a7':'กรกฎาคม', 'a8':'สิงหาคม', 'a9':'กันยายน', 'a10':'ตุลาคม', 'a11':'พฤศจิกายน', 'a12':'ธันวาคม'}" />
				<s:select label="จำนวนสมาชิก" name="" headerKey="-1"
					list="#{'a1':'0-10,000', 'a2':'10,001-20,0000', 'a3':'20,001-40,0000', 'a4':'40,001-80,000', 'a5':'80,001-160,000', 'a6':'160,001-320,000','a7':'320,001-640,000','a7':'640,001-1,280,000'}" />
				<sj:submit id="grid_multi_getselectedbutton"
					value="Export" onClickTopics="getselectedids"
					label="xxx"
					button="true" /></td>

			</tr>
		</table>
	</s:form>
</sj:div>
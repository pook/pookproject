<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/patch_layout.css" rel="stylesheet" type="text/css" />
<div class="headernode" id="headnode">
<div class="ui-widget">
<div id="messageInfo" style="margin-top: 20px; padding: 0pt 0.7em;"></div>
</div>
<div class="ui-widget">
<div id="messageError" style="padding: 0pt 0.7em;"></div>
</div>
<div class="bodycontent" id="bcontent">
<div id="formsearch" class="sform">

<div class="search" id="search"><label for="searchuser">ค้นหา
:</label><br />
<input id="searchuser" name="memberid" value="" /> <a id="fsubmit"
	href="%{searchuser}"
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">ค้นหา</span></a></div>

<div class="backward-buttom" id="backward-buttom">
<div class="backward"><a id="abackword"
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">ถอยไปชั้นสมาชิก</span></a></div>
<div class="backward1"><a id="abackword1"
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">ถอยกลับ 1 ชั้น</span></a></div>
<div class="backward6"><a id="abackword6"
	class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span
	class="ui-button-text">ถอยกลับ 6 ชั้น</span></a></div>
</div>
<div id="backwardImg" style="float: right"><img alt="Loading....."
	src="images/legend7.gif"></div>
</div>
</div>
</div>
<!-- header node -->
<div class="rootnode" id="rn">
<div class="nodeleft" id="nl">
<div class="llevel" id="lv1"></div>
<div class="llevel" id="lv2"></div>
<div class="llevel" id="lv3"></div>
<div class="llevel" id="lv4"></div>
<div class="llevel" id="lv5"></div>
<div class="llevel" id="lv6"></div>
</div>

<div class="mainnode" id="mainnode"
	style="position: absolute; margin-left: 70px; left: 20px; top: 120px">
<div class="level" id="l1">
<div class="node1" id="n1"></div>
</div>
<div class="level" id="l2">
<div class="node1" id="n2"></div>
<div class="node1" id="n3"></div>
</div>
<div class="level" id="l3">
<div class="node1" id="n4"></div>
<div class="node1" id="n5"></div>
<div class="node1" id="n6"></div>
<div class="node1" id="n7"></div>
</div>

<div class="level" id="l4">
<div class="node1" id="n8"></div>
<div class="node1" id="n9"></div>
<div class="node1" id="n10"></div>
<div class="node1" id="n11"></div>
<div class="node1" id="n12"></div>
<div class="node1" id="n13"></div>
<div class="node1" id="n14"></div>
<div class="node1" id="n15"></div>
</div>
<div class="level" id="l5">
<div class="node1" id="n16"></div>
<div class="node1" id="n17"></div>
<div class="node1" id="n18"></div>
<div class="node1" id="n19"></div>
<div class="node1" id="n20"></div>
<div class="node1" id="n21"></div>
<div class="node1" id="n22"></div>
<div class="node1" id="n23"></div>

<div class="node1" id="n24"></div>
<div class="node1" id="n25"></div>
<div class="node1" id="n26"></div>
<div class="node1" id="n27"></div>
<div class="node1" id="n28"></div>
<div class="node1" id="n29"></div>
<div class="node1" id="n30"></div>
<div class="node1" id="n31"></div>

</div>



<div class="level" id="l6">
<div class="node1" id="n32"></div>
<div class="node1" id="n33"></div>
<div class="node1" id="n34"></div>
<div class="node1" id="n35"></div>
<div class="node1" id="n36"></div>
<div class="node1" id="n37"></div>
<div class="node1" id="n38"></div>
<div class="node1" id="n39"></div>

<div class="node1" id="n40"></div>
<div class="node1" id="n41"></div>
<div class="node1" id="n42"></div>
<div class="node1" id="n43"></div>
<div class="node1" id="n44"></div>
<div class="node1" id="n45"></div>
<div class="node1" id="n46"></div>
<div class="node1" id="n47"></div>
<div class="node1" id="n48"></div>
<div class="node1" id="n49"></div>
<div class="node1" id="n50"></div>
<div class="node1" id="n51"></div>
<div class="node1" id="n52"></div>
<div class="node1" id="n53"></div>
<div class="node1" id="n54"></div>
<div class="node1" id="n55"></div>

<div class="node1" id="n56"></div>
<div class="node1" id="n57"></div>
<div class="node1" id="n58"></div>
<div class="node1" id="n59"></div>
<div class="node1" id="n60"></div>
<div class="node1" id="n61"></div>
<div class="node1" id="n62"></div>
<div class="node1" id="n63"></div>
</div>
</div>
<script type="text/javascript" src="js/or-chart.js"></script>
<script type="text/javascript">
	var jsondat = "json-organization-member",jsonbw = "json-organization-backward-member",jsonsearch = "json-organization-search-member";
	$(function() {
		$.getJSON(jsondat, function(data) {
			orgJSON(data);
		});
	});	
</script>
</div>
<div id="dis"></div>
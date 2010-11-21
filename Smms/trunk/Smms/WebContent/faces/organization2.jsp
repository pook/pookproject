<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/or-chart.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		fetchpopup(success);
	});
	function fetchpopup(data) {
		var x = $(popuphtml(1));
		var hideDelay = 500;
		var hideTimer = null;
		var dat = data;
		function cmouseover() {
			if (hideTimer)
				clearTimeout(hideTimer);
			var pos = $(this).offset();
			var width = $(this).width();
			var g = null;
			g = $(this).attr("id");
			var idx = g.substring(1);
			var txt = dat.teams[idx - 1].user.userId;
			if (txt == null)
				$("#name1").text("dat  ");
			else
				$("#name1").text("dat  " + txt);
			$("body").append(x);
			x.css({
				"z-index" : "100000",
				"height" : "50px",
				left : (pos.left + (width + 19)) + 'px',
				top : (pos.top - 25) + 'px'
			});
			x.css('display', 'block');
		}
		$("#n1").live("mouseover", cmouseover);
		$("#n2").live("mouseover", cmouseover);
		$("#n3").live("mouseover", cmouseover);
		$("#n4").live("mouseover", cmouseover);
		$("#n5").live("mouseover", cmouseover);
		$("#n6").live("mouseover", cmouseover);
		$("#n7").live("mouseover", cmouseover);
		$("#n8").live("mouseover", cmouseover);
		$("#n9").live("mouseover", cmouseover);
		$("#n10").live("mouseover", cmouseover);
		$("#n11").live("mouseover", cmouseover);
		$("#n12").live("mouseover", cmouseover);
		$("#n13").live("mouseover", cmouseover);
		$("#n14").live("mouseover", cmouseover);
		$("#n15").live("mouseover", cmouseover);
		$("#n16").live("mouseover", cmouseover);
		$("#n17").live("mouseover", cmouseover);
		$("#n18").live("mouseover", cmouseover);
		$("#n19").live("mouseover", cmouseover);
		$("#n20").live("mouseover", cmouseover);
		$("#n21").live("mouseover", cmouseover);
		$("#n22").live("mouseover", cmouseover);
		$("#n23").live("mouseover", cmouseover);
		$("#n24").live("mouseover", cmouseover);
		$("#n25").live("mouseover", cmouseover);
		$("#n26").live("mouseover", cmouseover);
		$("#n27").live("mouseover", cmouseover);
		$("#n28").live("mouseover", cmouseover);
		$("#n29").live("mouseover", cmouseover);
		$("#n30").live("mouseover", cmouseover);
		$("#n31").live("mouseover", cmouseover);
		$("#n32").live("mouseover", cmouseover);
		$("#n33").live("mouseover", cmouseover);
		$("#n34").live("mouseover", cmouseover);
		$("#n35").live("mouseover", cmouseover);
		$("#n36").live("mouseover", cmouseover);
		$("#n37").live("mouseover", cmouseover);
		$("#n38").live("mouseover", cmouseover);
		$("#n39").live("mouseover", cmouseover);
		$("#n40").live("mouseover", cmouseover);
		$("#n41").live("mouseover", cmouseover);
		$("#n42").live("mouseover", cmouseover);
		$("#n43").live("mouseover", cmouseover);
		$("#n44").live("mouseover", cmouseover);
		$("#n45").live("mouseover", cmouseover);
		$("#n46").live("mouseover", cmouseover);
		$("#n47").live("mouseover", cmouseover);
		$("#n48").live("mouseover", cmouseover);
		$("#n49").live("mouseover", cmouseover);
		$("#n50").live("mouseover", cmouseover);
		$("#n51").live("mouseover", cmouseover);
		$("#n52").live("mouseover", cmouseover);
		$("#n53").live("mouseover", cmouseover);
		$("#n54").live("mouseover", cmouseover);
		$("#n55").live("mouseover", cmouseover);
		$("#n56").live("mouseover", cmouseover);
		$("#n57").live("mouseover", cmouseover);
		$("#n58").live("mouseover", cmouseover);
		$("#n59").live("mouseover", cmouseover);
		$("#n60").live("mouseover", cmouseover);
		$("#n61").live("mouseover", cmouseover);
		$("#n62").live("mouseover", cmouseover);
		$("#n63").live("mouseover", cmouseover);

		$("#n1").live("mouseout", cmouseout);
		$("#n2").live("mouseout", cmouseout);
		$("#n3").live("mouseout", cmouseout);
		$("#n4").live("mouseout", cmouseout);
		$("#n5").live("mouseout", cmouseout);
		$("#n6").live("mouseout", cmouseout);
		$("#n7").live("mouseout", cmouseout);
		$("#n8").live("mouseout", cmouseout);
		$("#n9").live("mouseout", cmouseout);
		$("#n10").live("mouseout", cmouseout);
		$("#n11").live("mouseout", cmouseout);
		$("#n12").live("mouseout", cmouseout);
		$("#n13").live("mouseout", cmouseout);
		$("#n14").live("mouseout", cmouseout);
		$("#n15").live("mouseout", cmouseout);
		$("#n16").live("mouseout", cmouseout);
		$("#n17").live("mouseout", cmouseout);
		$("#n18").live("mouseout", cmouseout);
		$("#n19").live("mouseout", cmouseout);
		$("#n20").live("mouseout", cmouseout);
		$("#n21").live("mouseout", cmouseout);
		$("#n22").live("mouseout", cmouseout);
		$("#n23").live("mouseout", cmouseout);
		$("#n24").live("mouseout", cmouseout);
		$("#n25").live("mouseout", cmouseout);
		$("#n26").live("mouseout", cmouseout);
		$("#n27").live("mouseout", cmouseout);
		$("#n28").live("mouseout", cmouseout);
		$("#n29").live("mouseout", cmouseout);
		$("#n30").live("mouseout", cmouseout);
		$("#n31").live("mouseout", cmouseout);
		$("#n32").live("mouseout", cmouseout);
		$("#n33").live("mouseout", cmouseout);
		$("#n34").live("mouseout", cmouseout);
		$("#n35").live("mouseout", cmouseout);
		$("#n36").live("mouseout", cmouseout);
		$("#n37").live("mouseout", cmouseout);
		$("#n38").live("mouseout", cmouseout);
		$("#n39").live("mouseout", cmouseout);
		$("#n40").live("mouseout", cmouseout);
		$("#n41").live("mouseout", cmouseout);
		$("#n42").live("mouseout", cmouseout);
		$("#n43").live("mouseout", cmouseout);
		$("#n44").live("mouseout", cmouseout);
		$("#n45").live("mouseout", cmouseout);
		$("#n46").live("mouseout", cmouseout);
		$("#n47").live("mouseout", cmouseout);
		$("#n48").live("mouseout", cmouseout);
		$("#n49").live("mouseout", cmouseout);
		$("#n50").live("mouseout", cmouseout);
		$("#n51").live("mouseout", cmouseout);
		$("#n52").live("mouseout", cmouseout);
		$("#n53").live("mouseout", cmouseout);
		$("#n54").live("mouseout", cmouseout);
		$("#n55").live("mouseout", cmouseout);
		$("#n56").live("mouseout", cmouseout);
		$("#n57").live("mouseout", cmouseout);
		$("#n58").live("mouseout", cmouseout);
		$("#n59").live("mouseout", cmouseout);
		$("#n60").live("mouseout", cmouseout);
		$("#n61").live("mouseout", cmouseout);
		$("#n62").live("mouseout", cmouseout);
		$("#n63").live("mouseout", cmouseout);
		function cmouseout(data) {
			if (hideTimer)
				clearTimeout(hideTimer);
			hideTimer = setTimeout(function() {
				x.css('display', 'none');
			}, hideDelay);
			//alert("mouse out");
		}

	}
	function popuphtml(idx) {
		var x = "<div id='personPopupContainer'>"
				+ "<table id ='tablepopup' width='' border='0'  cellspacing='0' cellpadding='0' align='center' class='personPopupPopup'>"
				+ "<tr>"
				+ "<td class='corner topLeft'></td>"
				+ "<td class='top'></td>"
				+ "<td class='corner topRight'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td class='left'></td>"
				+ "<td>"
				+ "<table>"
				+ "<tr>"
				+ "<td ><img id='status' src='images/aaa.gif' style='height:24px;width:24px;border:none'/></td>"
				+ "<td><font size='-1'><div id='name1' >" + idx
				+ "</div><div id='nid' >bb</div></font>"
				+ "</td> </tr></table></td> <td class='right'></td>"
				+ "</tr><tr><td class='corner bottomLeft'></td>"
				+ "<td class='bottom'></td>"
				+ " <td class='corner bottomRight'></td></tr>" + "</table>"
				+ "</div>";
		return x;
	}
	$.subscribe('x1', function(event,data) {
		fetchdata(6, "json-organization.action");
     });
	
</script>







<s:url id="urlorchart" action="json-organization.action" >
	<s:param name="nodeId" value="-2"/>
</s:url>
<s:url id="urlorchart1" action="json-organization.action" >
	<s:param name="nodeId" value="-2"/>
</s:url>

<div class="mainnode" id="mainnode">
<div class="level" id="l1">
<div class="node1" id="n1">

<table id="tablepopup1" width="" border="0" cellspacing="0"
	cellpadding="0" align="center" class="personPopupPopup">
	<tr>
		<td class="corner topLeft"></td>
		<td class="top"></td>
		<td class="corner topRight"></td>
	</tr>
	<tr>
		<td class="left"></td>
		<td><sj:a id="ajaxlink6" href="%{urlorchart}" targets="mainnode" dataType="json" onSuccessTopics="success"
			indicator="indicator" >
			<table>
				<tr>
					<td><img id="status" src="images/aaa.gif"
						style="height: 24px; width: 24px; border: none" /></td>
					<td>
					<div id="name" style="height: 8px; width: 60px; position: relative"><font
						size="-2">empty</font></div>
					<br />
					<div id="nid" style="height: 8px; width: 50px"><font
						size="-2">empty</font></div>
					</td>
				</tr>
			</table>
		</sj:a></td>
		<td class="right"></td>
	</tr>
	<tr>
		<td class="corner bottomLeft"></td>
		<td class="bottom"></td>
		<td class="corner bottomRight"></td>
	</tr>
</table>
</div>
</div>
<div class="level" id="l2">
<div class="node1" id="n2">n2</div>
<div class="node1" id="n3">n3</div>
</div>
<div class="level" id="l3">
<div class="node1" id="n4">n4</div>
<div class="node1" id="n5">n5</div>
<div class="node1" id="n6">
<table id="tablepopup1" width="" border="0" cellspacing="0"
	cellpadding="0" align="center" class="personPopupPopup">
	<tr>
		<td class="corner topLeft"></td>
		<td class="top"></td>
		<td class="corner topRight"></td>
	</tr>
	<tr>
		<td class="left"></td>
		<td><sj:a id="ajaxlink1" href="%{urlorchart}" targets="mainnode"   
			indicator="indicator" >
			<table>
				<tr>
					<td><img id="status" src="images/aaa.gif"
						style="height: 24px; width: 24px; border: none" /></td>
					<td>
					<div id="name" style="height: 8px; width: 60px; position: relative"><font
						size="-2">emccc</font></div>
					<br />
					<div id="nid" style="height: 8px; width: 50px"><font
						size="-2">emttt</font></div>
					</td>
				</tr>
			</table>
		</sj:a>
		</td>
		<td class="right"></td>
	</tr>
	<tr>
		<td class="corner bottomLeft"></td>
		<td class="bottom"></td>
		<td class="corner bottomRight"></td>
	</tr>
</table>

</div>
<div class="node1" id="n7">n7</div>
</div>

<div class="level" id="l4">
<div class="node1" id="n8">n8</div>
<div class="node1" id="n9">n9</div>
<div class="node1" id="n10">n10</div>
<div class="node1" id="n11">n11</div>
<div class="node1" id="n12">n12</div>
<div class="node1" id="n13">n13</div>
<div class="node1" id="n14">n14</div>
<div class="node1" id="n15">n15</div>
</div>
<div class="level" id="l5">
<div class="node1" id="n16">n16</div>
<div class="node1" id="n17">n17</div>
<div class="node1" id="n18">n18</div>
<div class="node1" id="n19">n19</div>
<div class="node1" id="n20">n20</div>
<div class="node1" id="n21">n21</div>
<div class="node1" id="n22">n22</div>
<div class="node1" id="n23">n23</div>

<div class="node1" id="n24">n24</div>
<div class="node1" id="n25">n25</div>
<div class="node1" id="n26">n26</div>
<div class="node1" id="n27">n27</div>
<div class="node1" id="n28">n28</div>
<div class="node1" id="n29">n29</div>
<div class="node1" id="n30">n30</div>
<div class="node1" id="n31">n31</div>

</div>



<div class="level" id="l6">
<div class="node1" id="n32">n32</div>
<div class="node1" id="n33">n33</div>
<div class="node1" id="n34">n34</div>
<div class="node1" id="n35">n35</div>
<div class="node1" id="n36">n36</div>
<div class="node1" id="n37">n37</div>
<div class="node1" id="n38">n38</div>
<div class="node1" id="n39">n39</div>

<div class="node1" id="n40">n40</div>
<div class="node1" id="n41">n41</div>
<div class="node1" id="n42">n42</div>
<div class="node1" id="n43">n43</div>
<div class="node1" id="n44">n44</div>
<div class="node1" id="n45">n45</div>
<div class="node1" id="n46">n46</div>
<div class="node1" id="n47">n47</div>
<div class="node1" id="n48">n48</div>
<div class="node1" id="n49">n49</div>
<div class="node1" id="n50">n50</div>
<div class="node1" id="n51">n51</div>
<div class="node1" id="n52">n52</div>
<div class="node1" id="n53">n53</div>
<div class="node1" id="n54">n54</div>
<div class="node1" id="n55">n55</div>

<div class="node1" id="n56">n56</div>
<div class="node1" id="n57">n57</div>
<div class="node1" id="n58">n58</div>
<div class="node1" id="n59">n59</div>
<div class="node1" id="n60">n60</div>
<div class="node1" id="n61">n61</div>
<div class="node1" id="n62">n62</div>
<div class="node1" id="n63">n63</div>
</div>


</div>

    
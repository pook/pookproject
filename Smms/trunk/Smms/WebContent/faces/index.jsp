<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/ext.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/ckeditor.config.js"></script>
<script type="text/javascript">
	$(function() {
		$(".column div div .ui-icon").click(function() {
			$(this).toggleClass("ui-icon-minusthick");
			$(this).parents(".column div").find(".portlet-content").toggle();
		});
	});
	$.subscribe('onupdate', function(event, data) {
		var result = $("#sortableresult").empty();
		result.append("You move "
				+ $(event.originalEvent.ui.item).find(
						'.ui-widget-header > .title').html());
		result.append(' from ' + $(event.originalEvent.ui.sender).attr('id'));
		result.append(' to '
				+ $(event.originalEvent.ui.item).parent().attr('id'));
	});

	$(document).ready(function() {

		var myrichtextoptions = {};
		myrichtextoptions.jqueryaction = "myrichtextextend";
		myrichtextoptions.id = "richtextarea";
		myrichtextoptions.wysiwygoptions = {};
		myrichtextoptions.wysiwygoptions.resizeOptions = {};
		$.mys2jextend.bind($('#richtextarea'), myrichtextoptions);
	});
</script>
<style type="text/css">
div#main1 div {
	clear: both;
}

div#main2 {
	width: 700px
}
#sec1 {		
	margin: 30px 100px 30px 150px;
}
div#main3{
	float:left;
	}
#accordion {
	margin: 30px 100px 50px 150px;
}

#divInAccrodionItem {
	height: 180px
}

#divInAccrodionItem1 {
	height: 180px
}
#divrt1{
	margin: 30px 100px 30px 50px;
}
#divrt2{
	margin: 30px 100px 30px 50px;
}

</style>

<div id="main1">
<div id="main2"><s:url id="noticeurl" action="notice" /> <s:url
	id="activityurl" action="activity" /> <sj:accordion id="accordion">
	<sj:accordionItem title="แจ้งให้ทราบ">
		<sj:div id="divInAccrodionItem" href="%{noticeurl}" />
	</sj:accordionItem>
	<sj:accordionItem title="ข่าวและกิจกรรม">
		<sj:div id="divInAccrodionItem1" href="%{activityurl}" />
	</sj:accordionItem>
</sj:accordion></div>
<s:set id="contextPath"  value="#request.get('javax.servlet.forward.context_path')" />
<div id="sec1">
<div id="main3"> 
	<div id="divrt1">
	<s:form id="f1" action="save-notice" theme="xhtml">
	<sjr:ckeditor  name="notice"
	href="%{noticeurl}" id="rt" rows="8" cols="80" toolbar="MyToolbar" resizableMaxWidth="400"
	 customConfig="%{contextPath}/js/ckeditor.config.js" />
	 <sj:submit 
			id="s"
			targets="main1" 
			value="บันทึก การแจ้งให้ทราบ" 
			indicator="indicator" 
			button="true"
		/>
		<img id="indicator" 
			src="images/indicator.gif" 
			alt="Loading..." 
			style="display:none"/>
	 
	 </s:form></div>	 
	<div id="divrt2">
	<s:form id="f2" action="save-activity" theme="xhtml">	
	<sjr:ckeditor name="activity"
	href="%{activityurl}" id="rt1" rows="8" cols="80" toolbar="MyToolbar" resizableMaxWidth="400"
	 customConfig="%{contextPath}/js/ckeditor.config.js" />
	  <sj:submit  
			id="s1"
			targets="main1" 
			value="บันทึก กิจกรรม" 
			indicator="indicator" 
			button="true"
		/>
		<img id="indicator" 
			src="images/indicator.gif" 
			alt="Loading..." 
			style="display:none"/>
	 </s:form>
	</div>
	</div>
</div>
</div>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<link href="styles/ext.css" rel="stylesheet" type="text/css" />
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
<div id="main1">
<div id="div0">
  	<sj:div id="column1" cssClass="column"
	sortable="true" sortableConnectWith=".column"
	sortablePlaceholder="ui-state-highlight"
	sortableForcePlaceholderSize="true"
	sortableHandle="div.ui-widget-header" sortableCursor="crosshair"
	sortableOnUpdateTopics="onupdate">
<div id="div1">

	<div
		class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
	<div class="ui-widget-header ui-corner-all"><span class="title">แจ้งให้ทราบ</span><span
		class="ui-icon ui-icon-plusthick"></span></div>
	<div class="portlet-content"> 
	<u>22/10/2553</u><br>
	is well   equipped with the latest call center technology that fitted 
with the high volume   of call center environments. In addition our well
 trained agents have a great number of   experiences in handling 
different types of call solutions.  Need to find call center partner for
 your next marketing   campaign or CRM, Please feel free to 
 </div>
	</div>
</div>

<div id="div2">
	<div 
		class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
	<div class="ui-widget-header ui-corner-all"><span class="title">ข่าวและกิจกรรม</span><span
		class="ui-icon ui-icon-plusthick"></span></div>
	<div class="portlet-content"> 
	         
	<ul>                        
	<u>22/10/2553</u><br>
	                <li>Advertising Response Tracking <br>
                                                  </li><li>Complaint Management Service <br>
                                                  </li><li>Fulfillment Service <br>
                                                  </li><li>Information Center <br>
                                                  </li><li>Membership Subscriber Service <br>
                                                  </li><li>Pre-Event Registration</li></div>
      </ul>                                           
	</div>
	</div>
	<div id="div3"> 
	<textarea name="richtextarea" id="richtextarea" rows="15" cols="50">
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </textarea>
    </div>
</sj:div></div>

</div>



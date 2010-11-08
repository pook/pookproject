<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<sj:head jqueryui="true"/>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    $.subscribe('before', function(event,data) {
      var fData = event.originalEvent.formData;
         alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout );
      var form = event.originalEvent.form[0];
      if (form.echo.value.length < 2) {
          alert('Please enter a value with min 2 characters');
          // Cancel Submit comes with 1.8.0
          event.originalEvent.options.submit = false;
      }
    });
    $.subscribe('complete', function(event,data) {
         alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + 
     '\n\nThe output div should have already been updated with the responseText.');
    });
    $.subscribe('errorState', function(event,data) {
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status);
    });
    $.subscribe('rowadd', function(event,data) {
        $("#gridedittable").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:true}); 
    	});
        
    </script>       
  </head>
  <body>


<sj:div id="div2">
					<s:url id="remoteurl" action="json-test" />
					<!--  
					<s:url id="orderdetailsurl" action="jsonloadskus" />
					-->
					<s:url id="editurl" action="edit-grid-entry" />
					<sjg:grid id="gridedittable" caption="พระราม 4 " dataType="json"
						href="%{remoteurl}" pager="true" navigator="true"
						navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
						navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
						navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
						navigatorEdit="false" navigatorView="false" navigatorDelete="true"
						navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
						gridModel="gridModel" rowList="10,15,20" rowNum="15" width="1024"
						editurl="%{editurl}" editinline="true"
						onSelectRowTopics="rowselect" rownumbers="true">

						

						<sjg:gridColumn name="id" index="id"
							title="ID" sortable="true" editable="true" />
						<sjg:gridColumn name="name" 
							title="name" sortable="false" editable="true" />
					
				
					</sjg:grid>
					<br />
					<sj:submit id="grid_edit_addbutton" value="Add New"
						onClickTopics="rowadd" button="true" />
					<sj:submit id="grid_edit_searchbutton" value="Search"
						onClickTopics="searchgrid" button="true" />
					<sj:submit id="grid_edit_colsbutton" value="Show/Hide Columns"
						onClickTopics="showcolumns" button="true" />
					<br />
					<br />
				</sj:div>
				
</body>
</html>
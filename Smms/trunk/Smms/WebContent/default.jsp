<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
   <sj:head locale="th" jqueryui="true" jquerytheme="dark-hive"/>  
  <script 
		language="JavaScript" 
		src="${pageContext.request.contextPath}/struts/utils.js" 
		type="text/javascript">
	</script>
	<script 
		language="JavaScript" 
		src="${pageContext.request.contextPath}/struts/xhtml/validation.js" 
		type="text/javascript">
	</script>    
    
  </head>
  <body>
  <div>${pageContext.request.contextPath}</div>
  <div id="result">Submit form bellow.</div>
  
   <s:form id="formValidate" action="login" theme="xhtml">
     	<s:textfield 
     		id="loginuser" 
     		name="loginuser" 
     		label="User" 
     		required="true"
     	/>
     	<s:password 
     		id="loginpassword" 
     		name="loginpassword" 
     		label="Password" 
     		required="true"
     		
     	/>
    	<sj:submit 
    		targets="result" 
    		button="true" 
    		validate="true" 
    		effect="pulsate" 
    		value="Submit" 
    		indicator="indicator"
    		/>
    </s:form>   
  </body>
</html>
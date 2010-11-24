<%@ taglib prefix="s" uri="/struts-tags" %>
 <html>
<head>
</head>
 
<body>
<h1>Struts 2 URL tag example</h1>
 
<ol>
<li>
<img src="<s:url value="/images/man.jpg"/>" />
</li>
 
<li>
<a href="<s:url value="http://www.google.com"  />" target="_blank">Google</a>
</li>
 
<li>
<s:url action="urlTagAction.action" >
    <s:param name="id">123</s:param>
</s:url>
</li>
 
<li>
<s:url action="urlTagAction.action" var="urlTag" >
    <s:param name="name">mkyong</s:param>
</s:url>
<a href="<s:property value="#urlTag" />" >URL Tag Action (via property)</a>
</li>
 
<li>
<s:url action="urlTagAction.action" var="urlTag" >
    <s:param name="age">99</s:param>
</s:url>
<s:a href="%{urlTag}">URL Tag Action (via %)</s:a>
</li>
 
</ol>
 
</body>
</html>
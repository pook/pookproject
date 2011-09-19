<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="testResult" style="display: none"><s:property
	escape="%{test}" value="test" /></div>
<!-- 
<s:if test="hasActionErrors()">
	<s:iterator value="actionErrors">
		<span class="errorMessage"><s:property escape="false" /> </span>
	</s:iterator>
</s:if>
-->
<s:actionerror />

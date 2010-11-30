<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="testResult" style="display:none"> <s:property escape="%{test}" value="echo"/></div> 
<s:actionmessage />
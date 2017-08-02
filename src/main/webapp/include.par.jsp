<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="<%=baseUrl%>/images/favicon2.ico">
	<script type="text/javascript" src="<%=baseUrl%>/js/jquery-1.10.2.min.js"></script>
	<script src="<%=baseUrl%>/js/bootstrap-3.0.3/js/bootstrap.min.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/css/bootstrap.min.css" />
	<script type="text/javascript">
		var projectUrl;
		$(function(){
			projectUrl=$("#projectUrl").val();
		});
	
	</script>
	
</head>
	<input type="hidden" id="projectUrl" value="<%=baseUrl%>">
</html>
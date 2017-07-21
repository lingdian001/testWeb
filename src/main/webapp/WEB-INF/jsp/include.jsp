<%@ page language="java"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script type="text/javascript" src="<%=baseUrl%>/js/jquery-3.2.0.js"></script>
<script src="<%=baseUrl%>/js/bootstrap-3.0.3/js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/css/offcanvas.css" />


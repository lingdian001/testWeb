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
	<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/plugins/bootstrapvalidator/bootstrapValidator.min.css" />
	
	<script type="text/javascript" src="<%=baseUrl%>/js/jquery-1.10.2.min.js"></script>
	<script src="<%=baseUrl%>/js/bootstrap-3.0.3/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=baseUrl%>/js/bootstrap-3.0.3/plugins/table/bootstrap-table.min.js" type="text/javascript"></script> 
	<script src="<%=baseUrl%>/js/bootstrap-3.0.3/plugins/table/bootstrap-table-zh-CN.min.js" type="text/javascript"></script> 
	<script src="<%=baseUrl%>/js/bootstrap-3.0.3/plugins/bootstrapvalidator/bootstrapValidator.min.js" type="text/javascript"></script> 
	
	<script src="<%=baseUrl%>/js/util/bootstrapUtil.js" type="text/javascript"></script>
	<script src="<%=baseUrl%>/js/util/pub.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		var projectUrl;
		$(function(){
			projectUrl=$("#projectUrl").val();
		});
	
	</script>
	
</head>
	
	<body>
		<input type="hidden" id="projectUrl" value="<%=baseUrl%>">
		
		<!-- 模态弹出窗内容 -->
		<div class="modal" id="alertModal" data-backdrop="static" > 
			<div class="modal-dialog" >
				<div class="modal-content" >
					<div class="modal-header" style="background-color: #f5f5f5">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" >提示</h4>
					</div>
					<div class="modal-body">
						<p id="alertModalContext">模态弹出窗主体内容</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		
		
		
	</body>
</html>
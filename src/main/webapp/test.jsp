<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>表格</title>
	<meta name="keywords" content="表格">
	<meta name="description" content="这真的是一个表格" />
	<meta name="HandheldFriendly" content="True" />
	<link rel="shortcut icon" href="img/favicon.ico">
	
	<script type="text/javascript">
		$(function() {
			$(".btn").click(function() {
				$("#mymodal").modal();
			});
		});
	</script>

</head>

<body>
	<div>sdfsdfs</div>
	
	<button type="button" class="btn btn-warning" title="Popover title"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="右侧的 Popover 中的一些内容">
		右侧的 Popover
	</button>

	<!-- 触发模态弹出窗元素 -->
	<button class="btn btn-primary" type="button">点击我</button>
	<!-- 模态弹出窗内容 -->
	<div class="modal" id="mymodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">模态弹出窗标题</h4>
				</div>
				<div class="modal-body">
					<p>模态弹出窗主体内容</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>





</body>

</html>

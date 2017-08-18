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

<script type="text/JavaScript">
	$(function() {
		var height = document.documentElement.clientHeight;
		document.getElementById('iframe-page-content').style.height = height
				- 60 + 'px';
	});

	var menuClick = function(menuUrl) {
		$("#iframe-page-content").attr('src', menuUrl);
	};
</script>

</head>

<body>

	<div style="width: 100%;" >

		<!-- 左侧菜单栏 -->

		<div id="main-Container">

			<div id="sidebar" class="col-md-2 column" style="height: 300px;overflow-y: auto">

				<!-- 创建菜单树 -->

				<div class="col-md-12">
					<ul id="main-nav" class="nav nav-tabs nav-stacked" >
						<li>
								<a href="#systemSetting" class="nav-header collapsed"
									data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>index
										<span class="pull-right glyphicon glyphicon-chevron-down"></span>
								</a>
								<ul id="systemSetting" class="nav nav-list collapse secondmenu"
									style="height: 0px;">
									<li><a href="#"
										onclick="menuClick('${base}toViewInfo?id=${s.id}')"><i
											class="glyphicon glyphicon-user"></i>aaa</a></li>
									<li><a href="#" onclick="menuClick('${base}toTestList')"><i
											class="glyphicon glyphicon-th-list"></i>bbb</a></li>
								</ul>
						</li>

						<li>
							<a href="#systemSetting1" class="nav-header collapsed"
								data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>index1
									<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>

							<ul id="systemSetting1" class="nav nav-list collapse secondmenu"
								style="height: 0px;">
								<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>ccc</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-edit"></i>ddd</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>eee</a></li>
							</ul>
						</li>
						<li>
							<a href="#systemSetting3" class="nav-header collapsed"
								data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>index1
									<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>

							<ul id="systemSetting3" class="nav nav-list collapse secondmenu"
								style="height: 0px;">
								<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>ccc</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-edit"></i>ddd</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>eee</a></li>
							</ul>
						</li>
						
					</ul>
				</div>
			</div>

			<div class="col-md-10 column">
				<div class="breadcrumbs" id="breadcrumbs">
					<!-- 面包屑导航 -->
					<ul class="breadcrumb">
						<li>Home</li>
						<li class="active">Dashboard</li>
					</ul>
				</div>
				<!-- 内容展示页 -->
				<div>
					<iframe id="iframe-page-content" src="test2.jsp" width="100%"
						height="100%" frameborder="no" border="0" marginwidth="0"
						marginheight=" 0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
			</div>
			<!-- /.main-content -->

		</div>
		<!-- /.main-container -->

	</div>

</body>
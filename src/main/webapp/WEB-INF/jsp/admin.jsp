<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>首页</title>
	<style type="text/css">
	 	.navUl{background-color:#111111 }
	
	</style>
	
	<script type="text/javascript">
		$(function(){
			var height=document.documentElement.clientHeight;
			document.getElementById('iframePage').style.height=height-260+'px';
			changeTab('用户','user/user');
		});
	
		/**
		 * 改变标签的内容
		 */
		function changeTab(tabName,pageName){
			var url=projectUrl+"/sys/toFunPage.do?pageName="+pageName;
			$("#iframePage").attr("src",url);
		}
		
		/**根据html内容，弹出模态窗口**/		
		function openMainModal(contentHtml){
			var aa=$("#mainModal .modal-content").html(contentHtml);
			$("#mainModal").modal({ backdrop: 'static'});
		}
	
	</script>
</head>
<body>
	

	<!-- main -->
	<div class="container" style="background-color: #fafafa">
		<div style="height: 50px" >
	     	后台管理系统
	    </div>
	
	
		<div class="row row-offcanvas row-offcanvas-right" >
			<div id="sidebar" class="col-xs-12 col-sm-3 col-md-2" style="height: 300px;overflow-y: auto">
				<!-- 创建菜单树 -->
				<div class="col-md-12">
					<ul id="main-nav" class="nav nav-tabs nav-stacked" >
						<li >
							<a href="#userFun" class="nav-header collapsed" data-toggle="collapse"> 
								<i class="glyphicon glyphicon-list"></i>
								<span class="navUl">用户</span> 
								<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>
							<ul id="userFun" class="nav nav-list collapse secondmenu" style="height: 0px;">
								<li>
									<a href="#" onclick="changeTab('用户','user/user')">
									<i class="glyphicon glyphicon-list-alt"></i>aaa</a>
								</li>
								<li>
									<a href="#" onclick="changeTab('用户','user/user')">
									<i class="glyphicon glyphicon-list-alt"></i>bbb</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#post" class="nav-header collapsed active" data-toggle="collapse"> 
								<i class="glyphicon glyphicon-list"></i>海报
								<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>
							<ul id="post" class="nav nav-list collapse secondmenu" style="height: 0px;">
								<li>
									<a href="#" onclick="changeTab('用户','user/user')">
									<i class="glyphicon glyphicon-list-alt"></i>aaa</a>
								</li>
								<li>
									<a href="#" onclick="changeTab('用户','user/user')">
									<i class="glyphicon glyphicon-list-alt"></i>bbb</a>
								</li>
							</ul>
						</li>
						
					</ul>
				</div>
			</div>
			
			<div class="col-xs-12 col-sm-9 col-md-10 ">
				<div class="breadcrumbs" id="breadcrumbs">
					<!-- 面包屑导航 -->
					<ul class="breadcrumb">
						<li>Home</li>
						<li class="active">Dashboard</li>
					</ul>
				</div>
				<div class="panel panel-default">
				    <div class="panel-body">
 						<iframe  id="iframePage" src="" width="100%" height="100%" scrolling="auto" frameborder="no" ></iframe>				    
				    </div>
				</div>
			</div>
			
		</div>

		<hr/>
		<footer>
			<p>&copy; Company 2013</p>
		</footer>
		
		
		<!-- 模态弹出窗内容 -->
		<div class="modal fade in" id="mainModal" >
			<div class="modal-dialog">
				<div class="modal-content"></div>
			</div>
		</div>

	</div>


</body>
</html>
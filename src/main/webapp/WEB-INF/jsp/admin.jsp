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
			//document.getElementById('sidebar').style.height=height-160+'px';
			changeTab('后台管理','welcome');
		});
	
		/**
		 * 改变标签的内容
		 */
		function changeTab(tabName,pageName){
			var url=projectUrl+"/sys/toFunPage.do?pageName="+pageName;
			$("#iframePage").attr("src",url);
			var navs=tabName.split(',');
			var navsHtml='';
			for(i=0;i<navs.length;i++){
				if(i==navs.length-1){
					navsHtml+='<li class="active">'+navs[i]+'</li>';
				}else{
					navsHtml+='<li>'+navs[i]+'</li>';
				}
				
			}
			$('#breadcrumb').html(navsHtml);
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
	<div class="container" style="">
		<div class="row " >
			<div class="col-xs-12 col-sm-12 col-md-12" style="background-color: #EAF3FB" >
		     	<h3 class="text-center"><strong>后台管理系统</strong></h3>
		    </div>
		    
			<div id="sidebar" class="col-xs-12 col-sm-3 col-md-2" style="background-color:#F1F9FC;overflow-y: auto">
				<!-- 创建菜单树 -->
				<div class="col-md-12">
					<ul id="main-nav" class="nav nav-tabs nav-stacked" >
						<li >
							<a href="#userFun" class="nav-header collapsed" data-toggle="collapse"> 
								<i class="glyphicon glyphicon-cog"></i>
								<span>系统管理</span> 
								<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>
							<ul id="userFun" class="nav nav-list collapse secondmenu" style="height: 0px;">
								<li>
									<a href="#" onclick="changeTab('系统管理,用户管理','user/user')">
									<i class="glyphicon glyphicon-user"></i>用户管理</a>
								</li>
								<li>
									<a href="#" onclick="changeTab('系统管理,测试','user/user')">
									<i class="glyphicon glyphicon-refresh"></i>测试</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#post" class="nav-header collapsed active" data-toggle="collapse"> 
								<i class="glyphicon glyphicon-picture"></i>海报管理
								<span class="pull-right glyphicon glyphicon-chevron-down"></span>
							</a>
							<ul id="post" class="nav nav-list collapse secondmenu" style="height: 0px;">
								<li>
									<a href="#" onclick="changeTab('海报管理','user/user')">
									<i class="glyphicon glyphicon-play"></i>aaa</a>
								</li>
								<li>
									<a href="#" onclick="changeTab('海报管理','user/user')">
									<i class="glyphicon glyphicon-play"></i>bbb</a>
								</li>
							</ul>
						</li>
						
					</ul>
				</div>
			</div>
			
			<div class="col-xs-12 col-sm-9 col-md-10 ">
				<!-- 面包屑导航 -->
				<ol class="breadcrumb" style="background-color:#F1F9FC;width: 300px" id='breadcrumb'>
				</ol>
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
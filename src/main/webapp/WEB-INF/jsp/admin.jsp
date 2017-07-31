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
</head>
<body>
	<div style="height: 50px" >
     	说明.........
    </div>

	<!-- main -->
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-4 col-sm-4 col-md-4 " id="sidebar"
				role="navigation">
				<div class="list-group">
					<a href="#" class="list-group-item active">用户</a> <a href="#"
						class="list-group-item">海报</a> <a href="#" class="list-group-item">Link</a>
				</div>
			</div>
			<!--/span-->


			<div class="col-xs-8 col-sm-8 col-md-8 ">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab"> 菜鸟教程
					</a></li>
					<li><a href="#ios" data-toggle="tab">iOS</a></li>
					<li class="dropdown"><a href="#" id="myTabDrop1"
						class="dropdown-toggle" data-toggle="dropdown">Java <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
							<li><a href="#jmeter" tabindex="-1" data-toggle="tab">jmeter</a></li>
							<li><a href="#ejb" tabindex="-1" data-toggle="tab">ejb</a></li>
						</ul></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<p>菜鸟教程是一个提供最新的web技术站点，本站免费提供了建站相关的技术文档，帮助广大web技术爱好者快速入门并建立自己的网站。菜鸟先飞早入行——学的不仅是技术，更是梦想。</p>
					</div>
					<div class="tab-pane fade" id="ios">
						<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch
							和 Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS
							是苹果的移动版本。</p>
					</div>
					<div class="tab-pane fade" id="jmeter">
						<p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
					</div>
					<div class="tab-pane fade" id="ejb">
						<p>Enterprise Java
							Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web
							Logic 等）的 J2EE 上。</p>
					</div>
				</div>

			</div>



		</div>

		<hr>
		<footer>
			<p>&copy; Company 2013</p>
		</footer>

	</div>


</body>
</html>
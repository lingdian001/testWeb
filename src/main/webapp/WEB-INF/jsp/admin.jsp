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
	<script type="text/javascript">
		/**
		 * 改变标签的内容
		 */
		function changeTab(tabName,pageName){
			//$('#myTab a:first').html(tabName);
			var url=projectUrl+"/sys/toFunPage.do?pageName="+pageName;
			$("#iframePage").attr("src",url);
		}
	
	
	
	</script>
</head>
<body>
	

	<!-- main -->
	<div class="container" style="background-color: #fafafa">
		<div style="height: 50px" >
	     	后台管理系统
	    </div>
	
	
		<div class="row row-offcanvas row-offcanvas-right" style="height: 600px">
			<div class="col-xs-6 col-sm-3 col-md-2 " id="sidebar"
				role="navigation">
				<div class="list-group">
					<a href="#" class="list-group-item active" onclick="changeTab('用户','user/user')">用户</a> 
					<a href="#"	class="list-group-item" onclick="changeTab('海报','user/user')">海报</a> 
					<a href="#" class="list-group-item" onclick="changeTab('Link','user/user')">Link</a>
				</div>
			</div>
			
			<div class="col-xs-6 col-sm-9 col-md-10 ">
				<iframe id="iframePage" src="" width="100%" height="590px" frameborder="0"></iframe>
			</div>
			
		</div>

		<hr/>
		<footer>
			<p>&copy; Company 2013</p>
		</footer>

	</div>


</body>
</html>
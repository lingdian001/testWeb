<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>用户列表</title>
	<script type="text/javascript">
		$(function(){
			findall();
		});
		
		/**增加用户**/
		function addBtn(){
			hrefSubPage('user/add');
		}
		
		/**查询所有用户**/
		function selectAll(){
			$("#mymodal").modal();
		}
		
		/**修改用户**/
		function edit(){
			if($('table tbody tr').find('input:checked').length!=1){
				openMainModal('只允许选中一行');
			}else{
				
			}
		}
		
		/**删除用户**/
		function del(){
			if($('table tbody tr').find('input:checked').length<1){
				$("#alertModalContext").html('至少选中一行');
				$("#alertModal").modal();
			}
		}
		
		
		/**查询所有用户**/
		function findall() {
		 	$("#pageTable").bootstrapTable('destroy');
			$('#pageTable').bootstrapTable({
				method : 'post',
				contentType : "application/x-www-form-urlencoded",
				url : projectUrl + "/user/selectUsers.do",
				dataType : "json",
				pagination : true,//分页
				pageSize : 6, //默认显示的每页个数
				singleSelect : false,
				//设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
				queryParamsType : "undefined",
				queryParams : queryParams,
				sidePagination : "server", //服务端处理分页
				columns : [
						{
							title : '登录账号',
							field : 'loginId',
							align : 'center'
						},
						{
							title : '用户名',
							field : 'userName',
							align : 'center',
							valign : 'middle'
						},
						{
							title : '邮箱',
							field : 'email',
							align : 'center'
						},
						{
							title : '电话',
							field : 'telphone',
							align : 'center',
						} ],
						responseHandler : function(res) {  
				            return {  
				                total :res.total,  
				                rows : res.pageItems 
				            };  
				        },
				        onLoadSuccess: function(){
				        	initTableCheckbox('pageTable');
				        	$('#resultDiv').show();
				        }
			});
			
			/**查询参数**/
			function queryParams(params) {
				return {
					pageNumber: params.pageNumber,    
	                pageSize: params.pageSize,
	                loginId : $("#loginId").val(),
	                username : $('username').val()
				}
			}
		}
		
	</script>
</head>
<body>

	<div class="container" style="width: 100%;">

		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div style="padding: 0px 20px 40px;">
						<form class="form-inline">
							<div class="form-group">
								<label>登录账号：</label> <input type="text" class="form-control"
									id="loginId" style="width: 150px" placeholder="登录账号">
							</div>
							<div class="form-group">
								<label>用户名：</label> <input type="text" class="form-control"
									id="username" style="width: 150px" placeholder="用户名">
							</div>

							<div class="form-group" style="padding-left: 50px">
								<button type="button" class="btn btn-primary"
									onclick="findall()">查询</button>
							</div>
							
							<div class="form-group" style="padding-left: 50px">
								<button type="button" class="btn btn-default btn-sm"
									onclick="addBtn()">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
								</button>
							</div>
							
							
							
						</form>
				 </div>
				 
				 <div id="resultDiv" style="display: none;">
					<div class="panel-body">
						<div class="list-op" id="list_op">
							<button type="button" class="btn btn-default btn-sm"
								onclick="edit()">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
							</button>
							<button type="button" class="btn btn-default btn-sm"
								onclick="del()">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
					</div>
					<table class="table table-striped table-bordered table-hover"
						id="pageTable">
					</table>
				 </div>


			</div>
		</div>

	</div>


</body>
</html>
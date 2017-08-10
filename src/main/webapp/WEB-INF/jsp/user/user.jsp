<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- 	<link rel="stylesheet" type="text/css" href="<%=baseUrl%>/js/bootstrap-3.0.3/plugins/table/bootstrap-table.min.css" />
 --%>    
	<title>用户列表</title>
	<script type="text/javascript">
		$(function(){  
	        //initTableCheckbox();  
	    });
		
		
		/**增加用户**/
		function addBtn(){
			$("#mymodal").modal();
		}
		
		/**查询所有用户**/
		function selectAll(){
			$("#mymodal").modal();
		}
		
		/**修改用户**/
		function edit(){
			if($('table tbody tr').find('input:checked').length!=1){
				$("#alertModalContext").html('只允许选中一行');
				$("#alertModal").modal();
			}
		}
		
		/**删除用户**/
		function del(){
			if($('table tbody tr').find('input:checked').length<1){
				$("#alertModalContext").html('至少选中一行');
				$("#alertModal").modal();
			}
		}
		
		
		
		function findall() {
			$('#pageTable').bootstrapTable({
				method : 'post',
				contentType : "application/x-www-form-urlencoded",
				url : projectUrl + "/user/selectUsers.do",
				dataType : "json",
				pagination : true,//分页
				pageSize : 10, //默认显示的每页个数
				singleSelect : false,
				//设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
				queryParamsType : "undefined",
				queryParams : queryParams,
				sidePagination : "server", //服务端处理分页
				columns : [
						{
							title : '活动名称',
							field : 'userName',
							align : 'center',
							valign : 'middle'
						},
						{
							title : '状态',
							field : 'sex',
							align : 'center',
							valign : 'middle',
						},
						{
							title : '参与人数',
							field : 'age',
							align : 'center'
						},
						{
							title : '总人数',
							field : 'email',
							align : 'center'
						},
						{
							title : '开始时间',
							field : 'telphone',
							align : 'center',
						},
						{
							title : '操作',
							field : 'loginId',
							align : 'center',
							formatter : function(value, row,index) {
								var e = '<a href="#" mce_href="#" onclick="edit(\''+ row.id+ '\')">编辑</a> ';
								var d = '<a href="#" mce_href="#" onclick="del(\''+ row.id+ '\')">删除</a> ';
								return e + d;
							}
						} ],
						responseHandler : function(res) {  
				            return {  
				                total :res.total,  
				                rows : res.pageItems 
				            };  
				        },
				        onLoadSuccess: function(){
				        	initTableCheckbox();
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

	<div class="container" style="width: 100%">
		<div class="panel-group">  
            <div class="panel panel-primary">  
                <div class="panel-heading">用户列表 </div>
                <fieldset>
                	<legend style="color: #428bca">查询条件</legend>
                	<div style="padding: 0px 20px 40px;">

						<form class="form-inline">
							<div class="form-group">
								<label>登录账号：</label> 
								<input type="text" class="form-control" id="loginId" style="width: 150px" placeholder="登录账号">
							</div>
							<div class="form-group" style="padding-left: 50px">
								<label>用户名：</label> 
								<input type="text" class="form-control" id="username" style="width: 150px" placeholder="用户名">
							</div>
							
							<div style="padding-top: 20px;margin-left: 80%">
								<button type="button" class="btn btn-primary" onclick="findall()">查询</button>
							</div>
						</form>


					</div>
                </fieldset>
                
                
                
                <fieldset>
                	<legend  style="color: #428bca">查询结果</legend>
	                <div class="panel-body">  
	                    <div class="list-op" id="list_op">  
	                        <button id="addBtn" type="button" class="btn btn-default btn-sm"  onclick="addBtn()">  
	                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增  
	                        </button>  
	                        <button id="editBtn" type="button" class="btn btn-default btn-sm" onclick="edit()">  
	                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改  
	                        </button>  
	                        <button id="delBtn" type="button" class="btn btn-default btn-sm" onclick="del()">  
	                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除  
	                        </button>  
	                    </div>  
	                </div>  
	                <table  class="table table-striped table-bordered table-hover" id="pageTable"> </table>
	                
                </fieldset>
                
                
            </div>
        </div>
        
        
        <!-- 模态弹出窗内容 -->
		<div class="modal" id="addUsermodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">增加用户</h4>
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


	</div>


</body>
</html>
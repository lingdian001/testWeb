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
			//addUserForm();
	    });
		
		function test(){
			alert('i am child');
		}
		
		
		/**增加用户**/
		function addBtn(){
			window.parent.openMainModal($('#mainModal').html());
			window.parent.callSubMethod('initCheckUserForm');
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
		 	$("#pageTable").bootstrapTable('destroy');
			$('#pageTable').bootstrapTable({
				method : 'post',
				contentType : "application/x-www-form-urlencoded",
				url : projectUrl + "/user/selectUsers.do",
				dataType : "json",
				pagination : true,//分页
				pageSize : 5, //默认显示的每页个数
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

		/**初始化用户表单验证**/
		function initCheckUserForm(){
			$('#addUserForm',window.parent.document).bootstrapValidator({
				message: '无效的值',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	loginId: {
		                message: '登录账号无效',
		                validators: {
		                    notEmpty: {
		                        message: '登录账号不能为空'
		                    },
		                    stringLength: {
		                        min: 6,
		                        max: 30,
		                        message: '长度在6-30之间'
		                    },
		                    regexp: {
		                        regexp: /^[a-zA-Z0-9_\.]+$/,
		                        message: '登录账号包含字母，数字，下划线，点'
		                    },
		                    remote: {
		                        type: 'POST',
		                        url: projectUrl+'/user/checkUser.do',
		                        message: '此登录账号已经存在了'
		                    },
		                    different: {
		                        field: 'password,confirmPassword',
		                        message: '密码和确认密码不一致'
		                    }
		                }
		            },
		            password: {
		                validators: {
		                    notEmpty: {
		                        message: '密码不能为空'
		                    },
		                    different: {
		                        field: 'loginId',
		                        message: '登录账号和密码不能相同'
		                    }
		                }
		            },
		            userName: {
		                validators: {
		                    notEmpty: {
		                        message: '用户名不能为空'
		                    }
		                }
		            },
		            confirmPassword: {
		                validators: {
		                    notEmpty: {
		                        message: '确认密码不能为空'
		                    },
		                    identical: {
		                        field: 'password',
		                        message: '密码和确认密码不相同'
		                    }
		                }
		            },
		            telphone: {
		                 validators: {
		                     notEmpty: {
		                         message: '手机号码不能为空'
		                     },
		                     stringLength: {
		                         min: 11,
		                         max: 11,
		                         message: '请输入11位手机号码'
		                     },
		                     regexp: {
		                         regexp: /^1[3|5|8]{1}[0-9]{9}$/,
		                         message: '请输入正确的手机号码'
		                     }
		                 }
		             },
		             email: {
		                validators: {
		                    emailAddress: {
		                        message: '邮箱地址格式不正确'
		                    }
		                }
			         },
			            
		            
		        }
			});
			
		}
		
		/**保存用户**/
		function addUser(){
			$.ajax({
				type :'POST',
		        url : projectUrl+'/user/saveUser.do',
		        data : $('#addUserForm',window.parent.document).serializeArray(),
		        dataType : "json",
		        cache : false,
		        success : function(re){
		        	if(re.isSuccess==true){
		        		alert('success');
		        		$("#mymodal").modal();
		        	}else{
		        		alert('error');
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		        	alert(errorThrown);
		        }
			});
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


		<!-- 模态弹出窗内容 -->
		<div class="modal fade in" >
			<div class="modal-dialog">
				<div class="modal-content" id="mainModal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">增加用户</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id='addUserForm'>
							<div class="form-group">
								<label class="col-sm-2 control-label">登录账号</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="loginId"
										placeholder="登录账号">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="password"
										placeholder="密码">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">确认密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="confirmPassword"
										placeholder="确认密码">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="userName"
										placeholder="用户名">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="telphone"
										placeholder="电话">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">邮箱</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="email"
										placeholder="邮箱">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="callSubMethod('addUser')">保存</button>
					</div>
				</div>

			</div>
		</div>




	</div>


</body>
</html>
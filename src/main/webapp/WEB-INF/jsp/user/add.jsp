<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增用户</title>
	<script type="text/javascript">
		$(function(){
			initCheckUserForm();
			
		});
	
		/**初始化用户表单验证**/
		function initCheckUserForm(){
			$('#addUserForm').bootstrapValidator({
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
		        data : $('#addUserForm').serializeArray(),
		        dataType : "json",
		        cache : false,
		        success : function(re){
		        	if(re.isSuccess==true){
		        		hrefSubPage('user/index');
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
	<div class="container">
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
			
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-9">
					<button type="button" class="btn btn-primary"
						onclick="addUser()">保存</button>
					<button type="button" class="btn btn-success" onclick="hrefSubPage('user/index')">返回列表</button>
				</div>
			</div>
			
		</form>
	
	
	
	</div>


</body>
</html>
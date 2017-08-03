<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="<%=baseUrl%>/js/util/bootstrapUtil.js" type="text/javascript"></script> 
	<title>用户列表</title>
	<script type="text/javascript">
		$(function(){  
	        initTableCheckbox();  
	    });
		
		
		/**增加用户**/
		function addBtn(){
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
		
	</script>
</head>
<body>

	<div class="container" style="width: 100%">
		<div class="panel-group">  
            <div class="panel panel-primary">  
                <div class="panel-heading">用户列表 </div>
                <fieldset>
                	<legend>查询条件</legend>
                	<div style="padding: 0px 20px 40px;">
                		<form action="">
	                		<div class="input-group" style="width: 300px">
								<span class="input-group-addon">登录账号：</span>
								<input type="text" class="form-control" placeholder="登录账号">
							</div>
                		</form>
                	</div>
                </fieldset>
                
                
                
                <fieldset>
                	<legend>查询结果</legend>
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
	                <table class="table table-bordered table-hover">  
	                    <thead>  
	                        <tr class="success">  
	                            <th>登录账号</th>  
	                            <th>用户名</th>  
	                            <th>邮箱</th>  
	                        </tr>  
	                    </thead>  
	                    <tbody>  
	                        <tr>  
	                            <td>test1</td>  
	                            <td>测试1</td>  
	                            <td>1@qq.com</td>  
	                        </tr>  
	                        <tr>  
	                            <td>test2</td>  
	                            <td>测试2</td>  
	                            <td>2@qq.com</td>  
	                        </tr>  
	                    </tbody>  
	                </table>  
	                <div class="panel-footer">  
	                    <nav>  
	                        <ul class="pagination pagination-sm">  
	                            <li class="disabled">  
	                                <a href="#" aria-label="Previous">  
	                                    <span aria-hidden="true">«</span>  
	                                </a>  
	                            </li>  
	                            <li class="active"><a href="#">1</a></li>  
	                            <li><a href="#">2</a></li>  
	                            <li><a href="#">3</a></li>  
	                            <li><a href="#">4</a></li>  
	                            <li><a href="#">5</a></li>  
	                            <li>  
	                                <a href="#" aria-label="Next">  
	                                    <span aria-hidden="true">»</span>  
	                                </a>  
	                            </li>  
	                        </ul>  
	                    </nav>  
	                </div> 
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
/*!
 * 公共页面用到的js
 * **/

/**跳转到子页面*/
function hrefSubPage(pageName){
	var url=projectUrl+"/sys/toFunPage.do?pageName="+pageName;
	$("#iframePage",window.parent.document).attr("src",url);
}
/**根据html内容，弹出模态窗口**/		
function openMainModal(contentHtml){
	var aa=$("#mainModal .modal-content").html(contentHtml);
	$("#mainModal").modal({ backdrop: 'static'});
}

/**调用子页面方法**/
function callSubMethod(methodName){
	document.getElementById("iframePage").contentWindow.eval(methodName+'()');
}
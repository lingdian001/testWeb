<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include.par.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>编辑11</title>
	<script type="text/javascript" charset="utf-8" src="<%=baseUrl %>/js/uedit1.4/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=baseUrl %>/js/uedit1.4/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=baseUrl %>/js/uedit1.4/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div>
	    <h5>测试11</h5>
	    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
	</div>
	
	<div>
		<button onclick="getAllHtml()">获得整个html的内容</button>
        <button onclick="getContent()">获得内容</button>
	</div>
	
	<script type="text/javascript">
	 var ue = UE.getEditor('editor');
	 UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	 UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage') {
            return '<%=baseUrl %>/pub/uploadfile.do'; 
        }else {
            return this._bkGetActionUrl.call(this, action);
        }
	 } 
	 
	 function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml());
     }
	 
     function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
     }
    
     function callback(){alert('1');
         try{
             var link, json, loader,
                 body = (iframe.contentDocument || iframe.contentWindow.document).body,
                 result = body.innerText || body.textContent || '';
             //这里result就是后端返回的数据
             json = (new Function("return " + result))();
             //imageUrlPrefix这个很重要很重要很重要，如果没配置的话，图片可能显示不出来
             //link就是图片的路径
             link = me.options.imageUrlPrefix + json.url;
             if(json.state == 'SUCCESS' && json.url) {
                 loader = me.document.getElementById(loadingId);
                 loader.setAttribute('src', link);
                 loader.setAttribute('_src', link);
                 loader.setAttribute('title', json.title || '');
                 loader.setAttribute('alt', json.original || '');
                 loader.removeAttribute('id');
                 domUtils.removeClasses(loader, 'loadingclass');
             } else {
                 showErrorLoader && showErrorLoader(json.state);
             }
         }catch(er){
             showErrorLoader && showErrorLoader(me.getLang('simpleupload.loadError'));
         }
         form.reset();
         domUtils.un(iframe, 'load', callback);
     }
     function showErrorLoader(title){
         if(loadingId) {
             var loader = me.document.getElementById(loadingId);
             loader && domUtils.remove(loader);
             me.fireEvent('showmessage', {
                 'id': loadingId,
                 'content': title,
                 'type': 'error',
                 'timeout': 4000
             });
         }
     }
	
	
	</script>

</body>
</html>
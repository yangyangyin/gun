/**
 * 
 * @requires jQuery
 * 
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
	contentType: "application/x-www-form-urlencoded;charset=utf-8",
    error : function(XMLHttpRequest, textStatus, errorThrown) {
        try {
            parent.$.messager.progress('close');
            parent.$.messager.alert('错误', XMLHttpRequest.responseText);
        } catch (e) {
            alert(XMLHttpRequest.responseText);
        }
    },
    complete: function(XMLHttpRequest, textStatus, xhr) {
        //ajax session超时处理:通过XMLHttpRequest取得响应头,oauthstatus
        var oauthstatus = XMLHttpRequest.getResponseHeader("oauthstatus");
        if(oauthstatus == '401'){
            self.location.href = basePath + "/login";
            return;
        }
    }
});
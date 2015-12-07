<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ww-评论发表</title>
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="/css/myCss.css" rel="stylesheet" type="text/css" />
<link href="/css/font-awesome.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.form.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#submit").click(function() {
		var options = {
			type: 'post',
			success : function(data) {
				$("#ajax-Message").empty().append(data);
				$("#ajax-Message").on("click", function() {
					hideMessage();
				});	
			},
			error: function() {
				alert("add issue error!");
			}
		};
		$("#add-blessing-data-form").ajaxSubmit(options);
	});
});

//隐藏提示消息/并且删除提示消息
function hideMessage() {
	$("#ttm-message").hide();
}


//祝福添加操作成功之后 对数据操作
function operateSuccessData(data) {
	var ajax_Message = $("#ajax-Message");
	//清空元素,添加数据到对象
	ajax_Message.empty().append(data);
	//绑定事件
	ajax_Message.on("click", function() {
		hideMessage();
	});	
}
</script>
</head>

<body>
	<%-- 公用头部 --%>
	<%@include file="head.jsp" %>
    <!-- 面包屑 -->
    <div class="container margin10">
    	<ul class="breadcrumb">
        	<li><a href="#">首页</a><span class="divider">\</span></li>
            <li class="disabled">发表评论</li>
        </ul>
    </div><!-- 面包屑 end -->
    <div id="main" class="container">
        <!-- 用于存放Ajax请求数据 -->
    	<div id="ajax-Message"></div>
        <table class="table table-bordered table-condensed">
        	<caption><h2>评论详情</h2></caption>
			<tr>
            	<td>
                	<form action="/b/addBlessingData" method="post" id="add-blessing-data-form" class="form-horizontal">
                    	<div class="margin10">
                            <label for="exampleInputName1" class="ttm-control-label">Name</label>
                           	<input name="bleName" type="text" class="input-xxlarge" id="exampleInputName1" placeholder="Jane Doe" />
                        </div>
                        <div class="margin10">
                            <label for="exampleInputName2" class="ttm-control-label">Date</label>
                            <input name="bleTime" type="text" class="input-xxlarge" id="exampleInputName2" placeholder="${requestScopeShow.currentTimeShow}" value="${requestScope.currentTimeHidden}" readonly />
                        </div>
                        <div class="margin10">
                           	<label for="exampleInputName3" class="ttm-control-label">content</label>
                            <textarea name="bleContent" class="form-control input-xxlarge" rows="12" cols="1" id="exampleInputName3" placeholder="输入你想说的吧！"></textarea>
                        </div>
                        <div class="margin10">
                            <label for="exampleInputName3" class="ttm-control-label">&nbsp;</label>
                        	<button id="submit" type="button" class="btn btn-primary btn-large">Save</button>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
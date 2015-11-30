<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章显示</title>
<script src="<%=basePath %>js/jquery.js"></script>
<script src="<%=basePath %>js/jquery.form.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var options = {
				type : 'post',
				success : function(data) {
					$("#comment-list").html(data);
				}
			};
		
		$("#addComment").click(function() {
			$("#commentForm").ajaxSubmit(options);
		});
	});
</script>
</head>
<body>

	<h2>
		<c:out value="${requestScope.essay.title}" default="未知错误" />
	</h2>
	<div>
		<c:out value="${requestScope.essay.body}" default="未知内容"></c:out>
	</div>
	<div id="comment-list">
		<%@include file="comment.jsp" %>	
	</div>
	<form id="commentForm" action="/c/addComment" method="post">
		评论:<textarea name="content"></textarea>
		<input name="essayId" type="hidden" value='<c:out value="${requestScope.essay.id}" default="-1" />' />
	</form>
	<input type="button" value="评论" id="addComment"/>
</body>
</html>
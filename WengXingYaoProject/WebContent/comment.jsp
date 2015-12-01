<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${commentList.size()==0}">
	<div>没有评论</div>
</c:if>
<c:if test="${commentList.size()!=0}">
	<style type="text/css">
		.comment-show > span > * {
			padding:0px;
			margin:0px;
			border:0px;
			font-size:12px;
			font-weight:500;
		}
	</style>
	<c:forEach items="${requestScope.commentList}" var="comment">
		<div class="comment-show">
			<span style="margin:0px 5px;">${comment.id}</span>
			<span style="margin:0px 5px;">${comment.createData}</span>
			<span style="margin:0px 5px;">${comment.content}</span>
		</div>
	</c:forEach>
	<c:if test="${requestScope.commentList.size() >= 1}">
		<div style="border:1px solid #cccccc;">
			<%-- 是否有上一页判断 --%>     
			<c:if test="${sessionScope.commentPage.previous==true}">
				<a class="cur" href="javascript:void(0)" p="1">首页</a>
				<a class="cur" href="javascript:void(0)" p="${sessionScope.commentPage.pageNumber-1}">上一页</a>
			</c:if>
			<c:if test="${sessionScope.commentPage.previous==false}">
				<a>首页</a>
				<a>上一页</a>
			</c:if>
			
			<%-- 显示点击翻页效果 --%>
			<c:forEach items="${requestScope.showPage}" var="pn">
				<a class="cur" href="javascript:void(0)" p="${pn}">${pn}</a>
			</c:forEach>
			
			<%-- 是否有下一页判断 --%>
			<c:if test="${sessionScope.commentPage.next==false}">
				<a>下一页</a>
				<a>尾页</a>
			</c:if>
			<c:if test="${sessionScope.commentPage.next==true}">
				<a class="cur" href="javascript:void(0)" p="${sessionScope.commentPage.pageNumber+1}">下一页</a>
				<a class="cur" href="javascript:void(0)" p="${sessionScope.commentPage.totalPage}">尾页</a>
			</c:if>
		</div>
	</c:if>
</c:if>
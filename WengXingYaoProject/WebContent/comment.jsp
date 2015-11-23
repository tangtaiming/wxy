<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${commentList.size()==0}">
	<div>没有评论</div>
</c:if>
<c:if test="${commentList.size()!=0}">
	<c:forEach items="${requestScope.commentList}" var="comment">
		<div>
			<span style="margin:0px 5px;">${comment.id}</span>
			<span style="margin:0px 5px;">${comment.createData}</span>
			<span style="margin:0px 5px;">${comment.content}</span>
		</div>
	</c:forEach>
	<c:if test="${requestScope.commentList.size() >= 1}">
		<div style="border:1px solid #cccccc;">
			<%-- 是否有上一页判断 --%>     
			<c:if test="${sessionScope.commentPage.isUpPage==true}">
				<a href="/e/essays/1">首页</a>
				<a href="/e/essays/${sessionScope.commentPage.currentPage-1}">上一页</a>
			</c:if>
			<c:if test="${sessionScope.commentPage.isUpPage==false}">
				<a>首页</a>
				<a>上一页</a>
			</c:if>
			
			<%-- 显示点击翻页效果 --%>

			<c:forEach items="${sessionScope.commentPage.pageNumber}" var="pn">
				<a href="/e/essays/${pn}">${pn}</a>
			</c:forEach>
			
			
			<%-- 是否有下一页判断 --%>
			<c:if test="${sessionScope.commentPage.isDownPage==false}">
				<a>下一页</a>
				<a>尾页</a>
			</c:if>
			<c:if test="${sessionScope.commentPage.isDownPage==true}">
				<a href="/e/essays/${sessionScope.commentpage.currentPage+1}">下一页</a>
				<a href="/e/essays/${sessionScope.commentpage.totalPage}">尾页</a>
			</c:if>
		</div>
	</c:if>
</c:if>
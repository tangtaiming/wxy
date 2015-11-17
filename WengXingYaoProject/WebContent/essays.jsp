<%@page import="com.application.util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${requestScope.essayList}" var="essay" varStatus="status">
		<div style="margin: 10px; border:1px solid #ff7300;">
			<p> 
					id : ${essay.id}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					title : ${essay.title}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					click : ${essay.click}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					user : ${essay.user}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					writer : ${essay.writer}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					color : ${essay.color}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					description : ${essay.description}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					keywords : ${essay.keywords}
				<span style="margin: 0px 5px 0px 5px; padding:5px;"></span>
					body : ${essay.body}
			</p> 
		</div>
	</c:forEach>
	<c:if test="${requestScope.essayList.size() >= 1}">
		<div style="border:1px solid #cccccc;">
			<%-- 是否有上一页判断 --%>     
			<c:if test="${sessionScope.page.isUpPage==true}">
				<a href="/e/essays/1">首页</a>
				<a href="/e/essays/${sessionScope.page.currentPage-1}">上一页</a>
			</c:if>
			<c:if test="${sessionScope.page.isUpPage==false}">
				<a>首页</a>
				<a>上一页</a>
			</c:if>
			
			<%-- 显示点击翻页效果 --%>
			
			<%
				//获取jsp页面的session
				Page tempPage = (Page) session.getAttribute("page");
				for (int x = tempPage.getCurrentPage(); x < tempPage.getCurrentPage() + 4; x++) {
			%>
					<a href="/e/essays/<%=x%>"><%=x%></a>				
			<%
				}
			%>
			
			<%-- 是否有下一页判断 --%>
			<c:if test="${sessionScope.page.isDownPage==false}">
				<a>下一页</a>
				<a>尾页</a>
			</c:if>
			<c:if test="${sessionScope.page.isDownPage==true}">
				<a href="/e/essays/${sessionScope.page.currentPage+1}">下一页</a>
				<a href="/e/essays/${sessionScope.page.totalPage}">尾页</a>
			</c:if>
		</div>
	</c:if>
</body>
</html>
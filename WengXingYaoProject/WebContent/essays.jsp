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
	<c:if test="${requestScope.essayList.size() > 2}">
		<div style="border:1px solid #cccccc;">
			<a href="">首页</a>
			<a href="">上一页</a>
			<a href="">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href="">下一页</a>
			<a href="">尾页</a>
		</div>
	</c:if>
</body>
</html>
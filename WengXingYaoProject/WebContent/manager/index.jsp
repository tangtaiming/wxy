<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎进入星耀管理页面</title>
</head>
<body>

		<c:if test="${empty sessionScope.loginUser==false}">
			登录成功
		</c:if>
		<c:if test="${empty sessionScope.loginUser==true}">
			登录失败
		</c:if>

</body>
</html>
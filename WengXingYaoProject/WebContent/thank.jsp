<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="/css/myCss.css" rel="stylesheet" type="text/css" />
<title>感谢大家</title>
</head>

<body>
	<%-- 公用头部 --%>
	<%@include file="head.jsp" %>
    <!-- 面包屑 -->
    <div class="container margin10">
    	<ul class="breadcrumb">
        	<li><a href="#">首页</a><span class="divider">\</span></li>
            <li class="disabled">感谢</li>
        </ul>
    </div><!-- 面包屑 end -->
    <div class="container">
    	<c:if test="${requestScope.thank==null}">
    		<div class="thank_index margin10">
	            <h3 class="text-center">未知错误</h3>
	            <div class="text-left">
	                &nbsp;&nbsp;&nbsp;&nbsp;网址君,不知道飞哪里去玩了.稍后再来吧！
	            </div>
	        </div>
    	</c:if>
    	<c:if test="${requestScope.thank!=null}">
    		<div class="thank_index margin10">
	            <h3 class="text-center">${requestScope.thank.title}</h3>
	            <div class="text-left">
	                &nbsp;&nbsp;&nbsp;&nbsp;${requestScope.thank.content}
	            </div>
	        </div>
    	</c:if>
    </div>
</body>
</html>

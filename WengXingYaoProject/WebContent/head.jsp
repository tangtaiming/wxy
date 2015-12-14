<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div class="container margonBottom10">
    	<div class="row">
            <div class="span1"><a class="color_white <c:if test='${requestScope.action==null}'>headerChange</c:if>" href="/">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></div>
            <div class="span1"><a class="color_white <c:if test='${requestScope.action=="addBlessingData"}'>headerChange</c:if>" href="/b/addBlessingData">发表评论</a></div>
            <div class="span1"><a class="color_white <c:if test='${requestScope.action=="showThank"}'>headerChange</c:if>" href="/t/showThank">感&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;谢</a></div>
            <div class="span8"></div>
        </div>
    </div>
</div><!-- header end -->
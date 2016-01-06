<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../security.jsp" %>
<div class="right01">
	<img src="/img/04.gif" /> <a href="javascript:;" onclick="managerAjax('/b/blessingManager')">祝福管理</a>
</div>
<div id="xt-input-001" class="xt-input">
	<span>祝福内容</span><input type="text" class="int-text" />
	<span>网名</span><input type="text" class="int-text" /> 
	<input type="button" value="搜 索" class="green-int" />
</div>
<%@include file="index-data.jsp" %>

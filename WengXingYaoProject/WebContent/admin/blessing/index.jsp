<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right01">
	<img src="/img/04.gif" /> 用户信息查询
</div>
<div id="xt-input-001" class="xt-input">
	<span>账号类型</span> <select class="int-text">
		<option>选项一</option>
		<option>选项二</option>
		<option>选项三</option>
		<option>选项四</option>
		<option>选项五</option>
	</select> <span>账号/邮箱</span><input type="text" class="int-text" /> <span>审核/状态</span>
	<select class="int-text">
		<option>选项一</option>
		<option>选项二</option>
		<option>选项三</option>
		<option>选项四</option>
		<option>选项五</option>
	</select> <span>来源</span><input type="text" class="int-text" /> <input
		type="button" value="搜 索" class="green-int" />
</div>
<%@include file="index-data.jsp" %>

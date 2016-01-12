<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="javascript:;" name="praise-${blessing.id}" curId="${blessing.id}" showcount="${blessing.praiseNumber}" praisestatus="${upraiseStatus}" onclick="praiseAjax(this)"> 
	<i class="ttm_i_img icon-thumbs-up"></i> 
	<i class="ttm_i_text">
		<c:if test="${blessing.praiseNumber!=0}">
			<c:if test="${upraiseStatus eq 'minus'}">取消赞</c:if>
			<c:if test="${upraiseStatus eq 'add'}">赞</c:if>(${blessing.praiseNumber})
		</c:if>
		<c:if test="${blessing.praiseNumber==0}">赞</c:if>
	</i>
</a>
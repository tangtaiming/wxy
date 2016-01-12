<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul>
	<c:forEach var="praiseBlessing" items="${requestScope.praiseBlessing}" varStatus="status">
	    <li class="top">
	        <em>${status.count}</em>
	        <p>
	        	<a href="javascript:;" title="${praiseBlessing.bleContent}" target="_blank">${fn:substring(praiseBlessing.bleContent, 0, 20)}</a>
	        </p>
	        <span class="num">赞(${praiseBlessing.praiseNumber})</span>
	    </li>
    </c:forEach>
</ul>
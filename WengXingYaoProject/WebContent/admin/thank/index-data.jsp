<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../security.jsp" %>
<div id="xt-table-001" class="xt-table">
	<table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
		<tr>
			<th>ID</th>
			<th>标题</th>
			<th class="context">感谢内容</th>
			<th>创建时间</th>
			<th>创建人</th>
			<th>操作</th>
		</tr>
		<tr>
			<td><c:out value="${requestScope.thank.id}" default="--" /></td>
			<td>
				<c:out value="${requestScope.thank.title}"
					default="--" />
			</td>
			<td class="context" style="text-align: left;"><c:out value="${requestScope.thank.content}" default="--" /></td>
			<td><c:out value="${requestScope.thank.createTime}" default="--" /></td>
			<td><c:out value="${requestScope.showUser.userName}" default="--" /></td>
			<td>
				<a href="javascript:;" class="blue-xt" onclick="editRow('/t/thankEdit', <c:out value='${requestScope.thank.creator}' default='0'/>);">编辑</a>
				<a href="#" class="red-xt" id="delete-row-1" onclick="deleteRow(this)">删除</a>
			</td>
		</tr>
	</table>
</div>
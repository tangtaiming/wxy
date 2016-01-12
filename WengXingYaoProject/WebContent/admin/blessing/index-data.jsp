<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="xt-table-001" class="xt-table">
	<table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc"
		width="100%">
		<tr>
			<th>ID</th>
			<th class="context">祝福内容</th>
			<th>发布时间</th>
			<th>发布IP</th>
			<th>网名</th>
			<th>赞</th>
			<th>赞总数量</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.blessingList}" var="blessing">
			<tr>
				<td><c:out value="${blessing.id}" default="--" /></td>
				<td class="context"><c:out value="${blessing.bleContent}"
						default="--" /></td>
				<td><c:out value="${blessing.bleTime}" default="--" /></td>
				<td><c:out value="${blessing.bleIp}" default="--" /></td>
				<td><c:out value="${blessing.bleName}" default="--" /></td>
				<td><c:out value="${blessing.praise}" default="0" /></td>
				<td><c:out value="${blessing.praiseNumber}" default="0" /></td>
				<td><a href="javascript:;" class="blue-xt"
					onclick="editRow('/b/blessingEdit', <c:out value='${blessing.id}' default='0'/>);">编辑</a>
					<a href="#" class="red-xt" id="delete-row-1"
					onclick="deleteRow(this)">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="xt-fenye-001" class="xt-fenye">
		<div class="xt-fenye-left">
			当前第
			<c:out value="${requestScope.blessingPage.pageNumber}" default="1" />
			/
			<c:out value="${requestScope.blessingPage.totalPage}" default="1" />
			页, 每页
			<c:out value="${requestScope.blessingPage.pageSize}" default="1" />
			条，共
			<c:out value="${requestScope.blessingPage.totalNumber}" default="1" />
			条记录
		</div>
		<div class="xt-fenye-right">
			<c:if test="${requestScope.blessingPage.previous==true}">
				<a href="javascript:;"
					onclick="managerPageAjax('/b/blessingManagerPage', 1);">首页</a>
				<a href="javascript:;"
					onclick="managerPageAjax('/b/blessingManagerPage', ${requestScope.blessingPage.pageNumber-1 <= 0 ? requestScope.blessingPage.pageNumber : requestScope.blessingPage.pageNumber-1});">上一步</a>
			</c:if>
			<c:if test="${requestScope.blessingPage.next==true}">
				<a href="javascript:;"
					onclick="managerPageAjax('/b/blessingManagerPage', ${requestScope.blessingPage.pageNumber+1 > requestScope.blessingPage.totalPage ? requestScope.blessingPage.totalPage : requestScope.blessingPage.pageNumber+1});">下一步</a>
				<a href="javascript:;"
					onclick="managerPageAjax('/b/blessingManagerPage', ${requestScope.blessingPage.totalPage});">尾页</a>
			</c:if>
			<input type="text" name="text" /> <a href="#" class="xt-link">跳转</a>
		</div>
	</div>
</div>

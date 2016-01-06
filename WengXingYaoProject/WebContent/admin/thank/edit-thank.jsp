<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../security.jsp" %>
<div class="right01"><img src="/img/04.gif" /> <a href="javascript:;" onclick="managerAjax('/t/thankManager');">感谢管理</a>  <img src="/img/04.gif" /> <a href="javascript:;" onclick="editRow('/t/thankEdit', <c:out value='${requestScope.thankEdit.creator}' default='0'/>);">编辑</a></div>
<form id="from-entity" class="xt-form-table" action="/t/thankEdit/${requestScope.thankEdit.id}" method="post">
    <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
        <tr>
            <th colspan="2">
            	感谢编辑
            	<input type="hidden" name="creator" value="${requestScope.thankEdit.creator}" />
            </th>
        </tr>
        <tr>
            <td class="entity-property" width="150px;">
            	<label for="title-entity-${requestScope.thankEdit.id}">标题</label>
            </td>
            <td>
            	<input type="text" name="title" id="title-entity-${requestScope.thankEdit.id}" value="${requestScope.thankEdit.title}" placeholder=" 请输入标题" must=""/>
            </td>
        </tr>
        <tr>
            <td class="entity-property" width="150px;">
            	<label for="content-entity-${requestScope.thankEdit.id}">内容</label>
            </td>
            <td>
            	<textarea id="content-entity-${requestScope.thankEdit.id}" name="content" must="must">${requestScope.thankEdit.content}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="submit">
            	<input type="button" value="保存" class="green-int" onclick="editRowSaveThank('from-entity');" />
            </td>
        </tr>    
    </table>
</form>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../security.jsp" %>
<div class="right01"><img src="/img/04.gif" /> <a href="javascript:;" onclick="managerAjax('/b/blessingManager')">祝福管理</a> <img src="/img/04.gif" /> <a href="javascript:;" onclick="editRow('/b/blessingEdit', <c:out value='${blessing.id}' default='0'/>);">编辑</a></div>
<form id="xt-form-table-001" class="xt-form-table" action="/b/blessingEdit/${requestScope.blessing.id}" method="post">
    <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
        <tr>
            <th colspan="2">
            	祝福编辑
            	<input type="hidden" name="id" value="${requestScope.blessing.id}" />
            </th>
        </tr>
        <tr>
            <td class="entity-property" width="150px;">
            	<label for="blessing-name">网名</label>
            </td>
            <td>
            	<input type="text" name="bleName" id="blessing-name" value="${requestScope.blessing.bleName}" placeholder=" 请输入网名" />
            </td>
        </tr>
        <tr>
            <td class="entity-property" width="150px;">
            	<label for="blessing-content">内容</label>
            </td>
            <td>
            	<textarea id="blessing-content" name="bleContent">${requestScope.blessing.bleContent}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="submit">
            	<input type="button" value="保存" class="green-int" onclick="editRowSave('xt-form-table-001')" />
            </td>
        </tr>    
    </table>
</form>

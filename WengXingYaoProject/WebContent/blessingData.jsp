<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${requestScope.blessingList.size() <= 0}">
   	没有数据呢！
</c:if>
<c:if test="${requestScope.blessingList.size() > 0}">
	<c:forEach items="${requestScope.blessingList}" var="blessing">
		<div class="ttm_div">
			<span href="#" class="ttm_span">
				<div class="ttm_img">
					<img src="/img/shouye3.jpg" />
				</div>
				<h1 class="ttm_dis">${blessing.bleName}</h1>
				<h2 class="ttm_dis">${blessing.bleContent}</h2>
			</span> 
			<span class="ttm_span2"> 
				<a href="#"> 
					<i class="ttm_i_img icon-thumbs-up"></i> 
					<i class="ttm_i_text">赞</i>
				</a> 
				<a href="#"> 
					<i class="ttm_i_img icon-camera"></i> 
					<i class="ttm_i_text">分享</i>
				</a> 
				<a class="details"> 
					<i class="ttm_i_img icon-list-alt"></i> 
					<i class="ttm_i_text">详情</i>
				</a>
			</span>
		</div>
		<!-- ttm_div end -->
	</c:forEach>
</c:if>
<!-- 分页 -->
<div id="blessing-data-page" class="pagination pagination-centered">
	<ul>
		<c:if test="${sessionScope.blessingPage.previous==false}">
			<li class="active"><a>首页</a></li>
			<li class="active"><a>上一页</a></li>
		</c:if>
		<c:if test="${sessionScope.blessingPage.previous==true}">
			<li><a href="#">首页</a></li>
			<li><a href="#">上一页</a></li>
		</c:if>
		<c:forEach items="${requestScope.showPage}" var="showNumber">
			<li><a href="#">${showNumber}</a></li>
		</c:forEach>
		<c:if test="${sessionScope.blessingPage.next==true}">
			<li><a href="#">下一页</a></li>
			<li><a href="#">尾页</a></li>
		</c:if>
		<c:if test="${sessionScope.blessingPage.next==false}">
			<li class="active"><a>下一页</a></li>
			<li class="active"><a>尾页</a></li>
		</c:if>
	</ul>
</div><!-- 分页 end -->
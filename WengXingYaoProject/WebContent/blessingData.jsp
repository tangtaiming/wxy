<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		function initShowAndHide() {
			var ele = $("em[share^='share-iocn-']");	
			ele.hover(function() { showAndHide(this); }, function() { showAndHide(this); });
		}
		
		initShowAndHide();
	});
	
	
	function showAndHide(thisObj) {
		var tempEle = $(thisObj);
		var changeEleId = "." + tempEle.attr("share");
		var changeEle = $(changeEleId);
		var custom = changeEle.attr("custom");
		if (custom == "show") {
			changeEle.attr({"custom":"hide"});
			changeEle.attr({"id":"share-hide"});
		} 
		if(custom == "hide" || custom == "") {
			changeEle.attr({"custom":"show"});
			changeEle.attr({"id":"share-show"});
		}
	}	
</script>
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
			</span> <span class="ttm_span2"> 
			<a href="#"> <i class="ttm_i_img icon-thumbs-up"></i> <i class="ttm_i_text">赞</i></a> 
			<em share="share-iocn-${blessing.id}-${blessing.hashCode()}"> 
				<i class="ttm_i_img icon-camera"></i> 
				<i class="ttm_i_text"> 分享 </i>
				<span id="share-hide" class="share-iocn share-iocn-${blessing.id}-${blessing.hashCode()}" custom="">
                	<a id="qq-a-${blessing.id}" href="javascript:;" target="_blank"><i class="qq-ic"></i>QQ空间</a>
                    <a id="weibo-a-${blessing.id}" href="javascript:;" target="_blank"><i class="weibo-ic"></i>新浪微博</a>
                </span>
                <script type="text/javascript">
					(function() {
						var p = {
							url : location.href,
							showcount : '0',/*是否显示分享总数,显示：'1'，不显示：'0' */
							desc : '<c:out value="${blessing.bleContent}"/>',/*默认分享理由(可选)*/
							summary : '[星耀网作者寄语]我很喜欢她,所以我想为她做我能做的. 送给你翁星耀',/*分享摘要(可选)*/
							title : '<c:out value="${blessing.bleName}"/>',/*分享标题(可选)*/
							site : 'www.wengxingyao.cn',/*分享来源 如：腾讯网(可选)*/
							pics : '', /*分享图片的路径(可选)*/
							style : '203',
							width : 98,
							height : 22
						};
						var s = [];
						for ( var i in p) {
							s.push(i+ '='+ encodeURIComponent(p[i]||''));
						}
						var url = "http://service.weibo.com/share/share.php?" + s.join("&");
						var aUrl = "weibo-a-" + <c:out value='${blessing.id}'/>;
						document.getElementById(aUrl).attributes["href"].value = url;
					})();
				</script>
				<script type="text/javascript">
					(function() {
						var p = {
							url : location.href,
							showcount : '0',/*是否显示分享总数,显示：'1'，不显示：'0' */
							desc : '<c:out value="${blessing.bleContent}"/>',/*默认分享理由(可选)*/
							summary : '[星耀网作者寄语]我很喜欢她,所以我想为她做我能做的. 送给你翁星耀',/*分享摘要(可选)*/
							title : '<c:out value="${blessing.bleName}"/>',/*分享标题(可选)*/
							site : 'www.wengxingyao.cn',/*分享来源 如：腾讯网(可选)*/
							pics : '', /*分享图片的路径(可选)*/
							style : '203',
							width : 98,
							height : 22
						};
						var s = [];
						for ( var i in p) {
							s.push(i+ '='+ encodeURIComponent(p[i]||''));
						}
						var url = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?" + s.join("&");
						var aUrl = "qq-a-" + <c:out value='${blessing.id}'/>;
						document.getElementById(aUrl).attributes["href"].value = url;
					})();
				</script>
			</em> 
			<a class="details"> 
				<i class="ttm_i_img icon-list-alt"></i> <i
					class="ttm_i_text">详情</i>
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
</div>
<!-- 分页 end -->
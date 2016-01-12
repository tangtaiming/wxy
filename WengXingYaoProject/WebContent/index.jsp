<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="/css/myCss.css" rel="stylesheet" type="text/css" />
<link href="/css/font-awesome.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/myJs.js"></script>
<script type="text/javascript" src="/js/myScroll.js"></script>
<script type="text/javascript"  src="/js/manager-index.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		init();
	});
</script>
<title>为你准备的,一切都是为了你!</title>
</head>

<body>
	<%-- 公用头部 --%>
	<%@include file="head.jsp" %>
	<div class="container margin10">
       <div class="row">
       		<div class="span9">
            	<!-- ifocus start -->
            	<div id="ifocus">
                    <div id="ifocus_pic">
                        <div id="ifocus_piclist" style="left:0; top:0;">
                            <ul>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/IMG01.png" alt="校园模特招聘" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/IMG02.png" alt="网上有名" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/IMG03.png" alt="网上有名" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/IMG04.png" alt="网上有名" /></a></li>
                            </ul>
                        </div>
                        <div id="ifocus_opdiv"></div>
                        <div id="ifocus_tx">
                            <ul>
                                <li class="current">她的Q版</li>
                                <li class="normal">她的背影</li>
                                <li class="normal">以前送她的花</li>
                                <li class="normal">我的寄语</li>
                            </ul>
                        </div>
                    </div>
                    <div id="ifocus_btn">
                        <ul>
                            <li class="current" id="p0"><img src="/img/IMG_BTN01.png" alt=""/></li>
                            <li id="p1"><img src="/img/IMG_BTN02.png" alt="" /></li>
                            <li id="p2"><img src="/img/IMG_BTN03.png" alt="" /></li>
                            <li id="p3"><img src="/img/IMG_BTN04.png" alt="" /></li>
                        </ul>
                    </div>
                </div><!-- ifocus end -->
            </div><!-- span10 end -->
            <div class="span3">
            	<div class="demo">
                    <h2>祝福点赞排行</h2>
                    <div class="ranklist" id="praise-data">
                       <i class="icon-refresh icon-x icon-spin"></i> <span class="icon-x">加载数据...</span>
                    </div>
                </div><!-- demo end -->
            </div><!-- span3 end -->
       </div><!-- row end -->
    </div><!-- container end -->
    <!-- 评论 -->
    <div class="container margin10">
		<div id="ttm_con_page_data" class="ttm_index">
			<div id="load_img_index" class="row text-center">
				<i class="icon-refresh icon-2x icon-spin"></i> <span class="icon-2x">加载数据...</span>
			</div>
		</div><!-- ttm_index end -->
    </div><!-- 评论 end -->
</body>
</html>
<script type="text/javascript">
	function init() {
		$.ajax({
			url: "/b/showBlessingData",
			type: "get",
			success: function(data) {
				hideAjaxImg();
				$("#ttm_con_page_data").empty().append(data);
				initPraise();
			},
			error: function() {
				alert("error");	
			}	
		});	
	}

	function initPraise() {
		$.ajax({
			url: "/b/showBlessingPraiseData",
			type: "get",
			success: function(data) {
				$("#praise-data").empty().append(data);
			},
			error: function() {
				alert("fetch praise fail");	
			}	
		});
	}

	//显示加载祝福 加载图片
	function showAjaxImg() {
		$("#load_img_index").show();
	}

	//隐藏加载祝福 加载图片
	function hideAjaxImg() {
		$("#load_img_index").hide();
	}
</script>

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
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/center.jpg" alt="校园模特招聘" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/02.jpg" alt="网上有名" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/03.jpg" alt="网上有名" /></a></li>
                                <li><a href="http://www.17sucai.com/" target="_blank"><img src="/img/04.jpg" alt="网上有名" /></a></li>
                            </ul>
                        </div>
                        <div id="ifocus_opdiv"></div>
                        <div id="ifocus_tx">
                            <ul>
                                <li class="current">校园模特招聘</li>
                                <li class="normal">焦点图 b2</li>
                                <li class="normal">焦点图 c3</li>
                                <li class="normal">焦点图 d4</li>
                            </ul>
                        </div>
                    </div>
                    <div id="ifocus_btn">
                        <ul>
                            <li class="current" id="p0"><img src="/img/center.jpg" alt=""/></li>
                            <li id="p1"><img src="/img/btn_02.jpg" alt="" /></li>
                            <li id="p2"><img src="/img/btn_03.jpg" alt="" /></li>
                            <li id="p3"><img src="/img/btn_04.jpg" alt="" /></li>
                        </ul>
                    </div>
                </div><!-- ifocus end -->
            </div><!-- span10 end -->
            <div class="span3">
            	<div class="demo">
                    <h2>jquery</h2>
                    <div class="ranklist">
                        <ul>
                            <li class="top">
                                <em>01</em><p><a href="http://www.17sucai.com/" title="js图片左右无缝滚动用鼠标控制图片滚动" target="_blank">5555555555555</a></p><span class="num">32万下载</span>
                            </li>
                            <li class="top">
                                <em>02</em><p><a href="http://www.17sucai.com/" target="_blank">55</a></p><span class="num">32万下载</span>
                            </li>
                            <li class="top">
                                <em>03</em><p><a href="http://www.17sucai.com/" target="_blank">55</a></p><span class="num">32万下载</span>
                            </li>
                            <li>
                                <em>04</em><p><a href="http://www.17sucai.com/" target="_blank">5555555555555</a></p><span class="num">32万下载</span>
                            </li>
                            <li>
                                <em>05</em><p><a href="http://www.17sucai.com/" target="_blank">55</a></p><span class="num">32万下载</span>
                            </li>
                            <li>
                                <em>06</em><p><a href="http://www.17sucai.com/" target="_blank">55</a></p><span class="num">32万下载</span>
                            </li>
                            <li>
                                <em>07</em><p><a href="http://www.17sucai.com/" target="_blank">5555555555555</a></p><span class="num">32万下载</span>
                            </li>
                            <li>
                                <em>08</em><p><a href="http://www.17sucai.com/" target="_blank">2222222222222</a></p><span class="num">32万下载</span>
                            </li>
                        </ul>
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
			},
			error: function() {
				alert("error");	
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
    
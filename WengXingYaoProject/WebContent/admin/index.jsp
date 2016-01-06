<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>星耀后台管理-主页</title>
<link href="/css/manager-index.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/js/manager-index.js"></script>
<script type="text/JavaScript"> 
var jq=function(id) {
   return document.getElementById(id);
}

function show_menu(num){
for(i=0;i<100;i++){
	if(jq('li0'+i)){
	jq('li0'+i).style.display='none';
	jq('f0'+i).className='';
	 }
}
	  jq('li0'+num).style.display='block';//触发以后信息块
	  jq('f0'+num).className='left02down01_xia_li';//触发以后TAG样式
}

function show_menuB(numB){
	for(j=0;j<100;j++){
		 if(j!=numB){
			if(jq('Bli0'+j)){
		  jq('Bli0'+j).style.display='none';
		  jq('Bf0'+j).style.background='url(../img/01.gif)';
		}
		 }
	}
	if(jq('Bli0'+numB)){   
		if(jq('Bli0'+numB).style.display=='block'){
		  jq('Bli0'+numB).style.display='none';
		 jq('Bf0'+numB).style.background='url(../img/01.gif)';
		}else {
		  jq('Bli0'+numB).style.display='block';
		  jq('Bf0'+numB).style.background='url(../img/02.gif)';
		}
	}
}


var temp=0;
function show_menuC(){
		if (temp==0){
		 document.getElementById('LeftBox').style.display='none';
	  	 document.getElementById('RightBox').style.marginLeft='0';
		 document.getElementById('Mobile').style.background='url(../img/center.gif)';

		 temp=1;
		}else{
		document.getElementById('RightBox').style.marginLeft='222px';
	   	document.getElementById('LeftBox').style.display='block';
		document.getElementById('Mobile').style.background='url(../img/center0.gif)';

	    	temp=0;
		}
	 }
</script>
</head>

<body>
<div class="header">
	<div class="header03"></div>
	<div class="header01"></div>
	<div class="header02">星耀后台管理系统</div>
</div>
<div class="left" id="LeftBox">
	<div class="left01">
		<div class="left01_right"></div>
		<div class="left01_left"></div>
		<div class="left01_c">管理员：<c:out value="${sessionScope.loginUser.userName}" default="未登陆"></c:out></div>
	</div>
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c">用户信息管理</div>
		</div>
	  <div class="left02down">
			<div class="left02down01"><a onclick="managerAjax('/b/blessingManager')" href="javascript:;"><div id="Bf080" class="left02down01_img"></div>祝福管理</a></div>
		    <div class="left02down01"><a onclick="managerAjax('/t/thankManager')" href="javascript:;"><div id="Bf081" class="left02down01_img"></div>感谢管理</a></div>
	  </div>
	</div>
	<div class="left01">
		<div class="left03_right"></div>
		<div class="left01_left"></div>
		<div class="left03_c"><a href="javascript:;" onclick="loginout();">安全退出</a></div>
	</div>
</div>
<div class="rrcc" id="RightBox">
	<div class="center" id="Mobile" onclick="show_menuC()"></div>
	<div class="right" id="li010">
		<div style="margin: 20px; border: 1px solid #dcdcdc; overflow:hidden;">
        	<img src="/img/bg2.jpg" alt="星耀网,欢迎你." width="1280" height="600" />
        </div>
	</div>
	<div class="right noneBox" id="li011">
		<div class="right01"><img src="/img/04.gif" /> 用户信息查询 jqgt; <span>组合条件查询</span></div>
	</div>
	<div class="right noneBox" id="li012">
		<div class="right01"><img src="/img/04.gif" /> 用户密码管理 jqgt; <span>找回密码</span></div>
	</div>
	<div class="right noneBox" id="li013">
		<div class="right01"><img src="/img/04.gif" /> 用户密码管理 jqgt; <span>更改密码</span></div>
	</div>
</div>

</body>
</html>

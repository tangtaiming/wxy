<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/manager-index.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.js"></script>
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
		  jq('Bf0'+j).style.background='url(/img/01.gif)';
		}
		 }
	}
	if(jq('Bli0'+numB)){   
		if(jq('Bli0'+numB).style.display=='block'){
		  jq('Bli0'+numB).style.display='none';
		 jq('Bf0'+numB).style.background='url(/img/01.gif)';
		}else {
		  jq('Bli0'+numB).style.display='block';
		  jq('Bf0'+numB).style.background='url(/img/02.gif)';
		}
	}
}


var temp=0;
function show_menuC(){
		if (temp==0){
		 document.getElementById('LeftBox').style.display='none';
	  	 document.getElementById('RightBox').style.marginLeft='0';
		 document.getElementById('Mobile').style.background='url(/img/center.gif)';

		 temp=1;
		}else{
		document.getElementById('RightBox').style.marginLeft='222px';
	   	document.getElementById('LeftBox').style.display='block';
		document.getElementById('Mobile').style.background='url(/img/center0.gif)';

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
		<div class="left01_c">超级管理员：admin</div>
	</div>
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c">用户信息管理</div>
		</div>
	  <div class="left02down">
			<div class="left02down01"><a  onclick="show_menuB(80)" href="javascript:;"><div id="Bf080" class="left02down01_img"></div>祝福管理</a></div>
		    <div class="left02down01"><a onclick="show_menuB(81)" href="javascript:;"><div id="Bf081" class="left02down01_img"></div>感谢管理</a></div>
			
		</div>
	</div>
	<div class="left01">
		<div class="left03_right"></div>
		<div class="left01_left"></div>
		<div class="left03_c">安全退出</div>
	</div>
</div>
<div class="rrcc" id="RightBox">
	<div class="center" id="Mobile" onclick="show_menuC()"></div>
	<div class="right" id="li010">
		<div class="right01"><img src="/img/04.gif" /> 用户信息查询</div>
        <div class="xt-input">
            <span>账号类型</span>
            <select class="int-text" >
                <option>选项一</option>
                <option>选项二</option>
                <option>选项三</option>
                <option>选项四</option>
                <option>选项五</option>
            </select>
            <span>账号/邮箱</span><input type="text" class="int-text" />
            <span>审核/状态</span>
            <select class="int-text" >
                <option>选项一</option>
                <option>选项二</option>
                <option>选项三</option>
                <option>选项四</option>
                <option>选项五</option>
            </select>
            <span>来源</span><input type="text" class="int-text" />
            <input type="button" value="搜 索" class="green-int" />
        </div>
        <div class="xt-table">
            <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
                <tr>
                    <th>ID</th>
                    <th class="context">祝福内容</th>
                    <th>发布时间</th>
                    <th>发布IP</th>
                    <th>网名</th>
                    <th>赞</th>
                    <th>赞总数量</th>
                    <th>审核状态</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td class="context">comzhuzh@fadada.comcomzhuzh@fadada.comcomzhuzh@fadada.</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt" id="delete-row-1" onclick="deleteRow(this)">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
                <tr class="xt-bg">
                    <td>1</td>
                    <td>zhuzh@fadada.com</td>
                    <td>郑雄杰</td>
                    <td>450340198710196712</td>
                    <td>15814467255</td>
                    <td>法大大</td>
                    <td>视频认证</td>
                    <td>已审核</td>
                    <td>2015-05-20</td>
                    <td><a href="edit.html" class="blue-xt">编辑</a><a href="#" class="red-xt">删除</a></td>
                </tr>
    
            </table>
        </div>
    <div class="xt-fenye">
        <div class="xt-fenye-left">当前第 1 / 270 页,每页10条，共 2696条记录</div>
        <div class="xt-fenye-right">
            <a href="#">首页</a>
            <a href="#">上一步</a>
            <a href="#">下一步</a>
            <a href="#">尾页</a>
            <input type="text" name="text" />
            <a href="#" class="xt-link">跳转</a>
        </div>
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

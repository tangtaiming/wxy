<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<%=basePath %>css/style.css" rel='stylesheet' type='text/css' />
	<script src="<%=basePath %>js/jquery.js"></script>
	<script src="<%=basePath %>js/jquery.form.js"></script>
	<script type="application/x-javascript">
	 	addEventListener("load", function() { 
		 		setTimeout(hideURLbar, 0); 
			}, false); 

		function hideURLbar(){ 
			window.scrollTo(0,1); 
		} 

		//登录注册 action 提交地址 切换
		function myFunction(thisObj) {
			var _form = $("#form");

			var _id = thisObj.id;
			if (_id == "login") {
				_form[0]
					.attributes["action"]
					.value = "/user/login";
			} 
			if (_id == "register") {
				_form[0]
					.attributes["action"]
					.value = "/user/register";
			}
		}
		
		$(document).ready(function() {
			var options = {
				type : 'post',
				success : function(data) {
					alert("yes" + data);
				}
			}

			$("#register").click(function() {
				$("#form").ajaxSubmit(options);
			});

			$("#login").click(function() {
				$("#form").ajaxSubmit(options);
			});
		});
	</script>
	<title>注册页面</title>
</head>
<body>
	
	<div class="main">
		<div class="header" >
			<h1>登录或创建一个免费的账号!</h1>
		</div>
		<p>Lorem iopsum dolor sit amit,consetetur sadipscing eliter,sed diam voluptua.At vero  eso et accusam et justo duo dolores et ea rebum. </p>
			<form id="form" action="" method="POST">
				<ul class="left-form">
					<h2>新账号:</h2>
					<li>
						<input name="userName" type="text" placeholder="账号" />
						<a href="#" class="icon ticker"> </a>
						<div class="clear"> </div>
					</li> 
					<li>
						<input name="password" type="password" placeholder="密码" />
						<a href="#" class="icon into"> </a>
						<div class="clear"> </div>
					</li> 
					<li>
						<input name="verifyPassword" type="password" placeholder="确认密码" />
						<a href="#" class="icon into"> </a>
						<div class="clear"> </div>
					</li>
					<li>
						<input name="email" type="text"  placeholder="邮箱" />
						<a href="#" class="icon ticker"> </a>
						<div class="clear"> </div>
					</li> 
					<li>
						<input name="phone" type="text" placeholder="手机号码" />
						<a href="#" class="icon ticker"> </a>
						<div class="clear"> </div>
					</li>  
					<label class="checkbox" style="width:100%; margin:0px;">
						<input type="checkbox" name="checkbox" checked="">
						<i> </i>同意以上协议
					</label>
					<input id="register" type="submit" value="创建账号" onclick="myFunction(this)" />
					<div class="clear"> </div>
				</ul>
				<ul class="right-form">
					<h3>登录:</h3>
					<div>
						<li><input name="loginUserName" type="text"  placeholder="账号" /></li>
						<li><input name="loginPassword" type="password"  placeholder="密码" /></li>
						<h4 style="width:100%; margin:0px 0px 10px 0px;">忘记密码！</h4>
						<input id="login" type="submit" onclick="myFunction(this)" value="登录" style="margin:0px 0px 30px 0px;" />
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>
			</form>
		</div>
		<!-----start-copyright---->
  		<div class="copy-right">
			<p>Template by <a href="#">ttm</a></p> 
		</div>
		<!-----//end-copyright---->
</body>
</html>
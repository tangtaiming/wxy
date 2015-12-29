<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link href="/css/login-register.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.form.js"></script>
<script type="text/javascript">
	var login = function (formId) {
		var form = $("#" + formId);
		var options = {
			type : 'post',
			dataType : 'json',
			success : function(data) {
				var requestJson = data;
				var status = requestJson.status;

				$("#js-mail_ipt").removeClass("text-error");
				$("#js-mail_pwd_ipt").removeClass("text-error");
				if (status == 2) {
					$("#js-mail_ipt").addClass("text-error");
				}
				if (status == 3) {
					$("#js-mail_pwd_ipt").addClass("text-error");
				}
				if (status == 999) {
					window.location.href = "/user/lostManager";
				}
			}
		};

		function loginFrom (fromObj) {
			fromObj.ajaxSubmit(options);
		}
		loginFrom(form);
	};
</script>
</head>
<body>
<div class="wrap">
	<div class="banner-show" id="js_ban_content">
		<div class="cell bns-01">
			<div class="con">
			</div>
		</div>
	</div>
	<div class="container">
		<form class="login-box" id="form-login" method="post" action="/user/login">
			<div class="reg-slogan">
				用户登录
            </div>
			<div class="reg-form" id="js-form-mail">
				<div class="cell">
					<label for="js-mail_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="userName" id="js-mail_ipt" class="text" placeholder="输入你的账号" />
				</div>
				<div class="cell">
					<label for="js-mail_pwd_ipt">&nbsp;&nbsp;</label>
					<input type="password" name="password" id="js-mail_pwd_ipt" class="text" placeholder="密码" />
				</div>
				<div class="cell vcode">
					<label for="js-mail_vcode_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="code" id="js-mail_vcode_ipt" class="text" maxlength="4" placeholder="输入验证码" />
					<img id="js-mail_vcode_img" src="http://passport.115.com/?ct=securimage&ac=email" alt="code" />
					<span>
					<a id="js-mail_vcode_a" href="javascript:;" code_src="http://passport.115.com/?ct=securimage&amp;ac=email">
					换一张</a></span> </div>
				<div class="bottom">
					<a id="js-mail_btn" onclick="login('form-login')" class="button btn-green">
					登录</a>
				</div>
			</div>
		</form>
	</div>
</div>


</body>
</html>


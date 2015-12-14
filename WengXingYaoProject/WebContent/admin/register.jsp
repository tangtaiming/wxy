<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link href="/css/login-register.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.form.js"></script>
<script type="text/javascript">
	var register = function (formId) {
		var form = $("#" + formId);
		var options = {
			type : 'post',
			dataType : 'json',
			success : function(data) {
				var requestJson = data;
				var status = requestJson.status;

				if (status == 999) {
					location.href = "/user/index";
				}
			}
		};

		function registerFrom (fromObj) {
			fromObj.ajaxSubmit(options);
		}
		registerFrom(form);
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
		<form class="register-box" id="form-register" method="post" action="/user/register">
			<div class="reg-slogan">
				用户注册
            </div>
			<div class="reg-form" id="js-form-mobile">
				<div class="cell">
					<label for="js-mobile_name_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="userName" id="mobile_name_ipt" class="text" maxlength="11" placeholder="注册账号"  />
				</div>
				<div class="cell">
					<label for="js-mobile_pwd_ipt">&nbsp;&nbsp;</label>
					<input type="password" name="password" id="js-mobile_pwd_ipt" class="text" placeholder="密码" />
				</div>
				<div class="cell">
					<label for="js-mobile_pwdres_ipt">&nbsp;&nbsp;</label>
					<input type="password" name="passwordRes" id="js-mobile_pwdres_ipt" class="text" placeholder="重复密码" />
				</div>
				<div class="cell">
					<label for="js-mobile_phone_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="phone" id="js-mobile_phone_ipt" class="text" placeholder="手机号码" />
				</div>
				<div class="cell">
					<label for="js-mobile_email_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="email" id="js-mobile_email_ipt" class="text" placeholder="邮箱" />
				</div>
				<!-- !短信验证码 -->
				<div class="cell vcode">
					<label for="js-mobile_vcode_ipt">&nbsp;&nbsp;</label>
					<input type="text" name="code" id="js-mobile_vcode_ipt" class="text" maxlength="6" placeholder="输入验证码" />
					<a href="javascript:;" id="js-get_mobile_vcode" class="button btn-disabled">
					免费获取验证码</a> </div>
                <div class="user-agreement">
					<input type="checkbox" id="js-mail_chk" checked="true" />
					<label for="js-mail_chk">同意<a href="http://115.com/agreement.html" target="_blank">《星耀用户服务协议》</a></label>
				</div>
				<div class="bottom">
					<a id="js-mobile_btn" onclick="register('form-register')" class="button btn-green">
					立即注册</a></div>
			</div>
		</form>
	</div>
</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户登录</title>
<style>
body {
	background: url('img/login.jpg') no-repeat;
	background-size: 100% auto;
}

#login_box {
	width: 20%;
	height: 400px;
	background-color: #00000060;
	margin: auto;
	margin-top: 10%;
	text-align: center;
	border-radius: 10px;
	padding: 50px 50px;
}

#login_box input, #login_box button {
	outline: none;
}

#login_box h2 {
	color: #FFFFFF;
	margin-top: 5%;
}

#login_box #form #input_box {
	margin-top: 5%;
}

#login_box #form #input_box input {
	border: 0;
	width: 60%;
	font-size: 15px;
	color: #1375F7;
	background: #ffffff00;
	border-bottom: 2px solid #ffffff;
	padding: 5px 10px;
	margin-top: 10px;
}

#login_box button {
	margin-top: 50px;
	width: 40%;
	height: 20px;
	border-radius: 10px;
	border: 0;
	color: #fff;
	font-size: 15px;
	background-image: linear-gradient(120deg, #f093fb 0%, #f5576c 100%);
	cursor: pointer;
}

#login_box #sign_up {
	margin-top: 45%;
}

#login_box #sign_up a {
	color: #FFFFFF;
}
</style>
</head>

<body>
	<div id="login_box">
		<h2>LOGIN</h2>
		<div id="form">
			<div id="input_box">
				<input id="username" type="text" placeholder="用户名" value="admin"
					onkeypress="if(event.keyCode==13) focusNextInput(this);">
			</div>
			<div id="input_box">
				<input id="password" type="password" placeholder="密码" value="123456"
					onkeypress="if(event.keyCode==13) focusNextInput(this);">
			</div>
		</div>
		<button id="sign_in" onclick="login()">Sign in</button>
		<br>
		<div id="sign_up">
			<a href="javascript:;">忘记密码?</a>
		</div>
	</div>
</body>
<!-- 引入jquery核心文件 -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	function login() {
		var username = document.getElementById("username");
		var pass = document.getElementById("password");

		if (username.value == "") {
			alert("请输入用户名");
		} else if (pass.value == "") {
			alert("请输入密码");
		} else if (username.value == "admin" && pass.value == "123456") {
			window.location.href = "index.jsp";
		} else {
			alert("请输入正确的用户名和密码!");
		}

	}
	function focusNextInput(thisInput) {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			// 如果是最后一个，则焦点回到第一个
			if (i == (inputs.length - 1)) {
				inputs[0].focus();
				break;
			} else if (thisInput == inputs[i]) {
				inputs[i + 1].focus();
				break;
			}
		}
	}
</script>
</html>

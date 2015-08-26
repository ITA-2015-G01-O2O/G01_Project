<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/basic.css">
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="logo">
				<img src="../img/rice.png">
			</div>
			<form id="sign-form" action="../account/register.do"
				class="sign-form">
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input type="text"
						class="form-control" name="to_username" id="username"
						placeholder="username">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input type="password"
						class="form-control" name="to_password" id="password"
						placeholder="password">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input type="password"
						class="form-control" name="to_password2" id="password2"
						placeholder="comfirm password">
				</div>
				<div class="alert alert-danger" style="display: none" role="alert"
					id="errorMsg2"></div>

				<div class="bttons">
					<button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
				</div>

			</form>
		</div>
		<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script
			src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/consumer/consumer_register.js"></script>
		<script type="text/javascript" src="../js/jquery.form.js"></script>
</body>
</html>
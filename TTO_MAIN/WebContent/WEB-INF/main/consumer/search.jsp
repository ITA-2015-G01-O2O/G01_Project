<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nome do Documento</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/basic.css">
<link rel="stylesheet" href="../css/search.css">
</head>
<body>
	<nav class="navbar navbar-default" id="header">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-toggle="modal" data-target=".login-modal">登陆</a></li>
			<li><a href="register.html">注册</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-earphone"></span>找客服</a></li>
		</ul>
	</div>
	</nav>
	<div id="background"></div>
	<div class="title">
		<span class="brand">TAKE-OUT</span>
	</div>
	<div id="search">
		<a href="#" class="map-font" data-toggle="dropdown"
			aria-expanded="true" data-toggle="tooltip"> <span
			class=" glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		</a>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="maplist">
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，南方软件园</span></a></li>
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，东岸</span></a></li>
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，东岸</span></a></li>
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，东岸</span></a></li>
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，东岸</span></a></li>
			<li><a href="select-vender.html">珠海，<span class="text-muted">唐家，东岸</span></a></li>
		</ul>
		<input class="search-Place" type="text" class="form-control"
			placeholder="输入地址"> <a href="#" class="search-font"><span
			class=" glyphicon glyphicon-search" aria-hidden="true"></span></a>
	</div>

	<div id="footer">
		<a href="#">关注微信</a> <a>|</a> <a href="#">关注微博</a> <a>|</a> <a
			href="#">我要开店</a> <a>|</a> <a><span>客服电话400-xxx-xxx</span> </a>
	</div>

	<div class="modal fade login-modal" tabindex="-1" role="dialog" id="relogin">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title text-center">登录</h4>
				</div>
				<div class="modal-body">
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
					 <div class="alert alert-danger" style="display:none" role="alert" id="errorMsg"></div>
					<div class="checkbox btn-re">
						<label> <input type="checkbox"> Remeber me
						</label>
					</div>
					<div class="bttons">
						<a class="btn btn-primary btn-block" type="submit"
							onclick="consumerlogin()">Login</a> <a
							class="btn btn-success btn-block" href="register.html">Register</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/consumer/consumer.js"></script>
</html>
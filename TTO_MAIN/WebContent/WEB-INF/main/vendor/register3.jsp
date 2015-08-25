<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/register3.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/css/vendor/register.css'/>" />
		<title>Register</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="index.html"><img src="img/title_client.png" width="70px" style="margin-top:8px"></a>
				</div>
				<div class="collapse navbar-collapse" id="main-nav">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Welcome: Ace</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-log-out"></i></a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container container-main">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs nav-justified">
						<li role="presentation"><a href="#">Contact information</a></li>
     					<li role="presentation"><a href="#">Restaurant Information</a></li>
     					<li role="presentation" class="active"><a href="#">Qualification certification</a></li>
      					<li role="presentation"><a href="#">Approval status</a></li>
    				</ul>
    			</div>
    		</div>
    		<div class="sign-form page-center form-horizontal">
    			<div class="page-text">	
    				<label>Real name</label>
    				<div>
      					<input type="text" class="form-control input-lg" placeholder="Real name" id="inputName">
    				</div>
    			</div>
    			<div class="alert alert-danger" style="display: none;"  role="alert" id="namemsg">Please input your real name!</div>
    			<div class="page-text">	
    				<label>Idcard number</label>
    				<div>
      					<input type="text" class="form-control input-lg" placeholder="Idcard number" id="inputIdcard">
    				</div>
    			</div>	
    			<div class="alert alert-danger" style="display: none;"  role="alert" id="idcardmsg">Please input your idcard number!</div>
  				<div><img id="showIdcardPic" width="200" height="200" src="img/1.jpg" class="page-text"/></div>
  				<div class="controls page-text">
					<input name="idcardPic" type="file" id="IdcardPic"  style="display: none;"></input>
					<span class="btn btn-primary btn-lg" onclick="$('#IdcardPic').click();" id="idcardBtn">Choose idcard Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
				</div>
				<div class="alert alert-danger" style="display: none;"  role="alert" id="idcardpicmsg">Please upload your idcard picture!</div>
  				<div><img id="showLicensePic" width="200" height="200" src="img/1.jpg"  class="page-text"/></div>
  				<div class="controls page-text">
					<input name="licensePic" type="file" id="LicensePic"  style="display: none;"></input>
					<span class="btn btn-primary btn-lg" onclick="$('#LicensePic').click();" id="licenseBtn">Choose License Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
				</div>
				<div class="alert alert-danger" style="display: none;"  role="alert" id="licensepicmsg">Please upload your idcard picture!</div>
            	<a type="button" class="btn btn-primary btn-lg" href="register4.html" id="next">Next</a>
            <div>
		</div>
		<script>
		$(function () {
			$("#LicensePic").uploadPreview({ Img: "showLicensePic", Width: 120, Height: 120 });
			$("#IdcardPic").uploadPreview({ Img: "showIdcardPic", Width: 120, Height: 120 });
		});
		</script>
	</body>
</html>

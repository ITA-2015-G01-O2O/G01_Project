<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/vendor/register.css'/>" />
		<title>Register</title>
		<script type="text/javascript" src="<c:url value='/js/vendor/register1.js'/>"></script>
		<style type="text/css">
			.nav > li > a:hover{
				background-color: #fff;
			}
			.nav-tabs.nav-justified > li > a:hover{
				border-top: none;
				border-left: none;
				border-right: none;
			}
			
		</style>
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
					<a href="index.html"><img src="<c:url value='/img/vendor/title_vender.png'/>" width="70px" style="margin-top:8px"></a>
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
						<li role="presentation" class="active"><a href="#">Contact information</a></li>
     					<li role="presentation"><a >Restaurant Information</a></li>
     					<li role="presentation"><a >Qualification certification</a></li>
      					<li role="presentation"><a >Approval status</a></li>
    				</ul>
    			</div>
    		</div>
    		<div class="sign-form page-center form-horizontal">
            	<div class="page-text">	
    				<label>Phone</label>
    				<div class="page-text">
      					<input type="text" class="form-control input-lg" id="inputPhone" placeholder="phone">
    				</div>
    				<div class="alert alert-danger" style="display: none;"  role="alert" id="phonemsg">Wrong phone number!</div>
    			</div>    			
            	<button type="button" class="btn btn-primary btn-lg" id="next">Next</button>
            <div>
		</div>
	</body>
</html>

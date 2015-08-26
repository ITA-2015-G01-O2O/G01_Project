<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
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
						<li role="presentation"><a href="#">Contact information</a></li>
     					<li role="presentation"><a href="#">Restaurant Information</a></li>
     					<li role="presentation"><a href="#">Qualification certification</a></li>
      					<li role="presentation" class="active"><a href="#">Approval status</a></li>
    				</ul>
    			</div>
    		</div>

        	<div class="text-center page-center">        		
        		<img src="<c:url value='/img/vendor/success.png'/>" height="200px" width="200px" id="pic"/>
            	<h2 class="table-title">You have successfully submitted your application</h2>
            	<h2 class="table-title">Please be patient before admin review</h2>
           	 	<a class="btn btn-success btn-lg" href="../consumer/search.view" >goback</a>
        	</div>       
   		 	
		</div>
	</body>
</html>

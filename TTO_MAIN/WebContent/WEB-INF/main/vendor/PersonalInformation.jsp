<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Basic Setting</title>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/vendor/setting.css'/>" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>	
		<script type="text/javascript" src="<c:url value='/js/vendor/personalInfo.js'/>"></script>
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
					<div class="row breadcrumb-wrapper">
					</div>
					<div class="row">
						<div class="col-xs-3">
							<div calss="operate">
								<ul class="nav nav-pills nav-stacked">
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Order Center</li>
									<li role="presentation">
										<a href="<c:url value='/vendor/.../NewOrder.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;New Order<span class="badge">2</span></a>
									</li>
									<li role="presentation"><a href="<c:url value='/vendor/.../OrderCompleted.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed Order</a></li>
									<br/>
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
									<li role="presentation">
										<a href="<c:url value='/vendor/.../FoodManageMent.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food Management</a>
									</li>
									<br/>
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Account Center</li>
									<li class="active" role="presentation">
										<a href="<c:url value='/vendor/personalInfo/PersonalInformation.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Personal Information</a>
									</li>
									<li role="presentation"><a href="<c:url value='/vendor/storeInfo/storeInfo.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Store Information</a></li>
									<li role="presentation"><a href="<c:url value='/vendor/basicSetting/BasicSetting.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Basic Settings</a></li>
								</ul>
							</div>
							<div class="ShopState">
								<span class="spantitle"><i class="glyphicon glyphicon-th-list"></i>&emsp;Store Credit</span>
								<ul class="nav nav-pills nav-stacked">
									<li>Store Name :
										<label class="ShopNameLabel" id="shopNameLabel">${storeName}</label>
									</li>
									<li>Store average point :
										<label class="ShopNameLabel" id="avgPointLabel">${avgPoint}</label>
									</li>
									<li>Store average deliver Time:
										<label class="ShopNameLabel" id="avgTimeLabel">${avgTime}</label>
									</li>
									<li>Collection Number:
										<label class="ShopNameLabel" id="collectionNumLabel">${collectionNum}</label>
									</li>
								</ul>

							</div>
						</div>
						<div class="col-xs-9 main-wrapper">

							<div class="panel panel-default">

								<div class="panel-heading">Basic Setting</div>
								<div class="panel-body form-horizontal">
									
    								<div class="page-text">	
    									<label>True name</label>
    									<div>
      										<input type="text" class="form-control" placeholder="True name" readonly id="trueNamemsg">
    									</div>
    								</div>
    								<div class="page-text">	
    									<label>Idcard number</label>
    									<div>
      										<input type="text" class="form-control" placeholder="Idcard number" readonly id="dicardnumbermsg">
    									</div>
    								</div>
    								<div class="page-text">	
    									<label>Account balance</label>
    									<form class="form-inline">
  											<div class="form-group">
    											<div class="input-group">
      												<div class="input-group-addon">$</div>
      												<input type="text" class="form-control inputAmount"  placeholder="Amount" readonly id="accountmsg">      												
    											</div>
  											</div>
										</form>
    								</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</body>

</html>

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
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="<c:url value='/js/vendor/pic.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/js/vendor/jquery.form.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/js/vendor/storeInfo.js'/>" type="text/javascript"></script>
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
										<a href="<c:url value='/vendor/order/NewOrder.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;New Order<span class="badge">2</span></a>
									</li>
									<li role="presentation"><a href="<c:url value='/vendor/order/OrderCompleted.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed Order</a></li>
									<br/>
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
									<li role="presentation">
										<a href="<c:url value='/vendor/product/FoodManageMent.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food Management</a>
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
							<form enctype="multipart/form-data" id="si_form">
								<div class="panel-heading">Basic Setting</div>
								<div class="panel-body form-horizontal">
									<div class="page-text">	
    									<label>Address</label>
    									<div id="inputAddr"></div>
    								</div>
    								<div class="page-text">	
    									<label>Store name</label>
    									<div>
      										<input type="text" class="form-control" placeholder="Store name" id="inputStoreName" name="storename">
    									</div>
    									<div class="alert alert-danger" style="display: none;"  role="alert" id="storeNamemsg">Wrong store name!</div>
    								</div>
    								<div class="page-text">	
    									<label>Phone</label>
    									<div>
      										<input type="text" class="form-control" placeholder="tel" id="inputPhone" name="phone">
    									</div>
    									<div class="alert alert-danger" style="display: none;"  role="alert" id="phonemsg">Wrong phone!</div>
    								</div>
    								<div class="page-text">	
    									<label>Type</label>
    									<div>		
    										<input type="text" class="form-control"  id="inputType" name="type" style="display: none;">
    										<div class="btn-group">
  												<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="typemsg">
    												Choose type of Store <span class="caret"></span>
  												</button>
  											<ul class="dropdown-menu" id="configMenu">

  											</ul>
											</div>
    									</div>
    								</div>
    								<div class="page-text">	
    									<label>Store Picture</label>
    									<div><img id="showStorePic" width="200" height="200" src="<c:url value='/img/vendor/1.jpg'/>"  class="page-text"/></div>
    									<div class="controls page-text">
											<input type="file" id="StorePic"  style="display: none;" name="storeLogo"></input>
											<span class="btn btn-primary" onclick="$('#StorePic').click();" id="changePic">Change Store Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
										</div>
    								</div>
    								<input name="piclog" type="text" id="piclog"  style="display: none;"></input>
									<input type="submit" class="btn btn-primary btn-lg">Save</input>
								</div>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script>
		$(function () {
			$("#StorePic").uploadPreview({ Img: "showStorePic", Width: 120, Height: 120 });
		});
		</script>
	</body>

</html>


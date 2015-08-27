<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>SMS - home</title>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/js/vendor/OperateOrder.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/basic.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/css/vendor/basic.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/vendor/index.css'/>" />
</head>

<body>

	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">...</div>
		</div>
	</div>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#main-nav">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="index.html"><img src="img/title_client.png" width="70px"
				style="margin-top: 8px"></a>
		</div>
		<div class="collapse navbar-collapse" id="main-nav">
			<!--
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">My Meals</a></li>
                    <li><a href="#">My Profile</a></li>
                </ul>  -->
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
					<!--   <div class="col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Pick</a></li>
                            <li class="active">Confirm</li>
                            <li class="active">Success</li>                        
                        </ol>
                    </div>-->
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
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Account Center</li>
								<li role="presentation"><a href="PersonalInformation.html">
										<i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Personal
										Information
								</a></li>
								<li role="presentation"><a href="storeInfo.html"><i
										class="glyphicon glyphicon-triangle-right"></i>&emsp;Store
										Information</a></li>
								<li role="presentation"><a href="BasicSetting.html"><i
										class="glyphicon glyphicon-triangle-right"></i>&emsp;Basic
										Settings</a></li>
							</ul>
						</div>
						<!--
                        	作者：chen.ace@outlook.com
                        	时间：2015-08-22
                        	描述：增加商家状态信息
                        -->
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
						<div id="orderTable" class="col-xs-12 hidden">
							<div class="col-xs-12"	style="height: 180px; margin-bottom: 70px;">
								<div class="col-xs-4"
									style="height: 160px; margin-left: 0px; padding: 0px;">
									<div style="overflow-y: scroll; height: 150px;border: 1px solid #ddd;">
										<table class="table"
											style="border: 1px solid #ddd; margin-bottom: 0px;">
								          <tbody  id="TableTbody">
											<tr id="tableTitle">
												<td width="120px">餐点</td>
												<td>份数</td>
												<td>价格</td>
											</tr>
								          </tbody>
										</table>
									</div>
									<div style="border: 1px solid #ddd;text-align: center;">
										<label>总价格</label>
										<!-- label价格动态生成 -->
										<label id="priceLabel">27</label>
									</div>
									</div>
								
								<div class="col-xs-8"
									style="height: 176px; border: 1px solid #ddd; text-align: left;">
									<label>订单号：</label> <label id="orderNum">130000000000000</label>
									<br /> <label>下单日期：</label> <label id="orderDate">2015-08-23
										17:52:23</label> <br /> <label>订单状态：</label> <label id="orderState">商家未确认</label>
									<br /> <label>联系人：</label> <label id="orderPeopleName">ChenAce</label>
									<br /> <label>电话：</label> <label id="orderTel">13000000000</label>
									<br /> <label>地址：</label> <label id="orderAddress">南方软件园B5
										1-4单元 5楼</label> <br />
								</div>
								
								<div class="col-xs-12"style="text-align: right; border: 1px solid #ddd;">
									<button class="btn btn-primary access">ACCEPT</button>
									<button class="btn btn-danger giveUp">CANCEL</button>
								</div>
								</div>
							</div>
						</div>
					</div>
					<!--    <div class="col-xs-3">
                        <div class="myCart text-muted"><i class="glyphicon glyphicon-shopping-cart"></i><span>My Cart</span><span class="badge">42</span></div>
                        <div class="orders">
                            <div class="orderBox">
                                <h4>Blabla</h4>
                                <h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
                                <button class="btn btn-default btn-sm">-</button>
                                <input type="number" value="1" class="form-control input-sm">
                                <button class="btn btn-default btn-sm">+</button>
                                <span class="price">$27</span>
                                <div class="clear"></div>
                            </div>
                            <div class="orderBox">
                                <h4>Blabla</h4>
                                <h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
                                <button class="btn btn-default btn-sm">-</button>
                                <input type="number" value="1" class="form-control input-sm">
                                <button class="btn btn-default btn-sm">+</button>
                                <span class="price">$27</span>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="pay">
                            <span class="total">$81</span>
                            <button class="btn btn-lg btn-success pull-right">Delivery</button>
                            <div class="clear"></div>
                        </div>
                    </div>
                    -->
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<nav class="text-center"> <span><a href="#">关注 </a> </span> | <span><a
				href="#"> 客服热线：4000000</a></span> </nav>
		</div>
	</div>
	<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<html>
<meta charset="UTF-8">
<title>SMS - home</title>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/js/vendor/OperateOrderHistory.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/basic.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/css/vendor/basic.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/vendor/index.css'/>" />

<body>

	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

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
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Order Center</li>
								<li role="presentation"><a href="NewOrder.html"> <i
										class="glyphicon glyphicon-triangle-right"> </i>&emsp;New
										Order<span class="badge">2</span></a></li>
								<li class="active" role="presentation"><a href="#"><i
										class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed
										Order</a></li>
								<br />
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
								<li role="presentation"><a href="FoodManageMent.html">
										<i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food
										Management
								</a></li>
								<br />
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
							<span class="spantitle"><i
								class="glyphicon glyphicon-th-list"></i>&emsp;Store Credit</span>
							<ul class="nav nav-pills nav-stacked">
								<li>Shop Name : <label class="ShopNameLabel">Iphone
										Shop</label>
								</li>
								<li>Business score : <label class="ShopNameLabel">9.0</label>
								</li>
								<li>Average service time: <label class="ShopNameLabel">20
										min</label>
								</li>
								<li>Collection index: <label class="ShopNameLabel"><i
										class="glyphicon glyphicon-heart"></i></label>
								</li>
							</ul>

						</div>
					</div>
					<div class="col-xs-9 main-wrapper">
						<div id="flowLayot" class="col-xs-12">



							<div class="col-xs-12"
								style="height: 180px; margin-bottom: 70px;">
								<h3>Order History:</h3>
								<div style="overflow-y: scroll; height: 500px;">
									<table class="table"
										style="border: 1px solid #ddd; margin-bottom: 0px;">
										<tr>
											<td width="120px">订单号</td>
											<td>时间</td>
											<td>选择餐品</td>
											<td>评分</td>
											<td>评价</td>
											<td>状态</td>
											<td>操作</td>

										</tr>

										<tbody id="HistoryTbody">

										</tbody>

									</table>
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
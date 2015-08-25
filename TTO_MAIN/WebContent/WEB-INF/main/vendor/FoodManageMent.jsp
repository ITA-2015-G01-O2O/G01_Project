<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	src="<c:url value='/js/vendor/OperateMenu.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/css/vendor/index.css'/>"></script>
<script type="text/javascript"
	src="<c:url value='/css/vendor/basic.css'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/basic.js'/>"></script>
</head>

<body>
	<div class="modal fade bs-example-modal-sm1" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Menu</h4>
				</div>
				<div class="modal-body">
					<div class="col-xs-12">
						<div class="col-xs-6">
							<div>
								<img id="showMenuPic" width="200" height="200"
									src="img/vendor/1.jpg" class="page-text" />
							</div>
							<div class="controls page-text">
								<input name="productPic" type="file" id="MenuPic"
									style="display: none; margin-bottom: 10px;"></input> <span
									style="margin-top: 5px;" class="btn btn-primary btn-lg"
									onclick="$('#MenuPic').click();">Choose Menu Picture</span> <br />
								<div>
									<label>（Max size 2M,form：JPG,PNG,BMP）</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6" style="float: left;">
							<label>Menu Name:</label> <br /> <input class="form-control"
								type="text" id="menuName" /> <br /> <label>Menu type:</label>
							<label id="menuType">中餐</label> <br /> <label>Menu
								Price:</label> <br /> <input class="form-control" type="text"
								id="menuPrice" /> <br />
						</div>
					</div>
					<div class="clear"></div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="addMenuBtn" type="button" class="btn btn-primary">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>


	<!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>-->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Update Menu</h4>
				</div>
				<div class="modal-body">
				 <input id="updateMenuName" text="text" class="form-control"/>
				 <input id="updateMenuPrice" text="text" class="form-control"/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="updateMenuBtn" type="button" class="btn btn-primary">Save
						changes</button>
				</div>
			</div>
		</div>
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
                            <li class="active">Confirm</li>1
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
								<li role="presentation"><a href="OrderCompleted.html"><i
										class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed
										Order</a></li>
								<br />
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
								<li role="presentation" class="active"><a
									href="FoodManageMent.html"> <i
										class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food
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
								<li role="presentation"><a href="BasicSetting.view"><i
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
						<div class="col-xs-12">
							<div class="col-xs-12 addButtonArea">
								<div class="col-xs-10">
									<div class="row">
										<ul class="nav nav-pills">
											<li role="presentation"><a href="#">中餐</a></li>
											<li role="presentation"><a href="#">西餐</a></li>
											<li role="presentation"><a href="#">甜点</a></li>
											<li role="presentation"><a href="#">中餐</a></li>
											<li role="presentation"><a href="#">西餐</a></li>

											<li role="presentation"><a href="#">中餐</a></li>
											<li role="presentation"><a href="#">西餐</a></li>
											<li role="presentation"><a href="#">甜点</a></li>
											<li role="presentation"><a href="#">中餐</a></li>
											<li role="presentation"><a href="#">西餐</a></li>
											<li role="presentation"><a href="#">甜点</a></li>
											<li role="presentation"><a href="#">中餐</a></li>
											<li role="presentation"><a href="#">西餐</a></li>
											<li role="presentation"><a href="#">甜点</a></li>
										</ul>
									</div>
								</div>

								<div class="col-xs-2 ">
									<button id="addButton" class="col-xs-2 btn btn-success"
										data-toggle="modal" data-target=".bs-example-modal-lg"
										style="width: 100px;">Add Type</button>
								</div>

							</div>

							<div class="col-xs-12 MenuArea">
								<div class="row">
									<div class="col-xs-10"></div>
									<div class="col-xs-2">
										<button id="addButton" class="col-xs-2 btn btn-success"
											data-toggle="modal" data-target=".bs-example-modal-sm1"
											style="width: 100px;">Add Memu</button>
									</div>
								</div>
							</div>

							<div id="menuModel" class="col-xs-4 hidden menuCreate">
								<div class="mealBox">
									<a href="#" class="thumbnail"> <!--
                                            	作者：chen.ace@outlook.com
                                            	时间：2015-08-24
                                            	描述：专门写一个Controller去获取图片
                                            --> <img
										src="img/vendor/rice.png">
									</a>
									<div class="row">
										<div class="col-xs-7">
											<h4 id="menuName">Blabla</h4>
										</div>
										<div class="col-xs-5 text-right">

											<h4 id="menuPrice" class="menuPrice">￥27</h4>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-7">
											<button id="del" class="btn btn-danger del">Del</button>
										</div>
										<div class="col-xs-5 text-right">

											<button id="update" class="btn btn-primary update"
												data-toggle="modal" data-target=".bs-example-modal-sm">Update</button>
										</div>
									</div>
								</div>
							</div>
							<!--<div class="col-xs-4">
									<div class="mealBox">
										<a href="#" class="thumbnail">
											<img src="img/rice.png">
										</a>
										<div class="row">
											<div class="col-xs-7">
												<h4>Blabla</h4>
											</div>
											<div class="col-xs-5 text-right">

												<h4 class="menuPrice">￥27</h4>
											</div>
										</div>
										<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
										<div class="row">
											<div class="col-xs-7">
												<button class="btn btn-danger">Del</button>
											</div>
											<div class="col-xs-5 text-right">

												<button class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>
								</div>-->
							<!--<div class="col-xs-4">
									<div class="mealBox">
										<a href="#" class="thumbnail">
											<img src="img/rice.png">
										</a>
										<div class="row">
											<div class="col-xs-7">
												<h4>Blabla</h4>
											</div>
											<div class="col-xs-5 text-right">

												<h4 class="menuPrice">￥27</h4>
											</div>
										</div>
										<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
										<div class="row">
											<div class="col-xs-7">
												<button class="btn btn-danger">Del</button>
											</div>
											<div class="col-xs-5 text-right">

												<button class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>
								</div>-->
							<!--<div class="col-xs-4">
									<div class="mealBox">
										<a href="#" class="thumbnail">
											<img src="img/rice.png">
										</a>
										<div class="row">
											<div class="col-xs-7">
												<h4>Blabla</h4>
											</div>
											<div class="col-xs-5 text-right">

												<h4 class="menuPrice">￥27</h4>
											</div>
										</div>
										<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
										<div class="row">
											<div class="col-xs-7">
												<button class="btn btn-danger">Del</button>
											</div>
											<div class="col-xs-5 text-right">

												<button class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>
								</div>-->
							<!--<div class="col-xs-4">
									<div class="mealBox">
										<a href="#" class="thumbnail">
											<img src="img/rice.png">
										</a>
										<div class="row">
											<div class="col-xs-7">
												<h4>Blabla</h4>
											</div>
											<div class="col-xs-5 text-right">

												<h4 class="menuPrice">￥27</h4>
											</div>
										</div>
										<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
										<div class="row">
											<div class="col-xs-7">
												<button class="btn btn-danger">Del</button>
											</div>
											<div class="col-xs-5 text-right">

												<button class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>
								</div>-->
							<!--<div class="col-xs-4">
									<div class="mealBox">
										<a href="#" class="thumbnail">
											<img src="img/rice.png">
										</a>
										<div class="row">
											<div class="col-xs-7">
												<h4>Blabla</h4>
											</div>
											<div class="col-xs-5 text-right">

												<h4 class="menuPrice">￥27</h4>
											</div>
										</div>
										<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla</h5>
										<div class="row">
											<div class="col-xs-7">
												<button class="btn btn-danger">Del</button>
											</div>
											<div class="col-xs-5 text-right">

												<button class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>
								</div>-->
						</div>
						<div class="row">
							<div class="col-xs-12">
								<nav class="text-center">
								<ul class="pagination">
									<li><a href="#" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
								</nav>
							</div>
							<!--
                            	作者：chen.ace@outlook.com
                            	时间：2015-08-22
                            	描述:增加 关注| 客服热线：4000000
                            -->

						</div>

						<div class="col-xs-12">
							<nav class="text-center"> <span><a href="#">关注 </a>
							</span> | <span><a href="#"> 客服热线：4000000</a></span> </nav>
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
			<a href="#" onclick="gotoTop();return false;" class="totop">
				<div></div>
			</a>
		</div>
	</div>
	<script>
		$(function() {
			$("#MenuPic").uploadPreview({
				Img : "showMenuPic",
				Width : 120,
				Height : 120
			});
		});
	</script>

</body>

</html>
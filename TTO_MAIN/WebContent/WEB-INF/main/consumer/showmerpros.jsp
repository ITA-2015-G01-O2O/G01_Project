<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.clear {
	clear: both;
}

body {
	background: #eee;
}

.container-main {
	background: #eee;
	width: 1100px;
	margin-bottom: 50px;
	padding-bottom: 50px;
}

.container-main .text-muted {
	color: #bbb;
}

.mealBox {
	margin-bottom: 50px;
	padding: 0 10px;
	word-wrap: break-word;
}

.mealBox img {
	width: 100%;
}

.breadcrumb-wrapper {
	border-bottom: 1px solid #ddd;
	margin-bottom: 20px;
}

.breadcrumb {
	background: #fff;
	margin-bottom: 0;
}

.main-wrapper {
	border-right: 1px solid #ddd;
	border-left: 1px solid #ddd;
}

.myCart {
	position: relative;
	padding: 5px 0 0 10px;
	margin-top: 50px;
	background-color: white;
}

.myCart i {
	font-size: 35px;
	margin-right: 10px;
}

.myCart .badge {
	position: absolute;
	left: 0;
	top: 0;
	background-color: #e00;
}

.orders {
	margin-top: 40px;
	padding: 0 10px 50px;
	overflow-y: auto;
	overflow-x: hidden;
	background-color: white;
}

.orders .orderBox {
	word-wrap: break-word;
	margin-top: 40px;
}

.orders .orderBox input {
	width: 60px;
	display: inline-block;
}

.orders .orderBox button {
	width: 30px;
}

.orders .orderBox .price {
	font-weight: bold;
	font-size: 23px;
	float: right;
}

.pay .total {
	font-weight: bold;
	font-size: 40px;
	position: relative;
	top: -5px;
}

.imfolist {
	height: 150px;
	word-wrap: break-word;
}

.imfoimg {
	background-color: white;
}

.imfoimg img {
	padding: 20px;
	width: 150px;
	height: 150px;
}

.secondTitle {
	background-color: white;
	padding: 20px;
}

.secondTitle button {
	margin: 10px;
	border: 0px;
}

.commentlist {
	border: 1px solid #eee;
	word-wrap: break-word;
}

.preferInfo {
	margin-top: 40px;
	padding: 0 10px 50px;
	overflow-y: auto;
	overflow-x: hidden;
	background-color: white;
}

.preferInfo .preferInfoBox {
	word-wrap: break-word;
	margin-top: 40px;
}

.nav-tabs {
	width: 236px;
}

.nav-tabs.affix {
	top: 30px;
	/* Set the top position of pinned element */
}

.affix-bottom {
	position: absolute;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#main-nav">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="index.html"><img src="../img/title_client.png"
				width="70px" style="margin-top: 8px"></a>
		</div>
		<div class="collapse navbar-collapse" id="main-nav">
			<ul class="nav navbar-nav">
				<li><a href="#">Change Of Address </a></li>
				<input type="hidden" id="merId" value="${merId}" />
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">137*****</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container container-main">
		<div class="row">
			<div class="col-xs-12">

				<div class="row">

					<div class="col-xs-9">

						<div class="row">
							<div class="jumbotron" style="background-color: white;">
								<div class="col-xs-5">
									<img src="../img/img.png" />

								</div>
								 <div class="col-xs-7" style="word-wrap: break-word;">
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <h3 id="storeName"></h3>
                                            <h5 id="detailLocation"></h5>

                                        </div>
                                        <div class="col-xs-4">
                                            <h3 id="avgPoint"></h3>
                                            <h5>商家平均分</h5>
                                        </div>
                                        <div class="col-xs-4">
                                            <h3 id="avgDeliverTime"></h3>
                                            <h5>平均送达时间</h5>
                                        </div>
                                    </div>
                                    <h5 id="startingFee"></h5>
                                     <h5 id="deliverFee"></h5>
                                    <a href="#"><h5><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>收藏</h5></a>
                                </div>
								<div class="clear"></div>
							</div>

						</div>

						<div class="row">
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#meals"
									aria-controls="Meals" role="tab" data-toggle="tab">Meals</a></li>
								<li role="presentation"><a href="#comment"
									aria-controls="comment" role="tab" data-toggle="tab">Conmment</a></li>
							</ul>

							<div class="tab-content">

								<div role="tabpanel " class="tab-pane active" id="meals">

									<div class="col-xs-12 secondTitle" id="showAllpros">
										<button type="button" class="btn btn-default btn-lg active">Sort</button>
										<button type="button" class="btn btn-default btn-lg ">Profile</button>
										<button type="button" class="btn btn-default btn-lg ">Messages</button>
									</div>
									<div class="col-xs-3 imfoimg" id="proimg"
										style="display: none;">
										<img src="../img/img.png" />
									</div>

									<div class="col-xs-9 imfolist" id="proInfo" style="background-color: white;display: none;" >
										<h4>红烧猪蹄</h4>
										<span style="display: none;">1</span>
										<h5>
											￥<span>20</span>/份
										</h5>
										<h5 class="text-muted">
											月售<span>50</span>份
										</h5>
										<button type="button" onclick="addMeals(this)"
											class="btn btn-success pull-right">Add</button>
									</div>
									<!-- 
											<div class="col-xs-3 imfoimg">
												<img src="img.png"  style="height: 150px;" />
											</div>

											<div class="col-xs-9 imfolist" style="background-color: white;">
												<h4>红烧猪脚</h4>
												<span style="display: none;">2</span>
												<h5>￥<span>20</span>/份</h5>
												<h5 class="text-muted">月售<span>50</span>份</h5>
												<button type="button" onclick="addMeals(this)" class="btn btn-success pull-right">Add</button>
											</div>
								
											<div class="col-xs-3 imfoimg">
												<img src="img.png"  style="height: 150px;" />
											</div>

											<div class="col-xs-9 imfolist" style="background-color: white;">
												<h4>卤酱猪脚</h4>
												<span style="display: none;">3</span>
												<h5>￥<span>20</span>/份</h5>
												<h5 class="text-muted">月售<span>50</span>份</h5>
												<button type="button" onclick="addMeals(this)" class="btn btn-success pull-right">Add</button>
											</div>
						
											<div class="col-xs-3 imfoimg">
												<img src="img.png"  style="height: 150px;" />
											</div>

											<div class="col-xs-9 imfolist" style="background-color: white;">
												<h4>卤酱猪手</h4>
												<span style="display: none;">4</span>
												<h5>￥<span>20</span>/份</h5>
												<h5 class="text-muted">月售<span>50</span>份</h5>
												<button type="button" onclick="addMeals(this)" class="btn btn-success pull-right">Add</button>
											</div>
											<div class="col-xs-3 imfoimg">
												<img src="img.png"  style="height: 150px;" />
											</div>

											<div class="col-xs-9 imfolist" style="background-color: white;">
												<h4>隆江猪脚</h4>
												<span style="display: none;">5</span>
												<h5>￥<span>20</span>/份</h5>
												<h5 class="text-muted">月售<span>50</span>份</h5>
												<button type="button" onclick="addMeals(this)" class="btn btn-success pull-right">Add</button>
											</div>
											<div class="col-xs-3 imfoimg">
												<img src="img.png"  style="height: 150px;" />
											</div>

											<div class="col-xs-9 imfolist" style="background-color: white;">
												<h4>隆江猪手</h4>
												<span style="display: none;">6</span>
												<h5>￥<span>20</span>/份</h5>
												<h5 class="text-muted">月售<span>50</span>份</h5>
												<button type="button" onclick="addMeals(this)" class="btn btn-success pull-right">Add</button>
											</div>
										 -->
								</div>

								<div role="tabpanel" class="tab-pane" id="comment">

									<div class="col-xs-12 secondTitle">
										<button type="button" class="btn btn-default btn-lg active">好评（4-5分）</button>
										<button type="button" class="btn btn-default btn-lg ">中评（3分）</button>
										<button type="button" class="btn btn-default btn-lg ">差评（1-2分）</button>
									</div>
									<div class="col-xs-12 secondTitle commentlist">
										<div class="col-xs-3">评分：xx分</div>
										<div class="col-xs-9 text-right">点评时间：2015-08-23
											12:00:00</div>
										<div class="col-xs-12 secondTitle">
											点评内容：
											<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla
											</h5>
										</div>
									</div>
									<div class="col-xs-12 secondTitle commentlist">
										<div class="col-xs-3">评分：xx分</div>
										<div class="col-xs-9 text-right">点评时间：2015-08-23
											12:00:00</div>
										<div class="col-xs-12 secondTitle">
											点评内容：
											<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla
											</h5>
										</div>
									</div>
									<div class="col-xs-12 secondTitle commentlist">
										<div class="col-xs-3">评分：xx分</div>
										<div class="col-xs-9 text-right">点评时间：2015-08-23
											12:00:00</div>
										<div class="col-xs-12 secondTitle">
											点评内容：
											<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla
											</h5>
										</div>
									</div>
									<div class="col-xs-12 secondTitle commentlist">
										<div class="col-xs-3">评分：xx分</div>
										<div class="col-xs-9 text-right">点评时间：2015-08-23
											12:00:00</div>
										<div class="col-xs-12 secondTitle">
											点评内容：
											<h5 class="text-muted">BlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlablaBlabla
											</h5>
										</div>
									</div>

								</div>
							</div>

						</div>

					</div>

					<div class="col-xs-3">
						<div class="nav nav-tabs nav-stacked" data-spy="affix"
							data-offset -top="100" data-offset-bottom="100">
							<div class="preferInfo">
								<div class="preferInfoBox">
									<h4>商家营业公告及营业时间</h4>
									<h5 class="text-muted" id="announcement">
									</h5>
									<h5 class="text-muted">营业开始时间<span id="serviceBeginTime"></span> </h5>
									<h5 class="text-muted">营业结束时间<span id="serviceEndTime"></span> </h5>
									</h5>
								</div>

							</div>

							<div class="orders" id="ordersCard">
								<div class="myCart text-muted">
									<i class="glyphicon glyphicon-shopping-cart"></i><span>My
										Cart</span><span class="badge">42</span>
								</div>
								<div class="orderBox" id="orderBoxCopy" style="display: none;">
									<h4></h4>
									<span style="display: none;"></span>
									<button class="btn btn-default btn-sm" onclick="del1(this)">-</button>
									<input type="number" value="1" class="form-control input-sm">
									<button class="btn btn-default btn-sm" onclick="add1(this)">+</button>
									<span class="price"></span> <span style="display: none;"></span>
									<div class="clear"></div>
								</div>
							</div>

							<div class="pay" id="payCount">
								<span class="total">$0</span>
								<button class="btn btn-lg btn-success pull-right" onclick="deliveryPros()">Delivery</button>
								<div class="clear"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
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
	
	
	
	<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="../js/consumer/merpros.js"></script>
	<script src="../js/consumer/Ordermodel.js"></script>
</body>

</html>
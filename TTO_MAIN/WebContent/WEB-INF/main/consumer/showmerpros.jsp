<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Products</title>
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../css/basic.css">
<style>
.clear {
	clear: both;
}

.container-main {
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

.cart {
	position: relative;
	padding: 5px 0 0 10px;
	margin-top: 50px;
	background-color: white;
}

.cart i {
	font-size: 35px;
	margin-right: 10px;
}

.cart .badge {
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
	padding-top: 20px;
	height: 150px;
	word-wrap: break-word;
	border-bottom: 1px dashed #eee;
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

#payCount {
	margin-top: 30px;
}

.secondTitle a {
	border: 1px solid #e0e0e0;
	margin-left: 5px;
	margin-right: 5px;
}
</style>
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="true">
		<jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
	</jsp:include>
	<div class="container container-main">
		<div class="row">
			<div class="col-xs-12">

				<div class="row">

					<div class="col-xs-9">

						<div class="row">
							<div class="jumbotron panel">
								<input type="hidden" id="merId" value=${merId } />
								<div class="col-xs-5">
									<img id="storeImgId" class="thumbnail" src="../img/img.png" />

								</div>
								<div class="col-xs-7" style="word-wrap: break-word;">
									<div class="row">
										<div class="col-xs-4">
											<h3 id="storeName"></h3>
										</div>
										<div class="col-xs-4">
											<h3 id="avgPoint"></h3>

										</div>
										<div class="col-xs-4">
											<h3 id="avgDeliverTime"></h3>

										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<h5 id="detailLocation"></h5>
										</div>
										<div class="col-xs-4">
											<h5>商家平均分</h5>
										</div>
										<div class="col-xs-4">
											<h5>平均送达时间</h5>
										</div>
									</div>
									<h5 id="startingFee" class="label label-primary"></h5>
									<h5 id="deliverFee"></h5>
									<a href="#" onclick="addCollect()" class="btn btn-default">

										<i class="glyphicon glyphicon-heart " aria-hidden="true "></i>收藏

									</a>
								</div>
								<div class="clear "></div>
							</div>

						</div>

						<div class="row ">
							<ul class="nav nav-tabs " role="tablist ">
								<li role="presentation " class="active "><a href="#meals "
									aria-controls="Meals " role="tab " data-toggle="tab ">Meals</a></li>
								<li role="presentation "><a href="#comment "
									aria-controls="comment" role="tab" data-toggle="tab"
									onclick="conment()">Conmment</a></li>
							</ul>

							<div class="tab-content">

								<div role="tabpanel" class="tab-pane active" id="meals">

									<div class="col-xs-12 secondTitle" id="showAllpros">
										<a type="button" class="btn btn-default btn-sm"
											onclick="clickproLabelgetAll()">All</a> <a type="button "
											id="labelBtn" class="btn btn-default btn-sm "
											style="display: none" onclick="clickproLabel(this)">Sort</a>
									</div>
									<div class="col-xs-3 imfoimg" id="proimg"
										style="display: none;">
										<img src=" " />
									</div>

									<div class="col-xs-9 imfolist" id="proInfo"
										style="background-color: white; display: none;">
										<h4>红烧猪蹄</h4>
										<span style="display: none;">1</span>
										<h5>
											￥<span>20</span>/份
										</h5>
										<h5 class="text-muted ">
											月售<span>50</span>份
										</h5>
										<button type="button " onclick="addMeals(this) "
											class="btn btn-default pull-right ">
											<i class="glyphicon glyphicon-shopping-cart "></i> Add
										</button>
									</div>

								</div>

								<div role="tabpanel" class="tab-pane" id="comment">

									<div class="col-xs-12 secondTitle">
										<button type="button" class="btn btn-default btn-lg"
											onclick="conment()">全部</button>
										<button type="button" class="btn btn-default btn-lg"
											onclick="getComby(4)">好评（4-5分）</button>
										<button type="button" class="btn btn-default btn-lg"
											onclick="getComby(3)">中评（3分）</button>
										<button type="button" class="btn btn-default btn-lg"
											onclick="getComby(1)">差评（1-2分）</button>
									</div>
									<div class="col-xs-12 secondTitle commentlist"
										id="commentInfo" style="display: none">
										<div class="col-xs-3">
											评分：<span></span>分
										</div>
										<div class="col-xs-9 text-right">
											送餐时间：<span></span>分钟
										</div>
										<div class="col-xs-12 secondTitle">
											点评内容：
											<h5 class="text-muted"></h5>
										</div>
									</div>




								</div>
							</div>

						</div>

					</div>

					<div class="col-xs-3 ">
						<div class="nav nav-tabs nav-stacked " data-spy="affix "
							data-offset -top="100 " data-offset-bottom="100 ">
							<div class="preferInfo ">
								<div class="preferInfoBox ">
									<h4>商家营业公告及营业时间</h4>
									<h5 class="text-muted " id="announcement"></h5>
									<h5 class="text-muted ">
										营业开始时间:<span id="serviceBeginTime"></span>
									</h5>
									<h5 class="text-muted ">
										营业结束时间:<span id="serviceEndTime"></span>
									</h5>
									</h5>
								</div>

							</div>

							<div class="orders " id="ordersCard">
								<div class="cart text-muted ">
									<i class="glyphicon glyphicon-shopping-cart "></i><span>My
										Cart</span>
								</div>
								<div class="orderBox " id="orderBoxCopy" style="display: none;">
									<h4></h4>
									<span style="display: none;"></span>
									<button class="btn btn-default btn-sm " onclick="del1(this) ">-</button>
									<input type="number " value="1 " readOnly="true "
										class="form-control input-sm ">
									<button class="btn btn-default btn-sm " onclick="add1(this) ">+</button>
									<span class="price "></span> <span style="display: none;"></span>
									<div class="clear "></div>
								</div>
							</div>

							<div class="pay " id="payCount">
								<span class="total ">$0</span>
								<button class="btn btn-lg btn-success pull-right "
									onclick="deliveryPros() ">Delivery</button>
								<div class="clear "></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade " id="orderEmpty" tabindex="-1 " role="dialog "
		aria-labelledby="myModalLabel ">
		<div class="modal-dialog " role="document ">
			<div class="modal-content ">
				<div class="modal-body ">
					<h5>Choose a meal, pls</h5>
				</div>
				<div class="modal-footer ">
					<button type="button " class="btn btn-default "
						data-dismiss="modal ">Comfirm</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade " id="successaddCollect" tabindex="-1 "
		role="dialog " aria-labelledby="myModalLabel ">
		<div class="modal-dialog " role="document ">
			<div class="modal-content ">
				<div class="modal-body ">
					<h5>collect successfully!!</h5>
				</div>
				<div class="modal-footer ">
					<button type="button " class="btn btn-default "
						data-dismiss="modal ">Comfirm</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/loginmodal.jsp"%>
	<jsp:include page="../common/footer.jsp " flush="true ">
		<jsp:param name="config_hotLine " value="${config_hotLine} "></jsp:param>
	</jsp:include>

</body>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js "></script>
<script
	src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js "></script>
<script src="../js/consumer/merpros.js "></script>
<script src="../js/consumer/Ordermodel.js "></script>
<script src="../js/jquery.cookie.js "></script>
<script src="<c:url value='/js/common/basic.js' />"></script>

</html>

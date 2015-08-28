<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<html>
<meta charset="UTF-8">
<title>SMS - home</title>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
<link rel="stylesheet" href="<c:url value='/css/basic.css'/>">
<script src="<c:url value='/js/jquery.cookie.js'/>"></script>
<script src="<c:url value='/js/common/basic.js'/>"></script>
<body>
	<jsp:include page="../common/header.jsp" flush="true">
		<jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
	</jsp:include>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Order Detail</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tbody id="tbody">
							<tr>
								<td>订单号：</td>
								<td><label id="orderNum">123456677743322</label></td>
							</tr>
							<tr>
								<td>日期：</td>
								<td><label id="orderDate">2015-08-09 12:20</td>
							</tr>
							<tr>
								<td>选择餐品：</td>
								<td><label id="orderMenu">鸡肉，牛肉，猪肉</td>
							</tr>
							<tr>
								<td>评分：</td>
								<td><label id="orderPoint">9.0</td>
							</tr>
							<tr>
								<td>状态：</td>
								<td><label id="orderState">Finished</td>
							</tr>
							<tr>
								<td>消费金额：</td>
								<td><label id="orderPrice">100</td>
							</tr>
							<hr />
							<tr>
								<td>消费者：</td>
								<td><label id="Name">Ace</td>
							</tr>
							<tr>
								<td>联系号码：</td>
								<td><label id="Phone">137500012345</td>
							</tr>
							<tr>
								<td>留言：</td>
								<td><label id="Remark">Good</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
								<li  role="presentation">
										<a href="<c:url value='/vendor/order/NewOrder.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;New Order<span class="badge"  style="background-color: red">2</span></a>
									</li>
									<li role="presentation" class="active"><a href="<c:url value='/vendor/order/OrderCompleted.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed Order</a></li>
									<br/>
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
									<li role="presentation">
										<a href="<c:url value='/vendor/product/FoodManageMent.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food Management</a>
									</li>
								<br />
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Account Center</li>
									<li role="presentation">
										<a href="<c:url value='/vendor/personalInfo/PersonalInformation.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Personal Information</a>
									</li>
									<li role="presentation"><a href="<c:url value='/vendor/storeInfo/storeInfo.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Store Information</a></li>
									<li role="presentation"><a href="<c:url value='/vendor/basicSetting/BasicSetting.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Basic Settings</a></li>
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
								<li>Store Name : <label class="ShopNameLabel"
									id="shopNameLabel">${storeName}</label>
								</li>
								<li>Store average point : <label class="ShopNameLabel"
									id="avgPointLabel">${avgPoint}</label>
								</li>
								<li>Store average deliver Time: <label
									class="ShopNameLabel" id="avgTimeLabel">${avgTime}</label>
								</li>
								<li>Collection Number: <label class="ShopNameLabel"
									id="collectionNumLabel">${collectionNum}</label>
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

	</div>
	<jsp:include page="../common/footer.jsp" flush="true">
		<jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
	</jsp:include>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMS - home</title>
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

.th-inner {
	padding: 17px 0;
	font-size: 14px;
}

.alight-left {
	text-align: left;
}

.alight-right {
	text-align: right;
}

.dishtable {
	color: #434343;
	border: 1px solid #ebebeb;
	background-color: #ffffff;
	font: 12px/1.125 Microsoft Yahei, Arial, Helvetica, sans-serif;
}

.left {
	padding-left: 15px;
}

.right {
	padding-right: 15px;
}

.td-inner {
	background: url(img/order-border.png) repeat-x;
	padding: 17px 0;
	font-size: 14px;
}

.address-box {
	border: 1px solid #eeeeee;
	height: 86px;
	line-height: 86px;
	width: 600px;
	cursor: pointer;
	background-color: #fafafa;
	color: #898989;
	font-size: 14px;
	text-align: center;
	margin-bottom: 20px;
}

.address-box2 {
	border: 1px solid #eeeeee;
	height: 100px;
	line-height: 86px;
	width: 600px;
	background-color: #fafafa;
	color: black;
	text-align: center;
	font-size: 14px;
	margin-top: 30px;
	margin-bottom: 20px;
}

input {
	border: 1px solid #eeeeee;
	height: 25px;
	line-height: 18px;
	margin: 0;
	width: 351px;
	background-position: -579px 0;
	padding-left: 6px;
	padding-bottom: 8px;
	padding-top: 8px;
	background-repeat: no-repeat;
}

.merchantMsgclass {
	margin: 20px;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" flush="true">
		<jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
	</jsp:include>
	<div class="container container-main">
		<span style="display: none" id="merId">${merId}</span>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-4">
						<table class="dishtable">
							<thead>
								<tr>
									<th class="left" width="240px">
										<div class="th-inner alight-left">菜品</div>

									</th>

									<th class="right">
										<div class="th-inner alight-right">价格/份数</div>
									</th>
								</tr>

							</thead>
							<tbody id="showorderpros1">
								<tr>
									<td class="left" width="240px">
										<h4 style="font-weight: bold;">合计</h4>
									</td>
									<td class="right">
										<div class="alight-right">
											<h5 style="font-weight: bold;" id="totalcount">
												$0
												</h4>
										</div>
									</td>
								</tr>

								<tr id="showorderCopy" style="display: none">
									<td class="left" width="240px">
										<div class="td-inner alight-left"></div> <span
										style="display: none"></span>
									</td>

									<td class="right">
										<div class="td-inner alight-right"></div>
									</td>

								</tr>

							</tbody>
						</table>

					</div>

					<div class="col-xs-8"
						style="background-color: white; height: 350px;">
						<div class="col-lg-12">
							<h4>送餐详情</h4>
							<div class="address-box" id="addadress" data-toggle="modal"
								data-target="#addressModal">添加地址</div>
						</div>
						<div style="display: none" class="address-box2"
							id="showaddressInfo" onclick="addaddress()" data-toggle="modal"
							data-target="#addressModal">
							<h5>
								联系人：<label id="contact"></label>
							</h5>
							<h5>
								电话：<label id="phonenum"></label>
							</h5>
							<h5>
								详细地址：<label id="addressInfo"></label>
							</h5>
						</div>
						<div class="col-lg-12 merchantMsgclass">
							<label for="merchantmsg" class="col-sm-3 control-label">给商家留言：</label>
							<input type="text" width="200px" id="merchantmsg"
								placeholder="不要辣，多放盐等口味要求">
						</div>
						<div class="col-lg-12 ">
							<div class="td-inner"></div>
							<span style="font-weight: bold; font-size: 20px;">支付方式:</span> <span
								style="color: #fe4d3d">货到付款</span>
						</div>
						<button type="button" class="btn btn-primary pull-right"
							id="getusebtn" onclick="confirmbuy()">Comfirm</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="addressModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="form-horizontal center-block well"
					style="max-height: 400px; max-width: 450px; margin-top: 50px;">
					<h2 class="form-inline">Your Information</h2>
					<div class="form-group">
						<label for="merchantName" class="col-sm-4 control-label"
							style="font: 20px/1.125 Microsoft Yahei, Arial, Helvetica, sans-serif;">*联系人:</label>
						<div class="col-sm-5 input-group " id="merchantName">

							<input type="text" class="form-control" id="ausername">
						</div>
					</div>

					<div class="form-group">
						<label for="merchantPhone" class="col-sm-4 control-label"
							style="font: 20px/1.125 Microsoft Yahei, Arial, Helvetica, sans-serif;">*手机号码:</label>
						<div class="col-sm-5 input-group " id="merchantPhone">
							<input type="text" class="form-control" id="auserPhone">
						</div>
					</div>
					<div class="form-group">
						<label for="merchantAddress" class="col-sm-4 control-label"
							style="font: 20px/1.125 Microsoft Yahei, Arial, Helvetica, sans-serif;">*详细地址:</label>
						<div class="col-sm-5 input-group " id="merchantAddress">
							<input type="text" class="form-control" id="auseraddress">
						</div>
					</div>
					<div class="form-group">
						<div class="alert alert-danger" style="display: none" role="alert"
							id="errorMsg2"></div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="getusebtn"
						onclick="confirmorderbtn()">Comfirm</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



	<%@ include file="../common/loginmodal.jsp"%>
	<jsp:include page="../common/footer.jsp" flush="true">
		<jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
	</jsp:include>

	<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="../js/consumer/comfirmorder.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script type="text/javascript" src="../js/common/basic.js"></script>
</body>
</html>
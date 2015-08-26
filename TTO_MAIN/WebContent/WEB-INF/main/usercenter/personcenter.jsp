<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../js/usercenter/myfav.js"></script>
<script src="../js/usercenter/myinfo.js"></script>
<script src="../js/usercenter/myorder.js"></script>
<script src="../js/usercenter/personcenter.js"></script>
<link rel="stylesheet" href="../css/usercenter/myfav.css" />
<link rel="stylesheet" href="../css/usercenter/myinfo.css" />
<link rel="stylesheet" href="../css/usercenter/myorder.css" />
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
			<a href="index.html"><img src="../img/usercenter/title_admin.png"
				width="70px" style="margin-top: 8px"></a>
		</div>
		<div class="collapse navbar-collapse" id="main-nav">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Hello user</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-log-out"></i></a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container container-main">

		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-2">
						<ul class="nav nav-pills nav-stacked">
							<ul class="nav nav-tabs nav-stacked" role="tablist">
								<li role="presentation" class="active"><a href="#home"
									aria-controls="home" role="tab" data-toggle="tab">myorder</a></li>
								<li role="presentation"><a href="#profile"
									aria-controls="profile" role="tab" data-toggle="tab"
									onclick="loadMyInfo()">myinfo</a></li>
								<li role="presentation"><a href="#messages"
									aria-controls="messages" role="tab" data-toggle="tab"
									onclick="loadMyFav()">myfav</a></li>
							</ul>
						</ul>
					</div>
					<div class="col-xs-10 main-wrapper">

						<div class="row" id="mainContent">
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="home"></div>

								<div role="tabpanel" class="tab-pane" id="profile">
									<div class="col-xs-3"></div>

									<div class="col-xs-6" id="userinfo">
										<form class="form-horizontal">
											<div class="form-group">
												<label class="col-sm-2 control-label">tel</label>
												<div class="col-sm-10">
													<p class="form-control-static" id="userInfo_uname"></p>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword" class="col-xs-2 control-label">Password</label>
												<div class="col-xs-10">
													<ul class="list-inline">
														<li><p class="form-control" id="userInfo_password"></p>
														</li>
														<li><a class="btn btn-info" id="changePsd">change
																psd</a></li>

													</ul>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">account:</label>
												<div class="col-sm-10">
													<ul class="list-inline">
														<li class="form-control-static"><p id="userInfo_fund"></p></li>
														<li><a class="btn btn-info" id="charge">charge</a></li>
													</ul>
												</div>
											</div>
										</form>
									</div>

									<div class="col-xs-3"></div>

								</div>

								<div role="tabpanel" class="tab-pane" id="messages"></div>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="hidden" id="myordermodel">
			<div class="col-xs-12 res_content  page-header ">
				<div class="col-xs-1"></div>
				<div class="col-xs-2">
					<img src="" id="showImg" width="100px" height="80px" />
				</div>
				<div class="col-xs-6">
					<ul class="list-inline">
						<li>res name:<lable id="resOVoname"></lable></li>
						<li>res tel:<lable id="resOVoPhone"></lable></li>
					</ul>
					<ul class="list-inline">
						<li>order number:<lable id="resOVoOrderNumber"></lable></li>
						<li>oder time:<lable id="resOVoOrderTime"></lable></li>
					</ul>

				</div>
				<div class="col-xs-2">
					<div>order state:</div>
					<div>
						<span class="btn btn-info"><lable id="resOVoOrderState"></lable></span>
					</div>
				</div>
				<div class="col-xs-1"></div>
			</div>
			<div class="">
				<div class="clo-xs-12 ">
					<div class="col-xs-4">
						<div class="">
							<table class="table table-bordered ">
								<caption>orderInfo</caption>
								<thead>
									<th class="active">productId</th>
									<th class="active">productName</th>
									<th class="active">productPrice</th>
								</thead>
								<tfoot>
									<th class="active">productId</th>
									<th class="active">productName</th>
									<th class="active">productPrice</th>
								</tfoot>
								<tbody id="myordertbody">

								</tbody>
							</table>
							<div class="text-right">
								total:$<lable id="totalPrice"></lable>
								

							</div>
						</div>
					</div>
					<div class="col-xs-8">

						<div class="col-xs-12 myclass1">
							<div class="col-xs-2"></div>
							<div class="page-header ">order state</div>
							<div>
								contacter:
								<lable id="resOVoContacter"></lable>
							</div>
							<div>
								tel:
								<lable id="resOVoContactPhone"></lable>
							</div>
							<div>
								remarks:
								<lable id="resOVoRemarks"></lable>
							</div>
							<div>
								comment:
								<lable id="resOVoComment"></lable>
							</div>
							<div class="page-header ">addr:<lable id="detailLocation"></lable></div>
						</div>
						<div class="myclass1">
							<div class="text-center mymainhei" id="resReplyToUser">waiting for check by res</div>
							<div class=" text-right">
								<button class="btn btn-warning hidden" id="userCancelThisOrder">cancel order?</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<tr class="hidden" id="productListModul">
			<td class="active" id="productId"></td>
			<td class="success" id="productName"></td>
			<td class="warning" id="productPrice"></td>
		</tr>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Center.</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../js/usercenter/myfav.js"></script>
<script src="../js/usercenter/myinfo.js"></script>
<script src="../js/usercenter/myorder.js"></script>
<script src="../js/usercenter/personcenter.js"></script>
<script src="../js/usercenter/changepsw.js"></script>
<link rel="stylesheet" href="../css/usercenter/myfav.css" />
<link rel="stylesheet" href="../css/usercenter/myinfo.css" />
<link rel="stylesheet" href="../css/usercenter/myorder.css" />
<link rel="stylesheet" href="<c:url value='/css/basic.css'/>">
		<script src="<c:url value='/js/jquery.cookie.js'/>"></script>
		<script src="<c:url value='/js/common/basic.js'/>"></script>
<style>
	
.resOVoComment2 {
	padding: 5px;
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

														<li><input id="userInfo_password" type="password" />
														</li>
														<li><a class="btn btn-info" onclick="changePsw()">change
																psd</a></li>

														<li><div class="alert alert-danger"
																style="display: none" role="alert" id="errorMsg2"></div></li>

													</ul>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">account:</label>
												<div class="col-sm-10">
													<ul class="list-inline">
														<li class="form-control-static"><p id="userInfo_fund"></p></li>
														<li><button type="button" class="btn btn-primary btn-lg"
															data-toggle="modal" data-target="#chargePage">
															charge</button>
															<li>
	
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
		<!-- my order template -->
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
								total:$
								<lable id="totalPrice"></lable>


							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-offset-2">

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
							<div id="resOVoCommentFunc" style="display: none">
								<div>
									conment:
									<lable id="resOVoComment" style="display:none"></lable>
									score:
									<lable id="resOVoCommentscore2" style="display:none"></lable>
									deliver time:
									<lable id="resOVoCommenttime2" style="display:none"></lable>
								</div>
								<div id="resOVoComment2" style="display: none; padding: 5px;">
									comment:<input style="margin: 5px;" type="text"
										id="resOVoCommenttext" /> <br/>score:<input style="margin: 5px;"
										type="text" id="resOVoCommentscore" /> <br/>deliver time:<input
										style="margin: 5px;" type="text" id="resOVoCommenttime" />
									minute(s)<br/>
									<button onclick="commitcomment(this)"
										style="margin-left: 15px;" id="commitId">commit</button>
									<div class="alert alert-danger" style="display: none"
										role="alert" id="errorMsg3"></div>

								</div>
							</div>
							<div class="page-header ">
								addr:
								<lable id="detailLocation"></lable>
							</div>
						</div>
						<div class="myclass1">
							<div class="text-center mymainhei" id="resReplyToUser"></div>
							<div class=" text-right">
								<button class="btn btn-warning hidden" id="userConfirmThisOrder">confirm
									order?</button>
							</div>
							<div class=" text-right">
								<button class="btn btn-warning hidden" id="userCancelThisOrder">cancel
									order?</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--shopping car template  -->
		<tr class="hidden" id="productListModul">
			<td class="active" id="productId"></td>
			<td class="success" id="productName"></td>
			<td class="warning" id="productPrice"></td>
		</tr>
		<!-- modal of changepassword -->
		<div class="modal fade" id="showChangePsw" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						请输入原始密码：<input type="password" id="checkPassword" />
					</div>
					<div class="alert alert-danger" style="display: none" role="alert"
						id="errorMsg"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							onclick="confirmPsw()">Comfirm</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- change password success modal -->
		<div class="modal fade" id="successchange" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<h3>Update password successfully!!</h3>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Comfirm</button>
					</div>
				</div>
			</div>
		</div>
		<!-- change password fail modal -->
		<div class="modal fade" id="failchange" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<h3>Login,pls!!</h3>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Comfirm</button>
					</div>
				</div>
			</div>
		</div>
		<!-- favorite vendors template -->
		<div class="hidden" id="myfavinfo">
			<div class="col-xs-12">
				<div class="col-xs-1"></div>
				<div class="col-xs-10 myborder">
					<div class="col-xs-12 res_content  page-header">
						<div class="col-xs-1"></div>
						<div class="col-xs-2">
							<a href="#"><img src="" id="showStorePic" width="100px"
								height="50px" /></a>
						</div>
						<div class="col-xs-6">
							<ul class="list-inline">
								<li>res name:<lable id="resVoname"></lable></li>
								<li>res tel:<label id="resVophone"></label></li>
								<li>res addr:<lable id="resVodetailLocation"></lable></li>
							</ul>
							<ul class="list-inline">
								<li>res point:<lable id="resVopoint"></lable></li>
								<li>res sold amount:<lable id="resVoAmount"></lable></li>
								<li>res col amount:<lable id="resVoColAmount"></lable></li>
							</ul>
							<ul class="list-inline">

								<li>
									<button class="btn btn-warning" name="cancelfav">cancel
										fav</button>
								</li>
							</ul>
						</div>
						<div class="col-xs-1"></div>
					</div>
				</div>
				<div class="col-xs-1"></div>
			</div>


		</div>
		<!-- user charge template -->
		<div class="modal fade" id="chargePage" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">charge money</h4>
					</div>
					<div class="modal-body">
						<div>add amount:<input type="text" id="addMoney"></div>					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" id="saveCharge">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp" flush="true">
            <jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
        </jsp:include>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>SMS - home</title>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/js/vendor/OperateMenu.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/OperateMenuLabel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/vendor/basic.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/vendor/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/css/vendor/basic.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/vendor/index.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/basic.css'/>">
<script src="<c:url value='/js/jquery.cookie.js'/>"></script>
<script src="<c:url value='/js/common/basic.js'/>"></script>
<script  type="text/javascript"  src="<c:url value='/js/vendor/TimeSetting.js'/>"></script>
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="true">
		<jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
	</jsp:include>
	<div class="modal fade bs-example-modal-sm1" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<form id="form1" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Add Menu</h4>
					</div>
					<div class="modal-body">
						<div class="col-xs-12">
							<div class="col-xs-6">
								<div>
									<img id="showMenuPic" width="200" height="200" src="img/1.jpg"
										class="page-text" />
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
									type="text" id="menuName" name="menuName" /> <br /> <label>Menu
									type:</label>


								<div class="btn-group">
									<select class="selectMenuType" name="selectType">
										<!--<option style="width: 300px">1000</option>
									<!--	<option style="width: 200px">2</option>
										<option style="width: 200px">3</option>
										<option style="width: 200px">4</option>
										<option style="width: 200px">5</option>-->
									</select>
								</div>
								<br /> <label>Menu Price:</label> <br /> <input
									class="form-control" type="text" id="menuPrice"
									name="menuPrice" /> <br />
							</div>
						</div>
						<div class="clear"></div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button id="addMenuBtn" type="submit" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</form>
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
					<label>Product Name</label>
					<input id="updateMenuName" text="text" class="form-control" /> 
					<label>Produce Price</label>
					<input
						id="updateMenuPrice" text="text" class="form-control" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="updateMenuBtn" type="button" class="btn btn-primary">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>

	<!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>-->
	<div class="modal fade bs-example-modal-sm2" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add New Menu Type</h4>
				</div>
				<div class="modal-body">
					<input id="addMenuType" text="text" class="form-control" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="saveMenuTypeBtn" type="button" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container container-main">
		<div class="row">
			<div class="col-xs-12">
				<div class="row breadcrumb-wrapper"></div>
				<div class="row">
					<div class="col-xs-3">
						<div calss="operate">
							<ul class="nav nav-pills nav-stacked">
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Order Center</li>
								<li role="presentation"><a
									href="<c:url value='/vendor/order/NewOrder.view'/>"> <i
										class="glyphicon glyphicon-triangle-right"> </i>&emsp;New
										Order<span class="badge">2</span></a></li>
								<li role="presentation"><a
									href="<c:url value='/vendor/order/OrderCompleted.view'/>"><i
										class="glyphicon glyphicon-triangle-right"></i>&emsp;Completed
										Order</a></li>
								<br />
								<li role="presentation" class="title"><i
									class="glyphicon glyphicon-file"></i>&emsp;Meal Center</li>
								<li role="presentation" class="active"><a
									href="<c:url value='/vendor/product/FoodManageMent.view'/>">
										<i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Food
										Management
								</a></li>
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
						<div class="col-xs-12 menuFunctionArea">
							<div class="col-xs-12 addButtonArea">
								<div class="col-xs-10">
									<div class="row">
										<ul id="labelArea" class="nav nav-pills">
											<li id="a" class="menuLabel active" role="presentation"><a
												class="aLabel" href="#">All</a></li>
										</ul>
									</div>
								</div>
								<div class="col-xs-2 ">
									<button id="addButton" class="col-xs-2 btn btn-success"
										data-toggle="modal" data-target=".bs-example-modal-sm2"
										style="width: 100px;">Add Type</button>
								</div>

							</div>

							<div class="col-xs-12 MenuArea">
								<div class="row MenuArea">
									<div class="col-xs-10">&nbsp;</div>
									<div class="col-xs-2">
										<button id="addButton" class="col-xs-2 btn btn-success"
											data-toggle="modal" data-target=".bs-example-modal-sm1"
											style="width: 100px;">Add Memu</button>
									</div>
								</div>
							</div>
							<div class="menuTestArea"></div>
							<div id="menuModel" class="col-xs-4 hidden menuCreate">
								<div class="mealBox">
									<a href="#" class="thumbnail"> <!--
                                            	作者：chen.ace@outlook.com
                                            	时间：2015-08-24
                                            	描述：专门写一个Controller去获取图片
                                            --> <img id="srcImg"
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
						</div>

					</div>

				</div>


			</div>
			<a href="#" onclick="gotoTop();return false;" class="totop">
				<div></div>
			</a>
		</div>



	</div>
	<jsp:include page="../common/footer.jsp" flush="true">
		<jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
	</jsp:include>

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
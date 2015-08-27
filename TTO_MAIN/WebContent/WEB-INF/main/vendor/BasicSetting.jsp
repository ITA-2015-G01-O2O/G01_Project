<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Basic Setting</title>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/vendor/setting.css'/>" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>	
		<link href="<c:url value='/css/vendor/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" media="screen">
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/bootstrap-datetimepicker.js'/>" charset="UTF-8"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/bootstrap-datetimepicker.fr.js'/>" charset="UTF-8"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/basicSetting.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/css/basic.css'/>">
		<script src="<c:url value='/js/jquery.cookie.js'/>"></script>
		<script src="<c:url value='/js/common/basic.js'/>"></script>
	</head>

	<body>
		<jsp:include page="../common/header.jsp" flush="true">
            <jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
        </jsp:include>
		<div class="container container-main">
			<div class="row">
				<div class="col-xs-12">
					<div class="row breadcrumb-wrapper">
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
									<li role="presentation" class="title"><i class="glyphicon glyphicon-file"></i>&emsp;Account Center</li>
									<li class="active" role="presentation">
										<a href="<c:url value='/vendor/personalInfo/PersonalInformation.view'/>"> <i class="glyphicon glyphicon-triangle-right"> </i>&emsp;Personal Information</a>
									</li>
									<li role="presentation"><a href="<c:url value='/vendor/storeInfo/storeInfo.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Store Information</a></li>
									<li role="presentation"><a href="<c:url value='/vendor/basicSetting/BasicSetting.view'/>"><i class="glyphicon glyphicon-triangle-right"></i>&emsp;Basic Settings</a></li>
								</ul>
							</div>
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

							<div class="panel panel-default">

								<div class="panel-heading">Basic Setting</div>
								<div class="panel-body form-horizontal">
									
									<div class="page-text">	
    									<label>Announcement</label>
    									<div>
      										<input type="text" class="form-control" placeholder="Announcement" id="inputAnnouncement">
    									</div>
    									<div class="alert alert-danger" style="display: none;"  role="alert" id="announcementmsg">Announcement is too long!</div>
    								</div>
    								<div class="page-text">	
    									<label>Min Send Price</label>
    									<form class="form-inline">
  											<div class="form-group">
    											<div class="input-group">
      												<div class="input-group-addon">$</div>
      												<input type="text" class="form-control inputAmount" placeholder="Amount" id="inputMinAmount">     											
    											</div>
  											</div>
										</form>
										<div class="alert alert-danger" style="display: none;"  role="alert" id="minAmountmsg">Min send price can not be empty!</div>
    								</div>
    								<div class="page-text">	
    									<label>Shipment</label>
    									<form class="form-inline">
  											<div class="form-group">
    											<div class="input-group">
      												<div class="input-group-addon">$</div>
      												<input type="text" class="form-control inputAmount" id="inputShipment"  placeholder="Amount">						
    											</div>
  											</div>
										</form>
										<div class="alert alert-danger" style="display: none;"  role="alert" id="shipmentmsg">Shipment can not be empty!</div>
    								</div>
									<div class="page-text">	
    									<label>Pay type</label>
    									<div>
      										<input type="text" class="form-control" placeholder="Pay type" readonly id="inputPayType">
    									</div>
    									<div class="alert alert-danger" style="display: none;"  role="alert" id="payTypemsg">pay type can not be empty!</div>
    								</div>
									<div>
                						<label for="startTime" class="col-md-3 control-label" id="starttimelabel">Business Start time</label>
                						<div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="startTime" data-link-format="hh:ii">
                    						<input class="form-control" size="16" type="text"  readonly  id="startTime">
                    						<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                						</div>
										<input type="hidden"  value="" /><br/>
            						</div>
            						<div class="alert alert-danger" style="display: none;"  role="alert" id="startTimemsg">Please choose your bussiness start time!</div>
    								<div>
                						<label for="finishTime" class="col-md-3 control-label" id="finishtimelabel">Business finish time</label>
                						<div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="finishTime" data-link-format="hh:ii">
                    						<input class="form-control" size="16" type="text"  readonly id="finishTime">
                    						<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                						</div>
										<input type="hidden"  value="" /><br/>
            						</div>
            						<div class="alert alert-danger" style="display: none;"  role="alert" id="finishTimemsg">Please choose your bussiness finish time!</div>
									<button type="button" class="btn btn-primary btn-lg" id="save">Save</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<jsp:include page="../common/footer.jsp" flush="true">
            <jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
        </jsp:include>
		<script type="text/javascript">
	$('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
	</script>
	</body>

</html>
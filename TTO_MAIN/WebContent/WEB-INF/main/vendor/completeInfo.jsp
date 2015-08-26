<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />		
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/vendor/register.css'/>" />
		<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
		<link href="<c:url value='/css/vendor/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" media="screen">
		<script type="text/javascript" src="<c:url value='/js/vendor/bootstrap-datetimepicker.js'/>" charset="UTF-8"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/bootstrap-datetimepicker.fr.js'/>" charset="UTF-8"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/completeInfo.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/jquery.form.js'/>"></script>
		<title>Complete Information</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="index.html"><img src="<c:url value='/img/vendor/title_vender.png'/>" width="70px" style="margin-top:8px"></a>
				</div>
				<div class="collapse navbar-collapse" id="main-nav">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Welcome: Ace</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-log-out"></i></a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container container-main">	
			<form enctype="multipart/form-data" id="ci_form">
    		<div class="sign-form page-center form-horizontal">
    			<div class="page-text text-center">	
    				<h2>Please complete your store message</h2>
    			</div>   			
            	<div class="page-text">	
    				<label>Announcement</label>
    				<div>
      					<input type="text" class="form-control" placeholder="Announcement" id="inputAnnouncement" name="announcement">
    				</div>
    				<div class="alert alert-danger" style="display: none;"  role="alert" id="announcementmsg">Announcement is too long!</div>
    			</div>
    			<div class="page-text">	
    				<label>Min Send Price</label>
    				<form class="form-inline">
  						<div class="form-group">
    						<div class="input-group">
      							<div class="input-group-addon">$</div>
      							<input type="text" class="form-control inputAmount" placeholder="Amount" id="inputMinAmount" name="minPrice">      												
    						</div>
  						</div>
					</form>
					<div class="alert alert-danger" style="display: none;"  role="alert" id="minAmountmsg">Min send price can not be empty!</div>
    			</div>
    			<div class="page-text">	
    				<label>Shipment</label>
    				<div class="form-inline">
  						<div class="form-group">
    						<div class="input-group">
      							<div class="input-group-addon">$</div>
      							<input type="text" class="form-control inputAmount"  placeholder="Amount" id="inputShipment" name="shipment">
    						</div>
  						</div>
					</div>
					<div class="alert alert-danger" style="display: none;"  role="alert" id="shipmentmsg">Shipment can not be empty!</div>
    			</div>
    			<div>
                	<label for="startTime" class="col-md-4 control-label">Business Start time</label>
                	<div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="startTime" data-link-format="hh:ii">
                    	<input class="form-control" size="16" type="text"  readonly id="startTime" name="starttime">
                    	<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
               		</div>
					<input type="hidden" id="startTime" value="" /><br/>
            	</div>
            	<div class="alert alert-danger" style="display: none;"  role="alert" id="startTimemsg">Please choose your bussiness start time!</div>
    			<div>
                	<label for="finishTime" class="col-md-4 control-label">Business finish time</label>
                	<div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="finishTime" data-link-format="hh:ii">
                    	<input class="form-control" size="16" type="text"  readonly id="finishTime" name="finishtime">
                    	<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                	</div>
					<input type="hidden" id="finishTime" value="" /><br/>
            	</div>
            	<div class="alert alert-danger" style="display: none;"  role="alert" id="finishTimemsg">Please choose your bussiness finish time!</div>
            	<div class="page-text">	
    				<label>Pay type</label>
    				<div>
      					<input type="text" class="form-control" placeholder="Pay type" readonly>
    				</div>
    			</div>
    			<div class="page-text">	
    				<label>Store Picture</label>
    				<div><img id="showStorePic" width="200" height="200" src="<c:url value='/img/vendor/1.jpg'/>"  class="page-text"/></div>
    				<div class="controls page-text">
						<input name="logopic" type="file" style="display: none;" id="inputStorePic"></input>
						<span class="btn btn-primary" onclick="$('#inputStorePic').click();">Choose Store Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
     			</div>
     			<div class="alert alert-danger" style="display: none;"  role="alert" id="storePicmsg">Please choose your store picture!</div>           	
            	<input class="btn btn-primary btn-lg" id="submit" type="submit"></input>
            	
            </div>
            </form>
		</div>
		
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
    	$(function () {
			$("#inputStorePic").uploadPreview({ Img: "showStorePic", Width: 120, Height: 120 });
		});
	</script>
	</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="<c:url value='/js/vendor/pic.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/vendor/register3.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/css/vendor/register.css'/>" />
		<title>Register</title>
		<style type="text/css">
			.nav > li > a:hover{
				background-color: #fff;
			}
			.nav-tabs.nav-justified > li > a:hover{
				border-top: none;
				border-left: none;
				border-right: none;
			}
			
		</style>
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
					<ul class="nav nav-tabs nav-justified">
						<li role="presentation"><a >Contact information</a></li>
     					<li role="presentation"><a >Restaurant Information</a></li>
     					<li role="presentation" class="active"><a >Qualification certification</a></li>
      					<li role="presentation"><a >Approval status</a></li>
    				</ul>
    			</div>
    		</div>
    		<div class="sign-form page-center form-horizontal">
    			<form action="register3.do" method="post" enctype="multipart/form-data" id="form3">
    			<div class="page-text">	
    				<label>Real name</label>
    				<div>
      					<input type="text" class="form-control input-lg" placeholder="Real name" id="inputName" name="realname">
    				</div>
    			</div>
    			<div class="alert alert-danger" style="display: none;"  role="alert" id="namemsg">Please input your real name!</div>
    			<div class="page-text">	
    				<label>Idcard number</label>
    				<div>
      					<input type="text" class="form-control input-lg" placeholder="Idcard number" id="inputIdcard" name="idcardnumber">
    				</div>
    			</div>	
    			<div class="alert alert-danger" style="display: none;"  role="alert" id="idcardmsg">Please input your idcard number!</div>
  				<div><img id="showIdcardPic" width="200" height="200" src="<c:url value='/img/vendor/1.jpg'/>" class="page-text"/></div>
  				<div class="controls page-text">
					<input type="file" id="IdcardPic"  style="display: none;" name="idcardpic"></input>
					<span class="btn btn-primary btn-lg" onclick="$('#IdcardPic').click();" id="idcardBtn">Choose idcard Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
				</div>
				<div class="alert alert-danger" style="display: none;"  role="alert" id="idcardpicmsg">Please upload your idcard picture!</div>
  				<div><img id="showLicensePic" width="200" height="200" src="<c:url value='/img/vendor/1.jpg'/>"  class="page-text"/></div>
  				<div class="controls page-text">
					<input  type="file" id="LicensePic"  style="display: none;"  name="licensepic"></input>
					<span class="btn btn-primary btn-lg" onclick="$('#LicensePic').click();" id="licenseBtn">Choose License Picture</span> （Max size 2M,form：JPG,GIF,PNG,BMP）
				</div>
				<div class="alert alert-danger" style="display: none;"  role="alert" id="licensepicmsg">Please upload your idcard picture!</div>
            	<input type="submit" class="btn btn-primary btn-lg" id="next"></input>
            	</form>
            <div>
		</div>
		<script>
		$(function () {
			$("#LicensePic").uploadPreview({ Img: "showLicensePic", Width: 120, Height: 120 });
			$("#IdcardPic").uploadPreview({ Img: "showIdcardPic", Width: 120, Height: 120 });
		});
		</script>
		<jsp:include page="../common/footer.jsp" flush="true">
            <jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
        </jsp:include>
	</body>
</html>

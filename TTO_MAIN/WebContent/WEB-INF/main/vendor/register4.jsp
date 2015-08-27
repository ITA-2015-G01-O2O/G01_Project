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
     					<li role="presentation"><a >Qualification certification</a></li>
      					<li role="presentation" class="active"><a >Approval status</a></li>
    				</ul>
    			</div>
    		</div>

        	<div class="text-center page-center">        		
        		<img src="<c:url value='/img/vendor/success.png'/>" height="200px" width="200px" id="pic"/>
            	<h2 class="table-title">You have successfully submitted your application</h2>
            	<h2 class="table-title">Please be patient before admin review</h2>
           	 	<a class="btn btn-success btn-lg" href="/TTO_MAIN/consumer/search.view" >goback</a>
        	</div>       
   		 	
		</div>
		<jsp:include page="../common/footer.jsp" flush="true">
            <jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
        </jsp:include>
	</body>
</html>

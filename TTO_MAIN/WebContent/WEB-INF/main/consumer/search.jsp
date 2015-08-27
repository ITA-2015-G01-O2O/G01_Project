<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>G01外卖</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/basic.css">
<link rel="stylesheet" href="../css/search.css">
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="true">
		<jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
	</jsp:include>
	<div id="background"></div>
	<div class="title">
		<span class="brand">TAKE-OUT</span>
	</div>
	<div id="search">
		<a href="#" class="map-font" data-toggle="dropdown"
			aria-expanded="true" data-toggle="tooltip"> <span
			class=" glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		</a>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="maplist">

		</ul>

		<li class="hidden" id="temp"><a href="#">珠海，唐家，南方软件园</a></li> <input
			class="search-Place" type="text" class="form-control"
			placeholder="输入地址"> <a href="#" class="search-font"
			id="search-btn"><span class=" glyphicon glyphicon-search"
			aria-hidden="true"></span></a>
	</div>

	<%@ include file="../common/loginmodal.jsp"%>
	<jsp:include page="../common/footer.jsp" flush="true">
		<jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
	</jsp:include>

</body>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/consumer/search.js"></script>
<script type="text/javascript" src="../js/common/basic.js"></script>
</html>

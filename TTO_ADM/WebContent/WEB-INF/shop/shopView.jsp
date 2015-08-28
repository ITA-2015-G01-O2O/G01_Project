<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TTO ADMIN - SHOP VIEW</title>
<script src="http://cdn.sencha.com/ext/gpl/4.2.1/ext-all.js"></script>
<link rel="stylesheet"
	href="http://cdn.sencha.com/ext/gpl/4.2.1/packages/ext-theme-gray/build/resources/ext-theme-gray-all.css" />
<link rel="stylesheet" href="<c:url value='/css/custom.css'/>" />
<%@include file="../config.jsp"%>
<script type="text/javascript"
	src="<c:url value='/js/common/commonController.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/shop/shopViewApp.js'/>"></script>
</head>
<body>
	<input type="hidden" id="shopId" value="${id}"></input>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>home</title>
            <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
            <link rel="stylesheet" href="../css/select-vender.css">
            <link rel="stylesheet" href="../css/basic.css">
        </head>

        <body>
            <jsp:include page="../common/header.jsp" flush="true">
                <jsp:param name="config.hotLine" value="${config.hotLine}"></jsp:param>
            </jsp:include>
            <div class="container">
                <div class="row">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div id="carousel" class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="/TTO_MAIN/img/temp.jpg" data-holder-rendered="true">
                            </div>
                            <div class="item">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="/TTO_MAIN/img/temp1.jpg" data-holder-rendered="true">
                            </div>
                            <div class="item">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="/TTO_MAIN/img/temp.jpg" data-holder-rendered="true">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <div class="main-wrapper container">
                        <div class="row">
                            <ul class="nav nav-pills" id="store_type_list">
                                <li role="presentation" class="active"><a href="#">全部</a></li>

                            </ul>
                        </div>
                        <div class="nav sorter">
                            <div class="btn-group navbar-form navbar-left" role="group" id="sorter">
                                <button type="button" class="btn btn-default" id="sales">
                                    &nbsp;销量<span class="hidden glyphicon glyphicon-sort-by-attributes" aria-hidden="true"></span>
                                </button>
                                <button type="button" class="btn btn-default" id="score"><span class="hidden glyphicon glyphicon-sort-by-attributes-alt" aria-hidden="true"></span>&nbsp;评分</button>
                                <button type="button" class="btn btn-default" id="speed"><span class="hidden glyphicon glyphicon-sort-by-attributes-alt" aria-hidden="true"></span>&nbsp;速度</button>

                            </div>
                            <form class="navbar-form navbar-right search">
                                <input type="text" class="form-control" placeholder="Search">
                                <button class="btn btn-default">Go</button>
                            </form>
                        </div>
                        <div class="row venders">
                            <div class="col-sm-6 col-md-4 col-lg-3 hidden" id="store_temp">
                                <a href="../../consumer/getMerprosById.view?merId=50" class="thumbnail shopId"> <img class="logoPicURL" src="">
                                </a>
                                <h3 class="shopName">汉堡店</h3>
                                <div class="row">
                                    <div class="col-xs-6 avgPoint">评分：4分</div>
                                    <div class="col-xs-6 salesNum">销量：888单</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 startingFee">30元 起送</div>
                                    <div class="col-xs-6 deliverFee">免外卖费</div>
                                </div>
                                <div class="row">
                                    <h6 class="text-muted col-xs-6 avgDeliverTime">30分钟送达</h6>
                                    <h6 class="text-muted col-xs-6 payway">货到付款</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a href="#" onclick="gotoTop();return false;" class="totop">
                <div></div>
            </a>
            <%@ include file="../common/loginmodal.jsp"%>
                <jsp:include page="../common/footer.jsp" flush="true">
                    <jsp:param name="config_hotLine" value="${config_hotLine}"></jsp:param>
                </jsp:include>
        </body>


        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
        <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="../js/jquery.cookie.js"></script>
        <script type="text/javascript" src="<c:url value='../js/consumer/select_vender.js'/>"></script>
        <script src="<c:url value='/js/common/basic.js'/>"></script>


        </html>

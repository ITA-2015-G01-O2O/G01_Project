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
            <nav class="navbar navbar-default" id="header">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"> TAKE-OUT </a>
                    </div>
                    <ul class="nav navbar-nav navbar-left address">
                        <li><a href="search.html"><span
					class="glyphicon glyphicon-map-marker"></span> 珠海,切换地址</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../../o2o_user/personcenter.html">Hi,13552262626</a></li>
                        <li><a href="../../../Vendor/completeInfo.html"><span
					class="glyphicon glyphicon glyphicon-home"></span>我的店铺</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-earphone"></span>找客服</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>注销</a></li>
                    </ul>
                </div>
            </nav>
            <div class="container">
                <div class="row">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="../images/temp.jpg" data-holder-rendered="true">
                            </div>
                            <div class="item">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="../images/temp.jpg" data-holder-rendered="true">
                            </div>
                            <div class="item">
                                <img data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide [900x500]" src="../images/temp.jpg" data-holder-rendered="true">
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
                    <div class="col-xs-12 main-wrapper">
                        <div class="row">
                            <ul class="nav nav-pills" id="store_type_list">
                                <li role="presentation" class="active"><a href="#">全部</a></li>

                            </ul>
                        </div>
                        <div class="nav sorter">
                            <div class="btn-group navbar-form navbar-left" role="group" id="sorter">
                                <button type="button" class="btn btn-default" id="sales">
                                    销量<span class="glyphicon glyphicon-sort-by-attributes" aria-hidden="true"></span>
                                </button>
                                <button type="button" class="btn btn-default" id="score">评分</button>
                                <button type="button" class="btn btn-default" id="speed">速度</button>

                            </div>
                            <form class="navbar-form navbar-right search">
                                <input type="text" class="form-control" placeholder="Search" id="searchStoreName">
                                <button class="btn btn-default" onclick="searchStore()">Go</button>
                            </form>
                        </div>
                        <div class="row venders">
                            <div class="col-xs-3 hidden" id="store_temp">
                                <a href="../../consumer/getMerprosById.view?merId=50" class="thumbnail shopId"> <img class="logoPicURL" src="">
                                </a>
                                <h4 class="shopName">汉堡店</h4>
                                <div class="row">
                                    <div class="col-xs-6 avgPoint">评分：4分</div>
                                    <div class="col-xs-6 salesNum">销量:888单</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 startingFee">30元 起送</div>
                                    <div class="col-xs-6 deliverFee">免外卖费</div>
                                </div>
                                <div class="row">
                                    <h6 class="text-muted col-xs-6 avgDeliverTime">30分钟送达</h6>
                                    <h6 class="text-muted col-xs-6">货到付款</h6>
                                </div>
                            </div>



                        </div>
                    </div>
                </div>

                <div class="modal fade login-modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title text-center">登录</h4>
                            </div>
                            <div class="modal-body">
                                <div class="input-group">
                                    <span class="input-group-addon"><span
								class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" class="form-control" name="to_username" id="username" placeholder="username">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon"><span
								class="glyphicon glyphicon-lock"></span></span>
                                    <input type="password" class="form-control" name="to_password" id="password" placeholder="password">
                                </div>
                                <div class="checkbox btn-re">
                                    <label>
                                        <input type="checkbox"> Remeber me
                                    </label>
                                </div>
                                <div class="bttons">
                                    <button class="btn btn-primary btn-block" type="submit">Login</button>
                                    <a class="btn btn-success btn-block" href="register.html">Register</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <a href="#" onclick="gotoTop();return false;" class="totop">
                <div></div>
            </a>
            <div id="footer">
                <a href="#">关注微信</a> <a>|</a> <a href="#">关注微博</a> <a>|</a> <a href="../../../Vendor/register1.html">我要开店</a> <a>|</a> <a><span>客服电话400-xxx-xxx</span>
		</a>
            </div>
        </body>


        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
        <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<c:url value='../js/consumer/select_vender.js'/>"></script>

        <script src="<c:url value='../js/consumer/search.js'/>"></script>
        <script src="<c:url value='../js/consumer/basic.js'/>"></script>

        </html>

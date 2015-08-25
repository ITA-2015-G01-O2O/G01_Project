<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="../js/usercenter/myfav.js"></script>
		<script src="../js/usercenter/myinfo.js"></script>
		<script src="../js/usercenter/myorder.js"></script>
		<script src="../js/usercenter/personcenter.js"></script>
		<link rel="stylesheet" href="../css/usercenter/myfav.css"/>
		<link rel="stylesheet" href="../css/usercenter/myinfo.css"/>
		<link rel="stylesheet" href="../css/usercenter/myorder.css"/>
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
					<a href="index.html"><img src="../img/usercenter/title_admin.png" width="70px" style="margin-top:8px"></a>
				</div>
				<div class="collapse navbar-collapse" id="main-nav">

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Hello user</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-log-out"></i></a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container container-main">

			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-2">
							<ul class="nav nav-pills nav-stacked">
								<ul class="nav nav-tabs nav-stacked" role="tablist">
									<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">myorder</a></li>
									<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" onclick="loadMyInfo()">myinfo</a></li>
									<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">myfav</a></li>
								</ul>
							</ul>
						</div>
						<div class="col-xs-10 main-wrapper">

							<div class="row" id="mainContent">
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="home">
										<div class="col-xs-12 res_content  page-header">
											<div class="col-xs-1">

											</div>
											<div class="col-xs-2">
												<img src="../img/usercenter/title_admin.png" />
											</div>
											<div class="col-xs-6">
												<ul class="list-inline">
													<li>res name:XXX</li>
													<li> res tel:10000000</li>
												</ul>
												<ul class="list-inline">
													<li>order number:XXX</li>
													<li>oder time:2015-01-02</li>
												</ul>

											</div>
											<div class="col-xs-2">
												<div>order state:</div>
												<div>
													<span class="btn btn-info">affect</span>
												</div>
											</div>
											<div class="col-xs-1">

											</div>
										</div>
										<div class="">
											<div class="clo-xs-12 ">
												<div class="col-xs-4">
													<div class="">
														<table class="table table-bordered ">
															<caption>order info</caption>
															<thead>
																<th class="active">food number</th>
																<th class="active">food name</th>
																<th class="active">food price</th>
															</thead>
															<tfoot>
																<th class="active">food number</th>
																<th class="active">food name</th>
																<th class="active">food price</th>
															</tfoot>
															<tbody>
																<tr>
																	<td class="active">order 1</td>
																	<td class="success">name</td>
																	<td class="warning">price</td>
																</tr>
																<tr>
																	<td class="active">order 1</td>
																	<td class="success">name</td>
																	<td class="warning">price</td>
																</tr>
																<tr>
																	<td class="active">order 1</td>
																	<td class="success">name</td>
																	<td class="warning">price</td>
																</tr>
																<tr>
																	<td class="active">order 1</td>
																	<td class="success">name</td>
																	<td class="warning">price</td>
																</tr>

															</tbody>
														</table>
														<div class="text-right">total:$24
															<!--<button type="button" class="btn btn-success">confirm</button>-->

														</div>
													</div>
												</div>
												<div class="col-xs-8">

													<div class="col-xs-12 myclass1">
														<div class="col-xs-2">

														</div>
														<div class="page-header ">order state</div>
														<div>contacter:XXX</div>
														<div>tel:XXXXX</div>
														<div>remarks</div>
														<div>comment</div>
														<div class="page-header ">addr:XXXXX</div>
													</div>
													<!--<div class="clearfix list-container">

												<div class="list-wrapper clearfix" mon="area=mid_category_hot_tuangou">
													<div class="title">热门团购</div>
													<ul class="mid-list list-inline">
														<li><a href="http://www.nuomi.com/deal/movies" class="" mon="element=电影&amp;position=0">电影</a></li>
														<li><a href="http://www.nuomi.com/392" class="hot" mon="element=自助餐&amp;position=1">自助餐</a></li>
														<li><a href="http://www.nuomi.com/341" class="" mon="element=KTV&amp;position=2">KTV</a></li>
														<li><a href="http://www.nuomi.com/364" class="hot" mon="element=火锅&amp;position=3">火锅</a></li>
														<li><a href="http://www.nuomi.com/881" class="" mon="element=蛋糕&amp;position=4">蛋糕</a></li>
														<li><a href="http://t.nuomi.com" class="hot" mon="element=酒店&amp;position=5">酒店</a></li>
														<li><a href="http://www.nuomi.com/380" class="" mon="element=小吃快餐&amp;position=6">小吃快餐</a></li>
														<li><a href="http://www.nuomi.com/391" class="" mon="element=西餐&amp;position=7">西餐</a></li>
													</ul>
												</div>
											</div>-->
													<div class="myclass1">
														<div class="text-center mymainhei">waiting for check by res</div>
														<div class=" text-right">
															<button class="btn btn-warning">cancel order?</button>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>

									<div role="tabpanel" class="tab-pane" id="profile">
										<div class="col-xs-3"></div>

										<div class="col-xs-6" id="userinfo">
											<form class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-2 control-label">tel</label>
													<div class="col-sm-10">
														<p class="form-control-static">13545102672</p>
													</div>
												</div>
												<div class="form-group">
													<label for="inputPassword" class="col-xs-2 control-label">Password</label>
													<div class="col-xs-10">
														<ul class="list-inline">
															<li>
																<input type="password" class="form-control" id="inputPassword" value="123456" disabled="disabled">
															</li>
															<li>
																<a class="btn btn-info" id="changePsd">change psd</a>
															</li>

														</ul>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label">account:</label>
													<div class="col-sm-10">
														<ul class="list-inline">
															<li class="form-control-static">$400</li>
															<li>
																<a class="btn btn-info" id="charge">charge</a>
															</li>
														</ul>
													</div>
												</div>
											</form>
										</div>

										<div class="col-xs-3"></div>

									</div>

									<div role="tabpanel" class="tab-pane" id="messages">
										<div class="col-xs-12">
											<div class="col-xs-1"></div>
											<div class="col-xs-10 myborder">
												<div class="col-xs-12 res_content  page-header">
													<div class="col-xs-1">

													</div>
													<div class="col-xs-2">
														<img src="../img/usercenter/title_admin.png" />
													</div>
													<div class="col-xs-6">
														<ul class="list-inline">
															<li>res name:XXX</li>
															<li> res tel:10000000</li>
														</ul>
														<ul class="list-inline">
															<li>res addr:XXX</li>
															<li>open time:2015-01-02</li>
														</ul>
														<ul class="list-inline">
															<li><a class="link">enter this res</a></li>
															<li>
																<button class="btn btn-warning" name="cancelfav">cancel fav</button>
															</li>
														</ul>
													</div>
													<div class="col-xs-1">

													</div>
												</div>
											</div>
											<div class="col-xs-1"></div>
										</div>
										<div class="col-xs-12">
											<div class="col-xs-1"></div>
											<div class="col-xs-10 myborder">
												<div class="col-xs-12 res_content  page-header">
													<div class="col-xs-1">

													</div>
													<div class="col-xs-2">
														<img src="../img/usercenter/title_admin.png" />
													</div>
													<div class="col-xs-6">
														<ul class="list-inline">
															<li>res name:XXX</li>
															<li> res tel:10000000</li>
														</ul>
														<ul class="list-inline">
															<li>res addr:XXX</li>
															<li>open time:2015-01-02</li>
														</ul>
														<ul class="list-inline">
															<li><a class="link">enter this res</a></li>
															

																<button class="btn btn-warning" name="cancelfav">cancel fav</button>
															</li>
														</ul>
													</div>
													<div class="col-xs-1">

													</div>
												</div>
											</div>
											<div class="col-xs-1"></div>
										</div>
										<div class="col-xs-12">
											<div class="col-xs-1"></div>
											<div class="col-xs-10 myborder">
												<div class="col-xs-12 res_content  page-header">
													<div class="col-xs-1">

													</div>
													<div class="col-xs-2">
														<img src="../img/usercenter/title_admin.png" />
													</div>
													<div class="col-xs-6">
														<ul class="list-inline">
															<li>res name:XXX</li>
															<li> res tel:10000000</li>
														</ul>
														<ul class="list-inline">
															<li>res addr:XXX</li>
															<li>open time:2015-01-02</li>
														</ul>
														<ul class="list-inline">
															<li><a class="link">enter this res</a></li>
															<li>
																<button class="btn btn-warning" name="cancelfav">cancel fav</button>
															</li>
														</ul>
													</div>
													<div class="col-xs-1">

													</div>
												</div>
											</div>
											<div class="col-xs-1"></div>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<!--<div id="copyright-info">
				<div class="site-info text-center">
					<a href="#" class="link" target="_blank">关注微信</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#" class="link" target="_blank">关注微博</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#" class="link" target="_blank">我要开店</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
			</div>
			<div class="text-right">
				<div class="contact-info ">
					<ul class="list-inline">
						<li class="contact-name"><i>客服电话</i></li>
						<li class="contact-numbers"><strong>4000000</strong></li>
						<li class="contact-time small">(9:00-22:00)</li>
					</ul>
				</div>
			</div>-->
		</div>


</body>
</html>
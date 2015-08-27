<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    <nav class="navbar navbar-default" id="header">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"> TAKE-OUT </a>
            </div>
            <ul class="nav navbar-nav navbar-left address">
                <li><a href="../stores/search.view"><span class="glyphicon glyphicon-map-marker"></span> <span id="address">珠海,切换地址</span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li id="loginameshow" style="display:none">
                    <a href="#"></a>
                </li>

                <li id="logintitle" style="display:none"><a href="#" data-toggle="modal" data-target=".login-modal">登陆</a></li>
                <li id="registertitle" style="display:none"><a href="../consumer/register.view">注册</a></li>
                <li><a href="#"><span class="glyphicon glyphicon glyphicon-home"></span>我的店铺</a></li>

                <li><a href="#"><span class="glyphicon glyphicon-earphone"></span>找客服 ${config.hotLine} </a></li>
            </ul>
        </div>
    </nav>

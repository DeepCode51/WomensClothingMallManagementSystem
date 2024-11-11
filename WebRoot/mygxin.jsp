<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!------------------------------head------------------------------>
<!------------------------------idea------------------------------>
<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人中心</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/11.jpeg"/></a>
                <p class="clearfix"><span class="fl">[${name.user_name}]</span><span><a href="logout">[退出登录]</a></span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="showcart">我的购物车</a></li>
                 <li><c:if test="${name!=null}"><a href="selectddan?dd=${name.user_id}">我的订单</a></c:if></li>
                   
            </div>
        </div>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix"><a href="#" class="fl"><img src="img/11.jpeg"/></a>
                    <p class="fl"><span>${name.user_name}</span></p></div>
                <div class="fr"><a href="touserupdate?id=${name.user_id}">修改资料</a></div>
                 
            </div>
            
</div><!--返回顶部-->

<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
           
        </div>
    </div>
    </div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
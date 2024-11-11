<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head lang="en">
    <meta charset="utf-8"/>
    <title>ok</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!----------------------------------------order------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect"><img src="img/logo.png"  height=90px/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </p>
               
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
           
</div>
<div class="order mt cart">
    <div class="site"><p class="wrapper clearfix"><span class="fl"></span><img class="top"
                                                                                   src="img/temp/cartTop03.png" width="537" height="40"></p>
    </div>
    <p class="ok">支付成功！剩余<span>5</span>秒<a href="indexselect">返回首页</a></p></div>
</div>
</div><!--footer-->

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>
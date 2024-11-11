<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span><a
            href="mygxin.jsp">个人中心</a><span>/</span><a href="myorderq.html" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/11.jpeg"/></a>
                <p class="clearfix"><span class="fl">[${name.user_name}]</span><span><a href="logout">[退出登录]</a></span></p></h3>
       <div><h4>我的订单</h4>
                
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2></div>
            <div class="dlist clearfix">
             	<table border="1"  width="800px" height="100px" bordercolor="black">
				<tr  align="center">
					<td class="field">订单号</td>
					<td class="field">用户ID</td>
					<td class="field">商品名称</td>
					<td class="field">商品图片</td>
					<td class="field">商品价格</td>
					<td class="field">购买数量</td>
					<td class="field">商品库存</td>
					<td class="field">商品尺寸</td>
					<td class="field">货物状态</td>
					<td class="field">操作</td>
					
				</tr>
				<c:forEach var="d" items="${dan}">
					<tr align="center">
						<td>${d.oid}</td>
						<td>${d.uid }</td>
						<td>${d.product_name }</td>
						<td><img src="images/product/${d.product_filename}"  height="100" width="100"/></td>
						<td>${d.product_price}</td>
						<td>${d.quantity }</td>
						<td>${d.product_stock }</td>
						<td>${d.size }</td>
					
						<td><c:if test="${d.status eq 1}">待发货</c:if><c:if test="${d.status eq 2 }">发货</c:if><c:if test="${d.status eq 3}">确认收货</c:if></td>
					<td><a href="toorder?id=${d.oid }"><h3 style="color:red">确认收货</h3></a></td>
					</tr>
					</c:forEach>
			</table> 
             
            </div>
            
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
			
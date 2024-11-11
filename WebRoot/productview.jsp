<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <title>商品详情页面</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<%@ include file="header.jsp" %>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    	<a href="indexselect">首页</a><span>/</span>
   	 	<a href="selectproductlist?cid=${cate.cate_id }">${cate.cate_name }</a><span>/</span>
    	<a href="#">${p.product_name }</a><span>/</span>
    </div>
</div><!-----------------------Detail------------------------------>
 <div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
            
            <img class="det" src="images/product/${p.product_filename }"/>
                <div class="smallImg clearfix"><img src="images/product/${p.product_filename }"
                                                    data-src="images/product/${p.product_filename }"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>${p.product_name }</h4>
                
                    <p>【${p.product_description }】</p><span>￥${p.product_price }.00</span></div>
                <div class="proIntro"><p>颜色分类</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img src="images/product/${p.product_filename }"
                                                                        ></div>
                    <p>数量&nbsp;&nbsp;库存<span>${p.product_stock }</span>件</p>
                    <div class="num clearfix">
                    
                    <img class="fl sub" src="img/temp/sub.jpg">
                    <span id="count" class="fl" contentEditable="true">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                    
                        <p class="please fl">请选择商品属性!</p></div>
                </div>
                <p>尺码</p>
                <input style="width: 15px;height:15px" type="radio" name="c" value="S" checked="checked">S;
        	<input style="width: 15px;height:15px" type="radio" name="c" value="M" >M
        	<input style="width: 15px;height:15px" type="radio" name="c" value="L" >L
        	<input style="width: 15px;height:15px" type="radio" name="c" value="XL" >XL
                <div class="btns clearfix">
                
                <a href="javascript:shopAdd(${p.product_id },'z')"><p class="buy fl">立即购买</p></a>
                
                <a href="javascript:shopAdd(${p.product_id },'s')"><p class="cart fr">加入购物车</p></a></div>
                
            </div>
        </div>
    </div>
</div>

<!-- 加入购物车数量   跳转到cartadd-->
<script>
var checkElement=getRadioValue("hero");
  console.log("当前选中的元素="+checkElement)
  
	function shopAdd(id, url) {
		var count = document.getElementById("count").innerHTML;
		var c=document.getElementsByName("c");
    for(var i=0; i<c.length; i ++){
        if(c[i].checked){
        var d= c[i].value;
        }
    }
   
		location.href='cartadd?id='+id+'&count='+count+'&d='+d+'&url='+url;
		
	}

</script>


<div class="like"><h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                
                
                 <c:forEach var="lp" items="${lastlylist }">
			        <a href="selectproductview?id=${lp.product_id }">
			            <dl>
			                <dt><img src="images/product/${lp.product_filename }"></dt>
			                <dd>${lp.product_name }</dd>
			                <dd>￥${lp.product_price }.00</dd>
			            </dl>
			        </a>
       			 </c:forEach>
             </div>
               
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
<
    <p>400-800-8200</p></div>
<div class="msk"></div><!--footer-->
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
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
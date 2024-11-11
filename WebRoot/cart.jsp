<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
      <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <
       <link rel="stylesheet" type="text/css" href="css/style.css"/>
 
 
</head>
<body>
<div class="wrap">
	<div id="shopping">
	<form action="gmservlet" method="get">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>尺码</th>
					<th>操作</th>
				</tr>
				<c:forEach var="rs" items="${requestScope.shoplist}">
					
					<tr id="product_id_1">
						<td class="thumb"><input type="checkbox" name="op" onclick="dxcheck()" /><img src="images/product/${rs.cart_p_filename }" height="100" width="100" />
						<a href="product-view.html">${rs.cart_p_name }</a></td>
						<td class="price" id="price_id_1">
							<span id="priceText" name="priceText" >${rs.cart_p_price}</span><!-- 商品单价 --><input type="hidden" name="sPPrice" value="${rs.cart_p_price}" />
							<input type="hidden" value="99" />
						</td>
						<td class="number">
							<dl>
								<dt>
								<input type="button"  value="-" onclick="sub(${rs.cart_id})" />
								<!-- 购物单id --><input type="hidden" name="esID" value="${rs.cart_id}" />
								<!-- 商品id --><input type="hidden" name="spID" value="${rs.cart_p_id}" />
								<!-- 购买数量 --><input id="${rs.cart_id}" type="text" name="number" value="${rs.cart_quantity }"  onblur="closeText(id,${rs.cart_p_stock})" />
								
								<input type="button"  value="+" onclick="plus(${rs.cart_id},${rs.cart_p_stock}) " />
								</dt>
								
							</dl>
						</td>
						<td>
							<!-- 尺码 --><input id="" type="text" name="c" value="${rs.cart_p_size }" />
						</td>
						<td class="delete"><a href="javascript:del(${rs.cart_id});">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<input type="checkbox" onclick="qxcheck()" name="op2" />全选 <div align="right" >总价钱:<span id="zdzj">0</span>元</div>
														<input type="hidden" name="jstext" id="jstext" value="0" />
			<div align="center"><span id="xzText">请选择物品！！！</span></div>
			<div class="button"><input  style ="border-radius:7px;height:22px;background:#7c43a9;color:white;width:80px;float:right "type="submit" value="结算" id="jsbutton"  /></div>
		</form>
       <script>
	function plus(id,stock){
		var va=document.getElementById(id).value;
		var c=document.getElementsByName("c")[0].value;
		if(va>=stock){
			return;
		}
		location.href="updateservlet?pid="+id+"&c="+c+"&action=jia";
		
	}
	function sub(id){
		var va=document.getElementById(id).value;
		var c=document.getElementsByName("c")[0].value;
		if(va<=1){
			return;
		}
		location.href="updateservlet?pid="+id+"&c="+c+"&action=jian";
		
	}
	function closeText(id,stock){
		var va=document.getElementById(id).value;
		var c=document.getElementsByName("c")[0].value;
		if(va<1){
		alert('您输入的数量不能小于1！！！')
			document.getElementById(id).value=1;
			va=1;
		}
		if(va>stock){
		alert('您输入的数量超出库存！！！');
			document.getElementById(id).value=stock;
			va=stock;
		}
		location.href="updateservlet?pid="+id+"&getvalue="+va+"&c="+c+"&action=closeText";
	}
	function del(id){
	var c=document.getElementsByName("c")[0].value;
	if(confirm("确定要删除吗？")) {
		location.href="updateservlet?pid="+id+"&c="+c+"&action=delText";
		}
	}
	

	var fxi=0;
	function qxcheck(){
	
		var op2 = document.getElementsByName("op2");
		var op =  document.getElementsByName("op");
		
		if(fxi==0){
			for(var i=0;i<op.length;i++)
			{
				op[i].checked=true;
			}
			fxi=1;
		}else{
			for(var i=0;i<op.length;i++)
			{
				op[i].checked=false;
			}
			fxi=0;
		}
		dxcheck();
	}

	function dxcheck(){
	var sum=0;
		var op = document.getElementsByName("op");
		var price=document.getElementsByName("priceText");
		var number=document.getElementsByName("number");
		for(var i=0;i<op.length;i++)
		{
			if(op[i].checked)
			{
				sum+=parseInt(parseInt(price[i].innerText)*parseInt(number[i].value));
			}
		}
			
		document.getElementById("zdzj").innerHTML=sum;	
		document.getElementById("jstext").value=sum;
		var money=document.getElementById("zdzj").innerText;
		if(money=="0"){
			document.getElementById("jsbutton").style.display='none';
			document.getElementById("xzText").hidden=false;
		}else{
			document.getElementById("xzText").hidden=true;
			document.getElementById("jsbutton").style.display='inline';
		}
	}
	
</script>
</html>
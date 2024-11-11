<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            
          
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/orderdouservlet" method="get" id="myform" name="myform" >
                  
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="${order.oid }" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="name" value="${order.uname }"  readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">收货地址</td>
						<td><input type="text" class="text" name="addres" value="${order.uaddress }"  ></td>
					</tr>
					<tr>
						<td class="field">手机号码</td>
						<td><input type="text" class="text" name="uphone" value="${order.uphone }"  ></td>
					</tr>
					<tr>
						<td class="field">总价格</td>
						<td><input type="text" class="text" name="cost" value="${order.cost}" readonly="readonly"></td>
					</tr>
					<input type="hidden" class="text" name="size" value="${order.size}" ></td>
					<tr>
						<td class="field">订单状态</td>
						<td >
							<select name="tatus" onchange="change(this,${order.status })">
								<option value="1" ${order.orderStatusStr=="待发货" ? "selected" : ""}>待发货</option>
								<option value="2" ${order.orderStatusStr=="发货" ? "selected" :""}>发货</option>
								<option value="3" ${order.orderStatusStr=="确认收货" ? "selected" : ""}>确认收货</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
            <div class="main">
		<h2>订单详细</h2>
		<div class="manage">
				<table border="1"  width="600px" height="100px" bordercolor="red">
					<tr align="center">
						<td class="field">商品名称</td>
						<td class="field">商品图片</td>
						<td class="field">商品价格</td>
						<td class="field">购买数量</td>
						<td class="field">商品库存</td>
						<td class="field">商品尺寸</td>
					</tr>
					<c:forEach var="d" items="${dlist}">
					<tr align="center">
						<td>${d.product_name }</td>
						<td><img src="../images/product/${d.product_filename }"  height="100" width="100"/></td>
						<td>${d.product_price }</td>
						<td>${d.quantity }</td>
						<td>${d.product_stock}</td>
						<td>${d.size}</td>
					</tr>
					</c:forEach>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
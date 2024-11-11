<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

      
                <form action="/shop/doorder" method="get" id="myform" name="myform" >
                  
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
						<td><input type="hidden" class="text" name="orderId" value="${order.oid }" readonly="readonly"/></td>
					</tr>
					<tr>
					
						<td><input type="hidden" class="text" name="name" value="${order.uname }"  readonly="readonly"/></td>
					</tr>
					<tr>
						
						<td><input type="hidden" class="text" name="addres" value="${order.uaddress }"  ></td>
					</tr>
					<tr>
						
						<td><input type="hidden" class="text" name="uphone" value="${order.uphone }"  ></td>
					</tr>
					<tr>
				
						<td><input type="hidden" class="text" name="cost" value="${order.cost}" readonly="readonly"></td>
					</tr>
					<tr>
				
						<td><input type="hidden" class="text" name="size" value="${order.size}" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="field">订单状态</td>
						<td >
							<select name="tatus" onchange="change(this,${order.status })">
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
	

    </div>
    <!--/main-->
</div>
</body>
</html>
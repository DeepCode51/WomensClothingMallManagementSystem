<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="/shop/manage/admin_douserdel" id="myform" method="post">
            
                <div class="result-title">
                    <div class="result-list">
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            
                            <th>🎅ID</th>
                            <th>🎅姓名</th>
                            <th>🙊发货地址</th>
                             <th>🙊手机号码</th>
                             
                            <th>🙊状态</th>
                            <th>🌺操作</th>
                        </tr>
                        <c:forEach var="o" items="${order}">
	                        <tr>
	                        <td> ${o.oid  }</td>
	                        <td> ${o.uname }</td>
	                        <td> ${o.uaddress}</td>
	                        <td>${o.uphone }</td>
	                       
	                        <td><c:if test="${o.status eq 1}">待发货</c:if><c:if test="${o.status eq 2}">发货</c:if><c:if test="${o.status eq 3}">确认收货</c:if></td>
	                        <td><a href="ordertouservlet?id=${o.oid }">修改</a> <a href="javascript:DeleteOder(${o.oid});">删除</a></td> 
	                        </tr>
	                    </c:forEach>
	                     <script>
	                     function DeleteOder(id)
                        { 
	                  if(confirm("确定要删除吗？")) {
	 	            location.href = "orderdelservlet?id=" + id;
	}
}
	                                </script>
	                                </table>
	                            
                        
                        
                        
                    
</body>
</html>
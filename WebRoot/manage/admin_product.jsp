<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="/shop/manage/admin_douserdel" id="myform" method="post">
            
                <div class="result-title">
                    <div class="result-list">
                        <a href="/shop/manage/admin_toproductadd"><i class="icon-font"></i>新增商品</a>
                       <!-- <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> --> 
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="65%">
                        <tr>
                            
                            <th>🎅商品ID</th>
                            <th>🙊商品名称</th>
                            <th>🌺操作</th>
                        </tr>
                        
                         <c:forEach var="p" items="${plist }">
                        	<tr>
                        		<td>${p.product_id }</td>
                        		<td><img src="../images/product/${p.product_filename}" width="80" height="80">
                        			${p.product_name }
                        		
                        		</td>
                        		
                        		<!-- 修改删除还没有做 -->
                        		<td>
                        			<a href="admin_toproductupdate?id=${p.product_id}">修改</a>
                        			<a href="javascript:productdel(${p.product_id})">删除</a>
                        		</td>
                        	</tr>
	                    </c:forEach>
                        
                        
                       
	                    <!--  做判断  -->
	                    <script>
	                    function productdel(id) {
                    		if(confirm("确认要删除吗？")) {
                    			location.href="admin_doproductdel?id="+id;
                    			
                    		}
                    	}

                        </script>
	                    
	                    
	                    
                    </table>
                   
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">活动管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="/shop/manage/admin_douserdel" id="myform" method="post">
            
               <div class="result-title">
                    <div class="result-list">
                        <a href="admin_newsadd.jsp"><i class="icon-font"></i>新增活动信息</a>
                                            </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            
                            <th>🎅ID</th>
                            <th>🎅活动标题</th>
                            <th>🌺操作</th>
                        </tr>
                  	<c:forEach var="n" items="${newslist}">
	                        <tr>
	                        <td> ${n.EN_ID  }</td>
	                        <td> ${n.EN_TITLE }</td>
	                      <td><a href="admin_tonewsupdate?id=${n.EN_ID }">修改</a> <a href="javascript:Delete2(${n.EN_ID });">删除</a></td>
				</tr>
	                        
	                    </c:forEach>
	                     <script>
	                    
	function Delete2(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "admin_donewsdel?id=" + id;
	}
}

	                                </script>
	                                </table>
	                            
                        
                        
                        
                    
</body>
</html>
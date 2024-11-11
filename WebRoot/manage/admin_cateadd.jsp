<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>新增分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/admin_docateadd" method="post" id="myform" name="myform" > <!--/去分类servlet DoCateAdd写-->
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">🎅</i>父级分类：</th>
                                <td>
                                    <select class="common-text required" name="parentid"  >
                                      <option value="0" selected="selected">根分类</option>
                                    	<c:forEach var="cate" items="${catelist }">
                                    		<c:if test="${cate.cate_parent_id == 0 }">
                                    			<option value="${cate.cate_id }"> ${cate.cate_name } </option>
                                    		</c:if>
                                    	</c:forEach>
                                    </select>
                                    
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>分类名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="classname" size="50" value="" type="text">
                                </td>
                            </tr>
                            

                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
    </div>
    
</body>
</html>
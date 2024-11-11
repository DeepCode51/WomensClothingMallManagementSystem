<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_product.jsp">商品管理</a><span class="crumb-step">&gt;</span><span><a herf="/shop/manage/admin_toproductadd"> 新增商品</a></span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            <!--   将类型改为enctype 才可 -->
                <form action="/shop/manage/admin_doproductadd" method="post" enctype="multipart/form-data" id="myform" name="myform" > <!--/去分类servlet DoCateAdd写-->
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                            <tr>
                                <th><i class="require-red">🙊</i>商品名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productname" size="50" value="" type="text">
                                </td>
                            </tr>
                        
                            <tr>
                                <th><i class="require-red">🎅</i>商品分类：</th>
                                <td>
                                    <select class="common-text required" name="parentid"  >
                                      <c:forEach var="f" items="${flist }">
                                    		<option value="${f.cate_id }" disabled="disabled"> |-${f.cate_name } </option>
                                    		<c:forEach var="c" items="${clist }">
                                    			<c:if test="${c.cate_parent_id == f.cate_id}">
                                    				<option value="${f.cate_id }-${c.cate_id }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    				&nbsp;&nbsp;|-${c.cate_name } </option>
                                    			</c:if>
                                    		</c:forEach>
                                    	</c:forEach>
                                    </select>
                                    
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">🙊</i>商品图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo" size="50" value="" type="file">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>商品价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productprice" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>商品介绍：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productdesc" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>商品库存：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productstock" size="50" value="" type="text">
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
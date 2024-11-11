<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="/shop/manage/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/shop/manage/admin_douserselect">用户管理</a>
            <span class="crumb-step">&gt;</span><span>修改用户信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/admin_douserupdate" method="post" id="myform" name="myform" > 
                    
                    <input type="hidden" name="status" value="${user.user_status }">
                    <input type="hidden" name="cpage" value="${cpage }">
                    
                    
                    
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="id" size="50" value="${user.user_id }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${user.user_name }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="pwd" size="50" value="${user.user_pwd }" type="text">
                                </td>
                            </tr>
                          
                            
                            <tr>
                                <th>性别：</th>
                                <td>
                                    <input name="sex" value="T" type="radio" ${user.user_sex=='T'?"checked":"" }>男
                                    <input name="sex" value="F" type="radio" ${user.user_sex=='F'?"checked":"" }>女
                                </td>
                            </tr>
                            
                            <tr>
                                <th>出生日期：</th>
                                <td>
                                    <input class="common-text"  name="birth" size="50" value="${user.user_birth }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>用户邮箱：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="${user.user_email }" type="text">
                                </td>
                            </tr>
                            
                              <tr>
                                <th><i class="require-red">*</i>用户电话：</th>
                                <td>
                                    <input class="common-text required" id="title" name="phone" size="50" value="${user.user_phone }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>用户地址：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="${user.user_address }" type="text">
                                </td>
                            </tr>
                            
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交修改信息" type="submit">
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
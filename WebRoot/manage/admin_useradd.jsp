<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/admin_douseradd" method="post" id="myform" name="myform" > <!--/去用户servlet DoUserAdd写-->
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">🎅</i>用&nbsp;户&nbsp;I&nbsp;D：</th>
                                <td>
                                    <input class="common-text required" id="title" name="id" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🔒</i>登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="pwd" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🔏</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="rpwd" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th>👫性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</th>
                                <td>
                                    &nbsp;&nbsp;<input name="sex" value="T" type="radio" checked="checked" >&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input name="sex" value="F" type="radio" >&nbsp;女
                                </td>
                            </tr>
                            
                            <tr>
                                <th>🍰出生日期：</th>
                                <td>
                                    <input class="common-text"  name="birth" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">📧</i>用户邮箱：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                              <tr>
                                <th><i class="require-red">📞</i>用户电话：</th>
                                <td>
                                    <input class="common-text required" id="title" name="phone" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">💒</i>用户地址：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
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
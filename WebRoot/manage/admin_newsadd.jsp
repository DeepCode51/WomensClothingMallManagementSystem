<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="#">活动管理</a><span class="crumb-step">&gt;</span><span>新增活动信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/admin_donewsadd" method="post" id="myform" name="myform" > <!--/去用户servlet DoUserAdd写-->
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">🎅</i>活动标题</th>
                                <td>
                                    <input class="common-text required" id="title" name="title" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">🙊</i>活动内容</th>
                                <td>
                                    <input class="common-text required" id="title" name="content" size="50" value="" type="text">
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
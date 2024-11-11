<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8"/>
    <title>童装商城后台管理</title>
		<link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<style>
body{

background:url(images/bg.png);
backgrond-repeat:no-repeat;
background-size:100% 200%;

}
</style>
<body >
<div class="admin_login_wrap">
    <h1 >&emsp;&emsp;&emsp;后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="/shop/manage/adminlogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用&nbsp;户&nbsp;I&nbsp;D：</label>
                        <input type="text" name="id" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">登录密码：</label>
                        <input type="password" name="pwd" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <br>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
   
</div>
</body>
</html>
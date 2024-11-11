<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
 
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/function.js" type="text/javascript"></script>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
	
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1></h1>
    
        <p style="color:red">用&nbsp;户&nbsp;I&nbsp;D：<input  type="text" name="id" value=""  onfocus="FocusItem(this)"onblur="CheckItem(this)" placeholder="输入用户名"><span >&emsp;</span></p>
        <p style="color:red">用户姓名：<input type="text" name="name" value="" onfocus="FocusItem(this)"onblur="CheckItem(this)" placeholder="请填写真实姓名"><span>&emsp;</span></p>
        <p style="color:red">登录密码：<input type="text" name="pwd" value="" onfocus="FocusItem(this)"onblur="CheckItem(this)" placeholder="输入密码"><span>&emsp;</span></p>
        <p style="color:red">确认密码：<input type="text" name="rpwd" value="" onfocus="FocusItem(this)"onblur="CheckItem(this)" placeholder="确认密码"><span>&emsp;</span></p>
        <p style="color:red">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
        	&emsp;&emsp;<input style="width: 15px;height:15px" type="radio" name="sex" value="T" chceked="checked">男&emsp;&emsp;
        	<input style="width: 15px;height:15px" type="radio" name="sex" value="F" >女
        </p>
        <p style="color:red">出生日期：<input type="text" name="birth" value="" placeholder="格式xxxx-xx-xx"><span></span></p>
        <p style="color:red">用户邮箱：<input type="text" name="email" value="" placeholder="输入邮箱"><span></span></p>
        <p style="color:red">用户电话：<input type="text" name="phone" value="" placeholder="手机号码"><span></span></p>
        <p style="color:red">收货·地址：<input type="text" name="address" value="" placeholder="请输入收货地址"><span></span></p>
        <p style="color:red">&nbsp;验&nbsp;证&nbsp;码：<input class="code" type="text" name="verycode" onfocus="FocusItem(this)"onblur="CheckItem(this)" value="" placeholder="验证码">&emsp;
             <img class="cc" src="getcode" alt="看不清，换一张" onclick="change(this)"><span ></span></p><br>
        <p style="color:red">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" name="" value="注册">&emsp;&emsp;&emsp;&emsp;
        <a href="login.jsp"><span>已有账号登录</span></a></p>
        
       <!-- <p class="txt"><a href="#"><span></span>已有账号登录<img  src="img/temp/scat.jpg" width=18px height=18px /></a></p>
        <a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
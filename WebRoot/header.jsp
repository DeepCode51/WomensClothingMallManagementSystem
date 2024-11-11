<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect">
        <img src="img/logo.png" ></a></h1>
        
        
            <div class="fr clearfix" id="top1"><p class="fl">
            
           		<c:if test="${isLogin !=1 }">
            		<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	
            	</c:if>
            	
            	
            	
            	<c:if test="${isLogin ==1 }">
            		<b>你好：</b><a href="login.jsp" id="login">${name.user_name}</a>
            	
            	</c:if>
            	
            	
           		 
            </p>
            <form action="selectproductlist" method="get" class="fl"><input type="text" placeholder="" name="keywords" value="${param.keywords }"/><input
                     value=""   type="submit"/></form>
            
                <div class="btn fl clearfix">
                
                <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                
                              
                               
                               <c:if test="${isLogin ==1 }">
                                  <a href="showcart"><img src="img/gwc.png"/></a>  
                               </c:if>
                               
                    <p><a href="#"><br></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
         <li><a href="#"></a></li>
            <li><a href="indexselect">首页</a></li>
            
            
            <c:forEach var="f" items="${flist }">
            
            <li><a href="selectproductlist?fid=${f.cate_id }">${f.cate_name }</a>
                <div class="sList2">
                    <div class="clearfix">
                    	<c:forEach var="c" items="${clist }">
                    		<c:if test="${f.cate_id == c.cate_parent_id }">  
                    			<a href="selectproductlist?cid=${c.cate_id }">${c.cate_name }</a>
                    		</c:if>
                    	</c:forEach>
                    </div>
                </div>
            </li>
           </c:forEach>
            
        </ul>
    </div>
</div>
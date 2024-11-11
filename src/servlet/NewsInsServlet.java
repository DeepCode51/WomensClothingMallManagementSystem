package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NEWSDao;

import bean.NEWS;

@WebServlet("/manage/admin_donewsadd")
public class NewsInsServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 设置字符集
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	    String title=request.getParameter("title");
	    String content=request.getParameter("content");
	    NEWS news=new NEWS(0, title, content, null);
	    int count =NEWSDao.insert(news);
	    if(count >0){
			response.sendRedirect("admin_newsselect");  
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('新闻添加失败')");
			out.write("location.href='manage/admin_newsadd.jsp'");
			out.write("</script>");
		}
			
}
}

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

@WebServlet("/manage/admin_donewsupdate")
public class NewsDouServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //设置字符集
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");		
	String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		NEWS n=new NEWS(Integer.parseInt(id), title, content, null);
		int count=NEWSDao.update(n);
		if(count>0){
			response.sendRedirect("admin_newsselect");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('新闻修改失败');");
			out.print("location.href='manage/admin_tonewsupdate?id="+id+"'");
			out.print("</script>");
			out.close();
		}
	}
}

package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NEWSDao;


@WebServlet("/manage/admin_donewsdel")
public class NewsDelServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//设置字符集
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		int count=NEWSDao.del(Integer.parseInt(id));
		if(count>0){
			response.sendRedirect("admin_newsselect");
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('新闻删除失败');");
			out.print("location.href='manage/admin_newsselect'");
			out.print("</script>");
			out.close();
		}
}
}

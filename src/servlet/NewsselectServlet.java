package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NEWSDao;


import bean.NEWS;



@WebServlet("/manage/admin_newsselect")
public class NewsselectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NEWS>  newslist = NEWSDao.selectAll();
		
		request.setAttribute("newslist", newslist);
		
		request.getRequestDispatcher("admin_news.jsp").forward(request, response);  
	}
}

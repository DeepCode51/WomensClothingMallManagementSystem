package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NEWS;

import service.NEWSDao;


@WebServlet("/manage/admin_tonewsupdate")
public class NewsTouServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		NEWS news=NEWSDao.selectById(Integer.parseInt(id));
		request.setAttribute("news", news);
		request.getRequestDispatcher("admin_newsmodify.jsp").forward(request, response);
}
}

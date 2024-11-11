package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_PRODUCTDao;



/**
 * Servlet implementation class DoProductDel
 */
@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Shop_PRODUCTDao.del(id);
		response.sendRedirect("admin_productselect");
	}

	

}

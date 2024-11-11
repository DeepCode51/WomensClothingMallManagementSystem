package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_CATEGORYDao;


/**
 * Servlet implementation class DoCateDel
 */
@WebServlet("/manage/admin_docatedel")
public class DoCateDel extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Shop_CATEGORYDao.del(id);
		response.sendRedirect("admin_cateselect");
	}


}

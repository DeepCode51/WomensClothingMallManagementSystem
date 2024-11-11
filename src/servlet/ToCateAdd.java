package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_CATEGORYDao;

import bean.CATEGORY;



/**
 * Servlet implementation class ToCateAdd
 */
@WebServlet("/manage/admin_tocateadd")
public class ToCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CATEGORY> catelist = Shop_CATEGORYDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
	}


}

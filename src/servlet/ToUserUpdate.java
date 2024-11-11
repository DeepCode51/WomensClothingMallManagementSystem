package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_USERDao;

import bean.USER;



/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");   //获取参数
		
		//通过id到数据库中进行查找
		USER user = Shop_USERDao.selectByID(id);
		
		//给到修改界面
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);


		
	}

	
}

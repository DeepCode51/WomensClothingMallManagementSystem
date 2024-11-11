package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_DDDao;
import service.Shop_ORDERDao;

import bean.DD;
import bean.Order;




@WebServlet("/manage/ordertouservlet")
public class OrderTouServlet extends HttpServlet {

	
	public  void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		
		Order order=Shop_ORDERDao.selectById(Integer.parseInt(id));
		ArrayList<DD> dlist=Shop_DDDao.selectById(Integer.parseInt(id));
		
		request.setAttribute("dlist", dlist);
		request.setAttribute("order", order);
		request.getRequestDispatcher("admin_ordermodify.jsp").forward(request, response);
}
}

	



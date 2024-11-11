package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Shop_CARTDao;

import bean.CART;
import bean.USER;



@WebServlet("/shopselect")
public class ShopSelect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		USER userCZ =(USER)session.getAttribute("name");
		if(userCZ!=null){
//			System.out.println("登录好了");
			USER eu=(USER)session.getAttribute("name");
			String id=(String)eu.getUser_id();
			ArrayList<CART> list=Shop_CARTDao.getCart(id);
			request.setAttribute("shoplist",list);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('请先登录');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
			
		}
	}
}
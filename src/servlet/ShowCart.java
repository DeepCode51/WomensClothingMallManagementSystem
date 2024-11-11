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



/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid = (String)user.getUser_id();
			
			ArrayList<CART> list= Shop_CARTDao.getCart(uid);
			
			request.setAttribute("shoplist", list); //放入请求对象中
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);  //请求页面
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('请先登录后，再购买')");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
			
			
		}
	}


}

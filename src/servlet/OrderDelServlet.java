package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_ORDERDao;



@WebServlet("/manage/orderdelservlet")
public class OrderDelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int count=Shop_ORDERDao.del(Integer.parseInt(id));
		if(count>0){
			response.sendRedirect("orderselservlet");
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<srcipt>");
			out.print("alert('删除失败');");
			out.print("location.href='orderselvlet'");
			out.print("</srcipt>");
		}
}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_ORDERDao;

import bean.Order;




@WebServlet("/manage/orderdouservlet")
public class OrderDoUServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orderId=request.getParameter("orderId");
		String name=request.getParameter("name");
		String addres=request.getParameter("addres");
		String uphone=request.getParameter("uphone");
		String cost=request.getParameter("cost");
		String tatus=request.getParameter("tatus");
		String size=request.getParameter("size");
		Order order=new Order(Integer.parseInt(orderId), "", name, addres,uphone, "", Integer.parseInt(cost), Integer.parseInt(tatus),size);
		int count=Shop_ORDERDao.update(order);
		if(count>0){
			response.sendRedirect("orderselservlet");
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>");
			out.print("alert('修改失败');");
			out.print("location.href='ordertouservlet'");
			out.print("</script>");
			out.close();
		}
}

}
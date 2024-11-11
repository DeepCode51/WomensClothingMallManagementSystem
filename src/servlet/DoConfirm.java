package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import service.Shop_ORDERDao;

/**
 * Servlet implementation class DoConfirm
 */
@WebServlet("/doorder")
public class DoConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		String name=request.getParameter("name");
		String addres=request.getParameter("addres");
		String uphone=request.getParameter("uphone");
		String cost=request.getParameter("cost");
		String size=request.getParameter("size");
		String tatus=request.getParameter("tatus");
		Order order=new Order(Integer.parseInt(orderId), "", name, addres,uphone, "", Integer.parseInt(cost), Integer.parseInt(tatus),size);
		int count=Shop_ORDERDao.update(order);
		if(count>0){
			response.sendRedirect("selectddan?dd="+name);
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
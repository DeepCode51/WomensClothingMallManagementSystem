package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_USERDao;

import bean.USER;



/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 设置字符集
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//获取参数  接收参数
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String pwd = request.getParameter("pwd");
				String sex = request.getParameter("sex");
				String year = request.getParameter("birth");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String status = request.getParameter("status");
				
				int ustatus = 1;
				
				if(status != null) {
					ustatus = Integer.parseInt(status);
				}
				

				//创建用户实体
				USER user = new USER(id, name, pwd, sex, year, null, email, phone, address, ustatus);
				
				//加入到数据库的用户表中
				int count = Shop_USERDao.update(user);
				
				
				//判断成功或者失败重定向到哪里
				if(count >0){
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				}else{
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('用户修改失败')");
					out.write("location.href='manage/admin_touserupdate?id="+id+"'");
					out.write("</script>");
				}
					
	}

}

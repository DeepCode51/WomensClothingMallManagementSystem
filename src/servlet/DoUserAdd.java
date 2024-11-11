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
 * Servlet implementation class DoUserAdd     写admin_useradd.jsp
 */
@WebServlet("/manage/admin_douseradd")   
public class DoUserAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户添加 
		
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
		
		//创建用户实体
		USER u = new USER(id, name, pwd, sex, year, null, email, phone, address, 1);
		
		//加入到数据库的用户表中
		int count = Shop_USERDao.insert(u);
		
		
		//判断成功或者失败重定向到哪里
		if(count >0){
			response.sendRedirect("admin_douserselect");  
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='manage/admin_useradd.jsp'");
			out.write("</script>");
		}
			
			
	}

}

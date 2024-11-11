package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Shop_USERDao;

import bean.USER;




/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		int count = Shop_USERDao.selectByNM(id, pwd);
		
		//System.out.println(id + "##"+pwd);
		
		if(count > 0) {
			
			USER user = Shop_USERDao.selectAdmin(id, pwd);  //获取用户信息
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			
			if(user.getUser_status() == 2) {
				session.setAttribute("isAdminLogin", "1");   //状态为2 才能登录后台
			//	System.out.println(userName + "##"+passWord);
				response.sendRedirect("/shop/manage/admin_index.jsp");  //登录后台
			}else{
				
				response.sendRedirect("/shop/index.jsp");  //登录前台
			}
	
		
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户登录失败！');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}

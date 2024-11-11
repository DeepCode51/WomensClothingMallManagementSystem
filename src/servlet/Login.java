package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.USER;

import service.Shop_USERDao;



/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//提交登录信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取参数  接收参数
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
        int count = Shop_USERDao.selectByNM(id, pwd);
		
		if(count > 0) {
			HttpSession session = request.getSession();
			USER user = Shop_USERDao.selectAdmin(id, pwd);
			
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			
			response.sendRedirect("indexselect");
			
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
	



package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_CATEGORYDao;

import bean.CATEGORY;



/**
 * Servlet implementation class DoUserCate
 */
@WebServlet("/manage/admin_docateadd")
public class DoUserCate extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		int fid = Integer.parseInt(request.getParameter("parentid")); //取出父id并变换成整数
		String name = request.getParameter("classname");
		
		CATEGORY cate= new CATEGORY(0, name, fid);
		Shop_CATEGORYDao.insert(cate);
		
		response.sendRedirect("admin_cateselect");  //转向列表页面
	}

}

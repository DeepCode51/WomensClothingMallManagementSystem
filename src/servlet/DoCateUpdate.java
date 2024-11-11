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
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				int id = Integer.parseInt(request.getParameter("id"));
				int fid = Integer.parseInt(request.getParameter("parentid"));
				String name = request.getParameter("classname");
				
				CATEGORY cate= new CATEGORY(id, name, fid);
				Shop_CATEGORYDao.update(cate);
				
				response.sendRedirect("admin_cateselect");
		
	}

}

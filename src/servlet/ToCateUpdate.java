package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_CATEGORYDao;

import bean.CATEGORY;


//获取修改记录
/**
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));	  //转成整数
		
		CATEGORY cate =  Shop_CATEGORYDao.selectById(id);  //拿过来一个记录
		
		
		ArrayList<CATEGORY> catelist = Shop_CATEGORYDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate1", cate);
		
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}


}

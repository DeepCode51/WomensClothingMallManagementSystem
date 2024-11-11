package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CATEGORY;

import service.Shop_CATEGORYDao;



/**
 * Servlet implementation class CateSelect  
 */
//3调用分类列表  查询方法
@WebServlet("/manage/admin_cateselect")
public class CateSelect extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    ArrayList<CATEGORY> catelist = Shop_CATEGORYDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);  //会加载admin_cate.jsp
	}


}


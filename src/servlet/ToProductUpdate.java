package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_CATEGORYDao;
import service.Shop_PRODUCTDao;

import bean.CATEGORY;
import bean.PRODUCT;


/**
 * 后台商品修改
 */
@WebServlet("/manage/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");//获取父分类
		request.setAttribute("flist", flist);
		
		ArrayList<CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");//获取子分类
		request.setAttribute("clist", clist);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");   //获取参数
		
		//通过id到数据库中进行查找
				PRODUCT product = Shop_PRODUCTDao.selectById(Integer.parseInt(id));
				
				//给到修改界面
				request.setAttribute("product", product);
				//request.setAttribute("cpage", request.getParameter("cpage"));
				
				//重定向
				request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);

		
	}

	

}

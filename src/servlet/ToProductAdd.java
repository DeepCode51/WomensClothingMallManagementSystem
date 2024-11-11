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
 * 产品获取分类信息
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");//获取父分类
		request.setAttribute("flist", flist);
		
		ArrayList<CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");//获取子分类
		request.setAttribute("clist", clist);
		
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);;
	}


}

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
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		//接受用户搜索字符串
		String keyword = request.getParameter("keywords");
		
		int id=0;
		ArrayList<PRODUCT> list = null;
		
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list = Shop_PRODUCTDao.selectAllByFid(id);
			request.setAttribute("title", Shop_CATEGORYDao.selectById(id).getCate_name());
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list = Shop_PRODUCTDao.selectAllByCid(id);
			request.setAttribute("title", Shop_CATEGORYDao.selectById(id).getCate_name());
		}
		if(keyword!=null){
			list = Shop_PRODUCTDao.selectAllByWord(keyword);
		}
		
			request.setAttribute("searchParams", "&keywords="+keyword);
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
}
}
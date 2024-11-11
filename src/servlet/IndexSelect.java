package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CATEGORY;
import bean.NEWS;
import bean.PRODUCT;

import service.NEWSDao;
import service.Shop_CATEGORYDao;
import service.Shop_PRODUCTDao;





/**
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//父分类
		ArrayList<CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");  //用列表进行接收
		request.setAttribute("flist", flist);
		
		//子分类
		ArrayList<CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
     ArrayList<PRODUCT>  plist = Shop_PRODUCTDao.selectAll();
		
		request.setAttribute("plist", plist);
		ArrayList<NEWS> nlist = NEWSDao.selectAll();
		request.setAttribute("nlist", nlist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	

}

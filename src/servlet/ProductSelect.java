package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_PRODUCTDao;

import bean.PRODUCT;





/**
 * Servlet implementation class ProductSelect
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<PRODUCT>  plist = Shop_PRODUCTDao.selectAll();
		
		request.setAttribute("plist", plist);
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);  
	}


}

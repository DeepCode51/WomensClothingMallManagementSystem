package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CART;

import service.Shop_CARTDao;





@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String str1=request.getParameter("pid");
		String str2=request.getParameter("action");
		String str3=request.getParameter("getvalue");
		String c=request.getParameter("c");
		if(str2.equals("jia")){
			int count=Shop_CARTDao.updateJia(Integer.parseInt(str1));
		}
		if(str2.equals("jian")){
			int count=Shop_CARTDao.updateJian(Integer.parseInt(str1));
			
		}
		if(str2.equals("closeText")){
			CART es=new CART(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, c,1, "1", 1);
			int count=Shop_CARTDao.updateClose(es);
		}
		if(str2.equals("delText")){
			int count=Shop_CARTDao.getDeleteDD(Integer.parseInt(str1));
		}
		response.sendRedirect("shopselect");
	}
}

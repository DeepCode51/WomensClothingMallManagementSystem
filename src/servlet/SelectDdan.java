package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Ddan;
import bean.PRODUCT;

import service.Shop_DdanDao;
import service.Shop_PRODUCTDao;





/**
 * Servlet implementation class SelectDdan
 */

@WebServlet("/selectddan")
public class SelectDdan extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = req.getSession();
		//查询最近浏览的商品
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		if(ids!=null){
			ArrayList<PRODUCT> lastlylist = Shop_PRODUCTDao.selectAllById(ids);
			req.setAttribute("lastlylist", lastlylist);
		}
		
			EncodeUtil.encode(req);
			String dd=req.getParameter("dd");
			ArrayList<Ddan> dan=Shop_DdanDao.selectById(dd);
			req.setAttribute("dan", dan);
			req.getRequestDispatcher("myorderq.jsp").forward(req, resp);
	}
	}

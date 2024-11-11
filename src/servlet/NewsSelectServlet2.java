package servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NEWSDao;


import bean.NEWS;



/**
 */
@WebServlet("/newsselect2")   
public class NewsSelectServlet2 extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取参数  接收参数
		String id = request.getParameter("id");
		NEWS n = null;
		if(id!=null){
			n = NEWSDao.selectById(Integer.parseInt(id));
		}
		request.setAttribute("n", n);
		ArrayList<NEWS> nlist = NEWSDao.selectAll();
		request.setAttribute("nlist", nlist);
		request.getRequestDispatcher("news.jsp").forward(request, response);
			
			
	}

}

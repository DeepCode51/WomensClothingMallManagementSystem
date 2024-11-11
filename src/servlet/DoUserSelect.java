package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.USER;

import service.Shop_USERDao;




/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage = 1; //当前页面
		int count = 5; //每页显示几条
		
		//获取用户指定的页面
		
		String cp = request.getParameter("cp");
		
		//接受用户搜索关键字
		String keyword = request.getParameter("keywords");

		
		if(cp!=null){
					cpage = Integer.parseInt(cp);
				}
		
		int arr[] = Shop_USERDao.totalPage(count, keyword);
		
		//获取用户所有列表
		ArrayList<USER> list = Shop_USERDao.selectAll(cpage, count, keyword);
		
		//放到请求对象
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		//传入对象
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	
	}
		
		
		
	}

	



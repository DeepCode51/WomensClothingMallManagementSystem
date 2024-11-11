package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import javax.servlet.http.HttpSession;

import bean.CATEGORY;
import bean.PRODUCT;

import service.Shop_CATEGORYDao;
import service.Shop_PRODUCTDao;





/**
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> flist =  Shop_CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<CATEGORY> clist =  Shop_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		
		
		//传id
		String id = request.getParameter("id");
		
		
 //获取最近访问
		HttpSession session = request.getSession();  //获取session对象
		
		//从SSESSIOn获取一下 ids
		
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");  //接收第一次访问 如果为空
		
		if(ids == null){
			ids = new ArrayList<Integer>();
		}
			
		//最多放5， 如果多出6个将第一个删除
		if(ids.size() >= 6) {
			ids.remove(0);
		}
		
		// 添加列表里， 但只要一份  不重复
		if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		
		}
		
		session.setAttribute("ids", ids);
		
		ids= (ArrayList<Integer>)session.getAttribute("ids");
		
		//从数据库中取出
		if(ids!=null) {
			ArrayList<PRODUCT> lastlylist = Shop_PRODUCTDao.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		
		PRODUCT p = null;
		
		if(id !=null) {
			p = Shop_PRODUCTDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p); //发送到前端
		}
		
		if(p!=null) {
			int cid = p.getProduct_cid();
			ArrayList<PRODUCT> classlist = Shop_PRODUCTDao.selectAllByCid(cid);
			//request.setAttribute("classlist", classlist);
			
			CATEGORY cate = Shop_CATEGORYDao.selectById(cid);
			
			request.setAttribute("cate", cate);
		}
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}


}

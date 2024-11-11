package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Shop_CARTDao;
import service.Shop_PRODUCTDao;

import bean.CART;
import bean.PRODUCT;
import bean.USER;




/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PRODUCT  p = null;
		String pid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		String d=request.getParameter("d");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			
			String uid = (String)user.getUser_id();
			
			
			//通过用户ID和购物车中的商品ID 查看有没有这条记录
			
			CART srcsp = Shop_CARTDao.getCartShop(uid, pid);
			
			if(srcsp != null) {
				int srccount = srcsp.getCart_quantity();
				
				int newcount = srccount + Integer.parseInt(count);
				
				if(newcount >=5) {
					newcount =5;
				}
				
				Shop_CARTDao.updatenum(srcsp.getCart_id(), newcount);
				
			}else{
			
			
				if(pid !=null) {
					p  = Shop_PRODUCTDao.selectById(Integer.parseInt(pid));
				}
				
				CART  cart = new CART (
							0,
							p.getProduct_filename(),
							p.getProduct_name(),
							p.getProduct_price(),
							Integer.parseInt(count),
							p.getProduct_stock(),
							d,
							p.getProduct_id(),
							uid,
							1
							
						);
				
				Shop_CARTDao.insert(cart);
			}
			
		}else{
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买')");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else{
			response.sendRedirect("selectproductview?id="+pid);
		}
		
	}

	



		
	}

	

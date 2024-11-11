package com.sflower.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
//后台登录过滤器
@WebFilter("/manage/*")
public class AdminLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request; //转换成父类request的http的
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session =req.getSession();
		
		String flag=(String)session.getAttribute("isAdminLogin");
		
		String requst_uri = req.getRequestURI();
		String ctxPath= req.getContextPath();
		String uri = requst_uri.substring(ctxPath.length());
		
        //System.out.println("url:" +requst_uri);
        if(requst_uri.indexOf(".css")>0||requst_uri.indexOf(".js")>0||requst_uri.indexOf(".png")>0) {
        	chain.doFilter(req, resp);             return;
        }
        //response.setContentType("text/html;text/html; charset=UTF-8");
		if(uri.contains("admin_")){
			if(flag !=null && flag.equals("1")) {
				chain.doFilter(req, resp);  //不是登录直接过
			}else{
				PrintWriter out = resp.getWriter();
				out.write("<script>");
				out.write("alert('请先登录后台！');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
	
	
		}else{
			chain.doFilter(req, resp);	
		}
		
		return;
		
		 //不通过则直接return
		// pass the request along the filter chain
	//	chain.doFilter(req, resp); // 通过则使用这条语句
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Shop_PRODUCTDao;

import bean.PRODUCT;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 商品修改提交到数据库
 */
@WebServlet("/manage/admin_doproductupdate")
public class DoProductUpdate extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//创建SmartUpload对象
		SmartUpload su= new SmartUpload();
		
		//初使化
		su.initialize(this.getServletConfig(), request, response);
		
		//上传过程
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传的文件对象
		Files fs= su.getFiles();
		File f = fs.getFile(0);
		
		//获取上传的文件名称
		String fname = f.getFileName();
		
		try {
			su.save("images/product");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取新的请求对象
		Request req1 = su.getRequest();
		String id = req1.getParameter("id");
		String pname = req1.getParameter("productname");
		String pid = req1.getParameter("parentid");
		String price = req1.getParameter("productprice");
		String desc = req1.getParameter("productdesc");
		String stock = req1.getParameter("productstock");
		
		//创建产品对象
		PRODUCT p = new PRODUCT(
				        Integer.parseInt(id),
						pname,
						desc,
						Integer.parseInt(price),
						Integer.parseInt(stock),
						Integer.parseInt(pid.split("-")[0]),
						Integer.parseInt(pid.split("-")[1]),
						fname
				);
				
		//加入数据库
		int count = Shop_PRODUCTDao.update(p);
		
		
		//成功或失败重定向到哪里
		
				if(count >0 ) {
					
					response.sendRedirect("admin_productselect");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('商品添加失败')");
					out.write("location.href='manage/admin_toproductupdate'");
					out.write("</script>");
					
				}
		
		
	}

}

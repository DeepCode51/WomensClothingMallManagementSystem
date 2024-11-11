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

import bean.Orderitem;
import bean.USER;



@WebServlet("/gmservlet")
public class gmServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");

HttpSession session=request.getSession();
USER list=(USER)session.getAttribute("name");
//用户id
String id=list.getUser_id();
//用户姓名
String name=list.getUser_name();
//用户地址
String address=list.getUser_address();
String uphone=list.getUser_phone();
String c =request.getParameter("c");
//总价钱
String price=request.getParameter("jstext");
////////////////
//商品id
String [] EP_ID=request.getParameterValues("spID");
//购买数量
String [] quantity=request.getParameterValues("number");
//商品单价
String [] sPPrice=request.getParameterValues("sPPrice");

//购买后对商品表的库存进行修改
for(int i=0;i<EP_ID.length;i++){
	int count=Shop_CARTDao.updateStock(Integer.parseInt(quantity[i]),Integer.parseInt(EP_ID[i]));
}
//商品单个总价
int [] pprice=new int[EP_ID.length];
for(int i=0;i<EP_ID.length;i++){
	pprice[i]=Integer.parseInt(quantity[i])*Integer.parseInt(sPPrice[i]);
} 
/////////////////得到序列
//往订单表里添加数据
int count=Shop_CARTDao.insertDD(id, name, address,uphone,Integer.parseInt(price),c);
int getSequenceId=Shop_CARTDao.getSequenceId();
//循环往订单详情添加
for(int i=0;i<EP_ID.length;i++){
	Orderitem eod=new Orderitem(1,getSequenceId,Integer.parseInt(EP_ID[i]),Integer.parseInt(quantity[i]),pprice[i]);
	int count1=Shop_CARTDao.Insert(eod);
}


////////////////////
// 开单后，修改购物车
String [] esID=request.getParameterValues("esID");
for(int i=0;i<esID.length;i++){
	int count2 =Shop_CARTDao.cartdelete(Integer.parseInt(esID[i]));
}
/////
if(count>0){
	PrintWriter out = response.getWriter();
	out.print("<script>");
	out.print("alert('购物成功');");
	out.print("location.href='ok.jsp';");
	out.print("</script>");
	out.close();
}else{
	PrintWriter out = response.getWriter();
	out.print("<script>");
	out.print("alert('购物失败，请重新选择商品');");
	out.print("location.href='shopselect';");
	out.print("</script>");
	out.close();
}
}
}
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Orderitem;
import bean.CART;
import beans.Basedao;







//插入购物车方法
public class Shop_CARTDao {
	public static int insert(CART cart){
		String sql = "insert into cart values(null,?,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_size(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
				
		};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static CART getCartShop(String id) {
		CART es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from cart where cart_id=? and cart_valid=1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new CART(
						 	rs.getInt("Cart_id"),
						 	rs.getString("Cart_p_filename"),
						 	rs.getString("Cart_p_name"),
						 	rs.getInt("Cart_p_price"),
						 	rs.getInt("Cart_quantity"),
						 	rs.getInt("Cart_p_stock"),
						 	rs.getString("Cart_p_size"),
						 	rs.getInt("Cart_p_id"),
						 	rs.getString("Cart_u_id"),
						 	rs.getInt("Cart_valid")
						 );
				 
				 
				
				 
	
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	

	public static CART getCartShop(String uid, String pid) {
		CART es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from cart where cart_u_id=? and cart_p_id=? and cart_valid=1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new CART(
						 	rs.getInt("Cart_id"),
						 	rs.getString("Cart_p_filename"),
						 	rs.getString("Cart_p_name"),
						 	rs.getInt("Cart_p_price"),
						 	rs.getInt("Cart_quantity"),
						 	rs.getInt("Cart_p_stock"),
							rs.getString("Cart_p_size"),
						 	rs.getInt("Cart_p_id"),
						 	rs.getString("Cart_u_id"),
						 	rs.getInt("Cart_valid")
						 );
				 
				 
				
				 
	
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	/*
	 * 
	 *修改订单数量 加
	 */
	public static int updateJia(int id){
		String sql="update cart set cart_quantity=cart_quantity+1 where cart_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	
	/*
	 * 
	 *修改订单数量 减
	 */
	public static int updateJian(int id){
		String sql="update cart set cart_quantity=cart_quantity-1 where cart_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 
	 * 修改订单数量，自己输入
	 */
	public static int updateClose(CART es){
		String sql="update cart set cart_quantity=? where cart_id=?";
		Object [] params={es.Cart_quantity,es.Cart_id};
		return Basedao.exectuIUD(sql, params);
	}
	public static ArrayList<CART> getCart(String id){
		ArrayList<CART> list = new ArrayList<CART>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 CART  c = new CART(
						 	rs.getInt("Cart_id"),
						 	rs.getString("Cart_p_filename"),
						 	rs.getString("Cart_p_name"),
						 	rs.getInt("Cart_p_price"),
						 	rs.getInt("Cart_quantity"),
						 	rs.getInt("Cart_p_stock"),
							rs.getString("Cart_p_size"),
						 	rs.getInt("Cart_p_id"),
						 	rs.getString("Cart_u_id"),
						 	rs.getInt("Cart_valid")
						 );
				 
				 
				
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	public static int updatenum(int esid, int count){
		
		String sql = "update cart set cart_quantity=? where cart_id=? ";
		
		Object[] params = {count, esid};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	public static int cartdelete(int id){
		String sql="update  cart set cart_valid=2 where cart_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	//kucun
	public static int updateStock(int stock,int id){
		String sql="update product set product_stock=product_stock-? where product_id=?";
		Object [] params={stock,id};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int getDeleteDD(int id) {
		String sql="delete from cart where cart_id=?";
		
		Object[] params={id};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static int insertDD(String id,String name,String address,String uphone,int price,String size){
		String sql="insert into orders values(null,?,?,?,?,now(),?,1,?)";
		Object [] params={id,name,address,uphone,price,size};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 得到序列
	 */
	public static int getSequenceId(){
		int id = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select oid from orders order by oid desc limit 0,1");
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return id;
	}
	/*
	 * 
	 * 订单详细表的添加
	 */
	public static int Insert(Orderitem i){
		String sql="insert into orderitem values(null,?,?,?,?)";
		Object [] params={i.getOid(),i.getProduct_id(),i.getQuantity(),i.getCost()};
		return Basedao.exectuIUD(sql, params);
	}
}

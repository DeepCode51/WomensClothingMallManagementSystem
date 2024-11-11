package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Order;
import beans.Basedao;





public class Shop_ORDERDao {
	public static ArrayList<Order> selectAll(){
		ArrayList<Order> list=new ArrayList<Order>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orders");
			rs=ps.executeQuery();
			while (rs.next()) {
				Order o=new Order(rs.getInt("oid"),rs.getString("uid"),rs.getString("uname"),rs.getString("uaddress"),rs.getString("uphone"),rs.getString("createtime"),rs.getInt("cost"),rs.getInt("status"),rs.getString("size"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static Order selectById(int id){
		Order o=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orders where oid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				o=new Order(rs.getInt("oid"),rs.getString("uid"),rs.getString("uname"),rs.getString("uaddress"),rs.getString("uphone"),rs.getString("createtime"),rs.getInt("cost"),rs.getInt("status"),rs.getString("size"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return o;
	}
	
	public static int insert(Order o){
		String sql="insert into orders values(null,?,?,?,?,?,?,?)";
		Object[] params={o.getUid(),o.getUname(),o.getUaddress(),o.getUphone(),o.getCreatetime(),o.getCost(),o.getStatus(),o.getSize()};
		return Basedao.exectuIUD(sql, params);
	}

	public static int update(Order o){
		String sql="update orders set uname=?,uaddress=?,uphone=?,cost=?,status=?,size=? where oid=?";
		Object[] params={o.getUname(),o.getUaddress(),o.getUphone(),o.getCost(),o.getStatus(),o.getSize(),o.getOid()};
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id){
		String sql="delete from orders where oid=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}



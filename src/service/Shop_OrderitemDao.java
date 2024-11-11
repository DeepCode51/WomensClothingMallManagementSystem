package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Orderitem;
import beans.Basedao;






public class Shop_OrderitemDao {
	public static ArrayList<Orderitem> selectAll(){
		ArrayList<Orderitem> list=new ArrayList<Orderitem>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orderitem");
			rs=ps.executeQuery();
			while (rs.next()) {
				Orderitem c=new Orderitem(rs.getInt("iid"),rs.getInt("oid"),rs.getInt("Product_id"),rs.getInt("quantity"),rs.getInt("cost"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static Orderitem selectById(int id){
		Orderitem c=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orderitem where iid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				c=new Orderitem(rs.getInt("iid"),rs.getInt("oid"),rs.getInt("Product_id"),rs.getInt("quantity"),rs.getInt("cost"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return c;
	}
	public static int insert(Orderitem od){
		String sql="insert into orderitem values(null,?,?,?,?)";
		Object[] params={od.getOid(),od.getProduct_id(),od.getQuantity(),od.getCost()};
		return Basedao.exectuIUD(sql, params);
	}

	public static int update(Orderitem od){
		String sql="update orderitem set oid=?,pid=?,quantity=?,cost=? where iid=?";
		Object[] params={od.getOid(),od.getProduct_id(),od.getQuantity(),od.getIid()};
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id){
		String sql="delete from orderitem where iid=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}



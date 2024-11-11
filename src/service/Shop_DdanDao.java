package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Ddan;
import beans.Basedao;





public class Shop_DdanDao {
	public static ArrayList<Ddan> selectById(String id){
		ArrayList<Ddan> dd=new ArrayList<Ddan>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orders o,orderitem i ,product p where o.uid=? and i.oid=o.oid and i.product_id=p.product_id order by o.oid desc");
			ps.setString(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				Ddan d=new Ddan(rs.getInt("oid"),rs.getString("uid"),rs.getString("Product_name"), rs.getString("product_filename"), rs.getInt("Product_price"), rs.getInt("quantity"), rs.getInt("Product_stock"),rs.getInt("status"),rs.getString("size"));
				dd.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return dd;
	}
}


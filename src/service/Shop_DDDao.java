package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DD;
import beans.Basedao;




public class Shop_DDDao {
	public static ArrayList<DD>  selectById(int id){
		ArrayList<DD> dd=new ArrayList<DD>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from orders o,orderitem i, product p where o.oid=? and i.oid=o.oid and i.product_id= p.product_id");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				DD d=new DD(rs.getString("Product_name"), rs.getString("product_filename"), rs.getInt("Product_price"), rs.getInt("quantity"), rs.getInt("Product_stock"),rs.getString("size"));
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


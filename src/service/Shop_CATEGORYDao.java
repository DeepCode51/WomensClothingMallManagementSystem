package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CATEGORY;
import beans.Basedao;








  //2查询列表方法   获取所有分类
public class Shop_CATEGORYDao {
	
	public static ArrayList<CATEGORY> selectAll() {
		ArrayList<CATEGORY> list = new ArrayList<CATEGORY>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CATEGORY cate = new CATEGORY(
						 	rs.getInt("Cate_id"),
						 	rs.getString("Cate_name"),
						 	rs.getInt("Cate_parent_id")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	
	//修改分类方法
	public static CATEGORY selectById(int id) {

		CATEGORY cate = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *  from category  where Cate_id=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 cate = new CATEGORY(
						 	rs.getInt("Cate_id"),
						 	rs.getString("Cate_name"),
						 	rs.getInt("Cate_Parent_id")
			
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return cate;
	}
	
	
	
	//更新方法
	public static int update(CATEGORY cate) {
		String sql = "update category set Cate_name=?, Cate_parent_id=?  where Cate_id = ?";
		
		Object[] params = {
					cate.getCate_name(),
					cate.getCate_parent_id(),
					cate.getCate_id()
					};
		
		return Basedao.exectuIUD(sql, params);
}
	
	
	
   //添加分类的方法
	public static int insert(CATEGORY cate) {
		String sql = "insert into category values(null, ?, ?)";
		
		Object[] params = {
					cate.getCate_name(), 
					cate.getCate_parent_id()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	//删除方法
	public static int del(int id) {
		String sql = "delete from category where Cate_id=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	//前台分类获取方法
	/**
	 * 查询分类，子分类和父级分类
	 * @param flag  flag="father" flag="child"
	 * @return
	 */
	public static ArrayList<CATEGORY> selectCat(String flag) {
		ArrayList<CATEGORY> list = new ArrayList<CATEGORY>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;

		
		try {
			
			String sql = null;
			
			//判断子分类 父分类
			if(flag!=null && flag.equals("father")){
			
				sql = "select * from category where Cate_parent_id=0";
			}else{
				sql = "select * from category where Cate_parent_id!=0";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 CATEGORY cate = new CATEGORY(
						 	rs.getInt("Cate_id"),
						 	rs.getString("Cate_name"),
						 	rs.getInt("Cate_parent_id")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
}
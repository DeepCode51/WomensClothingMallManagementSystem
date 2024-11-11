package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PRODUCT;
import beans.Basedao;






public class Shop_PRODUCTDao {

  //插入数据库方法
	public static int insert(PRODUCT p) {
		String sql = "insert into product values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					p.getProduct_name(),
					p.getProduct_description(),
					p.getProduct_price(),
					p.getProduct_stock(),
					p.getProduct_fid(),
					p.getProduct_cid(),
					p.getProduct_filename()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
  //查询数据库
	public static ArrayList<PRODUCT> selectAll() {
		ArrayList<PRODUCT> list = new ArrayList<PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
	
		try {
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 PRODUCT p = new PRODUCT(
						 	rs.getInt("Product_id"),
						 	rs.getString("Product_name"),
						 	rs.getString("Product_description"),
						 	rs.getInt("Product_price"),
						 	rs.getInt("Product_stock"),
						 	rs.getInt("Product_fid"),
						 	rs.getInt("Product_cid"),
						 	rs.getString("Product_filename")
						 );
				 
				 
				 list.add(p);
				 
			 }
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
  //查询单个id
	public static PRODUCT selectById(int id){
		PRODUCT p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
	
		try {
			String sql = "select * from product where Product_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 p = new PRODUCT(
						 	rs.getInt("Product_id"),
						 	rs.getString("Product_name"),
						 	rs.getString("Product_description"),
						 	rs.getInt("Product_price"),
						 	rs.getInt("Product_stock"),
						 	rs.getInt("Product_fid"),
						 	rs.getInt("Product_cid"),
						 	rs.getString("Product_filename")
						 );
 
			 }
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return p;
	}
	
	
	
  //查询获取所有父id
	public static ArrayList<PRODUCT> selectAllByFid(int fid) {
		ArrayList<PRODUCT> list = new ArrayList<PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
	
		try {
			String sql = "select * from product where Product_fid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 PRODUCT p = new PRODUCT(
						 	rs.getInt("Product_id"),
						 	rs.getString("Product_name"),
						 	rs.getString("Product_description"),
						 	rs.getInt("Product_price"),
						 	rs.getInt("Product_stock"),
						 	rs.getInt("Product_fid"),
						 	rs.getInt("Product_cid"),
						 	rs.getString("Product_filename")
						 );
				 
				 
				 list.add(p);
				 
			 }
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	//查询获取所有子id
		public static ArrayList<PRODUCT> selectAllByCid(int cid) {
			ArrayList<PRODUCT> list = new ArrayList<PRODUCT>();
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
		
			try {
				String sql = "select * from product where Product_cid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, cid);
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 PRODUCT p = new PRODUCT(
							 	rs.getInt("Product_id"),
							 	rs.getString("Product_name"),
							 	rs.getString("Product_description"),
							 	rs.getInt("Product_price"),
							 	rs.getInt("Product_stock"),
							 	rs.getInt("Product_fid"),
							 	rs.getInt("Product_cid"),
							 	rs.getString("Product_filename")
							 );
					 
					 
					 list.add(p);
					 
				 }
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			return list;
		}
		
		
		/**
		 * Servlet implementation class ToCateUpdate
		 * 
		 * 	//更新数据库方法    !!!有问题
				public static int update(product p){
						String sql = "update product set Product_name=?, Product_fid=?, "
								+ "Product_cid=?, Product_filename=?, Product_price=?,"
								+ "Product_description=? ,Product_stock=? where Product_id = ?";
						
						Object[] params ={
								
								p.getProduct_id(),
								p.getProduct_name(),
								p.getProduct_description(),
								p.getProduct_price(),
								p.getProduct_stock(),
								p.getProduct_fid(),
								p.getProduct_cid(),
								p.getProduct_filename(),
						};		
					
						
						return Basedao.exectuIUD(sql, params);  //返回影响
				}
		 */
	
		
		
		public static int update(PRODUCT p){
			if(!p.getProduct_filename().equals("")){
				String sql = "update product set Product_name=?, "
						+ "Product_description=? ,"
						+ "Product_price=?,"
						+ "Product_stock=?,"
						+ "Product_fid=?, "
						+ "Product_cid=?,"
						+ "Product_filename=? "
						+ "where Product_id = ?";
		
				
				Object[] params ={
						p.getProduct_name(),
						p.getProduct_description(),
						p.getProduct_price(),
						p.getProduct_stock(),
						p.getProduct_fid(),
						p.getProduct_cid(),
						p.getProduct_filename(),
						p.getProduct_id()};
						
				return Basedao.exectuIUD(sql, params);  //返回影响
				}else{		
					String sql = "update product set Product_name=?, "
							+ "Product_description=? ,"
							+ "Product_price=?,"
							+ "Product_stock=?,"
							+ "Product_fid=?, "
							+ "Product_cid=?,"
							+ "Product_filename=?"
							+ "where Product_id = ?";
					
					Object[] params ={
							p.getProduct_name(),
							p.getProduct_description(),
							p.getProduct_price(),
							p.getProduct_stock(),
							p.getProduct_fid(),
							p.getProduct_cid(),
							p.getProduct_filename(),
							p.getProduct_id()};
							
					return Basedao.exectuIUD(sql, params);
				
		}
		
		}
		
		//猜你喜欢  显示最近浏览
				public static ArrayList<PRODUCT> selectAllById(ArrayList<Integer> ids) {
					ArrayList<PRODUCT> lastlylist = new ArrayList<PRODUCT>();
					//声明产品
					PRODUCT p=null;
					
					//声明结果集
					ResultSet rs = null;
					
					//获取连接对象
					Connection conn = Basedao.getconn();
					
					PreparedStatement ps = null;
				
					try {
						
						 for(int i=0; i<ids.size(); i++){
							 String sql = "select * from product where Product_id=?";
								ps = conn.prepareStatement(sql);
								ps.setInt(1, ids.get(i));
								rs = ps.executeQuery();
								 
								 while(rs.next()) {
									 p = new PRODUCT(
											 	rs.getInt("Product_id"),
											 	rs.getString("Product_name"),
											 	rs.getString("Product_description"),
											 	rs.getInt("Product_price"),
											 	rs.getInt("Product_stock"),
											 	rs.getInt("Product_fid"),
											 	rs.getInt("Product_cid"),
											 	rs.getString("Product_filename")
											 );
									 
									 
									 lastlylist.add(p);
									 
								 } 
						 }
						
						
				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					return lastlylist;
				}
				
				
				
				//查询id  修改商品信息
				public static PRODUCT selectAll(String id) {
					PRODUCT p = null;
					//声明结果集
					ResultSet rs = null;
					//获取连接对象
					Connection conn = Basedao.getconn();
					
					PreparedStatement ps = null;
				
					try {
						String sql = "select * from product where Product_id=?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, id);  //设置商品
						rs = ps.executeQuery();
						 
						 while(rs.next()) {
							  p = new PRODUCT(
									 	rs.getInt("Product_id"),
									 	rs.getString("Product_name"),
									 	rs.getString("Product_description"),
									 	rs.getInt("Product_price"),
									 	rs.getInt("Product_stock"),
									 	rs.getInt("Product_fid"),
									 	rs.getInt("Product_cid"),
									 	rs.getString("Product_filename")
									 );
			
							 
						 }
				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					return p;
				}
				
				
	//删除商品
				public static int del(int id){
					String sql = "delete from product where Product_id = ?";
					
					Object[] params ={id};
					return Basedao.exectuIUD(sql, params);
				}
				/**
				 * 通过关键词搜索获取下面所有产品列表信息（用于展示在前台页面）
				 * @param fid
				 * @return
				 */
				public static ArrayList<PRODUCT> selectAllByWord(String keyword) {
					
					ArrayList<PRODUCT> list = new ArrayList<PRODUCT>();
					//声明结果集
					ResultSet rs = null;
					//获取连接对象
					Connection conn = Basedao.getconn();
					
					PreparedStatement ps = null;

					
					try {
							String sql = "select * from product where Product_name like ?";
							ps = conn.prepareStatement(sql);
							ps.setString(1, "%"+keyword+"%");
						
							rs = ps.executeQuery();
						 while(rs.next()) {
							 PRODUCT p = new PRODUCT(
									 rs.getInt("Product_id"),
									 	rs.getString("Product_name"),
									 	rs.getString("Product_description"),
									 	rs.getInt("Product_price"),
									 	rs.getInt("Product_stock"),
									 	rs.getInt("Product_fid"),
									 	rs.getInt("Product_cid"),
									 	rs.getString("Product_filename")
									 );
							 
							 
							 list.add(p);
							 
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

package service;
//查询用户
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.USER;
import beans.Basedao;



public class Shop_USERDao {
	//插入数据库方法
	public static int insert(USER u){
			String sql = "insert into user values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
			
			Object[] params ={
					u.getUser_id(),
					u.getUser_name(),
					u.getUser_pwd(),
					u.getUser_sex(),
					u.getUser_birth(),
					u.getUser_idenity(),
					u.getUser_email(),
					u.getUser_phone(),
					u.getUser_address(),
					u.getUser_status()};
		
			
			return Basedao.exectuIUD(sql, params);  //返回影响
	}
	
	//用户注册验证表单的方法
	public static int selectByName(String id) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		
		try {
			String sql = "select count(*) from user where User_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
	
	
	    //删除数据库中数据
	
		public static int del(String id) {
		
				String sql = "delete from user where User_id=? and User_status!=2";
		
				Object[] params = {id};
		
				return Basedao.exectuIUD(sql, params);
	}
	
	
		//更新数据库方法
		public static int update(USER u){
				String sql = "update user set User_name=?, User_pwd=?, User_sex=?, User_birth=DATE_FORMAT(?, '%y-%m-%d'), User_idenity=?,User_email=?, User_phone=?,User_address=?,User_status=? where User_id = ?";
				
				Object[] params ={
						
						u.getUser_name(),
						u.getUser_pwd(),
						u.getUser_sex(),
						u.getUser_birth(),
						u.getUser_idenity(),
						u.getUser_email(),
						u.getUser_phone(),
						u.getUser_address(),
						u.getUser_status(),
						u.getUser_id()};
			
				
				return Basedao.exectuIUD(sql, params);  //返回影响
		}
	
	
	
	//获取总记录数和总页数
	public static int[] totalPage(int count , String keyword) {
		// 0 ：总记录数， 1：页数
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();  //连接数据库
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "";
			if(keyword!=null) {
				sql = "select count(*) from user where User_name like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else{
				sql = "select count(*) from user";
				
				ps = conn.prepareStatement(sql);
				
			}
				
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
	}
	
	
	/*查询所有用户
	 ***/
	public static ArrayList<USER> selectAll(int cpage, int count,String keyword){
		ArrayList<USER> list = new ArrayList<USER>();   
		
		//获取用户集
		ResultSet rs = null;
		
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql= "";
			
			if(keyword!=null){
				//关键字搜索
				sql = "select * from user where User_id like ? order by User_birth desc limit ?,?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
				
			}else{
			    sql = "select * from user order by User_birth desc limit ?,?";
			    ps = conn.prepareStatement(sql);
				
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
			
			//执行查询 并给到结果集
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				USER u = new USER(
						rs.getString("User_id"),
						rs.getString("User_name"),
						rs.getString("User_pwd"),
						rs.getString("User_sex"),
						rs.getString("User_birth"),
						rs.getString("User_idenity"),
						rs.getString("User_email"),
						rs.getString("User_phone"),
						rs.getString("User_address"),
						rs.getInt("User_status")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	
	/*通过id查找用户*/
	public static USER selectByID(String id){
		USER u =null;   
		
		//获取用户集
		ResultSet rs = null;
		
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select m.*, DATE_FORMAT(m.user_birth, '%Y-%m-%d')birth from user m Where User_id=?";

			ps = conn.prepareStatement(sql);  //执行
			ps.setString(1, id);

			
			
			//执行查询 并给到结果集
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				 u = new USER(
						rs.getString("User_id"),
						rs.getString("User_name"),
						rs.getString("User_pwd"),
						rs.getString("User_sex"),
						rs.getString("User_birth"),
						rs.getString("User_idenity"),
						rs.getString("User_email"),
						rs.getString("User_phone"),
						rs.getString("User_address"),
						rs.getInt("User_status")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	//登录  通过用户名、密码查找信息
	public static int selectByNM(String id, String pwd){
		int count =0; 
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from user where User_id=? and User_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
	}
	
	/**
	 * 通过用户ID和密码查询用户信息
	 * @param id
	 * @param pwd
	 * @return
	 */
	
	public static USER selectAdmin(String id, String pwd) {
		USER u = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select m.*, DATE_FORMAT(m.user_birth, '%Y-%m-%d')birth  from user m where User_id=? and User_pwd=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
			 ps.setString(2, pwd);
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 u = new USER(
						    rs.getString("User_id"),
							rs.getString("User_name"),
							rs.getString("User_pwd"),
							rs.getString("User_sex"),
							rs.getString("User_birth"),
							rs.getString("User_idenity"),
							rs.getString("User_email"),
							rs.getString("User_phone"),
							rs.getString("User_address"),
							rs.getInt("User_status")
						 	
			
						 );
		
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return u;
		
		
	}
	
}

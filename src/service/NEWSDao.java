package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NEWS;
import beans.Basedao;



public class NEWSDao {
	public static ArrayList<NEWS> selectAll(){
		ArrayList<NEWS> list=new ArrayList<NEWS>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from news");
			rs=ps.executeQuery();
			while (rs.next()) {
				NEWS c=new NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
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

	public static NEWS selectById(int id){
		NEWS c=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from news where EN_ID=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				c=new NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return c;
	}
	
	public static ArrayList<NEWS> selectAll(int cpage,int count){
		ArrayList<NEWS> list=new ArrayList<NEWS>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement("select * from news order by EN_ID desc limit ?, ?");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2,count);
			rs=ps.executeQuery();
			while (rs.next()) {
				NEWS c=new NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
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
	
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from news");
			rs=ps.executeQuery();
			while(rs.next()){
				int sum=rs.getInt(1);
				if(sum%count==0){
					tpage=sum/count;
				}else{
					tpage=sum/count+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	public static int insert(NEWS n){
		String sql="insert into news values(null,?,?,NOW())";
		Object[] params={n.getEN_TITLE(),n.getEN_CONTENT()};
		return Basedao.exectuIUD(sql, params);
	}

	public static int update(NEWS n){
		String sql="update news set EN_TITLE=?,EN_CONTENT=? where EN_ID=?";
		Object[] params={n.getEN_TITLE(),n.getEN_CONTENT(),n.getEN_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id){
		String sql="delete from news where EN_ID=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}

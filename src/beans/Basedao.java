package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	static{
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//连接方法
	public static Connection getconn(){
		//创建一个连接对象
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation_286_shop?useUnicode=true&characterEncoding=utf8&useSSL=false","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block  添加连接异常
			e.printStackTrace();
		}
		
		//返回对象
		return conn;
	}
	

	public static int exectuIUD(String sql,Object[] params){   //通过Object[] params与数据库中？数据绑定
		int count = 0;
		
		Connection conn = Basedao.getconn();   //获取到连接
		
		PreparedStatement ps = null;           //准备sql语句执行
		
		//insert into(''''','') value(?,?,?)
		try {
			//准备sql语句
			ps = conn.prepareStatement(sql);
			
			//绑定
			for(int i=0;i<params.length;i++){
			ps.setObject(i+1, params[i]);
			}
			
			//执行
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);  //结果集关闭
		}
		return count;
	}
	
	//关闭三个连接对象 ： 结果集 预处理语句 连接对象
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn){
		try{
		if(rs!=null)
				rs.close();
		if(ps!=null)
			    ps.close();
		if(conn!=null)
			    conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}

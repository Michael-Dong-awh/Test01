package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	 //定义链接数据库四大常量
	 private final static String  driverName = "com.mysql.jdbc.Driver";
	 private final static String  url = "jdbc:mysql://127.0.0.1/myschool?useUnicode=true&characterEncoding=utf-8";
	 private final static String  userName = "root";
	 private final static String  passWord = "root";
	 
	 
	 protected Connection conn  = null;
	 protected PreparedStatement pst = null;
	 protected ResultSet rs = null;
	 //获取链接
	 public static Connection getConnection(){
		 try {
			Class.forName(driverName);
			//驱动管理，链接数据库
			return DriverManager.getConnection(url, userName, passWord);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }
	 
	 //关闭
	 public static void closeAll(Connection conn,PreparedStatement pst,ResultSet rs ){
		 if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	 }
	 
			/*增删改都是一个方法 executeUpdate
			 * 只有sql和 占位符不同
			 * 返回都是int
			 * 所以将增删改封装一个方法
			 * */
			 public int executeUpdate(String sql, Object[] params){
				 System.out.println("调用BaseDao模式进行Dao层操作");
				 Connection conn = getConnection();
				 PreparedStatement ps = null;
				try {
					ps =  conn.prepareStatement(sql);
					if(params != null){
						for (int i = 0; i < params.length; i++) {
							//依次为预编译的sql设置参数
							ps.setObject(i+1, params[i]);
						}
					}
					return  ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}finally {
					closeAll(conn, ps, null);
				}
				 
			 }
			 
			 /**
				 * @param sql:传递进来的sql语句，obj:不能确定参数数量，类型，统一用object处理
				 * 
				 * */
				public int commonMethods(String sql,Object[] obj){
					int flag=0;
					try {
						pst=getConnection().prepareStatement(sql);
						//有可能会涉及参数，设置参数（赋值）
						for(int i=0;i<obj.length;i++){
							//一一对应的方式赋值
							pst.setObject(i+1, obj[i]);
						}
						flag=pst.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return flag;
				}
			
			
			
			
}

package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Base {
	private static final String URL="jdbc:mysql://***/school?characterEncoding=utf8&useSSL=false";
	private static final String USER="";
	private static final String PASSWORD="";
	//连接数据库，返回数据库连接对象
	public static Connection getConnection(){
		Connection conn=null;
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的链接
			conn=DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	//释放相应资源 rs,pstmt,conn
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try {
			if(rs!=null){
			rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	//此方法完成所有增删改所有操作，返回true or flase
	public boolean operUpdate(String sql,List<Object> params){
		int res=0;//影响的行数
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=getConnection();//建立数据库连接
		try {
			pstmt=conn.prepareStatement(sql);//装在sql语句
			if(params!=null){
				//假如有？，在执行之前把？占位符替换掉
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1, params.get(i));
				}
				
			}
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,conn);
		}
		
		return res>0? true:false;
		
	}
	
	//使用泛型方法和反射机制进行封装
	public  <T> List<T> operQuery(String sql,List<Object> params,Class<T> cls) throws Exception, Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<T> data=new ArrayList<T>();
		
		
		
		try {
			conn=getConnection();//建立数据库连接
			pstmt=conn.prepareStatement(sql);//装在sql语句
			if(params!=null){
				//假如有？，在执行之前把？占位符替换掉
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1, params.get(i));
				}
				
			}
			rs=pstmt.executeQuery();
			//把查询出来的结果封装成对应的实体类对象
			ResultSetMetaData rsd=rs.getMetaData();//得到记录集元数据对象
			//通过此对象可以得到表的结果，包括，列名，列的个数，列的数据类型
			while(rs.next()){
				T m=cls.newInstance();
				for(int i=0;i<rsd.getColumnCount();i++){
				String col_name=rsd.getColumnName(i+1);	//获得列名
				Object value=rs.getObject(col_name);//获得列所对应的数据
				java.lang.reflect.Field field=cls.getDeclaredField(col_name);
				field.setAccessible(true);//给私有属性设置可访问性
				field.set(m,value);//给对象私有属性赋值
					
				}
				data.add(m);
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,conn);
		}
		
		return data;
		
	}

}


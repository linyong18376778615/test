package com.iotek.dao.impl;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class BaseDao {

	
	private static String name=null;
	private static String pwd=null;
	private static String url=null;
	

	static {
		try{
			
			Properties prop=new Properties();
			prop.load(BaseDao.class.getClassLoader().getResourceAsStream("conn.properties"));
		
			url=prop.getProperty("url");
			name=prop.getProperty("name");
			pwd=prop.getProperty("pwd");
			
			Class.forName(prop.getProperty("driver"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public static Connection getConnection() throws SQLException{
		return (Connection) DriverManager.getConnection(url, name, pwd);
		
	}
	
	public static void close(Connection conn,Statement pstmt,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//此方法可以完成增删改所有的操作
	//返回true / false
	public boolean operUpdate(String sql,List<Object> params) throws Exception{
		int res=0;//影响的行数
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
			conn=getConnection();
			pstmt=conn.prepareStatement(sql); //装载sql语句
			if(params!=null){
				//如果有？，在执行之前把？占位符替换掉
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1, params.get(i));
				}
			}
			res=pstmt.executeUpdate();
		
		
			close(conn,pstmt,rs);
		
		return res > 0 ? true :false;
	}

	//使用泛型刚发和反射机制进行封装。功能是查询
	public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls)
			throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			conn = getConnection();// 建立数据库连接
			pstmt = conn.prepareStatement(sql);//装载sql语句
			if (params != null) {
				// 假如有？，在执行之前把？占位符替换掉
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			// 把查询出来的记录封装成对应的实体类对象
			ResultSetMetaData rsd = rs.getMetaData();// 得到记录集元数据对象
			// 通过此对象可以得到表的结构，包括，列名，列的个数，列的数据类型
			while (rs.next()) {
				T m = cls.newInstance();
				for (int i = 0; i < rsd.getColumnCount(); i++) {
					String col_Name = rsd.getColumnName(i + 1);// 获得列名
					//System.out.println(col_Name);
					Object value = rs.getObject(col_Name);// 获得列所对应的值ֵ
					Field field = cls.getDeclaredField(col_Name);
					field.setAccessible(true);// 给私有属性设置可访问权
					field.set(m, value);// 给对象的私有属性赋值ֵ
				}
				data.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return data;
	}


	public static void main(String args[]){
		try {
			Connection conn=BaseDao.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   

}

package com.sstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库连接对象
 * @author 杨雄
 *
 */
public class DBCon {

	/**
	 * 获取数据库连接对象
	 * @return 数据库连接对象
	 */
	public static Connection  getConnection(){
		
		try {
			String url="jdbc:mysql://localhost/shoes_store?user=root&password=";
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			Connection con = DriverManager.getConnection(url);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 关闭连接
	 * @param con
	 */
	public static void closeCon(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭预编译
	 * @param con
	 */
	public static void closePre(PreparedStatement pre){
		try {
			pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭结果集
	 * @param con
	 */
	public static void closeRes(ResultSet res){
		try {
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

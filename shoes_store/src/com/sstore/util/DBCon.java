package com.sstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ���ݿ����Ӷ���
 * @author ����
 *
 */
public class DBCon {

	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @return ���ݿ����Ӷ���
	 */
	public static Connection  getConnection(){
		
		try {
			String url="jdbc:mysql://localhost/shoes_store?user=root&password=";
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			Connection con = DriverManager.getConnection(url);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * �ر�����
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
	 * �ر�Ԥ����
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
	 * �رս����
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


package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ManagerInfo;
import com.sstore.po.UserInfo;
import com.sstore.util.DBCon;;

/**
 * <p>Title: UserDAO</p>
 * <p>Description: 会员信息管理的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:</p>
 * @author 
 * @version 1.0
 */

public class UserDAO {
	/**
	 * 添加会员信息
	 * 
	 * @param user
	 *            会员信息
	 * @return true为成功 false失败
	 */
	public boolean add(UserInfo user) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into user_info (user_name,user_pwd,user_email,user_phone,user_address,is_user_check,user_create_time)"
					+ "  values(?,?,?,?,?,?,now())";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserPwd());
			pre.setString(3, user.getUserEmail());
			pre.setString(4, user.getUserPhone());
			pre.setString(5, user.getUserAddress());
			pre.setString(6, user.getUserCheck());
            
			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}

	/**
	 * 修改会员信息
	 * 
	 * @param user
	 *            会员信息
	 * @return true为成功 false失败
	 */
	public boolean update(UserInfo user) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		
		System.out.println(user.getUserId());

		try {
			String sql = "update user_info set user_name=?,user_pwd=?,user_email=?,user_phone=?,user_address=?,is_user_check=?,user_create_time=now() where user_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserPwd());
			pre.setString(3, user.getUserEmail());
			pre.setString(4, user.getUserPhone());
			pre.setString(5, user.getUserAddress());
			pre.setString(6, user.getUserCheck());
			pre.setInt(7, user.getUserId());
			
			
			
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserId());

			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}

	/**
	 * 根据编号删除会员信息
	 * 
	 * @param userId
	 *            会员编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer userId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update user_info set is_user_check=? where user_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, "否");
			pre.setInt(2, userId);
			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}

	/**
	 * 根据姓名查询用户信息
	 * 
	 * @param managerName
	 *           用户姓名
	 * @return 单个用户信息
	 */
	public UserInfo getUserN(String userName) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select *  from user_info where user_name=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				return user;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}

		return null;
	}
	
	/**
	 * 获取所有会员信息
	 * 
	 * @return 多个会员信息
	 */
	public List<UserInfo> getAllUser() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from user_info order by user_id desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<UserInfo> list = new ArrayList<UserInfo>();
			while (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserCheck(res.getString("is_user_check"));
				user.setUserTime(res.getTimestamp("user_create_time"));

				list.add(user);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}

		return null;
	}

	/**
	 * 根据编号查询会员信息
	 * 
	 * @param userId
	 *            会员编号
	 * @return 单个会员信息
	 */
	public UserInfo getUser(Integer userId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from user_info where user_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserCheck(res.getString("is_user_check"));
				user.setUserTime(res.getTimestamp("user_create_time"));

				return user;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}

		return null;
	}

}

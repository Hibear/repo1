package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ManagerInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: ManagerDAO</p>
 * <p>Description: 管理员信息管理的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 杨雄
 * @version 1.0
 */

public class ManagerDAO {
	/**
	 * 获取所有管理员信息
	 * 
	 * @return 多个管理员信息
	 */
	public List<ManagerInfo> getAllManager() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from  manager_info order by manager_id desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<ManagerInfo> list = new ArrayList<ManagerInfo>();
			while (res.next()) {
				ManagerInfo mager = new ManagerInfo();
				
				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				list.add(mager);
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
	 * 添加员工信息
	 * 
	 * @param user
	 *            员工信息
	 * @return true为成功 false失败
	 */
	public boolean add(ManagerInfo user) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into manager_info (manager_name,manager_pwd,manager_create_time)"
					+ "  values(?,?,now())";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getManagerName());
			pre.setString(2, user.getManagerPwd());

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
	 * 修改管理员信息
	 * 
	 * @param mager
	 *            管理员信息
	 * @return true为成功 false失败
	 */
	public boolean update(ManagerInfo mager) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update manager_info set manager_id=?,manager_name=?,manager_pwd=?,manager_create_time=now() where manager_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, mager.getManagerId());
			pre.setString(2, mager.getManagerName());
			pre.setString(3, mager.getManagerPwd());
			pre.setInt(4, mager.getManagerId());
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
	 * 根据编号查询管理员信息
	 * 
	 * @param userId
	 *           管理员编号
	 * @return 单个管理员信息
	 */
	public ManagerInfo getManager(Integer managerId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select *  from manager_info where manager_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, managerId);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				ManagerInfo mager = new ManagerInfo();

				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				return mager;

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
	 * 根据姓名查询管理员信息
	 * 
	 * @param managerName
	 *           管理员姓名
	 * @return 单个管理员信息
	 */
	public ManagerInfo getManagerName(String managerName) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select *  from manager_info where manager_name=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setString(1, managerName);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				ManagerInfo mager = new ManagerInfo();

				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				return mager;

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
	 * 根据编号删除管理员信息
	 * 
	 * @param userId
	 *            管理员编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer managerId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from  manager_info where manager_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, managerId);
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

}

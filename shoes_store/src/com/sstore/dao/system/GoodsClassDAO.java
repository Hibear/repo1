package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.GoodsClassInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsClassInfoDAO</p>
 * <p>Description: 商品类别数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 汪洪梅
 * @version 1.0
 */

public class GoodsClassDAO {
	/**
	 * 获取所有商品类别信息
	 * 
	 * @return 多个类别信息
	 */
	public List<GoodsClassInfo> getAllGoodsClass() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from  goods_class_info order by class_id desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<GoodsClassInfo> list = new ArrayList<GoodsClassInfo>();
			while (res.next()) {
				GoodsClassInfo goodsclass = new GoodsClassInfo();
				goodsclass.setClassId(res.getInt("class_id"));
				goodsclass.setClassName(res.getString("class_name"));
				list.add(goodsclass);
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
	 * 添加类别信息
	 * 
	 * @param goodsclass
	 *            类别信息
	 * @return true为成功 false失败
	 */
	public boolean add(GoodsClassInfo user) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_class_info (class_id,class_name)"
					+ "  values(?,?)";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, user.getClassId());
			pre.setString(2, user.getClassName());

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
	 * 修改类别信息
	 * 
	 * @param goods_class
	 *            类别信息
	 * @return true为成功 false失败
	 */
	public boolean update(GoodsClassInfo goodsclass) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update goods_class_info set class_name=? where class_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, goodsclass.getClassName());
			pre.setInt(2, goodsclass.getClassId());
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
	 * 根据编号查询类别信息
	 * 
	 * @param ClassId
	 *          类别编号
	 * @return 单个类别信息
	 */
	public GoodsClassInfo getGoodsClass(Integer classId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select *  from goods_class_info where class_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, classId);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				GoodsClassInfo goodsclass = new GoodsClassInfo();

				goodsclass .setClassId(res.getInt("class_id"));
				goodsclass .setClassName(res.getString("class_name"));
				return goodsclass ;

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
	 * 根据编号删除类别信息
	 * 
	 * @param classId
	 *            类别编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer classId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from  goods_class_info where class_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, classId);
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
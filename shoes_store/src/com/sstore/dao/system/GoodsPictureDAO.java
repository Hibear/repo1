package com.sstore.dao.system;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsPictureDAO</p>
 * <p>Description: 商品图片信息的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 杨雄
 * @version 1.0
 */

public class GoodsPictureDAO {
	/**
	 * 获取所有商品图片信息
	 * 
	 * @return 多个商品图片信息
	 */
	public List<GoodsPictureInfo> getAllGoodsPicture() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from  goods_picture_info order by picture_id desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<GoodsPictureInfo> list = new ArrayList<GoodsPictureInfo>();
			while (res.next()) {
				GoodsPictureInfo gopic = new GoodsPictureInfo();
				
				gopic.setPictureId(res.getInt("picture_id"));
				gopic.setGoodsId(res.getInt("goods_id"));
				gopic.setPictureName(res.getString("picture_name"));
				gopic.setPictureUrl(res.getString("picture_url"));
				list.add(gopic);
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
	 * 添加商品图片信息
	 * 
	 * @param user
	 *            商品图片信息
	 * @return true为成功 false失败
	 */
	public boolean add(GoodsPictureInfo gopic) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_picture_info (goods_id,picture_name,picture_url)"
					+ "  values(?,?,?)";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, gopic.getGoodsId());
			pre.setString(2, gopic.getPictureName());
			pre.setString(3, gopic.getPictureUrl());

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
	 * 修改商品图片信息
	 * 
	 * @param mager
	 *            商品图片信息
	 * @return true为成功 false失败
	 */
	public boolean update(GoodsPictureInfo gopic) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update goods_picture_info set picture_id=?,goods_id=?,picture_name=?,picture_url=? where picture_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, gopic.getPictureId());
			pre.setInt(2, gopic.getGoodsId());
			pre.setString(3, gopic.getPictureName());
			pre.setString(4, gopic.getPictureUrl());
			pre.setInt(5, gopic.getPictureId());
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
	 * 根据编号查询商品图片信息
	 * 
	 * @param userId
	 *           商品图片编号
	 * @return 单个商品图片信息
	 */
	public GoodsPictureInfo getGoodsPicture(Integer pictureId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		InputStream result = null;

		try {
			String sql = "select *  from goods_picture_info where picture_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, pictureId);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				GoodsPictureInfo gopic = new GoodsPictureInfo();

				gopic.setPictureId(res.getInt("picture_id"));
				gopic.setGoodsId(res.getInt("goods_id"));
				gopic.setPictureName(res.getString("picture_name"));
				gopic.setPictureUrl(res.getString("picture_url"));
				return gopic;

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
	 * 根据编号删除商品图片信息
	 * 
	 * @param pictureId
	 *            商品图片编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer pictureId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from  goods_picture_info where picture_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, pictureId);
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

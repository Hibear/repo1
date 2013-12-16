package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ReceiptInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsClassInfoDAO</p>
 * <p>Description: 商品进货信息数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:</p>
 * @author 刘钊
 * @version 1.0
 */
public class ReceiptDAO {
	/**
	 * 获取所有商品进货信息
	 * 
	 * @return 多个商品进货信息
	 */
	public List<ReceiptInfo> getAllReceipt(){
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from receipt_info order by receipt_id desc;";
			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<ReceiptInfo> list = new ArrayList<ReceiptInfo>();
			while (res.next()) {
				ReceiptInfo receipt = new ReceiptInfo();
				receipt.setReceiptId(res.getInt("receipt_id"));
				receipt.setReceiptPrice(res.getFloat("receipt_price"));
				receipt.setReceiptTime(res.getTimestamp("receipt_time"));
				list.add(receipt);
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
	 * 添加商品进货信息
	 * 
	 * @param receipt
	 *            商品信息
	 * @return true为成功 false失败
	 */
	public boolean add(ReceiptInfo receipt) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into receipt_info (receipt_id,receipt_price,receipt_time) values(?,?,now());";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, receipt.getReceiptId());
			pre.setFloat(2, receipt.getReceiptPrice());
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
	 * 修改商品进货信息
	 * 
	 * @param receipt
	 *            商品进货信息
	 * @return true为成功 false失败
	 */
	public boolean update(ReceiptInfo receipt) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update receipt_info set receipt_price=? where receipt_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setFloat(1, receipt.getReceiptPrice());
			pre.setInt(2, receipt.getReceiptId());
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
	 * 根据进货单号查询进货信息
	 * 
	 * @param ClassId
	 *          进货单号
	 * @return 单个进货信息
	 */
	public ReceiptInfo getReceiptInfo(Integer receiptId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from receipt_info where receipt_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, receiptId);
			// 执行sql
			res = pre.executeQuery();

			if (res.next()) {
				ReceiptInfo receipt = new ReceiptInfo();
				receipt.setReceiptId(res.getInt("receipt_id"));
				receipt.setReceiptPrice(res.getFloat("receipt_price"));
				receipt.setReceiptTime(res.getTimestamp("receipt_time"));
				
				return receipt;
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
	 * 根据进货单号删除进货信息
	 * 
	 * @param receiptId
	 *            进货单号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer receiptId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from receipt_info where receipt_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, receiptId);
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

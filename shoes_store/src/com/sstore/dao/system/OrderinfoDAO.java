package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.MyCartInfo;
import com.sstore.po.OrderInfo;
import com.sstore.util.DBCon;

public class OrderinfoDAO {
	/**
	 * 获取所有订单信息
	 * 
	 * @return 多个订单信息
	 */
	public List<OrderInfo> getAllOrder() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info;";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<OrderInfo> list = new ArrayList<OrderInfo>();
			while (res.next()) {
				OrderInfo order = new OrderInfo();
				order.setOrderId(res.getInt("order_id"));
				order.setUserId(res.getInt("user_id"));
				order.setOrderUserRealName(res.getString("order_user_real_name"));
				order.setOrderUserAddress(res.getString("order_user_address"));
				order.setOrderUserPostCode(res.getInt("order_user_post_code"));
				order.setOrderUserPhone(res.getString("order_user_phone"));
				order.setOrderUserEmail(res.getString("order_user_email"));
				order.setOrderGoodsSendType(res.getString("order_goods_send_type"));
				order.setOrderTime(res.getTimestamp("order_time"));
				order.setGoodsPrice(res.getFloat("goods_price"));
				order.setTranFee(res.getFloat("tran_fee"));
				order.setIsConfirm(res.getString("is_confirm"));

				list.add(order);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}

		return null;
	}
	/**
	 * 添加订单信息
	 * 
	 * @param order
	 *            订单信息
	 * @return true为成功 false失败
	 */
	public boolean add(OrderInfo order) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into order_records_info (order_id, user_id, order_user_real_name, order_user_address, order_user_post_code, order_user_phone, order_user_email, order_goods_send_type, order_time, goods_price, tran_fee, is_confirm)" +
					"values(?,?,?,?,?,?,?,?,now(),?,?,?);";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, order.getOrderId());
			pre.setInt(2, order.getUserId());
			pre.setString(3, order.getOrderUserRealName());
			pre.setString(4, order.getOrderUserAddress());
			pre.setInt(5, order.getOrderUserPostCode());
			pre.setString(6,order.getOrderUserPhone());
			pre.setString(7, order.getOrderUserEmail());
			pre.setString(8, order.getOrderGoodsSendType());
			
			pre.setFloat(9, order.getGoodsPrice());
			pre.setFloat(10, order.getTranFee());
			pre.setString(11, order.getIsConfirm());
			
			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}

		return false;
	}
	/**
	 * 修改订单信息
	 * 
	 * @param order
	 *            订单信息
	 * @return true为成功 false失败
	 */
	public boolean update(OrderInfo order) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update order_records_info set user_id=?,order_user_real_name=?,order_user_address=?,order_user_post_code=?,order_user_phone=?,order_user_email=?,order_goods_send_type=?,order_time=now(),goods_price=?,tran_fee=?,is_confirm=?  where order_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, order.getUserId());
			pre.setString(2, order.getOrderUserRealName());
			pre.setString(3, order.getOrderUserAddress());
			pre.setInt(4, order.getOrderUserPostCode());
			pre.setString(5, order.getOrderUserPhone());
			pre.setString(6, order.getOrderUserEmail());
			pre.setString(7, order.getOrderGoodsSendType());
			pre.setFloat(8, order.getGoodsPrice());
			pre.setFloat(9, order.getTranFee());
			pre.setString(10, order.getIsConfirm());
			pre.setInt(11, order.getOrderId());
			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}

		return false;
	}
	/*order_id, 
	user_id, 
	order_user_real_name, 
	order_user_address, 
	order_user_post_code, 
	order_user_phone, 
	order_user_email, 
	order_goods_send_type, 
	order_time, 
	goods_price, 
	tran_fee, 
	is_confirm
	
	,user_time=now()
	*/
	/**
	 * 根据编号查询订单信息
	 * 
	 * @param userId
	 *            订单号
	 * @return 单个订单信息
	 */
	public OrderInfo getOrder(Integer orderId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info where order_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, orderId);
			// 执行sql
			res = pre.executeQuery();
			
			if (res.next()) {
				OrderInfo order = new OrderInfo();
				order.setOrderId(res.getInt("order_id"));
				order.setUserId(res.getInt("user_id"));
				order.setOrderUserRealName(res.getString("order_user_real_name"));
				order.setOrderUserAddress(res.getString("order_user_address"));
				order.setOrderUserPostCode(res.getInt("order_user_post_code"));
				order.setOrderUserPhone(res.getString("order_user_phone"));
				order.setOrderUserEmail(res.getString("order_user_email"));
				order.setOrderGoodsSendType(res.getString("order_goods_send_type"));
				order.setOrderTime(res.getTimestamp("order_time"));
				order.setGoodsPrice(res.getFloat("goods_price"));
				order.setTranFee(res.getFloat("tran_fee"));
				order.setIsConfirm(res.getString("is_confirm"));

				return order;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}

		return null;
	}
	/**
	 * 根据会员编号查询订单信息
	 * 
	 * @param userId
	 *           订单编号
	 * @return 多个订单信息
	 */
	public List<OrderInfo> getMyOrder(Integer userId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info where user_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// 执行sql
			res = pre.executeQuery();

				System.out.println(userId);
				System.out.println(userId);
				System.out.println(userId);
				System.out.println(userId);
				List<OrderInfo> list = new ArrayList<OrderInfo>();
				
				while (res.next()){
					OrderInfo  Shoppingcart = new OrderInfo();
					Shoppingcart.setUserId(res.getInt("user_id"));
					Shoppingcart.setOrderId(res.getInt("order_id"));
					Shoppingcart.setOrderUserRealName(res.getString("order_user_real_name"));
					Shoppingcart.setOrderUserAddress(res.getString("order_user_address"));
					
					list.add(Shoppingcart);
				}
				System.out.println(list.size());
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
	 * 根据编号删除订单信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer orderId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from  order_records_info where order_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, orderId);
			// 执行sql：增加，修改，删除都是调用这个方法
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}

		return false;
	}
}

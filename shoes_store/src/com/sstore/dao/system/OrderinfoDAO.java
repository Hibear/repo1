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
	 * ��ȡ���ж�����Ϣ
	 * 
	 * @return ���������Ϣ
	 */
	public List<OrderInfo> getAllOrder() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
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
	 * ��Ӷ�����Ϣ
	 * 
	 * @param order
	 *            ������Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(OrderInfo order) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into order_records_info (order_id, user_id, order_user_real_name, order_user_address, order_user_post_code, order_user_phone, order_user_email, order_goods_send_type, order_time, goods_price, tran_fee, is_confirm)" +
					"values(?,?,?,?,?,?,?,?,now(),?,?,?);";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
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
			
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
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
	 * �޸Ķ�����Ϣ
	 * 
	 * @param order
	 *            ������Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(OrderInfo order) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update order_records_info set user_id=?,order_user_real_name=?,order_user_address=?,order_user_post_code=?,order_user_phone=?,order_user_email=?,order_goods_send_type=?,order_time=now(),goods_price=?,tran_fee=?,is_confirm=?  where order_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
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
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
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
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param userId
	 *            ������
	 * @return ����������Ϣ
	 */
	public OrderInfo getOrder(Integer orderId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info where order_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, orderId);
			// ִ��sql
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
	 * ���ݻ�Ա��Ų�ѯ������Ϣ
	 * 
	 * @param userId
	 *           �������
	 * @return ���������Ϣ
	 */
	public List<OrderInfo> getMyOrder(Integer userId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from order_records_info where user_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// ִ��sql
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
	 * ���ݱ��ɾ��������Ϣ
	 * 
	 * @param orderId
	 *            �������
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer orderId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from  order_records_info where order_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, orderId);
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
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

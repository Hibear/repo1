package com.sstore.service.system.order;

import java.util.List;

import com.sstore.dao.system.OrderinfoDAO;
import com.sstore.po.MyCartInfo;
import com.sstore.po.OrderInfo;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品订单信息查询的业务逻辑处理</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class OrderinfoService {
	/**
	 * 数据访问对象
	 */
	private OrderinfoDAO dao = new OrderinfoDAO();
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public List<OrderInfo> getAllOrder(){
		return dao.getAllOrder();
	}	
	/**
	 * 添加员工信息
	 * 
	 * @param order
	 * @return
	 */
	public boolean add(OrderInfo order) {

		if (order != null && order.getOrderId() != null
				&& !order.getOrderId().equals("")) {

			return dao.add(order);
		}
		return false;
	}
	/**
	 * 根据编号查询订单信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @return
	 */
	public OrderInfo getOrder(String orderId) {

		try {
			return dao.getOrder(Integer.parseInt(orderId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据用户ID查询订单信息
	 * 
	 * @param ShoppingcartId
	 *           订单编号
	 * @return
	 */
	
	public List<OrderInfo> MyOrder(Integer userId) {
		return dao.getMyOrder(userId);
	}
	
	/**
	 * 修改订单信息
	 * 
	 * @param user
	 *            订单信息
	 * @return
	 */
	public boolean update(OrderInfo order) {

		try {

			if (order != null && order.getOrderId() != null) {
				// 先查询在修改
				OrderInfo puser = dao.getOrder(order.getOrderId());
				
				if (puser != null) {
	
					puser.setUserId(order.getUserId());
					puser.setOrderUserRealName(order.getOrderUserRealName());
					puser.setOrderUserAddress(order.getOrderUserAddress());
					puser.setOrderUserPostCode(order.getOrderUserPostCode());
					puser.setOrderUserPhone(order.getOrderUserPhone());
					puser.setOrderUserEmail(order.getOrderUserEmail());
					puser.setOrderGoodsSendType(order.getOrderGoodsSendType());
					puser.setGoodsPrice(order.getGoodsPrice());
					puser.setTranFee(order.getTranFee());
					puser.setIsConfirm(order.getIsConfirm());

					return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	/**
	 * 根据编号删除订单信息
	 * @param orderId 订单号
	 * @return
	 */
	public boolean delete(String orderId) {

		try {
			if (orderId != null && !"".endsWith(orderId)) {

				return dao.delete(Integer.parseInt(orderId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

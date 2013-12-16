package com.sstore.service.system.order;

import java.util.List;

import com.sstore.dao.system.OrderinfoDAO;
import com.sstore.po.MyCartInfo;
import com.sstore.po.OrderInfo;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ��Ʒ������Ϣ��ѯ��ҵ���߼�����</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class OrderinfoService {
	/**
	 * ���ݷ��ʶ���
	 */
	private OrderinfoDAO dao = new OrderinfoDAO();
	/**
	 * ��ѯ���ж�����Ϣ
	 * @return
	 */
	public List<OrderInfo> getAllOrder(){
		return dao.getAllOrder();
	}	
	/**
	 * ���Ա����Ϣ
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
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param orderId
	 *            �������
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
	 * �����û�ID��ѯ������Ϣ
	 * 
	 * @param ShoppingcartId
	 *           �������
	 * @return
	 */
	
	public List<OrderInfo> MyOrder(Integer userId) {
		return dao.getMyOrder(userId);
	}
	
	/**
	 * �޸Ķ�����Ϣ
	 * 
	 * @param user
	 *            ������Ϣ
	 * @return
	 */
	public boolean update(OrderInfo order) {

		try {

			if (order != null && order.getOrderId() != null) {
				// �Ȳ�ѯ���޸�
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
	 * ���ݱ��ɾ��������Ϣ
	 * @param orderId ������
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

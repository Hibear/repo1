package com.sstore.service.system.shoppingcart;

import java.util.List;

import com.sstore.dao.system.ShoppingcartDAO;
import com.sstore.po.ManagerInfo;
import com.sstore.po.MyCartInfo;
import com.sstore.po.ShoppingcartInfo;

/**
 * <p>
 * Title:ShoppingcartService
 * </p>
 * <p>
 * Description: ���ﳵ��Ϣ�����ҵ���߼�����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: �������
 * </p>
 * 
 * @author ����÷
 * @version 1.0
 */
public class ShoppingcartService {
	/**
	 * ���ݷ��ʶ���
	 */
	private ShoppingcartDAO dao = new ShoppingcartDAO();
	/**
	 * ��ѯ���й��ﳵ��Ϣ
	 * 
	 * @return
	 */
	public List<ShoppingcartInfo> getAllShoppingcart() {
		return dao.getAllShoppingcart();
	}
	
	 /**
	 * �����û�ID��ѯ���ﳵ��Ϣ
	 * 
	 * @param ShoppingcartId
	 *            ���ﳵ���
	 * @return
	 */
	
	public List<MyCartInfo> Mycart(Integer userId) {
		return dao.getMycart(userId);
	}
	
	
	/**
	 * ��ӹ��ﳵ��Ϣ
	 * 
	 * @param mager
	 * @return
	 */

	public boolean addUserId(ShoppingcartInfo shopcart) {
		if (shopcart != null && shopcart.getUserId() != null
				&& !shopcart.getUserId().equals("")) {

			return dao.addUserId(shopcart);
		}
		return false;
	}
	
	/**
	 * ��ӹ��ﳵ��ϵ��Ϣ
	 * 
	 * @param mager
	 * @return
	 */

	public boolean addGoodsId(ShoppingcartInfo shopcart) {
		if (shopcart != null && shopcart.getGoodsId() != null
				&& !shopcart.getGoodsId().equals("")) {

			return dao.addGoodsId(shopcart);
		}
		return false;
	}
	
 }

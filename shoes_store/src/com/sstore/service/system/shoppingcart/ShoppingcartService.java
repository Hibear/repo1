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
 * Description: 购物车信息管理的业务逻辑处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: 中软国际
 * </p>
 * 
 * @author 汪洪梅
 * @version 1.0
 */
public class ShoppingcartService {
	/**
	 * 数据访问对象
	 */
	private ShoppingcartDAO dao = new ShoppingcartDAO();
	/**
	 * 查询所有购物车信息
	 * 
	 * @return
	 */
	public List<ShoppingcartInfo> getAllShoppingcart() {
		return dao.getAllShoppingcart();
	}
	
	 /**
	 * 根据用户ID查询购物车信息
	 * 
	 * @param ShoppingcartId
	 *            购物车编号
	 * @return
	 */
	
	public List<MyCartInfo> Mycart(Integer userId) {
		return dao.getMycart(userId);
	}
	
	
	/**
	 * 添加购物车信息
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
	 * 添加购物车联系信息
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

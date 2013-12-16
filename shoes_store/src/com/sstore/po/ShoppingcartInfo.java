package com.sstore.po;


/**
 * <p>Title: 购物车信息类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  岳利
 * @version 1.0
 */

public class ShoppingcartInfo {
	
	private Integer  shoppingcartId;
	
	private Integer	userId;

	private Integer goodsId;
	
	private Integer goodsNumber;
	
	
	
	/*
	 * 设置和获取购物车ID
	 */


	public Integer getGoodsId() {
		return goodsId;
	}

	public Integer getShoppingcartId() {
		return shoppingcartId;
	}

	public void setShoppingcartId(Integer shoppingcartId) {
		this.shoppingcartId = shoppingcartId;
	}

	
	/*
	 * 设置和获取用户ID
	 */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setGoodsId(Integer  goodsId) {
		this.goodsId = goodsId;
	}

	/*
	 * 设置和获取商品数量
	 */
	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	

}

package com.sstore.po;

/**
 * <p>Title:用户购物车信息类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  杨雄
 * @version 1.0
 */
public class MyCartInfo {
	
	/*
	 * 用户ID
	 */
	
	private Integer	userId;
	
	/*
	 * 商品名称
	 */
	
	private String goodsName;
	
	/*
	 * 商品价格
	 */
	
	private float goodsPriceShop;
	
	/*
	 * 商品数量
	 */
	
	private int goodsNumber;
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getGoodsPriceShop() {
		return goodsPriceShop;
	}

	public void setGoodsPriceShop(float goodsPriceShop) {
		this.goodsPriceShop = goodsPriceShop;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

}

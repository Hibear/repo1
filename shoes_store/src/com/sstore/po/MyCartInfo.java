package com.sstore.po;

/**
 * <p>Title:�û����ﳵ��Ϣ��</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  ����
 * @version 1.0
 */
public class MyCartInfo {
	
	/*
	 * �û�ID
	 */
	
	private Integer	userId;
	
	/*
	 * ��Ʒ����
	 */
	
	private String goodsName;
	
	/*
	 * ��Ʒ�۸�
	 */
	
	private float goodsPriceShop;
	
	/*
	 * ��Ʒ����
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

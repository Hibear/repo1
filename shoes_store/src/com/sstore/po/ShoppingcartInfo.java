package com.sstore.po;


/**
 * <p>Title: ���ﳵ��Ϣ��</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  ����
 * @version 1.0
 */

public class ShoppingcartInfo {
	
	private Integer  shoppingcartId;
	
	private Integer	userId;

	private Integer goodsId;
	
	private Integer goodsNumber;
	
	
	
	/*
	 * ���úͻ�ȡ���ﳵID
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
	 * ���úͻ�ȡ�û�ID
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
	 * ���úͻ�ȡ��Ʒ����
	 */
	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	

}

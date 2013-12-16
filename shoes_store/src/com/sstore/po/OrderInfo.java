package com.sstore.po;

import java.sql.Timestamp;
/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品订单信息的实体类</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class OrderInfo {
	/**
	 * 订单号
	 */
	private Integer orderId;
	/**
	 * 会员号
	 */
	private Integer userId;
	/**
	 * 会员名
	 */
	private String orderUserRealName;
	/**
	 * 送货地址
	 */
	private String orderUserAddress;
	/**
	 * 邮政编码
	 */
	private Integer orderUserPostCode;
	/**
	 * 联系号码
	 */
	private String orderUserPhone;
	/**
	 * 邮箱
	 */
	private String orderUserEmail;
	/**
	 * 商品发送方式
	 */
	private String orderGoodsSendType;
	/**
	 * 发送时间
	 */
	private Timestamp orderTime;
	/**
	 * 商品价格
	 */
	private Float goodsPrice;
	/**
	 * 运费
	 */
	private Float tranFee;
	/**
	 * 是否有效
	 */
	private String isConfirm;
	
	
	public void setOrderId(Integer orderId){
		this.orderId=orderId;
	}
	public Integer getOrderId(){
		return orderId;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setOrderUserRealName(String orderUserRealName){
		this.orderUserRealName=orderUserRealName;
	}
	public String getOrderUserRealName(){
		return orderUserRealName;
	}
	public void setOrderUserAddress(String orderUserAddress){
		this.orderUserAddress=orderUserAddress;
	}
	public String getOrderUserAddress(){
		return orderUserAddress;
	}
	public void setOrderUserPostCode(Integer orderUserPostCode){
		this.orderUserPostCode=orderUserPostCode;
	}
	public Integer getOrderUserPostCode(){
		return orderUserPostCode;
	}
	public void setOrderUserPhone(String orderUserPhone){
		this.orderUserPhone=orderUserPhone;
	}
	public String getOrderUserPhone(){
		return orderUserPhone;
	}
	public void setOrderUserEmail(String orderUserEmail){
		this.orderUserEmail=orderUserEmail;
	}
	public String getOrderUserEmail(){
		return orderUserEmail;
	}
	public void setOrderGoodsSendType(String orderGoodsSendType){
		this.orderGoodsSendType=orderGoodsSendType;
	}
	public String getOrderGoodsSendType(){
		return orderGoodsSendType;
	}
	public void setOrderTime(Timestamp orderTime){
		this.orderTime=orderTime;
	}
	public Timestamp getOrderTime(){
		return orderTime;
	}
	public void setGoodsPrice(Float goodsPrice){
		this.goodsPrice=goodsPrice;
	}
	public Float getGoodsPrice(){
		return goodsPrice;
	}
	public void setTranFee(Float tranFee){
		this.tranFee=tranFee;
	}
	public Float getTranFee(){
		return tranFee;
	}
	public void setIsConfirm(String isConfirm){
		this.isConfirm=isConfirm;
	}
	public String getIsConfirm(){
		return isConfirm;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", userId=" + userId + ", orderUserRealName="
				+ orderUserRealName + ", orderUserAddress=" + orderUserAddress + ", orderUserPostCode=" + orderUserPostCode
				+ ", orderUserPhone=" + orderUserPhone + ", orderUserEmail=" + orderUserEmail + ", orderGoodsSendType=" + orderGoodsSendType
				+ ", orderTime=" + orderTime + ", goodsPrice=" + goodsPrice + ", tranFee=" + tranFee + ", isConfirm=" + isConfirm +"]";
	}
}

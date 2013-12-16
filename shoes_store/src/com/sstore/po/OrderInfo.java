package com.sstore.po;

import java.sql.Timestamp;
/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ��Ʒ������Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class OrderInfo {
	/**
	 * ������
	 */
	private Integer orderId;
	/**
	 * ��Ա��
	 */
	private Integer userId;
	/**
	 * ��Ա��
	 */
	private String orderUserRealName;
	/**
	 * �ͻ���ַ
	 */
	private String orderUserAddress;
	/**
	 * ��������
	 */
	private Integer orderUserPostCode;
	/**
	 * ��ϵ����
	 */
	private String orderUserPhone;
	/**
	 * ����
	 */
	private String orderUserEmail;
	/**
	 * ��Ʒ���ͷ�ʽ
	 */
	private String orderGoodsSendType;
	/**
	 * ����ʱ��
	 */
	private Timestamp orderTime;
	/**
	 * ��Ʒ�۸�
	 */
	private Float goodsPrice;
	/**
	 * �˷�
	 */
	private Float tranFee;
	/**
	 * �Ƿ���Ч
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

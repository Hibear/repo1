package com.sstore.po;

import java.sql.Timestamp;


/**
 * <p>Title: 商品进货信息类</p>
 * <p>Description: 商品进货信息的实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  岳利
 * @version 1.0
 */
 public class ReceiptInfo {
	
	 private Integer receiptId;
	 
	 private Float receiptPrice;
	 
	 private Timestamp receiptTime;
	 
	 
	 
	 /*
	  * 设置和获取商品进货ID
	  */

	public Integer getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	
	
	 /*
	  * 设置和获取商品进货单价
	  */


	public Float getReceiptPrice() {
		return receiptPrice;
	}

	public void setReceiptPrice(Float receiptPrice) {
		this.receiptPrice = receiptPrice;
	}

	
	 /*
	  * 设置和获取商品进货时间
	  */

	
	public Timestamp getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Timestamp receiptTime) {
		this.receiptTime = receiptTime;
	}
 }	 
package com.sstore.po;

import java.sql.Timestamp;


/**
 * <p>Title: ��Ʒ������Ϣ��</p>
 * <p>Description: ��Ʒ������Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  ����
 * @version 1.0
 */
 public class ReceiptInfo {
	
	 private Integer receiptId;
	 
	 private Float receiptPrice;
	 
	 private Timestamp receiptTime;
	 
	 
	 
	 /*
	  * ���úͻ�ȡ��Ʒ����ID
	  */

	public Integer getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	
	
	 /*
	  * ���úͻ�ȡ��Ʒ��������
	  */


	public Float getReceiptPrice() {
		return receiptPrice;
	}

	public void setReceiptPrice(Float receiptPrice) {
		this.receiptPrice = receiptPrice;
	}

	
	 /*
	  * ���úͻ�ȡ��Ʒ����ʱ��
	  */

	
	public Timestamp getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Timestamp receiptTime) {
		this.receiptTime = receiptTime;
	}
 }	 
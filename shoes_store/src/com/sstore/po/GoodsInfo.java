package com.sstore.po;

import java.sql.Timestamp;

//import javax.xml.soap.Text;

/**
 * <p>Title: ��Ʒ��Ϣ��</p>
 * <p>Description: ��Ʒ����Ϣʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author ����÷
 * @version 1.0
 */
public class GoodsInfo {
	    private  Integer goodsId;
		
		private  Integer classId;
		
	    private  String goodsTypeCode;
		
		private String goodsName;
		
		private String goodsKeys;
		
		private String  goodsText;
		
		private  String  goodsPt;
		
		private Float goodsPriceShop;
		
		private Float goodsPriceUser;
		 
		private  String goodsIsNew;
		
		private  String isRecommend;
		
		private  Integer goodsBuyNumber;
		
		private Timestamp goodsInTime;
		
		private  String  isCheap;
		
		  /*
		  * ��ƷID
		  */	
		public Integer getGoodsId() {
			return goodsId;
		}

		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
		
		  /*
		  * ���ID
		  */	
		public Integer getClassId() {
			return classId;
		}

		public void setClassId(Integer classId) {
			this.classId = classId;
		}
		
		  /*
		  * ��Ʒ�ͺ�
		  */	
		public  String  getGoodsTypeCode() {
			return goodsTypeCode;
		}

		public void setGoodsTypeCode( String goodsTypeCode) {
			this.goodsTypeCode = goodsTypeCode;
		}
		
		  /*
		  * ��Ʒ����
		  */	
		public String getGoodsName() {
			return goodsName;
		}

		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		
		  /*
		  * ��Ʒ�ؼ���
		  */	
		public String getGoodsKeys() {
			return goodsKeys;
		}

		public void setGoodsKeys(String goodsKeys) {
			this.goodsKeys = goodsKeys;
		}
		
		  /*
		  * ��Ʒ����
		  */	
		public String   getGoodsText() {
			return goodsText;
		}

		public void setGoodsText(String  goodsText) {
			this.goodsText = goodsText;
		}
		
		  /*
		  * ��ƷƷ��
		  */	
		public String getGoodsPt() {
			return goodsPt;
		}

		public void setGoodsPt(String goodsPt) {
			this.goodsPt = goodsPt;
		}
		
		  /*
		  * ��Ʒ�г���
		  */	
		public Float getGoodsPriceShop() {
			return goodsPriceShop;
		}

		public void setGoodsPriceShop(Float goodsPriceShop) {
			this.goodsPriceShop = goodsPriceShop;
		}
		
		  /*
		  * ��Ʒ�Żݼ�
		  */	
		public Float getGoodsPriceUser() {
			return goodsPriceUser;
		}

		public void setGoodsPriceUser(Float goodsPriceUser) {
			this.goodsPriceUser = goodsPriceUser;
		}
		
		  /*
		  * �Ƿ�����Ʒ
		  */	
		public String getGoodsIsNew() {
			return goodsIsNew;
		}

		public void setGoodsIsNew(String goodsIsNew) {
			this.goodsIsNew = goodsIsNew;
		}
		
		  /*
		  * ��Ʒ�Ƿ��Ƽ�
		  */	
		public String getIsRecommend() {
			return isRecommend;
		}

		public void setIsRecommend(String isRecommend) {
			this.isRecommend = isRecommend;
		}
		
		  /*
		  * ��Ʒ������
		  */	
		public Integer getGoodsBuyNumber() {
			return goodsBuyNumber;
		}

		public void setGoodsBuyNumber(Integer goodsBuyNumber) {
			this.goodsBuyNumber = goodsBuyNumber;
		}
		 /*
		  * ��Ʒ¼��ʱ��
		  */	
		public Timestamp getGoodsInTime() {
			return goodsInTime;
		}

		public void setGoodsInTime(Timestamp goodsInTime) {
			this.goodsInTime = goodsInTime;
		}
		/*
		  * ��Ʒ�Ƿ��Ż�
		  */
		public String getIsCheap() {
			return isCheap;
		}

		public void setIsCheap(String isCheap) {
			this.isCheap = isCheap;
		}
    }

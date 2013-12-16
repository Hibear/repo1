package com.sstore.po;

import java.sql.Timestamp;

//import javax.xml.soap.Text;

/**
 * <p>Title: 商品信息类</p>
 * <p>Description: 商品的信息实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author 汪洪梅
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
		  * 商品ID
		  */	
		public Integer getGoodsId() {
			return goodsId;
		}

		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
		
		  /*
		  * 类别ID
		  */	
		public Integer getClassId() {
			return classId;
		}

		public void setClassId(Integer classId) {
			this.classId = classId;
		}
		
		  /*
		  * 商品型号
		  */	
		public  String  getGoodsTypeCode() {
			return goodsTypeCode;
		}

		public void setGoodsTypeCode( String goodsTypeCode) {
			this.goodsTypeCode = goodsTypeCode;
		}
		
		  /*
		  * 商品名称
		  */	
		public String getGoodsName() {
			return goodsName;
		}

		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		
		  /*
		  * 商品关键字
		  */	
		public String getGoodsKeys() {
			return goodsKeys;
		}

		public void setGoodsKeys(String goodsKeys) {
			this.goodsKeys = goodsKeys;
		}
		
		  /*
		  * 商品评论
		  */	
		public String   getGoodsText() {
			return goodsText;
		}

		public void setGoodsText(String  goodsText) {
			this.goodsText = goodsText;
		}
		
		  /*
		  * 商品品牌
		  */	
		public String getGoodsPt() {
			return goodsPt;
		}

		public void setGoodsPt(String goodsPt) {
			this.goodsPt = goodsPt;
		}
		
		  /*
		  * 商品市场价
		  */	
		public Float getGoodsPriceShop() {
			return goodsPriceShop;
		}

		public void setGoodsPriceShop(Float goodsPriceShop) {
			this.goodsPriceShop = goodsPriceShop;
		}
		
		  /*
		  * 商品优惠价
		  */	
		public Float getGoodsPriceUser() {
			return goodsPriceUser;
		}

		public void setGoodsPriceUser(Float goodsPriceUser) {
			this.goodsPriceUser = goodsPriceUser;
		}
		
		  /*
		  * 是否是新品
		  */	
		public String getGoodsIsNew() {
			return goodsIsNew;
		}

		public void setGoodsIsNew(String goodsIsNew) {
			this.goodsIsNew = goodsIsNew;
		}
		
		  /*
		  * 商品是否推荐
		  */	
		public String getIsRecommend() {
			return isRecommend;
		}

		public void setIsRecommend(String isRecommend) {
			this.isRecommend = isRecommend;
		}
		
		  /*
		  * 商品卖出数
		  */	
		public Integer getGoodsBuyNumber() {
			return goodsBuyNumber;
		}

		public void setGoodsBuyNumber(Integer goodsBuyNumber) {
			this.goodsBuyNumber = goodsBuyNumber;
		}
		 /*
		  * 商品录入时间
		  */	
		public Timestamp getGoodsInTime() {
			return goodsInTime;
		}

		public void setGoodsInTime(Timestamp goodsInTime) {
			this.goodsInTime = goodsInTime;
		}
		/*
		  * 商品是否优惠
		  */
		public String getIsCheap() {
			return isCheap;
		}

		public void setIsCheap(String isCheap) {
			this.isCheap = isCheap;
		}
    }

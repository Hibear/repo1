package com.sstore.po;


/**
 * <p>Title: 商品图片信息类</p>
 * <p>Description: 商品图片信息的实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  岳利
 * @version 1.0
 */
public class GoodsPictureInfo {

	private Integer  pictureId;
	
	private Integer  goodsId;
	
	private  String  pictureName;
	
	private  String   pictureUrl;
	
	
	
	/*
	 * 设置和获取图片ID
	 */
	
	public Integer getPictureId() {
		return  pictureId;
	}
	
	public void setPictureId(Integer pictureId) {
		
		this.pictureId = pictureId;
	}
	

	/*
	 * 设置和获取商品ID
	 */
	
	public Integer getGoodsId() {
		return  goodsId;
	}
	
	public void setGoodsId(Integer goodsId) {
		
		this.goodsId = goodsId;
	}
	

	/*
	 * 设置和获取图片名称
	 */
	
	public String getPictureName() {
		return  pictureName;
	}
	
	public void setPictureName( String pictureName) {
		
		this.pictureName = pictureName;
	}
	
	

	/*
	 * 设置和获取图片地址
	 */
	
	public String getPictureUrl() {
		return  pictureUrl;
	}
	
	public void setPictureUrl( String pictureUrl) {
		
		this.pictureUrl = pictureUrl ;
		
	}
	
	
}

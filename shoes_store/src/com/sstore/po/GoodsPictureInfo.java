package com.sstore.po;


/**
 * <p>Title: ��ƷͼƬ��Ϣ��</p>
 * <p>Description: ��ƷͼƬ��Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  ����
 * @version 1.0
 */
public class GoodsPictureInfo {

	private Integer  pictureId;
	
	private Integer  goodsId;
	
	private  String  pictureName;
	
	private  String   pictureUrl;
	
	
	
	/*
	 * ���úͻ�ȡͼƬID
	 */
	
	public Integer getPictureId() {
		return  pictureId;
	}
	
	public void setPictureId(Integer pictureId) {
		
		this.pictureId = pictureId;
	}
	

	/*
	 * ���úͻ�ȡ��ƷID
	 */
	
	public Integer getGoodsId() {
		return  goodsId;
	}
	
	public void setGoodsId(Integer goodsId) {
		
		this.goodsId = goodsId;
	}
	

	/*
	 * ���úͻ�ȡͼƬ����
	 */
	
	public String getPictureName() {
		return  pictureName;
	}
	
	public void setPictureName( String pictureName) {
		
		this.pictureName = pictureName;
	}
	
	

	/*
	 * ���úͻ�ȡͼƬ��ַ
	 */
	
	public String getPictureUrl() {
		return  pictureUrl;
	}
	
	public void setPictureUrl( String pictureUrl) {
		
		this.pictureUrl = pictureUrl ;
		
	}
	
	
}

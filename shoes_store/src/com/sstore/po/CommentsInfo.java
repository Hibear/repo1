package com.sstore.po;

 import java.sql.Timestamp;

import javax.xml.soap.Text;

 

/**
 * <p>Title: ������Ϣ��</p>
 * <p>Description: ������Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author ����
 * @version 1.0
 */



public class CommentsInfo {


	    private Integer reviewId;
	
		private  Integer userId;
		
		private Integer googoodsId;
		 
		private  Integer goodsId;
		
		private String userName;
		
		private String  reviewText;
		
		private Timestamp reviewTime;
		
		
	  /*
	  * ���úͻ�ȡ��Ʒ����ID
	  */	
		public Integer getReviewId() {
			
			return reviewId;
		}
		
		public void setReviewId(Integer reviewId) {
			this.reviewId = reviewId;
		}
		
		
		/*
		 *���úͻ�ȡ��Ʒ���۱����û�����ϵ��ID
		 */
		
       public Integer getGoogoodsId() {
			
			return googoodsId;
		}
		
		public void setGoogoodsId(Integer googoodsId) {
			this.googoodsId = googoodsId;
		}
		
		/*
		 * ���úͻ�ȡ��Ʒ�ɣ�
		 */
		
	   public Integer getGoodsId() {
				
				return goodsId;
			}
			
	   public void setGoodsId(Integer goodsId) {
				this.goodsId = goodsId;
			}
			
		/*
		 * �û�ID
		 */
		
		public Integer getUserId(){
					return userId;
				}
				
		public void setUserId(Integer userId) {
					this.userId = userId;
				}	
			
			
			
			
	   /*
	   * �����û���
	   */		
		
		public String getUserName() {
			return  userName;
		}
		
		public void setUserName( String userName) {
			this.userName = userName;
		}
		
		/*
		 * ��������
		 */
		public  String getReviewText() {
			
			return  reviewText;
		}
		
		public void setReviewText(String reviewText) {
			this.reviewText = reviewText;
		}
		
		
		/*
		 * ���úͻ�ȡ����ʱ��
		 */
		public Timestamp getReviewTime() 
		{
			return reviewTime;
		}
	 
		public void setReviewTime( Timestamp reviewTime)
		{
			this.reviewTime = reviewTime;
		}
		
	}
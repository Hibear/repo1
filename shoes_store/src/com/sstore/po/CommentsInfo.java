package com.sstore.po;

 import java.sql.Timestamp;

import javax.xml.soap.Text;

 

/**
 * <p>Title: 评论信息类</p>
 * <p>Description: 评论信息的实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author 岳利
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
	  * 设置和获取商品评论ID
	  */	
		public Integer getReviewId() {
			
			return reviewId;
		}
		
		public void setReviewId(Integer reviewId) {
			this.reviewId = reviewId;
		}
		
		
		/*
		 *设置和获取商品评论表与用户表联系的ID
		 */
		
       public Integer getGoogoodsId() {
			
			return googoodsId;
		}
		
		public void setGoogoodsId(Integer googoodsId) {
			this.googoodsId = googoodsId;
		}
		
		/*
		 * 设置和获取商品ＩＤ
		 */
		
	   public Integer getGoodsId() {
				
				return goodsId;
			}
			
	   public void setGoodsId(Integer goodsId) {
				this.goodsId = goodsId;
			}
			
		/*
		 * 用户ID
		 */
		
		public Integer getUserId(){
					return userId;
				}
				
		public void setUserId(Integer userId) {
					this.userId = userId;
				}	
			
			
			
			
	   /*
	   * 评论用户名
	   */		
		
		public String getUserName() {
			return  userName;
		}
		
		public void setUserName( String userName) {
			this.userName = userName;
		}
		
		/*
		 * 评论内容
		 */
		public  String getReviewText() {
			
			return  reviewText;
		}
		
		public void setReviewText(String reviewText) {
			this.reviewText = reviewText;
		}
		
		
		/*
		 * 设置和获取评论时间
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
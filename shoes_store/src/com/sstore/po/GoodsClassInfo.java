
package com.sstore.po;



/**
 * <p>Title: 商品类别信息类</p>
 * <p>Description: 商品类别信息的实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  岳利
 * @version 1.0
 * 
 */
  public class GoodsClassInfo {

	private Integer classId;
	
	private String className;
	
	
	 /*
	  * 设置和获取商品类别ID
	  */	
		public Integer getClassId() {
			
			return  classId;
		}
		
		public void  setClassId(Integer  classId){
			
			this.classId = classId;
		}
	
	
		/*
		 * 设置和获取商品类别名称
		 */	
		public String getClassName() {
				
				return  className;
			}
			
		public void setClassName(String className){
				
				this.className = className;
			}
	
}

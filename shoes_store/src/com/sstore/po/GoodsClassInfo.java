
package com.sstore.po;



/**
 * <p>Title: ��Ʒ�����Ϣ��</p>
 * <p>Description: ��Ʒ�����Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author  ����
 * @version 1.0
 * 
 */
  public class GoodsClassInfo {

	private Integer classId;
	
	private String className;
	
	
	 /*
	  * ���úͻ�ȡ��Ʒ���ID
	  */	
		public Integer getClassId() {
			
			return  classId;
		}
		
		public void  setClassId(Integer  classId){
			
			this.classId = classId;
		}
	
	
		/*
		 * ���úͻ�ȡ��Ʒ�������
		 */	
		public String getClassName() {
				
				return  className;
			}
			
		public void setClassName(String className){
				
				this.className = className;
			}
	
}

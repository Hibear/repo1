package com.sstore.po;

import java.sql.Timestamp;

/**
 * <p>Title: ��Ա��Ϣ</p>
 * <p>Description: ��Ա��Ϣ�Ĳ鿴</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: �������</p>
 * @author ��΢��
 * @version 1.0
 */

public class UserInfo {

	/**
	 * �û�ID
	 */
	
	private Integer userId;
	
	/**
	 * �û���
	 */
	private String userName;
	
	
	/**
	 * �û�����
	 */
	private String userPwd;
	
	
	/**
	 * �û�����
	 */
	private String userEmail;
	
	
	/**
	 * �û���ϵ�绰
	 */
	
	private String userPhone;
	
	
	/**
	 * �û���ַ
	 */
	
	private String userAddress;

	/**
	 * �û��Ƿ���Ч
	 */
	
	private String userCheck;
	
	
	/**
	 * �û�ע��ʱ��
	 */
	
	private Timestamp userTime;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserCheck() {
		return userCheck;
	}


	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}


	public Timestamp getUserTime() {
		return userTime;
	}


	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
	}


	

	

		
	
}


package com.sstore.po;

import java.sql.Timestamp;

/**
 * <p>Title: 会员信息</p>
 * <p>Description: 会员信息的查看</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 中软国际</p>
 * @author 曾微中
 * @version 1.0
 */

public class UserInfo {

	/**
	 * 用户ID
	 */
	
	private Integer userId;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	
	/**
	 * 用户密码
	 */
	private String userPwd;
	
	
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	
	
	/**
	 * 用户联系电话
	 */
	
	private String userPhone;
	
	
	/**
	 * 用户地址
	 */
	
	private String userAddress;

	/**
	 * 用户是否有效
	 */
	
	private String userCheck;
	
	
	/**
	 * 用户注册时间
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


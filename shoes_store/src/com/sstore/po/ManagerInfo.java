package com.sstore.po;

import java.sql.Timestamp;

/**
 * <p>Title: 管理员信息类</p>
 * <p>Description: 管理员的信息的实体类</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author 杨雄
 * @version 1.0
 */


public class ManagerInfo {
	
	/**
	 * 管理员编号
	 */
	private Integer managerId;
	/**
	 * 管理员姓名
	 */
	private String managerName;
	/**
	 * 管理员密码
	 */
	private String managerPwd;
	/**
	 * 创建时间
	 */
	private Timestamp managerCreateTime;
	
	public Timestamp getManagerCreateTime() {
		return managerCreateTime;
	}

	public void setManagerCreateTime(Timestamp managerCreateTime) {
		this.managerCreateTime = managerCreateTime;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	
}

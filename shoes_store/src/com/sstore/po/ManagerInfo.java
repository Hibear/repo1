package com.sstore.po;

import java.sql.Timestamp;

/**
 * <p>Title: ����Ա��Ϣ��</p>
 * <p>Description: ����Ա����Ϣ��ʵ����</p>
 * <p>Copyright: Copyright (c) 200x</p>
 * <p>Company: chinasoft</p>
 * @author ����
 * @version 1.0
 */


public class ManagerInfo {
	
	/**
	 * ����Ա���
	 */
	private Integer managerId;
	/**
	 * ����Ա����
	 */
	private String managerName;
	/**
	 * ����Ա����
	 */
	private String managerPwd;
	/**
	 * ����ʱ��
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

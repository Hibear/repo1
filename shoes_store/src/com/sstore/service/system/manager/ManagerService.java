package com.sstore.service.system.manager;

import java.util.List;


import com.sstore.dao.system.ManagerDAO;
import com.sstore.po.ManagerInfo;

/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: 管理员信息管理的业务逻辑处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: 中软国际
 * </p>
 * 
 * @author 杨雄
 * @version 1.0
 */

public class ManagerService {

	/**
	 * 数据访问对象
	 */
	private ManagerDAO dao = new ManagerDAO();
	/**
	 * 查询所有管理员信息
	 * 
	 * @return
	 */
	public List<ManagerInfo> getAllManager() {
		return dao.getAllManager();
	}
	/**
	 * 添加管理员信息
	 * 
	 * @param mager
	 * @return
	 */

	public boolean add(ManagerInfo mager) {
		if (mager != null && mager.getManagerName() != null
				&& !mager.getManagerName().equals("")) {

			return dao.add(mager);
		}

		return false;
	}
	
	/**
	 * 根据编号查询管理员信息
	 * 
	 * @param userId
	 *            管理员编号
	 * @return
	 */
	public ManagerInfo getManager(String managerId) {

		try {
			return dao.getManager(Integer.parseInt(managerId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据姓名查询管理员信息
	 * 
	 * @param userId
	 *            管理员编号
	 * @return
	 */
	public ManagerInfo getManagerName(String managerName) {

		try {
			return dao.getManagerName(managerName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改管理员信息
	 * 
	 * @param user
	 *            管理员信息
	 * @return
	 */
	public boolean update(ManagerInfo mager) {

		try {

			if (mager != null && mager.getManagerId() != null) {
				// 先查询在修改
				ManagerInfo puser = dao.getManager(mager.getManagerId());

				if (puser != null) {
					puser.setManagerId(mager.getManagerId());
					puser.setManagerName(mager.getManagerName());
					puser.setManagerPwd(mager.getManagerPwd());
					puser.setManagerCreateTime(mager.getManagerCreateTime());

					return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * 根据编号删除管理员信息
	 * @param managerId 管理员编号
	 * @return
	 */
	public boolean delete(String managerId) {

		try {
			if (managerId != null && !"".endsWith(managerId)) {

				return dao.delete(Integer.parseInt(managerId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	

}
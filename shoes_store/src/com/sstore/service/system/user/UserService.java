package com.sstore.service.system.user;

import java.util.List;

import com.sstore.dao.system.UserDAO;
import com.sstore.po.GoodsPictureInfo;
import com.sstore.po.ManagerInfo;
import com.sstore.po.UserInfo;

/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: 会员信息管理的业务逻辑处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author 
 * @version 1.0
 */

public class UserService {
	
	/**
	 * 数据访问对象
	 */
	private UserDAO dao = new UserDAO();

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	public List<UserInfo> getAllUser() {
		return dao.getAllUser();
	}


	/**
	 * 添加会员信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(UserInfo user) {

		if (user != null && user.getUserName() != null
				&& !user.getUserName().equals("")) {

			return dao.add(user);
		}

		return false;

	}

	/**
	 * 根据编号查询员工信息
	 * 
	 * @param userId
	 *            会员编号
	 * @return
	 */
	public UserInfo getUser(String userId) {

		try {
			return dao.getUser(Integer.parseInt(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据姓名查询用户信息
	 * 
	 * @param userName
	 *            用户编号
	 * @return
	 */
	public UserInfo getUserN(String userName) {

		try {
			return dao.getUserN(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改员工信息
	 * 
	 * @param user
	 *            会员信息
	 * @return
	 */
	public boolean update(UserInfo user) {

		try {

			if (user != null && user.getUserId() != null) {
				// 先查询在修改
				return dao.update(user);

				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 根据编号删除会员信息
	 * @param userId 会员编号
	 * @return
	 */
	public boolean delete(String userId) {

		try {
			if (userId != null && !"".endsWith(userId)) {

				return dao.delete(Integer.parseInt(userId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}

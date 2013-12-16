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
 * Description: ��Ա��Ϣ�����ҵ���߼�����
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
	 * ���ݷ��ʶ���
	 */
	private UserDAO dao = new UserDAO();

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public List<UserInfo> getAllUser() {
		return dao.getAllUser();
	}


	/**
	 * ��ӻ�Ա��Ϣ
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
	 * ���ݱ�Ų�ѯԱ����Ϣ
	 * 
	 * @param userId
	 *            ��Ա���
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
	 * ����������ѯ�û���Ϣ
	 * 
	 * @param userName
	 *            �û����
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
	 * �޸�Ա����Ϣ
	 * 
	 * @param user
	 *            ��Ա��Ϣ
	 * @return
	 */
	public boolean update(UserInfo user) {

		try {

			if (user != null && user.getUserId() != null) {
				// �Ȳ�ѯ���޸�
				return dao.update(user);

				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * ���ݱ��ɾ����Ա��Ϣ
	 * @param userId ��Ա���
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

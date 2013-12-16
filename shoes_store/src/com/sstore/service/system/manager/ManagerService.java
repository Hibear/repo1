package com.sstore.service.system.manager;

import java.util.List;


import com.sstore.dao.system.ManagerDAO;
import com.sstore.po.ManagerInfo;

/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: ����Ա��Ϣ�����ҵ���߼�����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: �������
 * </p>
 * 
 * @author ����
 * @version 1.0
 */

public class ManagerService {

	/**
	 * ���ݷ��ʶ���
	 */
	private ManagerDAO dao = new ManagerDAO();
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * 
	 * @return
	 */
	public List<ManagerInfo> getAllManager() {
		return dao.getAllManager();
	}
	/**
	 * ��ӹ���Ա��Ϣ
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
	 * ���ݱ�Ų�ѯ����Ա��Ϣ
	 * 
	 * @param userId
	 *            ����Ա���
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
	 * ����������ѯ����Ա��Ϣ
	 * 
	 * @param userId
	 *            ����Ա���
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
	 * �޸Ĺ���Ա��Ϣ
	 * 
	 * @param user
	 *            ����Ա��Ϣ
	 * @return
	 */
	public boolean update(ManagerInfo mager) {

		try {

			if (mager != null && mager.getManagerId() != null) {
				// �Ȳ�ѯ���޸�
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
	 * ���ݱ��ɾ������Ա��Ϣ
	 * @param managerId ����Ա���
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
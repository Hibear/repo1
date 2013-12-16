package com.sstore.service.system.goodsclass;

import java.util.List;
import com.sstore.dao.system.GoodsClassDAO;
import com.sstore.po.GoodsClassInfo;

 
/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: ��Ʒ�����Ϣ��ҵ���߼�����
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

public class GoodsClassService {
	
	/**
	 * ���ݷ��ʶ���
	 */
	private GoodsClassDAO dao = new GoodsClassDAO();
	/**
	 * ��ѯ������Ʒ�����Ϣ
	 * 
	 * @return
	 */
	public List<GoodsClassInfo> getAllGoodsClass() {
		
		return dao.getAllGoodsClass();
		
	}
	
	
	/**
	 * ������Ʒ����Ų�ѯ��Ʒ�����Ϣ
	 * 
	 * @param classId
	 *           �����
	 * @return
	 */
	
	
	public GoodsClassInfo getGoodsClass(String GoodsClassId) {

		try {
			return dao.getGoodsClass(Integer.parseInt(GoodsClassId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * �޸Ĺ���Ʒ�����Ϣ
	 * 
	 * @param classId
	 *            ��Ʒ�����Ϣ
	 * @return
	 */
	public boolean update(GoodsClassInfo gc) {

		try {

			if (gc != null && gc.getClassId() != null) {
				// �Ȳ�ѯ���޸�
				GoodsClassInfo puser = dao.getGoodsClass(gc.getClassId());

				if (puser != null) {
					puser.setClassId(gc.getClassId());
					puser.setClassName(gc.getClassName());
					 return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
 
	
	/**
	 * ���������ɾ�������Ϣ
	 * @param reviewId �����
	 * @return
	 */
	public boolean delete(String classId ) {

		try {
			if (classId  != null && !"".endsWith(classId )) {

				return dao.delete(Integer.parseInt(classId ));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * �����Ʒ�����Ϣ
	 * 
	 * @param mager
	 * @return
	 */

	public boolean add(GoodsClassInfo gc) {
		if (gc != null && gc.getClassName() != null
				&& !gc.getClassName().equals("")) {

			return dao.add(gc);
		}

		return false;
	}
	

}

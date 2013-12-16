package com.sstore.service.system.goodspicture;

import java.util.List;
import com.sstore.dao.system.GoodsPictureDAO;
import com.sstore.po.GoodsPictureInfo;
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

public class GoodsPictureService {

	/**
	 * ���ݷ��ʶ���
	 */
	private GoodsPictureDAO dao = new GoodsPictureDAO();
	/**
	 * ��ѯ����ͼƬ��Ϣ
	 * 
	 * @return
	 */
	public List<GoodsPictureInfo> getAllGoodsPicture() {
		return dao.getAllGoodsPicture();
	}
	/**
	 * ���ͼƬ��Ϣ
	 * 
	 * @param mager
	 * @return
	 */

	public boolean add(GoodsPictureInfo gopic) {
		if (gopic != null && gopic.getGoodsId() != null
				&& !gopic.getPictureName().equals("")) {
			return dao.add(gopic);
		}

		return false;
	}
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * 
	 * @param user
	 *            ����Ա��Ϣ
	 * @return
	 */
	public boolean update(GoodsPictureInfo gopic) {

		try {

			if (gopic != null && gopic.getPictureId() != null) {
				// �Ȳ�ѯ���޸�
				GoodsPictureInfo puser = dao.getGoodsPicture(gopic.getPictureId());

				if (puser != null) {
					puser.setPictureId(gopic.getPictureId());
					puser.setGoodsId(gopic.getGoodsId());
					puser.setPictureName(gopic.getPictureName());
					puser.setPictureUrl(gopic.getPictureUrl());

					return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	
	/**
	 * ����ͼƬ�Ų�ѯͼƬ��Ϣ
	 * 
	 * @param GoodsPictureId
	 *            ͼƬ���
	 * @return
	 */
	public GoodsPictureInfo getGoodsPicture(String GoodsPictureId) {

		try {
			return dao.getGoodsPicture(Integer.parseInt(GoodsPictureId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ���ݱ��ɾ��ͼƬ��Ϣ
	 * @param pictureId ͼƬ���
	 * @return
	 */
	public boolean delete(String pictureId) {

		try {
			if (pictureId != null && !"".endsWith(pictureId)) {

				return dao.delete(Integer.parseInt(pictureId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
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

public class GoodsPictureService {

	/**
	 * 数据访问对象
	 */
	private GoodsPictureDAO dao = new GoodsPictureDAO();
	/**
	 * 查询所有图片信息
	 * 
	 * @return
	 */
	public List<GoodsPictureInfo> getAllGoodsPicture() {
		return dao.getAllGoodsPicture();
	}
	/**
	 * 添加图片信息
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
	 * 修改管理员信息
	 * 
	 * @param user
	 *            管理员信息
	 * @return
	 */
	public boolean update(GoodsPictureInfo gopic) {

		try {

			if (gopic != null && gopic.getPictureId() != null) {
				// 先查询在修改
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
	 * 根据图片号查询图片信息
	 * 
	 * @param GoodsPictureId
	 *            图片编号
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
	 * 根据编号删除图片信息
	 * @param pictureId 图片编号
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
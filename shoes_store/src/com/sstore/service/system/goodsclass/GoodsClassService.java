package com.sstore.service.system.goodsclass;

import java.util.List;
import com.sstore.dao.system.GoodsClassDAO;
import com.sstore.po.GoodsClassInfo;

 
/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: 商品类别信息的业务逻辑处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: 中软国际
 * </p>
 * 
 * @author 岳利
 * @version 1.0
 */

public class GoodsClassService {
	
	/**
	 * 数据访问对象
	 */
	private GoodsClassDAO dao = new GoodsClassDAO();
	/**
	 * 查询所有商品类别信息
	 * 
	 * @return
	 */
	public List<GoodsClassInfo> getAllGoodsClass() {
		
		return dao.getAllGoodsClass();
		
	}
	
	
	/**
	 * 根据商品类别编号查询商品类别信息
	 * 
	 * @param classId
	 *           类别编号
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
	 * 修改管商品类别信息
	 * 
	 * @param classId
	 *            商品类别信息
	 * @return
	 */
	public boolean update(GoodsClassInfo gc) {

		try {

			if (gc != null && gc.getClassId() != null) {
				// 先查询在修改
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
	 * 根据类别编号删除类别信息
	 * @param reviewId 类别编号
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
	 * 添加商品类别信息
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

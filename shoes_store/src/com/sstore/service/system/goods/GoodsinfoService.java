package com.sstore.service.system.goods;

import java.util.List;

import com.sstore.dao.system.GoodsClassDAO;
import com.sstore.dao.system.GoodsInfoDAO;
import com.sstore.po.GoodsClassInfo;
import com.sstore.po.GoodsInfo;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品信息查询的业务逻辑处理</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class GoodsinfoService {
	/**
	 * 数据访问对象
	 */
	private GoodsInfoDAO dao = new GoodsInfoDAO();
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public List<GoodsInfo> getAllGoods(){
		return dao.getAllGoods();
	}
	/**
	 * 商品类别
	 */
	private GoodsClassDAO daogc = new GoodsClassDAO();
	/**
	 * 获取所有商品类别信息
	 * @return
	 */
	public List<GoodsClassInfo> getAllGoodsClassInfo(){
		return daogc.getAllGoodsClass();
	}
	/**
	 * 添加员工信息
	 * 
	 * @param order
	 * @return
	 */
	public boolean add(GoodsInfo goods) {

		if (goods != null && goods.getGoodsId() != null
				&& !goods.getGoodsId().equals("")) {

			return dao.add(goods);
		}
		return false;
	}
	/**
	 * 根据编号查询订单信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @return
	 */
	public GoodsInfo getGoods(String goodsId) {

		try {
			return dao.getGoods(Integer.parseInt(goodsId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据编号查询商品信息
	 * 
	 * @param goodsId
	 *            商品编号
	 * @return
	 */
	public GoodsInfo getGoods(Integer goodsId) {

		try {
			return dao.getGoods(goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改订单信息
	 * 
	 * @param user
	 *            订单信息
	 * @return
	 */
	public boolean update(GoodsInfo goods) {

		try {

			if (goods != null && goods.getGoodsId() != null) {
				// 先查询在修改
				GoodsInfo puser = dao.getGoods(goods.getGoodsId());
				
				if (puser != null) {
					puser.setClassId(goods.getClassId());
					puser.setGoodsTypeCode(goods.getGoodsTypeCode());
					puser.setGoodsName(goods.getGoodsName());
					puser.setGoodsKeys(goods.getGoodsKeys());
					puser.setGoodsText(goods.getGoodsText());
					puser.setGoodsPt(goods.getGoodsPt());
					puser.setGoodsPriceShop(goods.getGoodsPriceShop());
					puser.setGoodsPriceUser(goods.getGoodsPriceUser());
					puser.setGoodsIsNew(goods.getGoodsIsNew());
					puser.setIsRecommend(goods.getIsRecommend());
					puser.setGoodsBuyNumber(goods.getGoodsBuyNumber());
					puser.setIsCheap(goods.getIsCheap());

					return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	/**
	 * 根据编号删除订单信息
	 * @param orderId 订单号
	 * @return
	 */
	public boolean delete(String goodsId) {

		try {
			if (goodsId != null && !"".endsWith(goodsId)) {

				return dao.delete(Integer.parseInt(goodsId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

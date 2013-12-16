package com.sstore.service.system.goods;

import java.util.List;

import com.sstore.dao.system.GoodsClassDAO;
import com.sstore.dao.system.GoodsInfoDAO;
import com.sstore.po.GoodsClassInfo;
import com.sstore.po.GoodsInfo;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ��Ʒ��Ϣ��ѯ��ҵ���߼�����</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class GoodsinfoService {
	/**
	 * ���ݷ��ʶ���
	 */
	private GoodsInfoDAO dao = new GoodsInfoDAO();
	/**
	 * ��ѯ���ж�����Ϣ
	 * @return
	 */
	public List<GoodsInfo> getAllGoods(){
		return dao.getAllGoods();
	}
	/**
	 * ��Ʒ���
	 */
	private GoodsClassDAO daogc = new GoodsClassDAO();
	/**
	 * ��ȡ������Ʒ�����Ϣ
	 * @return
	 */
	public List<GoodsClassInfo> getAllGoodsClassInfo(){
		return daogc.getAllGoodsClass();
	}
	/**
	 * ���Ա����Ϣ
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
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param orderId
	 *            �������
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
	 * ���ݱ�Ų�ѯ��Ʒ��Ϣ
	 * 
	 * @param goodsId
	 *            ��Ʒ���
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
	 * �޸Ķ�����Ϣ
	 * 
	 * @param user
	 *            ������Ϣ
	 * @return
	 */
	public boolean update(GoodsInfo goods) {

		try {

			if (goods != null && goods.getGoodsId() != null) {
				// �Ȳ�ѯ���޸�
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
	 * ���ݱ��ɾ��������Ϣ
	 * @param orderId ������
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

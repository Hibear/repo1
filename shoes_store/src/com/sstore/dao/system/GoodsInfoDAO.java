package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.GoodsInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsDAO</p>
 * <p>Description: ��Ʒ��Ϣ��������ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����÷
 * @version 1.0
 */

public class GoodsInfoDAO {
	/**
	 * ��ȡ������Ʒ��Ϣ
	 * 
	 * @return �����Ʒ��Ϣ
	 */
	public List<GoodsInfo> getAllGoods() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from  goods_info order by goods_id desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<GoodsInfo> list = new ArrayList<GoodsInfo>();
			while (res.next()) {
				GoodsInfo goods = new GoodsInfo();
				
				goods.setGoodsId(res.getInt("goods_id"));
				goods.setClassId(res.getInt("class_id"));
				goods.setGoodsTypeCode(res.getString("goods_type_code"));
				goods.setGoodsName(res.getString("goods_name"));
				goods.setGoodsKeys(res.getString("goods_keys"));
				goods.setGoodsText(res.getString("goods_text"));
				goods.setGoodsPt(res.getString("goods_pt"));
				goods.setGoodsPriceShop(res.getFloat("goods_price_shop"));
				goods.setGoodsPriceUser(res.getFloat("goods_price_user"));
				goods.setGoodsIsNew(res.getString("goods_is_new"));
				goods.setIsRecommend(res.getString("is_recommend"));
				goods.setGoodsBuyNumber(res.getInt("goods_buy_number"));
				goods.setIsCheap(res.getString("is_cheap"));
				goods.setGoodsInTime(res.getTimestamp("goods_in_time"));
				list.add(goods);
			}

			return list;


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}

		return null;
	}
	
	/**
	 * �����Ʒ��Ϣ
	 * 
	 * @param goods
	 *            ��Ʒ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(GoodsInfo goods) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_info (goods_id,class_id,goods_type_code,goods_name,goods_keys,goods_text,goods_pt,goods_price_shop,goods_price_user,goods_is_new,is_recommend,goods_buy_number,goods_in_time,is_cheap)" +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,now(),?);";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, goods.getGoodsId());
			pre.setInt(2, goods.getClassId());
			pre.setString(3, goods.getGoodsTypeCode());
			pre.setString(4, goods.getGoodsName());
			pre.setString(5, goods.getGoodsKeys());
			pre.setString(6, goods.getGoodsText());
			pre.setString(7, goods.getGoodsPt());
			pre.setFloat(8, goods.getGoodsPriceShop());
			pre.setFloat(9, goods.getGoodsPriceUser());	
			pre.setString(10, goods.getGoodsIsNew());
			pre.setString(11, goods.getIsRecommend());
			pre.setInt(12, goods.getGoodsBuyNumber());
			pre.setString(13, goods.getIsCheap());
			
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param mager
	 *           ��Ʒ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(GoodsInfo goods) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update goods_info set class_id=?,goods_type_code=?,goods_name=?,goods_keys=?,goods_text=?,goods_pt=?,goods_price_shop=?,goods_price_user=?,goods_is_new=?,is_recommend=?,goods_buy_number=?,is_cheap=?" +
					" where goods_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, goods.getClassId());
			pre.setString(2, goods.getGoodsTypeCode());
			pre.setString(3, goods.getGoodsName());
			pre.setString(4, goods.getGoodsKeys());
			pre.setString(5, goods.getGoodsText());
			pre.setString(6, goods.getGoodsPt());
			pre.setFloat(7, goods.getGoodsPriceShop());
			pre.setFloat(8, goods.getGoodsPriceUser());
			pre.setString(9, goods.getGoodsIsNew());
			pre.setString(10, goods.getIsRecommend());
			pre.setInt(11, goods.getGoodsBuyNumber());
			pre.setString(12, goods.getIsCheap());
			pre.setInt(13, goods.getGoodsId());
			
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}
	/**
	 * ���ݱ�Ų�ѯ��Ʒ��Ϣ
	 * 
	 * @param userId
	 *           ��Ʒ���
	 * @return ������Ʒ��Ϣ
	 */
	public GoodsInfo getGoods(Integer goodsId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select *  from goods_info where goods_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, goodsId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				GoodsInfo goods = new GoodsInfo();

				goods.setGoodsId(res.getInt("goods_id"));
				goods.setClassId(res.getInt("class_id"));
				goods.setGoodsTypeCode(res.getString("goods_type_code"));
				goods.setGoodsName(res.getString("goods_name"));
				goods.setGoodsKeys(res.getString("goods_keys"));
				goods.setGoodsText(res.getString("goods_text"));
				goods.setGoodsPt(res.getString("goods_pt"));
				goods.setGoodsPriceShop(res.getFloat("goods_price_shop"));
				goods.setGoodsPriceUser(res.getFloat("goods_price_user"));
				goods.setGoodsIsNew(res.getString("goods_is_new"));
				goods.setIsRecommend(res.getString("is_recommend"));
				goods.setGoodsBuyNumber(res.getInt("goods_buy_number"));
				goods.setIsCheap(res.getString("is_cheap"));
				goods.setGoodsInTime(res.getTimestamp("goods_in_time"));
				return goods;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}

		return null;
	}
	
	
	
	
	
	/**
	 * ���ݱ��ɾ����Ʒ��Ϣ
	 * 
	 * @param goodsId
	 *            ��Ʒ���
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer goodsId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from goods_info where goods_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, goodsId);
			// ִ��sql�����ӣ��޸ģ�ɾ�����ǵ����������
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon(con);
			DBCon.closePre(pre);
		}

		return false;
	}

}


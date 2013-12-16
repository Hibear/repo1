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
 * <p>Description: 商品信息管理的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 汪洪梅
 * @version 1.0
 */

public class GoodsInfoDAO {
	/**
	 * 获取所有商品信息
	 * 
	 * @return 多个商品信息
	 */
	public List<GoodsInfo> getAllGoods() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select * from  goods_info order by goods_id desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
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
	 * 添加商品信息
	 * 
	 * @param goods
	 *            商品信息
	 * @return true为成功 false失败
	 */
	public boolean add(GoodsInfo goods) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_info (goods_id,class_id,goods_type_code,goods_name,goods_keys,goods_text,goods_pt,goods_price_shop,goods_price_user,goods_is_new,is_recommend,goods_buy_number,goods_in_time,is_cheap)" +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,now(),?);";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
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
			
			// 执行sql：增加，修改，删除都是调用这个方法
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
	 * 修改商品信息
	 * 
	 * @param mager
	 *           商品信息
	 * @return true为成功 false失败
	 */
	public boolean update(GoodsInfo goods) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update goods_info set class_id=?,goods_type_code=?,goods_name=?,goods_keys=?,goods_text=?,goods_pt=?,goods_price_shop=?,goods_price_user=?,goods_is_new=?,is_recommend=?,goods_buy_number=?,is_cheap=?" +
					" where goods_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
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
			
			// 执行sql：增加，修改，删除都是调用这个方法
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
	 * 根据编号查询商品信息
	 * 
	 * @param userId
	 *           商品编号
	 * @return 单个商品信息
	 */
	public GoodsInfo getGoods(Integer goodsId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select *  from goods_info where goods_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, goodsId);
			// 执行sql
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
	 * 根据编号删除商品信息
	 * 
	 * @param goodsId
	 *            商品编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer goodsId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from goods_info where goods_id=?;";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, goodsId);
			// 执行sql：增加，修改，删除都是调用这个方法
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


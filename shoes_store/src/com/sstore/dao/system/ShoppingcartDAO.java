package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.sstore.po.MyCartInfo;
import com.sstore.po.ShoppingcartInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: ShoppingcartDAO</p>
 * <p>Description: 购物车的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 汪洪梅
 * @version 1.0
 */

public class ShoppingcartDAO {
	/**
	 * 获取所有购物车信息
	 * 
	 * @return 多个购物车信息
	 */
	public List<ShoppingcartInfo> getAllShoppingcart() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select a.* ,b.* from  shoppingcart_info a ,goods_link_shoppingcart_info b where a.shoppingcart_id=b.shoppingcart_id ";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			List<ShoppingcartInfo> list = new ArrayList<ShoppingcartInfo>();
			while (res.next()) {
				ShoppingcartInfo  Shoppingcart = new ShoppingcartInfo();
				
				Shoppingcart.setShoppingcartId(res.getInt("shoppingcart_id"));
				Shoppingcart.setUserId(res.getInt("user_id"));
				Shoppingcart.setGoodsId(res.getInt("goods_id"));
				Shoppingcart.setGoodsNumber(res.getInt("goods_number"));
				list.add(Shoppingcart);
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
	 * 根据会员编号查询购物车信息
	 * 
	 * @param userId
	 *           购物车编号
	 * @return 单个购物车信息
	 */
	public List<MyCartInfo> getMycart(Integer userId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select c.user_id ,b.goods_name, b.goods_price_shop,a.goods_number  from  goods_link_shoppingcart_info  a, goods_info b, shoppingcart_info  c  where  a.goods_id=b.goods_id  and  a.shoppingcart_id=c.shoppingcart_id   and user_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// 执行sql
			res = pre.executeQuery();

				System.out.println(userId);
				System.out.println(userId);
				System.out.println(userId);
				System.out.println(userId);
				List<MyCartInfo> list = new ArrayList<MyCartInfo>();
				
				while (res.next()){
					MyCartInfo  Shoppingcart = new MyCartInfo();
					Shoppingcart.setUserId(res.getInt("user_id"));
					Shoppingcart.setGoodsName(res.getString("goods_name"));
					Shoppingcart.setGoodsPriceShop(res.getFloat("goods_price_shop"));
					Shoppingcart.setGoodsNumber(res.getInt("goods_number"));
					
					list.add(Shoppingcart);
				}
				System.out.println(list.size());
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
	 * 添加购物车信息
	 * 
	 * @param shopcart
	 *            购物车信息
	 * @return true为成功 false失败
	 */
	public boolean addUserId(ShoppingcartInfo shopcart) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into shoppingcart_info(user_id)"
					+ "  values(?)";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, shopcart.getUserId());


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
	 * 添加购物车信息
	 * 
	 * @param shopcart
	 *            购物车联系信息
	 * @return true为成功 false失败
	 */
	public boolean addGoodsId(ShoppingcartInfo shopcart) {
		// 声明
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql ="insert into goods_link_shoppingcart_info (goods_id,goods_number) values (?,?)";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, shopcart.getGoodsId());
			pre.setInt(2, shopcart.getGoodsNumber());



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

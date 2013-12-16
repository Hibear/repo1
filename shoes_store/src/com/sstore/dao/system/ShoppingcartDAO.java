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
 * <p>Description: ���ﳵ�����ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����÷
 * @version 1.0
 */

public class ShoppingcartDAO {
	/**
	 * ��ȡ���й��ﳵ��Ϣ
	 * 
	 * @return ������ﳵ��Ϣ
	 */
	public List<ShoppingcartInfo> getAllShoppingcart() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select a.* ,b.* from  shoppingcart_info a ,goods_link_shoppingcart_info b where a.shoppingcart_id=b.shoppingcart_id ";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
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
	 * ���ݻ�Ա��Ų�ѯ���ﳵ��Ϣ
	 * 
	 * @param userId
	 *           ���ﳵ���
	 * @return �������ﳵ��Ϣ
	 */
	public List<MyCartInfo> getMycart(Integer userId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select c.user_id ,b.goods_name, b.goods_price_shop,a.goods_number  from  goods_link_shoppingcart_info  a, goods_info b, shoppingcart_info  c  where  a.goods_id=b.goods_id  and  a.shoppingcart_id=c.shoppingcart_id   and user_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// ִ��sql
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
	 * ��ӹ��ﳵ��Ϣ
	 * 
	 * @param shopcart
	 *            ���ﳵ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean addUserId(ShoppingcartInfo shopcart) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into shoppingcart_info(user_id)"
					+ "  values(?)";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, shopcart.getUserId());


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
	 * ��ӹ��ﳵ��Ϣ
	 * 
	 * @param shopcart
	 *            ���ﳵ��ϵ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean addGoodsId(ShoppingcartInfo shopcart) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql ="insert into goods_link_shoppingcart_info (goods_id,goods_number) values (?,?)";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, shopcart.getGoodsId());
			pre.setInt(2, shopcart.getGoodsNumber());



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

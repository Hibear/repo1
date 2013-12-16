package com.sstore.dao.system;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsPictureDAO</p>
 * <p>Description: ��ƷͼƬ��Ϣ�����ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */

public class GoodsPictureDAO {
	/**
	 * ��ȡ������ƷͼƬ��Ϣ
	 * 
	 * @return �����ƷͼƬ��Ϣ
	 */
	public List<GoodsPictureInfo> getAllGoodsPicture() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from  goods_picture_info order by picture_id desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<GoodsPictureInfo> list = new ArrayList<GoodsPictureInfo>();
			while (res.next()) {
				GoodsPictureInfo gopic = new GoodsPictureInfo();
				
				gopic.setPictureId(res.getInt("picture_id"));
				gopic.setGoodsId(res.getInt("goods_id"));
				gopic.setPictureName(res.getString("picture_name"));
				gopic.setPictureUrl(res.getString("picture_url"));
				list.add(gopic);
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
	 * �����ƷͼƬ��Ϣ
	 * 
	 * @param user
	 *            ��ƷͼƬ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(GoodsPictureInfo gopic) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_picture_info (goods_id,picture_name,picture_url)"
					+ "  values(?,?,?)";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, gopic.getGoodsId());
			pre.setString(2, gopic.getPictureName());
			pre.setString(3, gopic.getPictureUrl());

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
	 * �޸���ƷͼƬ��Ϣ
	 * 
	 * @param mager
	 *            ��ƷͼƬ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(GoodsPictureInfo gopic) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update goods_picture_info set picture_id=?,goods_id=?,picture_name=?,picture_url=? where picture_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, gopic.getPictureId());
			pre.setInt(2, gopic.getGoodsId());
			pre.setString(3, gopic.getPictureName());
			pre.setString(4, gopic.getPictureUrl());
			pre.setInt(5, gopic.getPictureId());
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
	 * ���ݱ�Ų�ѯ��ƷͼƬ��Ϣ
	 * 
	 * @param userId
	 *           ��ƷͼƬ���
	 * @return ������ƷͼƬ��Ϣ
	 */
	public GoodsPictureInfo getGoodsPicture(Integer pictureId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;
		
		InputStream result = null;

		try {
			String sql = "select *  from goods_picture_info where picture_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, pictureId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				GoodsPictureInfo gopic = new GoodsPictureInfo();

				gopic.setPictureId(res.getInt("picture_id"));
				gopic.setGoodsId(res.getInt("goods_id"));
				gopic.setPictureName(res.getString("picture_name"));
				gopic.setPictureUrl(res.getString("picture_url"));
				return gopic;

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
	 * ���ݱ��ɾ����ƷͼƬ��Ϣ
	 * 
	 * @param pictureId
	 *            ��ƷͼƬ���
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer pictureId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from  goods_picture_info where picture_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, pictureId);
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

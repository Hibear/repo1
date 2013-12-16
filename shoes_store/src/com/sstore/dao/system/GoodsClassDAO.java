package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.GoodsClassInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsClassInfoDAO</p>
 * <p>Description: ��Ʒ������ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����÷
 * @version 1.0
 */

public class GoodsClassDAO {
	/**
	 * ��ȡ������Ʒ�����Ϣ
	 * 
	 * @return ��������Ϣ
	 */
	public List<GoodsClassInfo> getAllGoodsClass() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from  goods_class_info order by class_id desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<GoodsClassInfo> list = new ArrayList<GoodsClassInfo>();
			while (res.next()) {
				GoodsClassInfo goodsclass = new GoodsClassInfo();
				goodsclass.setClassId(res.getInt("class_id"));
				goodsclass.setClassName(res.getString("class_name"));
				list.add(goodsclass);
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
	 * ��������Ϣ
	 * 
	 * @param goodsclass
	 *            �����Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(GoodsClassInfo user) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into goods_class_info (class_id,class_name)"
					+ "  values(?,?)";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, user.getClassId());
			pre.setString(2, user.getClassName());

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
	 * �޸������Ϣ
	 * 
	 * @param goods_class
	 *            �����Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(GoodsClassInfo goodsclass) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update goods_class_info set class_name=? where class_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setString(1, goodsclass.getClassName());
			pre.setInt(2, goodsclass.getClassId());
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
	 * ���ݱ�Ų�ѯ�����Ϣ
	 * 
	 * @param ClassId
	 *          �����
	 * @return ���������Ϣ
	 */
	public GoodsClassInfo getGoodsClass(Integer classId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select *  from goods_class_info where class_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, classId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				GoodsClassInfo goodsclass = new GoodsClassInfo();

				goodsclass .setClassId(res.getInt("class_id"));
				goodsclass .setClassName(res.getString("class_name"));
				return goodsclass ;

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
	 * ���ݱ��ɾ�������Ϣ
	 * 
	 * @param classId
	 *            �����
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer classId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from  goods_class_info where class_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, classId);
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
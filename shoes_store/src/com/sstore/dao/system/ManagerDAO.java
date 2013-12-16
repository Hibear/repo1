package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ManagerInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: ManagerDAO</p>
 * <p>Description: ����Ա��Ϣ��������ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */

public class ManagerDAO {
	/**
	 * ��ȡ���й���Ա��Ϣ
	 * 
	 * @return �������Ա��Ϣ
	 */
	public List<ManagerInfo> getAllManager() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from  manager_info order by manager_id desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<ManagerInfo> list = new ArrayList<ManagerInfo>();
			while (res.next()) {
				ManagerInfo mager = new ManagerInfo();
				
				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				list.add(mager);
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
	 * ���Ա����Ϣ
	 * 
	 * @param user
	 *            Ա����Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(ManagerInfo user) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into manager_info (manager_name,manager_pwd,manager_create_time)"
					+ "  values(?,?,now())";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getManagerName());
			pre.setString(2, user.getManagerPwd());

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
	 * �޸Ĺ���Ա��Ϣ
	 * 
	 * @param mager
	 *            ����Ա��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(ManagerInfo mager) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update manager_info set manager_id=?,manager_name=?,manager_pwd=?,manager_create_time=now() where manager_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, mager.getManagerId());
			pre.setString(2, mager.getManagerName());
			pre.setString(3, mager.getManagerPwd());
			pre.setInt(4, mager.getManagerId());
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
	 * ���ݱ�Ų�ѯ����Ա��Ϣ
	 * 
	 * @param userId
	 *           ����Ա���
	 * @return ��������Ա��Ϣ
	 */
	public ManagerInfo getManager(Integer managerId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select *  from manager_info where manager_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, managerId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				ManagerInfo mager = new ManagerInfo();

				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				return mager;

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
	 * ����������ѯ����Ա��Ϣ
	 * 
	 * @param managerName
	 *           ����Ա����
	 * @return ��������Ա��Ϣ
	 */
	public ManagerInfo getManagerName(String managerName) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select *  from manager_info where manager_name=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setString(1, managerName);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				ManagerInfo mager = new ManagerInfo();

				mager.setManagerId(res.getInt("manager_id"));
				mager.setManagerName(res.getString("manager_name"));
				mager.setManagerPwd(res.getString("manager_pwd"));
				mager.setManagerCreateTime(res.getTimestamp("manager_create_time"));
				return mager;

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
	 * ���ݱ��ɾ������Ա��Ϣ
	 * 
	 * @param userId
	 *            ����Ա���
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer managerId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from  manager_info where manager_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, managerId);
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

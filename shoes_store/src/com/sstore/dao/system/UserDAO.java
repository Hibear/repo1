
package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ManagerInfo;
import com.sstore.po.UserInfo;
import com.sstore.util.DBCon;;

/**
 * <p>Title: UserDAO</p>
 * <p>Description: ��Ա��Ϣ��������ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:</p>
 * @author 
 * @version 1.0
 */

public class UserDAO {
	/**
	 * ��ӻ�Ա��Ϣ
	 * 
	 * @param user
	 *            ��Ա��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(UserInfo user) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into user_info (user_name,user_pwd,user_email,user_phone,user_address,is_user_check,user_create_time)"
					+ "  values(?,?,?,?,?,?,now())";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserPwd());
			pre.setString(3, user.getUserEmail());
			pre.setString(4, user.getUserPhone());
			pre.setString(5, user.getUserAddress());
			pre.setString(6, user.getUserCheck());
            
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
	 * �޸Ļ�Ա��Ϣ
	 * 
	 * @param user
	 *            ��Ա��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(UserInfo user) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		
		System.out.println(user.getUserId());

		try {
			String sql = "update user_info set user_name=?,user_pwd=?,user_email=?,user_phone=?,user_address=?,is_user_check=?,user_create_time=now() where user_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserPwd());
			pre.setString(3, user.getUserEmail());
			pre.setString(4, user.getUserPhone());
			pre.setString(5, user.getUserAddress());
			pre.setString(6, user.getUserCheck());
			pre.setInt(7, user.getUserId());
			
			
			
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserId());

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
	 * ���ݱ��ɾ����Ա��Ϣ
	 * 
	 * @param userId
	 *            ��Ա���
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer userId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update user_info set is_user_check=? where user_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setString(1, "��");
			pre.setInt(2, userId);
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
	 * ����������ѯ�û���Ϣ
	 * 
	 * @param managerName
	 *           �û�����
	 * @return �����û���Ϣ
	 */
	public UserInfo getUserN(String userName) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select *  from user_info where user_name=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				return user;

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
	 * ��ȡ���л�Ա��Ϣ
	 * 
	 * @return �����Ա��Ϣ
	 */
	public List<UserInfo> getAllUser() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from user_info order by user_id desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<UserInfo> list = new ArrayList<UserInfo>();
			while (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserCheck(res.getString("is_user_check"));
				user.setUserTime(res.getTimestamp("user_create_time"));

				list.add(user);

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
	 * ���ݱ�Ų�ѯ��Ա��Ϣ
	 * 
	 * @param userId
	 *            ��Ա���
	 * @return ������Ա��Ϣ
	 */
	public UserInfo getUser(Integer userId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from user_info where user_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				UserInfo user = new UserInfo();

				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserCheck(res.getString("is_user_check"));
				user.setUserTime(res.getTimestamp("user_create_time"));

				return user;

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

}

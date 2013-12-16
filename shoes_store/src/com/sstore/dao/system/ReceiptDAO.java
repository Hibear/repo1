package com.sstore.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.ReceiptInfo;
import com.sstore.util.DBCon;

/**
 * <p>Title: GoodsClassInfoDAO</p>
 * <p>Description: ��Ʒ������Ϣ���ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:</p>
 * @author ����
 * @version 1.0
 */
public class ReceiptDAO {
	/**
	 * ��ȡ������Ʒ������Ϣ
	 * 
	 * @return �����Ʒ������Ϣ
	 */
	public List<ReceiptInfo> getAllReceipt(){
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from receipt_info order by receipt_id desc;";
			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<ReceiptInfo> list = new ArrayList<ReceiptInfo>();
			while (res.next()) {
				ReceiptInfo receipt = new ReceiptInfo();
				receipt.setReceiptId(res.getInt("receipt_id"));
				receipt.setReceiptPrice(res.getFloat("receipt_price"));
				receipt.setReceiptTime(res.getTimestamp("receipt_time"));
				list.add(receipt);
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
	 * �����Ʒ������Ϣ
	 * 
	 * @param receipt
	 *            ��Ʒ��Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean add(ReceiptInfo receipt) {
		// ����
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "insert into receipt_info (receipt_id,receipt_price,receipt_time) values(?,?,now());";
			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, receipt.getReceiptId());
			pre.setFloat(2, receipt.getReceiptPrice());
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
	 * �޸���Ʒ������Ϣ
	 * 
	 * @param receipt
	 *            ��Ʒ������Ϣ
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean update(ReceiptInfo receipt) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "update receipt_info set receipt_price=? where receipt_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setFloat(1, receipt.getReceiptPrice());
			pre.setInt(2, receipt.getReceiptId());
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
	 * ���ݽ������Ų�ѯ������Ϣ
	 * 
	 * @param ClassId
	 *          ��������
	 * @return ����������Ϣ
	 */
	public ReceiptInfo getReceiptInfo(Integer receiptId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select * from receipt_info where receipt_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, receiptId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
				ReceiptInfo receipt = new ReceiptInfo();
				receipt.setReceiptId(res.getInt("receipt_id"));
				receipt.setReceiptPrice(res.getFloat("receipt_price"));
				receipt.setReceiptTime(res.getTimestamp("receipt_time"));
				
				return receipt;
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
	 * ���ݽ�������ɾ��������Ϣ
	 * 
	 * @param receiptId
	 *            ��������
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer receiptId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from receipt_info where receipt_id=?;";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, receiptId);
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

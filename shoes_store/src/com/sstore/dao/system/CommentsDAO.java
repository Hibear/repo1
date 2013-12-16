package com.sstore.dao.system;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sstore.po.CommentsInfo;
 
import com.sstore.util.DBCon;


/**
 * <p>Title: ManagerDAO</p>
 * <p>Description: ���۵����ݷ��ʶ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */

public class CommentsDAO {
	
	/**
	 * ��ȡ����������Ϣ
	 * 
	 * @return ����������Ϣ��Ϣ
	 */
	
	public List<CommentsInfo> getAllComments() {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;
		
		
		try {
			String sql = "select *  from  comments_info order by  review_id  desc";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			// ִ��sql
			res = pre.executeQuery();
			List<CommentsInfo> list = new ArrayList<CommentsInfo>();
			while (res.next()) {
				CommentsInfo comments  = new  CommentsInfo();
				
				comments.setReviewId(res.getInt("review_id"));
				comments.setUserId(res.getInt("user_id"));
				comments.setUserId(res.getInt("goods_id"));
				comments.setUserName(res.getString("user_name"));
				comments.setReviewText(res.getString("review_text"));
				comments.setReviewTime(res.getTimestamp("review_time"));
				list.add(comments);
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
	 * ���������Ϣ
	 * 
	 * @return 
	 */
	
	public boolean getAddComments(CommentsInfo commentsinfo) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;
		
		
		try {
			String sql = "insert into comments_info (user_id,goo_goods_id,goods_id,review_text,review_time) " +
					"values(?,?,?,?,now());";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			pre.setInt(1, commentsinfo.getUserId());
			pre.setInt(2, commentsinfo.getGoogoodsId());
			pre.setInt(3, commentsinfo.getGoodsId());
			pre.setString(4, commentsinfo.getReviewText());
			
			
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
			DBCon.closeRes(res);
		}

		return false;
	}	
	
	/**
	 * ���ݻ�Ա��Ų�ѯ������Ϣ
	 * 
	 * @param  userId
	 *           ��Ա���
	 * @return ����������Ϣ
	 */
	public CommentsInfo getUserId(Integer userId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select review_id, user_id, goods_id, user_name, review_text,review_time  from  comments_info  where user_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
               CommentsInfo comments  = new  CommentsInfo();
				
				comments.setReviewId(res.getInt("review_id"));
				comments.setUserId(res.getInt("user_id"));
				comments.setUserId(res.getInt("goods_id"));
				comments.setUserName(res.getString("user_name"));
				comments.setReviewText(res.getString("review_text"));
				comments.setReviewTime(res.getTimestamp("review_time"));
				
				return  comments;

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
	 * ���ݻ�Ա���ɾ��������Ϣ
	 * 
	 * @param userID
	 *            ��Ա���
	 * @return trueΪ�ɹ� falseʧ��
	 */
	public boolean delete(Integer reviewId) {
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;

		try {
			String sql = "delete from  comments_info where review_id=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ����ʵ��
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, reviewId);
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
	 * ���ݻ�Ա������ѯ������Ϣ
	 * 
	 * @param  userId
	 *           ��Ա����
	 * @return ����������Ϣ
	 */
	

	public CommentsInfo getUserName(String userName) {
		 
		// ���ݿ�����
		Connection con = null;
		// Ԥ����
		PreparedStatement pre = null;
		// �����
		ResultSet res = null;

		try {
			String sql = "select review_id, user_id, goods_id, user_name, review_text, review_time  from  comments_info where user_name=?";

			// ��ȡ����
			con = DBCon.getConnection();
			// ��ȡԤ����
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			// ִ��sql
			res = pre.executeQuery();

			if (res.next()) {
               CommentsInfo comments  = new  CommentsInfo();
				
				comments.setReviewId(res.getInt("review_id"));
				comments.setUserId(res.getInt("user_id"));
				comments.setUserId(res.getInt("goods_id"));
				comments.setUserName(res.getString("user_name"));
				comments.setReviewText(res.getString("review_text"));
				
				comments.setReviewTime(res.getTimestamp("review_time"));
				
				return  comments;

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
	
 	
	
	



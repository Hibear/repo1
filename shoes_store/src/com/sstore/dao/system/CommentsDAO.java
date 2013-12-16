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
 * <p>Description: 评论的数据访问对象</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 岳利
 * @version 1.0
 */

public class CommentsDAO {
	
	/**
	 * 获取所有评论信息
	 * 
	 * @return 多条评论信息信息
	 */
	
	public List<CommentsInfo> getAllComments() {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		
		try {
			String sql = "select *  from  comments_info order by  review_id  desc";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			// 执行sql
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
	 * 添加评论信息
	 * 
	 * @return 
	 */
	
	public boolean getAddComments(CommentsInfo commentsinfo) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		
		try {
			String sql = "insert into comments_info (user_id,goo_goods_id,goods_id,review_text,review_time) " +
					"values(?,?,?,?,now());";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, commentsinfo.getUserId());
			pre.setInt(2, commentsinfo.getGoogoodsId());
			pre.setInt(3, commentsinfo.getGoodsId());
			pre.setString(4, commentsinfo.getReviewText());
			
			
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
			DBCon.closeRes(res);
		}

		return false;
	}	
	
	/**
	 * 根据会员编号查询评论信息
	 * 
	 * @param  userId
	 *           会员编号
	 * @return 单条评论信息
	 */
	public CommentsInfo getUserId(Integer userId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select review_id, user_id, goods_id, user_name, review_text,review_time  from  comments_info  where user_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			// 执行sql
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
	 * 根据会员编号删除评论信息
	 * 
	 * @param userID
	 *            会员编号
	 * @return true为成功 false失败
	 */
	public boolean delete(Integer reviewId) {
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from  comments_info where review_id=?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, reviewId);
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
	 * 根据会员姓名查询评论信息
	 * 
	 * @param  userId
	 *           会员姓名
	 * @return 单条评论信息
	 */
	

	public CommentsInfo getUserName(String userName) {
		 
		// 数据库连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;

		try {
			String sql = "select review_id, user_id, goods_id, user_name, review_text, review_time  from  comments_info where user_name=?";

			// 获取连接
			con = DBCon.getConnection();
			// 获取预编译
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			// 执行sql
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
	
 	
	
	



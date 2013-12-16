package com.sstore.service.system.comments;

import java.util.List;

import com.sstore.dao.system.CommentsDAO;
 
import com.sstore.po.CommentsInfo;
 
 



/**
 * <p>
 * Title: CommentsService
 * </p>
 * <p>
 * Description: 评论信息管理的业务逻辑处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: 中软国际
 * </p>
 * 
 * @author 岳利
 * @version 1.0
 */

   public class CommentsService {
	
	/**
	 * 数据访问对象
	 */
	private CommentsDAO dao = new CommentsDAO();
	/**
	 * 查询所有评论信息
	 * 
	 * @return
	 */
	public List<CommentsInfo> getAllComments() {
		
		return dao.getAllComments();
	}
	
	/**
	 * 添加评论信息
	 * 
	 * @param order
	 * @return
	 */
	public boolean add(CommentsInfo commentsinfo) {

		if (commentsinfo != null && commentsinfo.getGoogoodsId() != null
				&& !commentsinfo.getGoogoodsId().equals("")) {

			return dao.getAddComments(commentsinfo);
		}
		return false;
	}
	
	/**
	 * 根据会员编号查询评论信息
	 * 
	 * @param userId
	 *           会员编号
	 * @return
	 */
	
	
	
	public CommentsInfo getUserId(Integer userId) {

		try {
			return dao.getUserId( userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 根据会员姓名查询评论信息
	 * 
	 * @param userId
	 *            管理员编号
	 * @return
	 */
	public CommentsInfo getUserName(String userName) {

		try {
			return dao.getUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据会员编号删除评论信息
	 * @param userId 会员编号
	 * @return
	 */
	public boolean delete(String reviewId ) {

		try {
			if (reviewId  != null && !"".endsWith(reviewId )) {

				return dao.delete(Integer.parseInt(reviewId ));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

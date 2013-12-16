package com.sstore.service.system.comments;

import java.util.List;

import com.sstore.dao.system.CommentsDAO;
 
import com.sstore.po.CommentsInfo;
 
 



/**
 * <p>
 * Title: CommentsService
 * </p>
 * <p>
 * Description: ������Ϣ�����ҵ���߼�����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: �������
 * </p>
 * 
 * @author ����
 * @version 1.0
 */

   public class CommentsService {
	
	/**
	 * ���ݷ��ʶ���
	 */
	private CommentsDAO dao = new CommentsDAO();
	/**
	 * ��ѯ����������Ϣ
	 * 
	 * @return
	 */
	public List<CommentsInfo> getAllComments() {
		
		return dao.getAllComments();
	}
	
	/**
	 * ���������Ϣ
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
	 * ���ݻ�Ա��Ų�ѯ������Ϣ
	 * 
	 * @param userId
	 *           ��Ա���
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
	 * ���ݻ�Ա������ѯ������Ϣ
	 * 
	 * @param userId
	 *            ����Ա���
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
	 * ���ݻ�Ա���ɾ��������Ϣ
	 * @param userId ��Ա���
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

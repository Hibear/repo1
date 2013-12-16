package com.sstore.web.serlvet.system.commentsinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.CommentsInfo;
import com.sstore.service.system.comments.CommentsService;
 


/**
 * <p>Title: CommentsQuerySerlvet</p>
 * <p>Description: ������Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */

public class CommentsQueryServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		
		//ҵ���߼�����
		CommentsService service = new CommentsService();
		//��ѯ������Ϣ
		
		
		List<CommentsInfo> list = service.getAllComments();
		
		System.out.print(list);
		
		req.setAttribute("list", list);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/commentsinfo/commentsinfo_list.jsp").forward(req, resp);
	}
	
	
	

}

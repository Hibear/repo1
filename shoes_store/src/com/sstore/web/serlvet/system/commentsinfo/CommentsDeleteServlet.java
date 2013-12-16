package com.sstore.web.serlvet.system.commentsinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.comments.CommentsService;

public class CommentsDeleteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		//ҵ���߼�����
		CommentsService service = new CommentsService();
		
		//��ȡҳ����Ϣ
		String reviewId = req.getParameter("reviewId");
		
		boolean mark = service.delete(reviewId);
		if(mark){
			req.setAttribute("info", "������Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "������Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/commentsinfo/commentsinfo_info.jsp").forward(req, resp);
		
	}

 
	
	

}

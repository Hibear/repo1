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
		 
		//业务逻辑处理
		CommentsService service = new CommentsService();
		
		//获取页面信息
		String reviewId = req.getParameter("reviewId");
		
		boolean mark = service.delete(reviewId);
		if(mark){
			req.setAttribute("info", "评论信息删除成功！");
		}else{
			req.setAttribute("info", "评论信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/commentsinfo/commentsinfo_info.jsp").forward(req, resp);
		
	}

 
	
	

}

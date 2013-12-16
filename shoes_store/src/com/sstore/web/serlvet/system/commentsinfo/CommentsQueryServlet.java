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
 * <p>Description: 评论信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 岳利
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
		 
		
		//业务逻辑处理
		CommentsService service = new CommentsService();
		//查询所有信息
		
		
		List<CommentsInfo> list = service.getAllComments();
		
		System.out.print(list);
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/commentsinfo/commentsinfo_list.jsp").forward(req, resp);
	}
	
	
	

}

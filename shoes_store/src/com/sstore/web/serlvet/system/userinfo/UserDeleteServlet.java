package com.sstore.web.serlvet.system.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.UserInfo;
import com.sstore.service.system.user.UserService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 会员信息删除的servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 中软国际</p>
 * @author 曾微中
 * @version 1.0
 */

public class UserDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		UserService service = new UserService();
		
		//获取页面信息
		String userId = req.getParameter("userId");
		
		boolean mark = service.delete(userId);
		if(mark){
			req.setAttribute("info", "会员信息删除成功！");
			
		}else{
			req.setAttribute("info", "会员信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_info.jsp").forward(req, resp);
		
		
	}

}

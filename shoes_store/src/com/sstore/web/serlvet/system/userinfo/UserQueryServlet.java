package com.sstore.web.serlvet.system.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.UserInfo;
import com.sstore.service.system.user.UserService;
/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 会员信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 中软国际</p>
 * @author 曾微中
 * @version 1.0
 */
public class UserQueryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		UserService service = new UserService();
		//查询所有信息
		List<UserInfo> list = service.getAllUser();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_list.jsp").forward(req, resp);
	}

}

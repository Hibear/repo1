package com.sstore.web.serlvet.front.signin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.UserInfo;
import com.sstore.service.system.user.UserService;
/**
 * <p>Title: FUserSignInServlet</p>
 * <p>Description: 会员信息注册增加的servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 中软国际</p>
 * @author 杨雄
 * @version 1.0
 */

public class FUserSignInServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		UserService service = new UserService();
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/signininfo/signininfo_add.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		UserService service = new UserService();
		
		//获取页面信息
		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("userPwd");
		String userEmail = req.getParameter("userEmail");
		String userPhone = req.getParameter("userPhone");
		String userAddress = req.getParameter("userAddress");
		String userCheck = req.getParameter("userCheck");
		
		UserInfo user = new UserInfo();
		
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserEmail(userEmail);
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserCheck(userCheck);
		
		boolean mark = service.add(user);
		if(mark){
			req.setAttribute("info", "会员信息注册成功！");
		}else{
			req.setAttribute("info", "会员信息注册失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/signininfo/usersignininfo_info.jsp").forward(req, resp);

   }
}
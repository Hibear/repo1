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
 * <p>Description: ��Ա��Ϣע�����ӵ�servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */

public class FUserSignInServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		UserService service = new UserService();
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/signininfo/signininfo_add.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		UserService service = new UserService();
		
		//��ȡҳ����Ϣ
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
			req.setAttribute("info", "��Ա��Ϣע��ɹ���");
		}else{
			req.setAttribute("info", "��Ա��Ϣע��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/signininfo/usersignininfo_info.jsp").forward(req, resp);

   }
}
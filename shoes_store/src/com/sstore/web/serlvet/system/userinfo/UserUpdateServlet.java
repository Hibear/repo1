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
 * <p>Description: ��Ա��Ϣ�޸ĵ�servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: �������</p>
 * @author ��΢��
 * @version 1.0
 */

public class UserUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		UserService service = new UserService();
		// Ա�����
		String userId = request.getParameter("userId");
		System.out.println(userId);
		UserInfo user = service.getUser(userId);
		System.out.println(user.getUserId());
		request.setAttribute("user", user);
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_update.jsp").forward(request, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		UserService service = new UserService();
		
		//��ȡҳ����Ϣ
		String userId1=req.getParameter("userId");
		int userId=Integer.parseInt(userId1);
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
		user.setUserId(userId);
		
		
		boolean mark = service.update(user);
		if(mark){
			req.setAttribute("info", "��Ա��Ϣ�޸ĳɹ���");
		}else{
			req.setAttribute("info", "��Ա��Ϣ�޸�ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_info.jsp").forward(req, resp);
	}


}

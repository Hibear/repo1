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
 * <p>Description: ��Ա��Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: �������</p>
 * @author ��΢��
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
		//ҵ���߼�����
		UserService service = new UserService();
		//��ѯ������Ϣ
		List<UserInfo> list = service.getAllUser();
		
		req.setAttribute("list", list);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_list.jsp").forward(req, resp);
	}

}

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
 * <p>Description: ��Ա��Ϣɾ����servlet</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: �������</p>
 * @author ��΢��
 * @version 1.0
 */

public class UserDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		UserService service = new UserService();
		
		//��ȡҳ����Ϣ
		String userId = req.getParameter("userId");
		
		boolean mark = service.delete(userId);
		if(mark){
			req.setAttribute("info", "��Ա��Ϣɾ���ɹ���");
			
		}else{
			req.setAttribute("info", "��Ա��Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/userinfo/userinfo_info.jsp").forward(req, resp);
		
		
	}

}

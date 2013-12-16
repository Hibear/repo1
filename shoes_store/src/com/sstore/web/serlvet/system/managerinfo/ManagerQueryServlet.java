package com.sstore.web.serlvet.system.managerinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.sstore.po.ManagerInfo;
import com.sstore.service.system.manager.ManagerService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: ����Ա��Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */

public class ManagerQueryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doPost(req,resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		ManagerService service = new ManagerService();
		//��ѯ������Ϣ
		List<ManagerInfo> list = service.getAllManager();
		
		req.setAttribute("list", list);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_list.jsp").forward(req, resp);
		}
}

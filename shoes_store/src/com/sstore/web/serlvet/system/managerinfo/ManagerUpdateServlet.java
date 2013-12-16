package com.sstore.web.serlvet.system.managerinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ManagerInfo;
import com.sstore.service.system.manager.ManagerService;


public class ManagerUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		ManagerService service = new ManagerService();
		// ����Ա���
		String managerId = request.getParameter("managerId");

		ManagerInfo mager = service.getManager(managerId);
		//��ȡ������Ϣ
		

		request.setAttribute("mager", mager);
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		ManagerService service = new ManagerService();
		
		//��ȡҳ����Ϣ
		String managerName = req.getParameter("managerName");
		String managerPwd = req.getParameter("managerPwd");
		String managerId = req.getParameter("managerId");
		String managerCreateTime = req.getParameter("managerCreateTime");
		
		ManagerInfo mager = new ManagerInfo();
		mager.setManagerName(managerName);
		mager.setManagerPwd(managerPwd);
		try {
			mager.setManagerId(Integer.parseInt(managerId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.update(mager);
		if(mark){
			req.setAttribute("info", "����Ա��Ϣ�޸ĳɹ���");
		}else{
			req.setAttribute("info", "����Ա��Ϣ�޸�ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
	}

}

package com.sstore.web.serlvet.system.managerinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ManagerInfo;
import com.sstore.service.system.manager.ManagerService;


public class ManagerAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		/*ManagerService service = new ManagerService();
		//��ȡ����Ա��Ϣ
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_add.jsp").forward(req, resp);
	
		
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
		
		ManagerInfo mager = new ManagerInfo();
		
		mager.setManagerName(managerName);
		mager.setManagerPwd(managerPwd);
		
		boolean mark = service.add(mager);
		if(mark){
			req.setAttribute("info", "����Ա��Ϣ��ӳɹ���");
		}else{
			req.setAttribute("info", "����Ա��Ϣ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
	}
}

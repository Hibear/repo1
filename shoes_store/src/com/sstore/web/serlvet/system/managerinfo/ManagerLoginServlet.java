package com.sstore.web.serlvet.system.managerinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ManagerInfo;
import com.sstore.service.system.manager.ManagerService;

public class ManagerLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
/*
		ManagerService service = new ManagerService();
		// ����Ա���
		String managerId = request.getParameter("managerId");

		ManagerInfo mager = service.getManager(managerId);
		//��ȡ������Ϣ
		

		request.setAttribute("mager", mager);*/
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/main/index.jsp").forward(request, resp);
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
		
		try{
			ManagerInfo mager = service.getManagerName(managerName);
			
			System.out.println(mager.getManagerPwd());
			System.out.println(managerPwd);
			if(mager.getManagerPwd().equals(managerPwd)){
			//��ת
				req.getRequestDispatcher("/back-stage/view/main/index.jsp").forward(req, resp);
			}else{
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}catch(Exception e){
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}finally{
		}
	}

}


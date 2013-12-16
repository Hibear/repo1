package com.sstore.web.serlvet.system.managerinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.manager.ManagerService;



public class ManagerDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		ManagerService service = new ManagerService();
		
		//��ȡҳ����Ϣ
		String managerId = req.getParameter("managerId");
		
		boolean mark = service.delete(managerId);
		if(mark){
			req.setAttribute("info", "Ա����Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "Ա����Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
		
		
	}

}
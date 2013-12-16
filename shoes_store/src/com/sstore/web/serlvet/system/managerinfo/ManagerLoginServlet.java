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
		// 管理员编号
		String managerId = request.getParameter("managerId");

		ManagerInfo mager = service.getManager(managerId);
		//获取部门信息
		

		request.setAttribute("mager", mager);*/
		
		//跳转
		request.getRequestDispatcher("/back-stage/view/main/index.jsp").forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		ManagerService service = new ManagerService();
		
		//获取页面信息
		String managerName = req.getParameter("managerName");
		String managerPwd = req.getParameter("managerPwd");
		
		try{
			ManagerInfo mager = service.getManagerName(managerName);
			
			System.out.println(mager.getManagerPwd());
			System.out.println(managerPwd);
			if(mager.getManagerPwd().equals(managerPwd)){
			//跳转
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


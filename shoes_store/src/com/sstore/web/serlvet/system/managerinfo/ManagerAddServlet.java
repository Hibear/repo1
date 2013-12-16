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
		//业务逻辑处理
		/*ManagerService service = new ManagerService();
		//获取管理员信息
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_add.jsp").forward(req, resp);
	
		
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
		
		ManagerInfo mager = new ManagerInfo();
		
		mager.setManagerName(managerName);
		mager.setManagerPwd(managerPwd);
		
		boolean mark = service.add(mager);
		if(mark){
			req.setAttribute("info", "管理员信息添加成功！");
		}else{
			req.setAttribute("info", "管理员信息添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
	}
}

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
		// 管理员编号
		String managerId = request.getParameter("managerId");

		ManagerInfo mager = service.getManager(managerId);
		//获取部门信息
		

		request.setAttribute("mager", mager);
		
		//跳转
		request.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_update.jsp").forward(request, resp);
	
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
			req.setAttribute("info", "管理员信息修改成功！");
		}else{
			req.setAttribute("info", "管理员信息修改失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
	}

}

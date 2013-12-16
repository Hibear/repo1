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
		//业务逻辑处理
		ManagerService service = new ManagerService();
		
		//获取页面信息
		String managerId = req.getParameter("managerId");
		
		boolean mark = service.delete(managerId);
		if(mark){
			req.setAttribute("info", "员工信息删除成功！");
		}else{
			req.setAttribute("info", "员工信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_info.jsp").forward(req, resp);
		
		
	}

}
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
 * <p>Description: 管理员信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 杨雄
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
		//业务逻辑处理
		ManagerService service = new ManagerService();
		//查询所有信息
		List<ManagerInfo> list = service.getAllManager();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_list.jsp").forward(req, resp);
		}
}

package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsClassInfo;
import com.sstore.service.system.goodsclass.GoodsClassService;


public class GoodsClassUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		GoodsClassService service = new GoodsClassService();
		// 管理员编号
		String classId = request.getParameter("classId");

		GoodsClassInfo mager = service.getGoodsClass(classId);
		//获取部门信息
	

		request.setAttribute("mager", mager);
		
		//跳转
		request.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		GoodsClassService service = new GoodsClassService();
		
		//获取页面信息
		String classId = req.getParameter("classId");
		String className = req.getParameter("className");
		
		GoodsClassInfo gopic = new GoodsClassInfo();
		
		gopic.setClassName(className);
		try {
			gopic.setClassId(Integer.parseInt(classId));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean mark = service.update(gopic);
		if(mark){
			req.setAttribute("info", "图片信息修改成功！");
		}else{
			req.setAttribute("info", "图片信息修改失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}

}
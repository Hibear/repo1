package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsClassInfo;
import com.sstore.service.system.goodsclass.GoodsClassService;

/**
 * <p>Title: GoodsClassAddServlet</p>
 * <p>Description: 商品类别信息添加的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 岳利
 * @version 1.0
 */

public class GoodsClassAddServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		GoodsClassService service = new GoodsClassService();
		
		//获取页面信息
		 
		String classId = req.getParameter( "classId" );
	 
		String className = req.getParameter("className");

		System.out.println("classId");
		
		GoodsClassInfo mager = new GoodsClassInfo();
		
		mager.setClassName(className);
		try {
			mager.setClassId(Integer.parseInt(classId));
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.add(mager);
		if(mark){
			req.setAttribute("info", "商品类别信息添加成功！");
		}else{
			req.setAttribute("info", "商品类别信息添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}
}


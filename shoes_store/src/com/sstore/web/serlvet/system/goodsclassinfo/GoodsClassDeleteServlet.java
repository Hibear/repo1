package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.goodsclass.GoodsClassService;

 
/**
 * <p>Title: GoodsClassAddServlet</p>
 * <p>Description: 商品类别信息删除的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 岳利
 * @version 1.0
 */


public class GoodsClassDeleteServlet  extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsClassService service = new GoodsClassService();
		
		//获取页面信息
		String classId = req.getParameter("classId");
		
		boolean mark = service.delete(classId);
		if(mark){
			req.setAttribute("info", "商品类别信息删除成功！");
		}else{
			req.setAttribute("info", "商品类别信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
		
		
	}

}

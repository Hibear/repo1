package com.sstore.web.serlvet.system.goodsinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.goods.GoodsinfoService;

public class GoodsinfoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsinfoService service = new GoodsinfoService();
		
		//获取页面信息
		String goodsId = req.getParameter("goodsId");
		
		boolean mark = service.delete(goodsId);
		if(mark){
			req.setAttribute("info", "商品信息删除成功！");
		}else{
			req.setAttribute("info", "商品信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_info.jsp").forward(req, resp);
		
		
	}
}

package com.sstore.web.serlvet.front.orderinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.order.OrderinfoService;

public class FOrderinfoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		OrderinfoService service = new OrderinfoService();
		
		//获取页面信息
		String orderId = req.getParameter("orderId");
		
		boolean mark = service.delete(orderId);
		if(mark){
			req.setAttribute("info", "订单信息删除成功！");
		}else{
			req.setAttribute("info", "订单信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/orderinfo/orderinfo_list.jsp").forward(req, resp);
		
		
	}
}

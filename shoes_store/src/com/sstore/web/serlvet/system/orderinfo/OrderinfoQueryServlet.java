package com.sstore.web.serlvet.system.orderinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.OrderInfo;
import com.sstore.service.system.order.OrderinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品订单信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class OrderinfoQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		OrderinfoService service = new OrderinfoService();
		//查询所有信息
		List<OrderInfo> list = service.getAllOrder();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_list.jsp").forward(req, resp);
	}
}

package com.sstore.web.serlvet.front.orderinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sstore.po.MyCartInfo;
import com.sstore.po.OrderInfo;
import com.sstore.po.UserInfo;
import com.sstore.service.system.order.OrderinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品订单信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class FOrderinfoQueryServlet extends HttpServlet{
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
		
		
		HttpSession session=req.getSession();
		UserInfo mager=(UserInfo)session.getAttribute("mager");
		int userId = mager.getUserId();
		List<OrderInfo> listtt = service.MyOrder(userId);

		
		String orderId = req.getParameter("orderId");
		
		System.out.println(orderId);
		
		//OrderInfo listt = service.getOrder(orderId);
		
		System.out.println(list.size());
		System.out.println(list.size());
		System.out.println(list.size());
		System.out.println(list.size());
		System.out.println(list.size());
		System.out.println(list.size());
		
		req.setAttribute("listtt", listtt);
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/orderinfo/orderinfo_list.jsp").forward(req, resp);
	}
}

package com.sstore.web.serlvet.system.orderinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.OrderInfo;
import com.sstore.service.system.order.OrderinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ������Ʒ�����Ų�ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class OrderinfoInquireServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		OrderinfoService service = new OrderinfoService();
		// ������
		
		String orderId = request.getParameter("orderId");
		OrderInfo order = service.getOrder(orderId);
		System.out.println(order.getOrderId());
		
		request.setAttribute("order", order);
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_list.jsp").forward(request, resp);
	
	}
}

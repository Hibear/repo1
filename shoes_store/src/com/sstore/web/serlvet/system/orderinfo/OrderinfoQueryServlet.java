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
 * <p>Description: ��Ʒ������Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
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
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		//��ѯ������Ϣ
		List<OrderInfo> list = service.getAllOrder();
		
		req.setAttribute("list", list);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_list.jsp").forward(req, resp);
	}
}

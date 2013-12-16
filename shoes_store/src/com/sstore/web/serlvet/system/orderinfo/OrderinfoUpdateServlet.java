package com.sstore.web.serlvet.system.orderinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.OrderInfo;
import com.sstore.service.system.order.OrderinfoService;

public class OrderinfoUpdateServlet extends HttpServlet{
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
		request.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		
		//��ȡҳ����Ϣ
		String orderId = req.getParameter("orderId");
		String userId = req.getParameter("userId");
		String orderUserRealName = req.getParameter("orderUserRealName");
		String orderUserAddress = req.getParameter("orderUserAddress");
		String orderUserPostCode = req.getParameter("orderUserPostCode");
		String orderUserPhone = req.getParameter("orderUserPhone");
		String orderUserEmail = req.getParameter("orderUserEmail");
		String orderGoodsSendType = req.getParameter("orderGoodsSendType");
		//String orderTime = req.getParameter("orderTime");
		String goodsPrice = req.getParameter("goodsPrice");
		String tranFee = req.getParameter("tranFee");
		String isConfirm = req.getParameter("isConfirm");
		
		
		OrderInfo order = new OrderInfo();
		
		order.setOrderUserRealName(orderUserRealName);
		order.setOrderUserAddress(orderUserAddress);	
		order.setOrderUserPhone(orderUserPhone);
		order.setOrderUserEmail(orderUserEmail);
		order.setOrderGoodsSendType(orderGoodsSendType);
		order.setIsConfirm(isConfirm);
		
		try {
			order.setOrderId(Integer.parseInt(orderId));
			order.setUserId(Integer.parseInt(userId));
			order.setOrderUserPostCode(Integer.parseInt(orderUserPostCode));
			order.setGoodsPrice(Float.parseFloat(goodsPrice));
			order.setTranFee(Float.parseFloat(tranFee));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.update(order);
		if(mark){
			req.setAttribute("info", "Ա����Ϣ�޸ĳɹ���");
		}else{
			req.setAttribute("info", "Ա����Ϣ�޸�ʧ�ܣ�");
		}
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_info.jsp").forward(req, resp);
	}
}

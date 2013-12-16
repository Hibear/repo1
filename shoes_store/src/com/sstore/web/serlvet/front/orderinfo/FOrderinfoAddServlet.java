package com.sstore.web.serlvet.front.orderinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sstore.po.OrderInfo;
import com.sstore.po.UserInfo;
import com.sstore.service.system.order.OrderinfoService;

public class FOrderinfoAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		//��ȡ������Ϣ
		List<OrderInfo> deList = service.getAllOrder();
		System.out.println(deList.size());
		req.setAttribute("deList", deList);
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/orderinfo/orderinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		
		HttpSession session=req.getSession();
		UserInfo mager=(UserInfo)session.getAttribute("mager");
		
		//��ȡҳ����Ϣ
		//String orderId = req.getParameter("orderId");
		String orderId = "12345";
		//String userId = req.getParameter("userId");
		int userId = mager.getUserId();
		String userName=mager.getUserName();
		//String orderUserRealName = req.getParameter("orderUserRealName");
		String orderUserAddress = req.getParameter("orderUserAddress");
		String orderUserPostCode = req.getParameter("orderUserPostCode");
		String orderUserPhone = req.getParameter("orderUserPhone");
		String orderUserEmail = req.getParameter("orderUserEmail");
		String orderGoodsSendType = req.getParameter("orderGoodsSendType");
		String orderTime = req.getParameter("orderTime");
		String goodsPrice = req.getParameter("goodsPrice");
		String tranFee = req.getParameter("tranFee");
		String isConfirm = req.getParameter("isConfirm");
		
		OrderInfo order = new OrderInfo();
		
		order.setOrderUserRealName(userName);
		order.setOrderUserAddress(orderUserAddress);
		order.setOrderUserPhone(orderUserPhone);
		order.setOrderUserEmail(orderUserEmail);
		order.setOrderGoodsSendType(orderGoodsSendType);
		
		order.setIsConfirm(isConfirm);
		
		try {
			order.setOrderId(Integer.parseInt(orderId));
			order.setUserId(userId);
			order.setOrderUserPostCode(Integer.parseInt(orderUserPostCode));
			order.setGoodsPrice(Float.parseFloat(goodsPrice));
			order.setTranFee(Float.parseFloat(tranFee));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session1 = req.getSession(true);
		session1.setAttribute("magerorderId", orderId);
		
		
		
		boolean mark = service.add(order);
		if(mark){
			req.setAttribute("info", "������Ϣ��ӳɹ���");
		}else{
			req.setAttribute("info", "������Ϣ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/orderinfo/orderinfo_info.jsp").forward(req, resp);
	}
}

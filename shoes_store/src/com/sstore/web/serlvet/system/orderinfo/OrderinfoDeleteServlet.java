package com.sstore.web.serlvet.system.orderinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.order.OrderinfoService;

public class OrderinfoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		
		//��ȡҳ����Ϣ
		String orderId = req.getParameter("orderId");
		
		boolean mark = service.delete(orderId);
		if(mark){
			req.setAttribute("info", "Ա����Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "Ա����Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/orderinfo/orderinfo_info.jsp").forward(req, resp);
		
		
	}
}

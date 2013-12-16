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
		//ҵ���߼�����
		OrderinfoService service = new OrderinfoService();
		
		//��ȡҳ����Ϣ
		String orderId = req.getParameter("orderId");
		
		boolean mark = service.delete(orderId);
		if(mark){
			req.setAttribute("info", "������Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "������Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/orderinfo/orderinfo_list.jsp").forward(req, resp);
		
		
	}
}

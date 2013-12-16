package com.sstore.web.serlvet.system.receiptinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.receipt.ReceiptinfoService;

public class ReceiptinfoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		ReceiptinfoService service = new ReceiptinfoService();
		
		//��ȡҳ����Ϣ
		String receiptId = req.getParameter("receiptId");
		
		boolean mark = service.delete(receiptId);
		if(mark){
			req.setAttribute("info", "��Ʒ������Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "��Ʒ������Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
		
		
	}
}

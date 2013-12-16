package com.sstore.web.serlvet.system.receiptinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ReceiptInfo;
import com.sstore.service.system.receipt.ReceiptinfoService;

public class ReceiptinfoUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		ReceiptinfoService service = new ReceiptinfoService();
		//��Ʒ��
		String receiptId = request.getParameter("receiptId");
		
		ReceiptInfo receipt = service.getReceipt(receiptId);
		
		request.setAttribute("receipt", receipt);
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		ReceiptinfoService service = new ReceiptinfoService();
		
		//��ȡҳ����Ϣ
		String receiptId = req.getParameter("receiptId");
		String receiptPrice = req.getParameter("receiptPrice");	
		
		ReceiptInfo receipt = new ReceiptInfo();
		try {
			receipt.setReceiptId(Integer.parseInt(receiptId));
			receipt.setReceiptPrice(Float.parseFloat(receiptPrice));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.update(receipt);
		if(mark){
			req.setAttribute("info", "��Ʒ������Ϣ�޸ĳɹ���");
		}else{
			req.setAttribute("info", "��Ʒ������Ϣ�޸�ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
	}
}

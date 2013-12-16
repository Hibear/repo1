package com.sstore.web.serlvet.system.receiptinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ReceiptInfo;
import com.sstore.service.system.receipt.ReceiptinfoService;

public class ReceiptinfoAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		ReceiptinfoService service = new ReceiptinfoService();
		//��ȡ��Ʒ�����Ϣ
		List<ReceiptInfo> deList = service.getAllReceipt();
		System.out.println(deList.size());
		req.setAttribute("deList", deList);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_add.jsp").forward(req, resp);
	
		
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
		
		
		boolean mark = service.add(receipt);
		if(mark){
			req.setAttribute("info", "������Ϣ��ӳɹ���");
		}else{
			req.setAttribute("info", "������Ϣ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
	}
}

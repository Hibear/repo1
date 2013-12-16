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
		//商品号
		String receiptId = request.getParameter("receiptId");
		
		ReceiptInfo receipt = service.getReceipt(receiptId);
		
		request.setAttribute("receipt", receipt);
		
		//跳转
		request.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		ReceiptinfoService service = new ReceiptinfoService();
		
		//获取页面信息
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
			req.setAttribute("info", "商品订单信息修改成功！");
		}else{
			req.setAttribute("info", "商品订单信息修改失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
	}
}

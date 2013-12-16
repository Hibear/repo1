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
		//业务逻辑处理
		ReceiptinfoService service = new ReceiptinfoService();
		//获取商品类表信息
		List<ReceiptInfo> deList = service.getAllReceipt();
		System.out.println(deList.size());
		req.setAttribute("deList", deList);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_add.jsp").forward(req, resp);
	
		
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
		
		
		boolean mark = service.add(receipt);
		if(mark){
			req.setAttribute("info", "进货信息添加成功！");
		}else{
			req.setAttribute("info", "进货信息添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
	}
}

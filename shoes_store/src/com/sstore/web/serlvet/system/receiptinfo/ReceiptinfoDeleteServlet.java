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
		//业务逻辑处理
		ReceiptinfoService service = new ReceiptinfoService();
		
		//获取页面信息
		String receiptId = req.getParameter("receiptId");
		
		boolean mark = service.delete(receiptId);
		if(mark){
			req.setAttribute("info", "商品进货信息删除成功！");
		}else{
			req.setAttribute("info", "商品进货信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_info.jsp").forward(req, resp);
		
		
	}
}

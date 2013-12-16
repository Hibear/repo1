package com.sstore.web.serlvet.system.receiptinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ReceiptInfo;
import com.sstore.service.system.receipt.ReceiptinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品进货信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class ReceiptinfoQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		ReceiptinfoService service = new ReceiptinfoService();
		//查询所有信息
		List<ReceiptInfo> list = service.getAllReceipt();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/receiptinfo/receiptinfo_list.jsp").forward(req, resp);
	}
}

package com.sstore.web.serlvet.system.goodsinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsInfo;
import com.sstore.service.system.goods.GoodsinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class GoodsinfoQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsinfoService service = new GoodsinfoService();
		//查询所有信息
		List<GoodsInfo> list = service.getAllGoods();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_list.jsp").forward(req, resp);
	}
}

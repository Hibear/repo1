package com.sstore.web.serlvet.system.shoppingcartinfo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.ShoppingcartInfo;
import com.sstore.service.system.shoppingcart.ShoppingcartService;

/**
 * <p>Title: ShoppingcartQueryServlet</p>
 * <p>Description: 购物车信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 汪洪梅
 * @version 1.0
 */
public class ShoppingcartQueryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doPost(req,resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		ShoppingcartService service = new ShoppingcartService();
		//查询所有信息
		List<ShoppingcartInfo> list = service.getAllShoppingcart();
		
		req.setAttribute("list", list);
		System.out.println(list.size());
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/shoppingcartinfo/shoppingcartinfo_list.jsp").forward(req, resp);
		}
}

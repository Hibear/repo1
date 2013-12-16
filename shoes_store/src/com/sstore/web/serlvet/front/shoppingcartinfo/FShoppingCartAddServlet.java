package com.sstore.web.serlvet.front.shoppingcartinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.sstore.po.ShoppingcartInfo;
import com.sstore.service.system.shoppingcart.ShoppingcartService;

public class FShoppingCartAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		/*ManagerService service = new ManagerService();
		//获取管理员信息
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		ShoppingcartService service = new ShoppingcartService();
		
		//获取页面信息
		String userId = req.getParameter("userId");
		String goodsId = req.getParameter("goodsId");
		String goodsNumber = req.getParameter("goodsNumber");
		
		System.out.println(userId);
		System.out.println(goodsId+"    "+"wuyu");
		System.out.println(goodsNumber);
		
		ShoppingcartInfo shopcart = new ShoppingcartInfo();
		try{
			shopcart.setGoodsId(Integer.parseInt(goodsId));
			shopcart.setGoodsNumber(Integer.parseInt(goodsNumber));
			shopcart.setUserId(Integer.parseInt(userId));
		}catch(Exception e){
			e.getStackTrace();
		}
		
		boolean mark1 = service.addUserId(shopcart);
		boolean mark2 = service.addGoodsId(shopcart);
		
		if(mark1){
			req.setAttribute("info", "购物车添加成功！");
		}else{
			req.setAttribute("info", "购物车添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/shoppingcartinfo/shoppingcartinfo_info.jsp").forward(req, resp);
	}
}

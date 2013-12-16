package com.sstore.web.serlvet.front.shoppingcartinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sstore.po.GoodsInfo;
import com.sstore.po.ManagerInfo;
import com.sstore.po.MyCartInfo;
import com.sstore.po.ShoppingcartInfo;
import com.sstore.po.UserInfo;
import com.sstore.service.system.shoppingcart.ShoppingcartService;

public class FShoppingCartQueryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		   doPost(req,resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
			try{
				req.setCharacterEncoding("utf-8");
				ShoppingcartService service = new ShoppingcartService();
				
				HttpSession session=req.getSession();
				UserInfo mager=(UserInfo)session.getAttribute("mager");
				int userId = mager.getUserId();
				System.out.println(userId);
				List<MyCartInfo> list = service.Mycart(userId);
				
				req.setAttribute("list", list);
				System.out.println(list.size());
				//跳转
				req.getRequestDispatcher("/front-stage/view/front/shoppingcartinfo/shoppingcartinfo_list.jsp").forward(req, resp);
		
			}catch(Exception e){
				req.getRequestDispatcher("/front-stage/view/front/shoppingcartinfo/shoppingcartinfo_list.jsp").forward(req, resp);
			}
		}
}
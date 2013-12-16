package com.sstore.web.serlvet.front.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.po.MyCartInfo;
import com.sstore.po.UserInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;
import com.sstore.service.system.shoppingcart.ShoppingcartService;
import com.sstore.service.system.user.UserService;

public class FUserClearServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		   doPost(req,resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			try{
				//业务逻辑处理
				UserService service3 = new UserService();
				GoodsPictureService service2 = new GoodsPictureService();
				//查询所有信息
				List<GoodsPictureInfo> list2 = service2.getAllGoodsPicture();
				
				System.out.println(list2.size());
				
				List lt1 = new ArrayList();
				lt1.add(list2.get(2));
				lt1.add(list2.get(2));
				lt1.add(list2.get(2));
				lt1.add(list2.get(2));
				
				
				List lt2 = new ArrayList();
				lt2.add(list2.get(3));
				lt2.add(list2.get(3));
				lt2.add(list2.get(3));
				lt2.add(list2.get(3));
				/*for(GoodsPictureInfo l:list){
					System.out.println("name:"+l.getPictureUrl());
				}*/
				req.setAttribute("list2", lt1);
				
				req.setAttribute("lists", lt2);
				
				System.out.println(list2.size());
				
			//业务逻辑处理
				
				req.setCharacterEncoding("utf-8");
				ShoppingcartService service = new ShoppingcartService();
				
				HttpSession session=req.getSession();
				UserInfo mager=(UserInfo)session.getAttribute("mager");
				session.invalidate();
				//跳转
				req.getRequestDispatcher("/front-stage/view/front/index.jsp").forward(req, resp);
		
			}catch(Exception e){
				req.getRequestDispatcher("/front-stage/view/front/index.jsp").forward(req, resp);
			}
		}
}
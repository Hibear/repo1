package com.sstore.web.serlvet.front.goodspictureinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;
import com.sstore.service.system.user.UserService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 商品图片时尚女鞋信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 刘钊
 * @version 1.0
 */
public class FFashionshoesQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		//业务逻辑处理
		GoodsPictureService service = new GoodsPictureService();
		//查询所有信息
		List<GoodsPictureInfo> list = service.getAllGoodsPicture();
		
		System.out.println(list.size());
		
		List l = new ArrayList();
		l.add(list.get(30));
		l.add(list.get(31));
		l.add(list.get(32));
		
		
		List ltw = new ArrayList();
		ltw.add(list.get(27));
		ltw.add(list.get(28));
		ltw.add(list.get(29));
		
		List lthr = new ArrayList();
		lthr.add(list.get(24));
		lthr.add(list.get(25));
		lthr.add(list.get(26));
		
		
		
		for(GoodsPictureInfo p:list){
			System.out.println("name:"+p.getPictureUrl());
		}
		req.setAttribute("list", l);
		
		req.setAttribute("listtw", ltw);
		
		req.setAttribute("listthr", lthr);
		
		req.getRequestDispatcher("/front-stage/view/front/femailshoesinfo/femailshoes_list.jsp").forward(req, resp);
	}
}

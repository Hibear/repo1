package com.sstore.web.serlvet.front.goodspictureinfo;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;


/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 商品图片信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 杨雄
 * @version 1.0
 */

public class FGoodsPictureQueryServlet  extends HttpServlet {
	
	
	
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
		
		List lt1 = new ArrayList();
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		
		
		List lt2 = new ArrayList();
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		/*for(GoodsPictureInfo l:list){
			System.out.println("name:"+l.getPictureUrl());
		}*/
		req.setAttribute("list", lt1);
		
		req.setAttribute("lists", lt2);
		req.getRequestDispatcher("/front-stage/index.jsp").forward(req, resp);
	}
	
	
	

}
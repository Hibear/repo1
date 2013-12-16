package com.sstore.web.serlvet.front.brandinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 品牌馆商品图片信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 杨雄
 * @version 1.0
 */

public class FBrandQueryServlet  extends HttpServlet {
	
	
	
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
		
		List lthotf = new ArrayList();
		lthotf.add(list.get(38));
		
		List lthotm = new ArrayList();
		lthotm.add(list.get(37));
		
		List lthoto = new ArrayList();
		lthoto.add(list.get(39));
		
		List lt1 = new ArrayList();
		lt1.add(list.get(44));
		lt1.add(list.get(45));
	
		List lt2 = new ArrayList();
		lt2.add(list.get(46));
		lt2.add(list.get(47));
		
		List ltL = new ArrayList();
		ltL.add(list.get(42));
		
		List ltN = new ArrayList();
		ltN.add(list.get(43));
		
		List ltH = new ArrayList();
		ltH.add(list.get(44));
		
		List ltA = new ArrayList();
		ltA.add(list.get(41));
		
		List ltB = new ArrayList();
		ltB.add(list.get(4));
		
		List ltM = new ArrayList();
		ltM.add(list.get(36));
		
		/*for(GoodsPictureInfo l:list){
			System.out.println("name:"+l.getPictureUrl());
		}*/
		req.setAttribute("listf", lthotf);
		req.setAttribute("listm", lthotm);
		req.setAttribute("listo", lthoto);
		req.setAttribute("list", lt1);
		req.setAttribute("listL", ltL);
		req.setAttribute("listN", ltN);
		req.setAttribute("listH", ltH);
		req.setAttribute("listA", ltA);
		req.setAttribute("listB", ltB);
		req.setAttribute("listM", ltM);
		req.setAttribute("lists", lt2);
		req.getRequestDispatcher("/front-stage/view/front/brandinfo/brandinfo_list.jsp").forward(req, resp);
	}
	
	
	

}
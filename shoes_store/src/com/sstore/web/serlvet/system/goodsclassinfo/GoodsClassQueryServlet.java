package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import com.sstore.po.GoodsClassInfo;
import com.sstore.service.system.goodsclass.GoodsClassService;


/**
 * <p>Title: GoodsClassAddServlet</p>
 * <p>Description: 商品类别信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 岳利
 * @version 1.0
 */

public class GoodsClassQueryServlet  extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsClassService service = new GoodsClassService();
		//查询所有信息
		List<GoodsClassInfo> list = service.getAllGoodsClass();
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_list.jsp").forward(req, resp);
	}
	
	
	

}

package com.sstore.web.serlvet.system.goodspictureinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;
import com.sstore.service.system.manager.ManagerService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: 商品图片信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: 中软国际</p>
 * @author 杨雄
 * @version 1.0
 */

public class GoodsPictureQueryServlet extends HttpServlet{
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
		
		req.setAttribute("list", list);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_list.jsp").forward(req, resp);
		}
}
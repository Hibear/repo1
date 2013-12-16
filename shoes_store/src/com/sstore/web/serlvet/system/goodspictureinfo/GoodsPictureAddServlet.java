package com.sstore.web.serlvet.system.goodspictureinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;


public class GoodsPictureAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		/*ManagerService service = new ManagerService();
		//获取管理员信息
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		GoodsPictureService service = new GoodsPictureService();
		
		//获取页面信息
		String goodsId = req.getParameter("goodsId");
		String pictureName = req.getParameter("pictureName");
		String pictureUrl = req.getParameter("pictureUrl");
		
		GoodsPictureInfo gopic = new GoodsPictureInfo();
		gopic.setGoodsId(Integer.parseInt(goodsId));
		gopic.setPictureName(pictureName);
		gopic.setPictureUrl(pictureUrl);
		
		boolean mark = service.add(gopic);
		if(mark){
			req.setAttribute("info", "图片添加成功！");
		}else{
			req.setAttribute("info", "图片添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_info.jsp").forward(req, resp);
	}
}

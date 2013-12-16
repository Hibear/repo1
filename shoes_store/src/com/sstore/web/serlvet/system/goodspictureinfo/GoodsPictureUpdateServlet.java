package com.sstore.web.serlvet.system.goodspictureinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;





public class GoodsPictureUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		GoodsPictureService service = new GoodsPictureService();
		// 管理员编号
		String pictureId = request.getParameter("pictureId");

		GoodsPictureInfo mager = service.getGoodsPicture(pictureId);
		//获取部门信息
	

		request.setAttribute("mager", mager);
		
		//跳转
		request.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		GoodsPictureService service = new GoodsPictureService();
		
		//获取页面信息
		String pictureId = req.getParameter("pictureId");
		String goodsId = req.getParameter("goodsId");
		String pictureName = req.getParameter("pictureName");
		String managerUrl = req.getParameter("managerUrl");
		
		GoodsPictureInfo gopic = new GoodsPictureInfo();
		
		gopic.setPictureName(pictureName);
		gopic.setPictureUrl(managerUrl);
		try {
			gopic.setPictureId(Integer.parseInt(pictureId));
			gopic.setGoodsId(Integer.parseInt(goodsId));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.update(gopic);
		if(mark){
			req.setAttribute("info", "类别修改成功！");
		}else{
			req.setAttribute("info", "类别修改失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}

}

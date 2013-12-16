package com.sstore.web.serlvet.system.goodspictureinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.goodspicture.GoodsPictureService;



public class GoodsPictureDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsPictureService service = new GoodsPictureService();
		
		//获取页面信息
		String pictureId = req.getParameter("pictureId");
		
		boolean mark = service.delete(pictureId);
		if(mark){
			req.setAttribute("info", "图片信息删除成功！");
		}else{
			req.setAttribute("info", "图片信息删除失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_info.jsp").forward(req, resp);
		
		
	}

}
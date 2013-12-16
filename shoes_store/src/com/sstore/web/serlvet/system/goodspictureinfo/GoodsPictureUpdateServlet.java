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
		// ����Ա���
		String pictureId = request.getParameter("pictureId");

		GoodsPictureInfo mager = service.getGoodsPicture(pictureId);
		//��ȡ������Ϣ
	

		request.setAttribute("mager", mager);
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		GoodsPictureService service = new GoodsPictureService();
		
		//��ȡҳ����Ϣ
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
			req.setAttribute("info", "����޸ĳɹ���");
		}else{
			req.setAttribute("info", "����޸�ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}

}

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
		//ҵ���߼�����
		/*ManagerService service = new ManagerService();
		//��ȡ����Ա��Ϣ
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		GoodsPictureService service = new GoodsPictureService();
		
		//��ȡҳ����Ϣ
		String goodsId = req.getParameter("goodsId");
		String pictureName = req.getParameter("pictureName");
		String pictureUrl = req.getParameter("pictureUrl");
		
		GoodsPictureInfo gopic = new GoodsPictureInfo();
		gopic.setGoodsId(Integer.parseInt(goodsId));
		gopic.setPictureName(pictureName);
		gopic.setPictureUrl(pictureUrl);
		
		boolean mark = service.add(gopic);
		if(mark){
			req.setAttribute("info", "ͼƬ��ӳɹ���");
		}else{
			req.setAttribute("info", "ͼƬ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_info.jsp").forward(req, resp);
	}
}

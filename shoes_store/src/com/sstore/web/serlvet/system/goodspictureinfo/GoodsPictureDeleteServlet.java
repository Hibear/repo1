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
		//ҵ���߼�����
		GoodsPictureService service = new GoodsPictureService();
		
		//��ȡҳ����Ϣ
		String pictureId = req.getParameter("pictureId");
		
		boolean mark = service.delete(pictureId);
		if(mark){
			req.setAttribute("info", "ͼƬ��Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "ͼƬ��Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodspictureinfo/goodspictureinfo_info.jsp").forward(req, resp);
		
		
	}

}
package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsClassInfo;
import com.sstore.service.system.goodsclass.GoodsClassService;


public class GoodsClassUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		GoodsClassService service = new GoodsClassService();
		// ����Ա���
		String classId = request.getParameter("classId");

		GoodsClassInfo mager = service.getGoodsClass(classId);
		//��ȡ������Ϣ
	

		request.setAttribute("mager", mager);
		
		//��ת
		request.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_update.jsp").forward(request, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		GoodsClassService service = new GoodsClassService();
		
		//��ȡҳ����Ϣ
		String classId = req.getParameter("classId");
		String className = req.getParameter("className");
		
		GoodsClassInfo gopic = new GoodsClassInfo();
		
		gopic.setClassName(className);
		try {
			gopic.setClassId(Integer.parseInt(classId));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean mark = service.update(gopic);
		if(mark){
			req.setAttribute("info", "ͼƬ��Ϣ�޸ĳɹ���");
		}else{
			req.setAttribute("info", "ͼƬ��Ϣ�޸�ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}

}
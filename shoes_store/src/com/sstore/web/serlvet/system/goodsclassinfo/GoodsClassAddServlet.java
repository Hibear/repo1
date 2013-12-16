package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsClassInfo;
import com.sstore.service.system.goodsclass.GoodsClassService;

/**
 * <p>Title: GoodsClassAddServlet</p>
 * <p>Description: ��Ʒ�����Ϣ��ӵ�servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */

public class GoodsClassAddServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		GoodsClassService service = new GoodsClassService();
		
		//��ȡҳ����Ϣ
		 
		String classId = req.getParameter( "classId" );
	 
		String className = req.getParameter("className");

		System.out.println("classId");
		
		GoodsClassInfo mager = new GoodsClassInfo();
		
		mager.setClassName(className);
		try {
			mager.setClassId(Integer.parseInt(classId));
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.add(mager);
		if(mark){
			req.setAttribute("info", "��Ʒ�����Ϣ��ӳɹ���");
		}else{
			req.setAttribute("info", "��Ʒ�����Ϣ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
	}
}


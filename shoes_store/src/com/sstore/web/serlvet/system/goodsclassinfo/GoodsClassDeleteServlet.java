package com.sstore.web.serlvet.system.goodsclassinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.goodsclass.GoodsClassService;

 
/**
 * <p>Title: GoodsClassAddServlet</p>
 * <p>Description: ��Ʒ�����Ϣɾ����servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */


public class GoodsClassDeleteServlet  extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		GoodsClassService service = new GoodsClassService();
		
		//��ȡҳ����Ϣ
		String classId = req.getParameter("classId");
		
		boolean mark = service.delete(classId);
		if(mark){
			req.setAttribute("info", "��Ʒ�����Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "��Ʒ�����Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsclassinfo/goodsclassinfo_info.jsp").forward(req, resp);
		
		
	}

}

package com.sstore.web.serlvet.system.goodsinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.service.system.goods.GoodsinfoService;

public class GoodsinfoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		GoodsinfoService service = new GoodsinfoService();
		
		//��ȡҳ����Ϣ
		String goodsId = req.getParameter("goodsId");
		
		boolean mark = service.delete(goodsId);
		if(mark){
			req.setAttribute("info", "��Ʒ��Ϣɾ���ɹ���");
		}else{
			req.setAttribute("info", "��Ʒ��Ϣɾ��ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_info.jsp").forward(req, resp);
		
		
	}
}

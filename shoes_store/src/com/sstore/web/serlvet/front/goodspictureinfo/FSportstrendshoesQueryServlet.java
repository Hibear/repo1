package com.sstore.web.serlvet.front.goodspictureinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;

/**
 * <p>Title: UserQuerySerlvet</p>
 * <p>Description: ��ƷͼƬ�˶�������Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: �������</p>
 * @author ����
 * @version 1.0
 */
public class FSportstrendshoesQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		//ҵ���߼�����
		GoodsPictureService service = new GoodsPictureService();
		//��ѯ������Ϣ
		List<GoodsPictureInfo> list = service.getAllGoodsPicture();
		
		System.out.println(list.size());
		
		List ll = new ArrayList();
		ll.add(list.get(8));
		ll.add(list.get(7));
		ll.add(list.get(6));
		
		
		List lltw = new ArrayList();
		lltw.add(list.get(3));
		lltw.add(list.get(4));
		lltw.add(list.get(5));
		
		List llthr = new ArrayList();
		llthr.add(list.get(12));
		llthr.add(list.get(13));
		llthr.add(list.get(14));
		
		
		
		for(GoodsPictureInfo p:list){
			System.out.println("name:"+p.getPictureUrl());
		}
		
		
		req.setAttribute("listll", ll);
		
		req.setAttribute("listlltw", lltw);
		
		req.setAttribute("listllthr", llthr);
		
		req.getRequestDispatcher("/front-stage/view/front/sportstrendinfo/sportstrendshoes_list.jsp").forward(req, resp);
	}
}

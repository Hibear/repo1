package com.sstore.web.serlvet.system.goodsinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsInfo;
import com.sstore.service.system.goods.GoodsinfoService;

/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ��Ʒ��Ϣ��ѯ��servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class GoodsinfoQueryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		GoodsinfoService service = new GoodsinfoService();
		//��ѯ������Ϣ
		List<GoodsInfo> list = service.getAllGoods();
		
		req.setAttribute("list", list);
		//��ת
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_list.jsp").forward(req, resp);
	}
}

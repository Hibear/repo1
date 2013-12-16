package com.sstore.web.serlvet.front.shoppingcartinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.sstore.po.ShoppingcartInfo;
import com.sstore.service.system.shoppingcart.ShoppingcartService;

public class FShoppingCartAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ҵ���߼�����
		/*ManagerService service = new ManagerService();
		//��ȡ����Ա��Ϣ
		List<ManagerInfo> magerList = service.getAllManager();
		System.out.println(magerList.size());*/
		
		req.getRequestDispatcher("/back-stage/view/system/managerinfo/managerinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������룺ֻ��doPost ��doGet��Ч
		req.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		ShoppingcartService service = new ShoppingcartService();
		
		//��ȡҳ����Ϣ
		String userId = req.getParameter("userId");
		String goodsId = req.getParameter("goodsId");
		String goodsNumber = req.getParameter("goodsNumber");
		
		System.out.println(userId);
		System.out.println(goodsId+"    "+"wuyu");
		System.out.println(goodsNumber);
		
		ShoppingcartInfo shopcart = new ShoppingcartInfo();
		try{
			shopcart.setGoodsId(Integer.parseInt(goodsId));
			shopcart.setGoodsNumber(Integer.parseInt(goodsNumber));
			shopcart.setUserId(Integer.parseInt(userId));
		}catch(Exception e){
			e.getStackTrace();
		}
		
		boolean mark1 = service.addUserId(shopcart);
		boolean mark2 = service.addGoodsId(shopcart);
		
		if(mark1){
			req.setAttribute("info", "���ﳵ��ӳɹ���");
		}else{
			req.setAttribute("info", "���ﳵ���ʧ�ܣ�");
		}
		
		//��ת
		req.getRequestDispatcher("/front-stage/view/front/shoppingcartinfo/shoppingcartinfo_info.jsp").forward(req, resp);
	}
}

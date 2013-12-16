package com.sstore.web.serlvet.system.goodsinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsClassInfo;
import com.sstore.po.GoodsInfo;
import com.sstore.service.system.goods.GoodsinfoService;

public class GoodsinfoAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//业务逻辑处理
		GoodsinfoService service = new GoodsinfoService();
		//获取商品类表信息
		List<GoodsClassInfo> deList = service.getAllGoodsClassInfo();
		System.out.println(deList.size());
		req.setAttribute("deList", deList);
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_add.jsp").forward(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		//业务逻辑处理
		GoodsinfoService service = new GoodsinfoService();
		
		//获取页面信息	
		String goodsId = req.getParameter("goodsId");
		String classId = req.getParameter("classId");
		String goodsTypeCode = req.getParameter("goodsTypeCode");
		String goodsName = req.getParameter("goodsName");
		String goodsKeys = req.getParameter("goodsKeys");
		String goodsText = req.getParameter("goodsText");
		String goodsPt = req.getParameter("goodsPt");
		String goodsPriceShop = req.getParameter("goodsPriceShop");
		String goodsPriceUser = req.getParameter("goodsPriceUser");
		String goodsIsNew = req.getParameter("goodsIsNew");
		String isRecommend = req.getParameter("isRecommend");
		String goodsBuyNumber = req.getParameter("goodsBuyNumber");
		String isCheap = req.getParameter("isCheap");
		
		GoodsInfo goods = new GoodsInfo();
		
		goods.setGoodsTypeCode(goodsTypeCode);
		goods.setGoodsName(goodsName);
		goods.setGoodsKeys(goodsKeys);
		goods.setGoodsText(goodsText);
		goods.setGoodsPt(goodsPt);
		
		goods.setGoodsIsNew(goodsIsNew);
		goods.setIsRecommend(isRecommend);
		
		goods.setIsCheap(isCheap);	
		try {
			goods.setGoodsId(Integer.parseInt(goodsId));
			goods.setClassId(Integer.parseInt(classId));
			goods.setGoodsPriceShop(Float.parseFloat(goodsPriceShop));
			goods.setGoodsPriceUser(Float.parseFloat(goodsPriceUser));
			goods.setGoodsBuyNumber(Integer.parseInt(goodsBuyNumber));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean mark = service.add(goods);
		if(mark){
			req.setAttribute("info", "员工信息添加成功！");
		}else{
			req.setAttribute("info", "员工信息添加失败！");
		}
		
		//跳转
		req.getRequestDispatcher("/back-stage/view/system/goodsinfo/goodsinfo_info.jsp").forward(req, resp);
	}
}

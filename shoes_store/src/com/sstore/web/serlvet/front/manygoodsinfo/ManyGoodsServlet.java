package com.sstore.web.serlvet.front.manygoodsinfo;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;
import com.sstore.po.GoodsInfo;
import com.sstore.service.system.goods.GoodsinfoService;

/**
 * <p>Title: ManyGoodsServlet</p>
 * <p>Description: 商品信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 杨雄
 * @version 1.0
 */
public class ManyGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*//业务逻辑处理
		GoodsinfoService service = new GoodsinfoService();
		//查询所有信息
		List<GoodsInfo> list = service.getAllGoods();
		
		req.setAttribute("list", list);*/
		
		//获取页面信息,获取类别信息
		String goodsId  = req.getParameter("goodsId");
		System.out.println(goodsId);
		GoodsinfoService goodsinfoservice = new GoodsinfoService();
		GoodsInfo goodsInfo = goodsinfoservice.getGoods(goodsId);
		req.setAttribute("goodsInfo", goodsInfo);
		GoodsPictureService goodspictureinfoservice = new GoodsPictureService();
		List<GoodsPictureInfo> ll = goodspictureinfoservice.getAllGoodsPicture();
		List llcha = new ArrayList();
		llcha.add(ll.get(32));
		req.setAttribute("goodspictureinfo", llcha);
		
		
		String goodsIds="224";
		System.out.println(goodsIds);

		GoodsInfo goodsInfot = goodsinfoservice.getGoods(goodsIds);
		req.setAttribute("goodsInfot", goodsInfot);

		List<GoodsPictureInfo> llt = goodspictureinfoservice.getAllGoodsPicture();
		List llchat = new ArrayList();
		llchat.add(llt.get(31));
		req.setAttribute("goodspictureinfot", llchat);
		
		
		String goodsIdst="223";
		System.out.println(goodsIdst);

		GoodsInfo goodsInfott = goodsinfoservice.getGoods(goodsIdst);
		req.setAttribute("goodsInfott", goodsInfott);

		List<GoodsPictureInfo> lltt = goodspictureinfoservice.getAllGoodsPicture();
		List llchatt = new ArrayList();
		llchatt.add(lltt.get(30));
		req.setAttribute("goodspictureinfott", llchatt);
		
		
		
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/manygoodsinfo/manygoodsinfo_list.jsp").forward(req, resp);
	}
}

package com.sstore.web.serlvet.front.departgoodsinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sstore.po.CommentsInfo;
import com.sstore.po.GoodsInfo;
import com.sstore.po.GoodsPictureInfo;
import com.sstore.service.system.comments.CommentsService;
import com.sstore.service.system.goods.GoodsinfoService;
import com.sstore.service.system.goodspicture.GoodsPictureService;




/**
 * <p>Title: DepartGoodsServlet</p>
 * <p>Description: 商品信息信息查询的servlet</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 杨雄
 * @version 1.0
 */
public class DepartGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String pictureId  = req.getParameter("pictureId");
		System.out.println(pictureId);
		GoodsPictureService goodspictureinfoservice = new GoodsPictureService();
		GoodsPictureInfo goodspictureinfo = goodspictureinfoservice.getGoodsPicture(pictureId);
		req.setAttribute("goodspictureinfo", goodspictureinfo);
		
		int picturegoodsId = goodspictureinfo.getGoodsId();
		GoodsinfoService goodsinfoservice = new GoodsinfoService();
		GoodsInfo goodsInfo = goodsinfoservice.getGoods(picturegoodsId);
		req.setAttribute("goodsInfo", goodsInfo);
		
		
		int googoodsId = goodsInfo.getGoodsId();
		System.out.println(googoodsId);
		CommentsService commentsservice = new CommentsService();
		List<CommentsInfo> commentsinfo = commentsservice.getAllComments();
		req.setAttribute("commentsinfo", commentsinfo);
		
		
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/goodsdetailinfo/goodsdetail.jsp").forward(req, resp);
	}
}

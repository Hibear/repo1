package com.sstore.web.serlvet.system.commentsinfo;

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

public class CommentsAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码：只在doPost 在doGet无效
		req.setCharacterEncoding("utf-8");
		
		CommentsService service = new CommentsService();
		
		//获取页面信息
		String pictureId = req.getParameter("pictureId");
		System.out.println(pictureId);
		
		
		String userId = req.getParameter("userId");
		String googoodsId = req.getParameter("googoodsId");
		String goodsId = req.getParameter("goodsId");
		String reviewText = req.getParameter("reviewText");
		
		CommentsInfo commentsinfo = new CommentsInfo();
		
		
		
		commentsinfo.setReviewText(reviewText);
		
		try {
			commentsinfo.setUserId(Integer.parseInt(userId));
			commentsinfo.setGoogoodsId(Integer.parseInt(googoodsId));
			commentsinfo.setGoodsId(Integer.parseInt(goodsId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean mark = service.add(commentsinfo);
		if(mark){
			System.out.println("评论成功");
		}else{
			System.out.println("评论失败");
		}
		
		
		

		

		GoodsPictureService goodspictureinfoservice = new GoodsPictureService();
		GoodsPictureInfo goodspictureinfo = goodspictureinfoservice.getGoodsPicture(pictureId);
		req.setAttribute("goodspictureinfo", goodspictureinfo);
		
		int picturegoodsId = goodspictureinfo.getGoodsId();
		System.out.println(picturegoodsId);
		GoodsinfoService goodsinfoservice = new GoodsinfoService();
		GoodsInfo goodsInfo = goodsinfoservice.getGoods(picturegoodsId);
		req.setAttribute("goodsInfo", goodsInfo);
		
		int googoodsIdss = goodsInfo.getGoodsId();
		System.out.println(googoodsIdss);
		CommentsService commentsservice = new CommentsService();
		List<CommentsInfo> commentsinfoss = commentsservice.getAllComments();
		req.setAttribute("commentsinfo", commentsinfoss);
		
		
		
	
		//跳转
		req.getRequestDispatcher("/front-stage/view/front/goodsdetailinfo/goodsdetail.jsp").forward(req, resp);
	}
}

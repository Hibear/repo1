package com.sstore.web.serlvet.front.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sstore.po.GoodsPictureInfo;
import com.sstore.po.UserInfo;
import com.sstore.service.system.goodspicture.GoodsPictureService;
import com.sstore.service.system.user.UserService;

public class FUserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
/*
		ManagerService service = new ManagerService();
		// ����Ա���
		String managerId = request.getParameter("managerId");

		ManagerInfo mager = service.getManager(managerId);
		//��ȡ������Ϣ
		

		request.setAttribute("mager", mager);*/
		
		//��ת
		request.getRequestDispatcher("/front-stage/view/front/userlogininfo/userlogininfo_info.jsp").forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//ҵ���߼�����
		UserService service = new UserService();
		GoodsPictureService service2 = new GoodsPictureService();
		//��ѯ������Ϣ
		List<GoodsPictureInfo> list = service2.getAllGoodsPicture();
		
		System.out.println(list.size());
		
		List lt1 = new ArrayList();
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		lt1.add(list.get(2));
		
		
		List lt2 = new ArrayList();
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		lt2.add(list.get(3));
		/*for(GoodsPictureInfo l:list){
			System.out.println("name:"+l.getPictureUrl());
		}*/
		request.setAttribute("list", lt1);
		
		request.setAttribute("lists", lt2);
		
		System.out.println(list.size());
		
		
		
		//��ȡҳ����Ϣ
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		try{
			UserInfo mager = service.getUserN(userName);
			mager.setUserName(userName);
			System.out.println(mager.getUserName());
			if(mager.getUserPwd().equals(userPwd)){
			//��ת
				HttpSession session = request.getSession(true);
				session.setAttribute("mager", mager); 
				/*request.setAttribute("mager", mager);*/
				request.getRequestDispatcher("/front-stage/view/front/index.jsp").forward(request, resp);
				//request.getRequestDispatcher("/index.jsp").forward(request, resp);
			}else{
				request.setAttribute("info", "��¼ʧ�ܣ�");
				request.getRequestDispatcher("/index.jsp").forward(request, resp);
			}
		}catch(Exception e){
			request.setAttribute("info", "��¼ʧ�ܣ�");
			request.getRequestDispatcher("/front-stage/view/front/signininfo/usersignininfo_info.jsp").forward(request, resp);
		}finally{
		}
	}
}

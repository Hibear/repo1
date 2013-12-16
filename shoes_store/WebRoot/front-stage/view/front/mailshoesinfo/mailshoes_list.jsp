<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mailshoes_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="front-stage/css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
<body>
<div id="wrapper">
 	<div class="headerzone">
    <div class="header">
      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:20px;" value="请输入查找项" /></div><div id="headerText2"><img src="front-stage/img/h1.png" border="0" /></div>
      </div>
      <div class="phone"> <input type="text" value="${sessionScope.mager.userName}" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>欢迎来到合鞋！
        <div class="email"> <a href="<%=basePath%>sys/FUserLoginServlet">登录</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>sys/FUserSignInServlet">注册</a><input type="hidden" value="${sessionScope.mager.userId}" name="userId" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/></div>
      </div>
    </div>
    <div class="clear"></div>
    <div class="topmenu">
       <ul>
        <li ><a href="<%=basePath%>sys/FGoodsPictureQueryServlet">首页</a></li>
        <li><a href="<%=basePath%>sys/FBrandQueryServlet">品牌馆</a></li>
        <li><a href="<%=basePath%>sys/FFashionshoesQueryServlet">时尚女鞋</a></li>
        <li><a href="<%=basePath%>sys/FMenfashionshoesQueryServlet">时尚男鞋</a></li>
        <li><a href="<%=basePath%>sys/FSportstrendshoesQueryServlet">运动潮流</a></li>
        <li style="border:none;"><a href="<%=basePath%>sys/FShoppingCartQueryServlet">购物车</a></li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
  
  <div class="workZone">
    <div class="midBox">
      <div class="topBox">
        <div class="bottomBox">
          <div class="leftBox">
            <div class="box1">
              <h1>季度热销款式</h1>
			  <div class="whiteText">潮流人字拖</div>
              <div class="cdBox"><a href="Goos001.html"><img  src="front-stage/img/18.png" width="150" height="113"/></a></div>
			  
            
              <div class="clear"></div>
            </div>
			<div class="box1">
              <h1>每月热销款式</h1>
			  <div class="whiteText">潮男帆布鞋</div>
			  <div class="cdBox"><a href="Goos001.html"><img src="front-stage/img/17.png" width="150" height="113"/></a></div>
			  
            
              <div class="clear"></div>
            </div>
			<div class="box1">
              <h1>每周热销款式</h1>
			  <div class="whiteText"> 运动必备</div>
              <div class="cdBox"><a href="Goos001.html"><img src="front-stage/img/16.png" width="150" height="113"/></a></div>
			  
            
              <div class="clear"></div>
            </div>
            <div class="clear"></div>
          </div>
          <div class="workZoneRight">
            <div class="rightBox inner">
              <div style="padding:0px 15px 20px 15px;">
                <h1 class="inner">流行款式</h1> 
            </div>
            <div class="clear">
				<div class="Lmain">
					<div style="font-size:20px;"><a href="#">清凉一夏</a></div>
						
						<c:forEach items="${listll}" var = "picture">
               				<div class="Lmainbox">
               		 			<div class="Lmainboxpic"><a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" width="180" height="200" class="project-img" alt="s" /></a></div>
               		 			<div class="Lmainboxtxt"><center>人字拖新品</center></div>
               				</div>	
               			</c:forEach> 
				</div>
				<div class="Lmain">
					<div style="font-size:20px;"><a href="#">活力无限</a></div>
						<c:forEach items="${listlltw}" var = "picture">
               				<div class="Lmainbox">
               		 			<div class="Lmainboxpic"><a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" width="180" height="200" class="project-img" alt="s" /></a></div>
               		 			<div class="Lmainboxtxt"><center>休闲运动板鞋</center></div>
               				</div>	
               			</c:forEach> 
				</div>
				<div class="Lmain">
					<div style="font-size:20px;"><a href="#">时尚靓丽</a></div>
						<c:forEach items="${listllthr}" var = "picture">
               				<div class="Lmainbox">
               		 			<div class="Lmainboxpic"><a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" width="180" height="200" class="project-img" alt="s" /></a></div>
               		 			<div class="Lmainboxtxt"><center>时尚休闲鞋</center></div>
               				</div>	
               			</c:forEach>
				</div>
			</div>
          </div>
          <div class="clear"></div>
        </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="footer">
    <ul style="color:#FFF;">
     Copyright (c) Sitename.com. All rights reserved. Design by Stylish From <a style=" color:#FFF;" href="http://www.cssmoban.com">cssMoban.com</a>.
    </ul>
  </div>
</div>
</body>
</html>

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
    
    <title>My JSP 'brandinfo_list.jsp' starting page</title>
    
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
              <h1>女士热销款式</h1>
			  <div class="whiteText"> Make your own music Library.</div>
              <div class="cdBox">
                  <c:forEach items="${listf}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=31"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
              </div>
			  
            
              <div class="clear"></div>
            </div>
            <div class="box1">
              <h1>男士热销款式</h1>
			  <div class="whiteText"> Make your own music Library.</div>
              <div class="cdBox">
              	  <c:forEach items="${listm}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
              </div>
			  
            
              <div class="clear"></div>
            </div>
            <div class="box1">
              <h1>其他热销款式</h1>
			  <div class="whiteText"> Make your own music Library.</div>
               <div class="cdBox">
              	  <c:forEach items="${listo}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet?goodsId=224"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
              </div>
			  
            
              <div class="clear"></div>
            </div>
            <div class="clear"></div>
          </div>
          <div class="workZoneRight">
            <div class="rightBox inner">
              <div style="padding:0 15px 10px 15px;">
                <h1 class="inner">女鞋品牌</h1>
               <div class="rightBox">
              <div class="tunesBox">
                <h5>女鞋品牌</h5>
                
                <span class="boldText"> </span></div>
               <c:forEach items="${list}" var = "picture">
               		 <div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
               </c:forEach>          
            </div>
                <div class="clear"></div>
               <div class="rightBox">
              <div class="tunesBox">
                <h5>男鞋品牌</h5>
                
                <span class="boldText"> </span></div>
               <c:forEach items="${lists}" var = "picture">
               		 <div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?goodsId=226"><img src="${picture.pictureUrl}" alt="s" /></a></div>
               </c:forEach>          
             </div>
                <div class="clear"></div>
                <div class="aboutcolumnzone">
				<h5>运动品牌</h5>
                  <div class="aboutcolumn1">
                    <div>
                      <h5>李林</h5>
					  
					   <c:forEach items="${listL}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
					  
                    </div>
                  </div>
                  <div class="aboutcolumn2">
                    <div>
                      <h5>NIKE</h5>
                      <c:forEach items="${listN}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
                     
                    </div>
                  </div>
                  <div class="clear"></div>
                  <div class="aboutcolumn1">
                    <div>
                      <h5>爱旅儿</h5>
                       <c:forEach items="${listA}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
                    
                    </div>
                  </div>
                  <div class="aboutcolumn2">
                    <div>
                      <h5>鸿星尔克</h5>
                        <c:forEach items="${listH}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
                     
                    </div>
                  </div>
                  <div class="clear"></div>
                </div>
                <div>
                  <h5>更多品牌...</h5>
                   <c:forEach items="${listM}" var = "picture">
               		 <a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a>
               	  </c:forEach>
                </div>
              </div>
            </div>
            <div class="clear"></div>
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
 <form action="<%=basePath%>sys/FShoppingCartQueryServlet" method="post">
  </form>
</body>
</html>

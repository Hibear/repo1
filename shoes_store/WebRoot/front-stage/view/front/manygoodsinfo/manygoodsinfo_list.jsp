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
    
    <title>My JSP 'manygoodsinfo_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link href="front-stage/css/style.css" rel="stylesheet" type="text/css" />
  <body>
<div id="wrapper">
   <div class="headerzone">
    <div class="header">
      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:20px;" value="请输入查找项" /></div>
	  <div id="headerText2"><img src="front-stage/img/h1.png" border="0" /></div>
      </div>
      <div class="phone"><input type="text" value="${sessionScope.mager.userName}" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/> 欢迎来到合鞋！
        <div class="email"> <a href="<%=basePath%>sys/FUserLoginServlet">登录</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>sys/FUserSignInServlet">注册</a><input type="hidden" value="${sessionScope.mager.userId}" name="userId" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>
        </div>
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
      <div class="clear"></div>
    <div class="clear"></div>
    </div>
    
    
      <div class="banner">
		  <div id="demo">
			<div id="indemo">
			<div id="demo1">
				<div id="main" style="background-color:yellow">
		<div id="middle-main">
		
		
		
		
		
		
			<ul>
				<li><a href="part.html">
					<div class="img">
						<c:forEach items="${goodspictureinfo}" var = "picture">
            				<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            			</c:forEach> 						
					</div></a>
					<div class="describ">
						<div class="food-name"><a href="<%=basePath %>sys/DepartGoodsServlet"><p>${goodsInfo.goodsName} ${goodsInfo.goodsTypeCode}</p></a></div>
						<div class="price"><p>商品优惠价格：${goodsInfo.goodsPriceShop}</p></div>
					</div><input type="hidden" name="goodsId" value="${goodsInfo.goodsId}"/> 
				</li>
				
				<li><a href="part.html">
					<div class="img">
						<c:forEach items="${goodspictureinfo}" var = "picture">
            				<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            			</c:forEach> 						
					</div></a>
					<div class="describ">
						<div class="food-name"><a href="#"><p>${goodsInfo.goodsName} ${goodsInfo.goodsTypeCode}</p></a></div>
						<div class="price"><p>商品优惠价格：${goodsInfo.goodsPriceShop}</p></div>
					</div>
				</li><li><a href="part.html">
					<div class="img">
						<c:forEach items="${goodspictureinfo}" var = "picture">
            				<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            			</c:forEach> 						
					</div></a>
					<div class="describ">
						<div class="food-name"><a href="#"><p>${goodsInfo.goodsName} ${goodsInfo.goodsTypeCode}</p></a></div>
						<div class="price"><p>商品优惠价格：${goodsInfo.goodsPriceShop}</p></div>
					</div>
				</li><li><a href="part.html">
					<div class="img">
						<c:forEach items="${goodspictureinfo}" var = "picture">
            				<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            			</c:forEach> 						
					</div></a>
					<div class="describ">
						<div class="food-name"><a href="#"><p>${goodsInfo.goodsName} ${goodsInfo.goodsTypeCode}</p></a></div>
						<div class="price"><p>商品优惠价格：${goodsInfo.goodsPriceShop}</p></div>
					</div>
				</li>
				

				
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfot}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=31"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfot.goodsName} ${goodsInfot.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfot.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfot}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=31"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfot.goodsName} ${goodsInfot.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfot.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfot}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=31"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfot.goodsName} ${goodsInfot.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfot.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfot}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=31"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfot.goodsName} ${goodsInfot.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfot.goodsPriceShop}</p></div>
					</div>
				</li>
				
				
				
				
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfott}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfott.goodsName} ${goodsInfott.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfott.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfott}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfott.goodsName} ${goodsInfott.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfott.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfott}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfott.goodsName} ${goodsInfott.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfott.goodsPriceShop}</p></div>
					</div>
				</li>
				<li><a href="#">
					<div class="img">
						<c:forEach items="${goodspictureinfott}" var = "picture">
               		 	<div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet?pictureId=33"><img src="${picture.pictureUrl}" alt="s" /></a></div>
            		</c:forEach> 
					</div></a>
					<div class="describ">
						<div class="food-name">
							<a href="#"><p>${goodsInfott.goodsName} ${goodsInfott.goodsTypeCode}</p></a>
						</div>
						<div class="price"><p>商品优惠价格：${goodsInfott.goodsPriceShop}</p></div>
					</div>
				</li>
				

			</ul>
			
			
			
			
			
			
			
			
			
		</div>
	</div>
			</div>
			<div id="demo2"></div>
			</div>
			</div>
		    <div class="clear"></div>
		
		    <div class="clear"></div>
  </div>
    
    
    
	
	
  </div>    
  </div>
</body>
</html>

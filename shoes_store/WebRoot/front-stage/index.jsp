<%@ page language="java" import="java.util.*,com.sstore.po.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合鞋网</title>
    
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
      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:25px;" value="请输入查找项" /></div><div id="headerText2"><img src="front-stage/img/h1.png" border="0" /></div>
      </div>
      <div class="phone"><input type="text" value="${sessionScope.mager.userName}" name="userName" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>欢迎来到合鞋！
        <div class="email"> <a href="<%=basePath%>sys/FUserLoginServlet">登录</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>sys/FUserSignInServlet">注册</a><input type="hidden" value="${sessionScope.mager.userId}" name="userId" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/><br />
        <a href="<%=basePath %>sys/FUserClearServlet">退出登录</a>
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
        <li style="border:none;"><a href="<%=basePath%>sys/FShoppingCartQueryServlet?userId=${sessionScope.mager.userId}">购物车</a></li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
  <div class="banner">
  <div id="demo">
<div id="indemo">
<div id="demo1">
<a href="#"><img src="front-stage/img/1.jpg" border="0" /></a>
<a href="#"><img src="front-stage/img/2.jpg" border="0" /></a>
<a href="#"><img src="front-stage/img/3.jpg" border="0" /></a>
</div>
<div id="demo2"></div>
</div>
</div>
    
    <div class="clear"></div>

    <div class="clear"></div>
  </div>
  <div class="workZone">
    <div class="midBox">
      <div class="topBox">
        <div class="bottomBox">
          <div class="leftBox">
            <div class="wrapper">
				<div class='sub-col'>
				<div class="category">
							<h3>所有商品分类</h3>
							<ul id="J_category" class="item">
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>凉鞋</span></li></a>
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>皮鞋</span></li></a>
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>草鞋</span></li></a>
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>运动鞋</span></li></a>
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>休闲鞋</span></li></a>
								<a href="<%=basePath %>sys/ManyGoodsServlet?goodsId=221"><li><span>儿童鞋</span></li></a>										
							</ul>
						</div>
					</div>
					</div>
				
          </div>
          <div class="workZoneRight">
            <div class="rightBox">
              <div class="tunesBox">
                <h1>当季潮流</h1>
                
                <span class="boldText"> </span></div>
               <c:forEach items="${list}" var = "picture">
               		 <div class="rightBox2Top"><a href="<%=basePath %>sys/DepartGoodsServlet"><img src="${picture.pictureUrl}" alt="s" /></a></div>
               </c:forEach>          
            </div>
            <div class="rightBox2">
              <h1>品牌活动</h1>
			   <c:forEach items="${lists}" var = "picture">
               		 <div class="rightBox2Top"><img src="${picture.pictureUrl}" alt="s" /></div>
               </c:forEach>
              <div class="productContainer">
                <div class="pic"><img src="front-stage/img/nike.png" alt="s" />
                  <div class="picText1"><strong>Nike</strong></div>
                  <div class="clear"></div>
                </div>
                <div class="pic"><img src="front-stage/img/add.png" alt="s" />
                  <div class="picText2"><strong>Adidas</strong></div>
                </div>
                <div class="pic"><img src="front-stage/img/.jpg" alt="s" width="8" height="17"/>
                  <div class="picText3"><strong>Classic</strong></div>
                </div>
                <div class="pic"><img src="front-stage/img/.jpg" alt="s" />
                  <div class="picText1"><strong>Touch</strong></div>
                  <div class="clear"></div>
                </div>
                <div class="clear"></div>
              </div>
              <div class="clear"></div>
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
     第四别动队 <a href="back-stage/index.jsp">进入后台</a>
    </ul>
  </div>
</div>


<!--滚动-->
			 <script type="text/javascript">
				var speed=10; //数字越大速度越慢
				var tab=document.getElementById("demo");
				var tab1=document.getElementById("demo1");
				var tab2=document.getElementById("demo2");
				tab2.innerHTML=tab1.innerHTML;
				function Marquee(){
				if(tab2.offsetWidth-tab.scrollLeft<=0)
				tab.scrollLeft-=tab1.offsetWidth
				else{
				tab.scrollLeft++;
				}
				}
				var MyMar=setInterval(Marquee,speed);
				tab.onmouseover=function() {clearInterval(MyMar)};
				tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
			</script>



</body>
</html>

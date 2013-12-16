<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderinfo_add.jsp' starting page</title>
    
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
  
   <body background="front-stage/img/beijing.jpg">
   <div id="wrapper">
   <div class="headerzone">
		    <div class="header">
		      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:25px;" value="请输入查找项" /></div><div id="headerText2"><img src="front-stage/img/h1.png" border="0" /></div>
		      </div>
		      <div class="phone"><input type="text" value="${sessionScope.mager.userName}" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>欢迎来到合鞋！
		        <div class="email"> <a href="<%=basePath%>sys/FUserLoginServlet">登录</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>sys/FUserSignInServlet">注册</a><input type="hidden" value="${sessionScope.mager.userId}" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/><br /></div>
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
	</div>
    <form action="<%=basePath%>sys/FOrderinfoAddServlet" method="post">
 		<center><table>
 		<tr><td colspan="2">
 		 <h1>提交订单</h1></td></tr>
 		<tr><td>
 		
 		<tr><td>
 		
 		<tr><td>
 		
 		<tr><td>
 		送货地址：</td><td> <input type="text" name="orderUserAddress"/></td></tr>
 		<tr><td>
 		邮政编码：</td><td> <input type="text" name="orderUserPostCode"/></td></tr>
 		<tr><td>
 		联系号码：</td><td> <input type="text" name="orderUserPhone"/></td></tr>
 		<tr><td>
 		邮   箱： </td><td><input type="text" name="orderUserEmail"/></td></tr>
 		<tr><td>
 		商品发送方式：</td><td> <input type="text" name="orderGoodsSendType"/></td></tr>
 		<!-- 
 		发送时间： <input type="text" name="orderTime"/><br/>
 		 -->
 		
 		<tr><td>
 		商品价格：</td><td> <input type="text" name="goodsPrice"/></td></tr>
 		<tr><td>
 		运费： </td><td><input type="text" name="tranFee"/></td></tr>
 		<tr><td>
 		</td><td> <input type="hidden" name="isConfirm" value="是"/></td></tr>
 		<tr><td colspan="2">
 		<input type="submit" value="添加"/></td></tr>
 		</table>
 		</center>
 		
 	</form>
  </body>
</html>


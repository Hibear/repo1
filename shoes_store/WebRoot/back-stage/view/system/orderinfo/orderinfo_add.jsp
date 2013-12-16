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

  </head>
  
   <body background="front-stage/img/beijing.jpg">
    <form action="<%=basePath%>sys/OrderinfoAddServlet" method="post">
 		<center><table>
 		<tr><td colspan="2">
 		 <h1>订单增加</h1></td></tr>
 		<tr><td>
 		订  单  号：</td><td> <input type="text" name="orderId"/></td></tr>
 		<tr><td>
 		会  员  号：</td><td> <input type="text" name="userId"/></td></tr>
 		<tr><td>
 		会  员  名：</td><td> <input type="text" name="orderUserRealName"/></td></tr>
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
 		是否有效：</td><td> <input type="text" name="isConfirm"/></td></tr>
 		<tr><td colspan="2">
 		<input type="submit" value="添加"/></td></tr>
 		</table>
 		</center>
 		
 	</form>
  </body>
</html>


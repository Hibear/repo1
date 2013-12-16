<%@ page language="java" import="java.util.*,com.sstore.po.OrderInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderinfo_update.jsp' starting page</title>
    
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
    
      <form action="<%=basePath%>sys/OrderinfoUpdateServlet" method="post">
  		<%OrderInfo order = (OrderInfo) request.getAttribute("order");
  		 %>
  		 <input type="hidden" name="orderId" value="<%=order.getOrderId()%>"/>
 		<center><table>
 		<tr><td colspan="2">
 		<h1>订单修改</h1></td></tr>
 		<tr><td>
 		会员号：</td><td> <input type="text" name="userId" value="<%=order.getUserId()%>"/></td></tr>
 		<tr><td>
 		会员名：</td><td> <input type="text" name="orderUserRealName" value="<%=order.getOrderUserRealName() %>"/></td></tr>
 		<tr><td>
 		送货地址：</td><td> <input type="text" name="orderUserAddress" value="<%=order.getOrderUserAddress() %>"/></td></tr>
 		<tr><td>
 		邮政编码：</td><td> <input type="text" name="orderUserPostCode" value="<%=order.getOrderUserPostCode() %>"/></td></tr>
 		<tr><td>
 		联系号码：</td><td> <input type="text" name="orderUserPhone" value="<%=order.getOrderUserPhone() %>"/></td></tr>
 		<tr><td>
 		邮箱： </td><td><input type="text" name="orderUserEmail" value="<%=order.getOrderUserEmail() %>"/></td></tr>
 		<tr><td>
 		商品发送方式：</td><td> <input type="text" name="orderGoodsSendType" value="<%=order.getOrderGoodsSendType() %>"/></td></tr>
 		<!-- 
 		发送时间： <input type="text" name="orderTime"/><br/>
 		 -->
 		
 		<tr><td>
 		商品价格：</td><td> <input type="text" name="goodsPrice" value="<%=order.getGoodsPrice() %>"/></td></tr>
 		<tr><td>
 		运费：</td><td> <input type="text" name="tranFee" value="<%=order.getTranFee() %>"/></td></tr>
 		<tr><td>
 		是否有效：</td><td> <input type="text" name="isConfirm" value="<%=order.getIsConfirm() %>"/></td></tr>
 		
 		
 		<tr><td colspan="2">
 		<input type="submit" value="修改"/></td></tr></table>
 		</center>
 		
 	</form>
  </body>
</html>

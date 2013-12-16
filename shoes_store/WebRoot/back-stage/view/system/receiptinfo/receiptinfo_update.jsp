<%@ page language="java" import="java.util.*,com.sstore.po.ReceiptInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'receiptinfo_update.jsp' starting page</title>
    
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
    <form action="<%=basePath%>sys/ReceiptinfoUpdateServlet" method="post">
  		<%ReceiptInfo receipt = (ReceiptInfo) request.getAttribute("receipt");
  		 %>
  		 <input type="hidden" name="receiptId" value="<%=receipt.getReceiptId()%>"/>
 		<center>
 		<h1>进货单修改</h1>
 	
		进货价格: <input type="text" name="receiptPrice" value="<%=receipt.getReceiptPrice() %>"/><br/>
		
 		<input type="submit" value="修改"/>
 		</center>
 		
 	</form>
  </body>
</html>

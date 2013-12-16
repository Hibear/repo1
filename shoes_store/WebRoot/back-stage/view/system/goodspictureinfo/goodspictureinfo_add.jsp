<%@ page language="java" import="java.util.*,com.sstore.po.ManagerInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerinfo_add.jsp' starting page</title>
    
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
  <form action="<%=basePath%>sys/GoodsPictureAddServlet" method="post">
 		<center>
 		<h1>增加图片</h1>
 		商品编号：<input type="text" name="goodsId"/><br/><br/>
 		图片名称：<input type="text" name="pictureName"/><br/><br/>
 		图片地址：<input type="text" name="pictureUrl"/><br/>
 		<br/>
 		<input type="submit" value="添加"/>
 		</center>
 		
 	</form>	
  </body>
</html>

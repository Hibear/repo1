<%@ page language="java" import="java.util.*,com.sstore.po.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerinfo_update.jsp' starting page</title>
    
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
  <form action="<%=basePath%>sys/GoodsPictureUpdateServlet" method="post">
  		<%GoodsPictureInfo mager = (GoodsPictureInfo) request.getAttribute("mager");
  		 %>
  		 <input type="hidden" name="pictureId" value="<%=mager.getPictureId() %>"/>
 		<center><table>
 		<tr><td colspan="2">
 		<h1>图片信息修改</h1></td></tr>
 		<tr><td>
 		商品号：</td><td><input type="text" name="goodsId" value="<%=mager.getGoodsId() %>" /></td></tr>
 		<tr><td>
 		图片名：</td><td><input type="text" name="pictureName" value="<%=mager.getPictureName() %>" /></td></tr>
 		<tr><td>
 		图片地址：</td><td><input type="text" name="pictureUrl" value="<%=mager.getPictureUrl() %>" /></td></tr>
 	<tr><td colspan="2">
 		<input type="submit" value="修改"/></td></tr>
 		</table>
 		</center>
 		
 	</form>	
  </body>
</html>

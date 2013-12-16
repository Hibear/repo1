<%@ page language="java" import="java.util.*,com.sstore.po.GoodsInfo,com.sstore.po.GoodsClassInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsinfo_update.jsp' starting page</title>
    
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
    <form action="<%=basePath%>sys/GoodsinfoUpdateServlet" method="post">
  		<%GoodsInfo goods = (GoodsInfo) request.getAttribute("goods");
  		 %>
  		 <input type="hidden" name="goodsId" value="<%=goods.getGoodsId()%>"/>
 		<center>
 		<table><tr><td colspan="2">
 		<h1>商品修改</h1></td></tr>
 		<tr><td>类别号：</td><td>
 		<select name="classId">
 			<%List<GoodsClassInfo> list =  (List<GoodsClassInfo>)request.getAttribute("deList"); 
 			  
 			if(list!=null && list.size()>0){
 			for(GoodsClassInfo de:list){
 			%>
 			<option value="<%=de.getClassId() %>"><%=de.getClassName() %></option>
 			<%}} %>
 		</select></td></tr>
 		
 		<tr><td>
		商品型号:</td><td><input type="text" name="goodsTypeCode" value="<%=goods.getGoodsTypeCode() %>"/></td></tr>
		<tr><td>
		商品名称:</td><td> <input type="text" name="goodsName" value="<%=goods.getGoodsName() %>"/></td></tr>
		<tr><td>
		商品关键字:</td><td> <input type="text" name="goodsKeys" value="<%=goods.getGoodsKeys() %>"/></td></tr>
		<tr><td>
		商品简介: </td><td><input type="text" name="goodsText" value="<%=goods.getGoodsText() %>"/></td></tr>
		<tr><td>
		商品品牌:</td><td> <input type="text" name="goodsPt" value="<%=goods.getGoodsPt() %>"/></td></tr>
		<tr><td>
		商品市场价:</td><td> <input type="text" name="goodsPriceShop" value="<%=goods.getGoodsPriceShop() %>"/></td></tr>
		<tr><td>
		商品优惠价: </td><td><input type="text" name="goodsPriceUser" value="<%=goods.getGoodsPriceUser() %>"/></td></tr>
		<tr><td>
		商品是否新品:</td><td> <input type="text" name="goodsIsNew" value="<%=goods.getGoodsIsNew() %>"/></td></tr>
		<tr><td>
		商品是否推荐: </td><td><input type="text" name="isRecommend" value="<%=goods.getIsRecommend() %>"/></td></tr>
		<tr><td>
		商品卖出数: </td><td><input type="text" name="goodsBuyNumber" value="<%=goods.getGoodsBuyNumber() %>"/></td></tr>
		<!-- 
		商品录入时间: <input type="text" name="goodsInTime"/><br/>
		 -->
		<tr><td>
		是否优惠: </td><td><input type="text" name="isCheap" value="<%=goods.getIsCheap() %>"/></td></tr>
 		
 		<tr><td colspan="2">
 		<input type="submit" value="修改"/></td></tr>
 		</table>
 		</center>
 	</form>
  </body>
</html>

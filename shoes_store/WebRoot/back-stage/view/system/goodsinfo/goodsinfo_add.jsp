<%@ page language="java" import="java.util.*,com.sstore.po.GoodsClassInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsinfo_add.jsp' starting page</title>
    
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
    <form action="<%=basePath%>sys/GoodsinfoAddServlet" method="post">
 		<center><table>
 		<tr><td colspan="3">
 		<h1>商品增加</h1></td></tr>
 		<tr><td>商品号:</td>
 		<td colspan="2"> <input type="text" name="goodsId"/></td>
 		</tr>
		<tr><td><br/>
		类别号：</td><td>
 		<select name="classId">
 			<%List<GoodsClassInfo> list =  (List<GoodsClassInfo>)request.getAttribute("deList"); 
 			
 			if(list!=null && list.size()>0){
 			for(GoodsClassInfo de:list){
 			%>
 			<option value="<%=de.getClassId() %>"><%=de.getClassName() %></option>
 			<%}} %>
 		</select></td></tr>
 		<tr><td>
		商品型号:</td><td colspan="2"> <input type="text" name="goodsTypeCode"/></td></tr>
		<tr><td>
		商品名称:</td><td colspan="2"> <input type="text" name="goodsName"/></td></tr>
		<tr><td>
		商品关键字: </td><td colspan="2"><input type="text" name="goodsKeys"/></td></tr>
		<tr><td>
		商品简介:</td><td colspan="2"> <input type="text" name="goodsText"/></td></tr>
		<tr><td>
		商品品牌: </td><td colspan="2"><input type="text" name="goodsPt"/></td></tr>
		<tr><td>
		商品市场价: </td><td colspan="2"><input type="text" name="goodsPriceShop"/></td></tr>
		<tr><td>
		商品优惠价: </td><td colspan="2"><input type="text" name="goodsPriceUser"/></td></tr>
		<tr><td>
		商品是否新品: </td><td colspan="2"><input type="text" name="goodsIsNew"/></td></tr>
		<tr><td>
		商品是否推荐: </td><td colspan="2"><input type="text" name="isRecommend"/></td></tr>
		<tr><td>
		商品卖出数:</td><td colspan="2"> <input type="text" name="goodsBuyNumber"/></td></tr>
		<!-- 
		商品录入时间: <input type="text" name="goodsInTime"/><br/>
		 -->
		<tr><td>
		是否优惠:</td><td colspan="2"> <input type="text" name="isCheap"/></td></tr>
		<tr><td colspan="3">	
 		<input type="submit" value="添加"/></td></tr>
 		</table>
 		</center>
 		
 	</form>	 
  </body>
 
</html>

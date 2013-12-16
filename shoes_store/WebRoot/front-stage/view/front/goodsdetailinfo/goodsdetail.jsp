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
    
    <title>商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="front-stage/css/style.css" rel="stylesheet" type="text/css">
	
	
	<script type="text/javascript">
			function add(){
				//等同于超链接 只能提交到doGet
				window.location = "<%=basePath%>sys/FOrderinfoAddServlet";
			}
			
		</script>
	
	
	
	
  </head>
<form action="<%=basePath%>sys/FShoppingCartAddServlet" method="post">  
<div id="wrapper">
  <div class="headerzone">
    <div class="header1" style="background-image:url(front-stage/img/header.jpg)">
      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:20px;" value="请输入查找项"></div><div id="headerText2"><img src="front-stage/img/h1.png" border="0"></div>
      </div>
      <div class="phone"><input type="text" value="${sessionScope.mager.userName}" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>欢迎来到合鞋！
        <div class="email"> <a href="<%=basePath%>sys/FUserLoginServlet">登录</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>sys/FUserSignInServlet">注册</a><input type="hidden" value="${sessionScope.mager.userId}" name="userId" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>
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
 <div >
	<h3><span class="tb-double-tag"></span> 鞋名： 聚尚网乐淘网走秀网好乐特价优购代购男鞋</h3>
    
</div>

<div style="width:1000px; height:400px; border-color:#FFFFFF; border-style:solid; border-width:thick; background-color:white;">
		<div style="width:400px; height:400px; position:relative; left:0px; top:0px; ">
		
			<img src="${goodspictureinfo.pictureUrl}">
		
		
		</div>
  <div style="width:600px; height:400px; background-color:#FFFFFF; position:relative; left:400px; top:-400px;  "> 
		
	<table width="600px;" border="0" style="background-color:#FFFFFF;">
		  <tr>
				<td colspan="1" height:"55px">
				
				</td>
		  </tr>  
	
		
		   <tr>
			<td colspan="1" style="background-color:#FFFFFF;height:55px">
			<div style="margin-left:100px;font-weight:bold"> 商品优惠价格：<input type="text" value="${goodsInfo.goodsPriceShop}" style="border-width:0px" readonly/>
			</div>
			</td>
		  </tr>  
	
		 <tr>
			<td colspan="1" style="background-color:#FFFFFF;height:55px">
			<div style="margin-left:100px;font-weight:bold"> 物流运费：<span >   </span>
			</div>
			</td>
		 </tr>  
	 
		 <tr>
			<td colspan="1" style="background-color:#FFFFFF;height:55px">
			<div style="margin-left:100px;font-weight:bold"> 尺码：<span >180元</span>
			</div>
			</td>
		 </tr> 
			
			<tr>
				<td colspan="1" style="background-color:#FFFFFF;height:55px">
				<div style="margin-left:100px;font-weight:bold">颜色分类：<span >180元</span><input type="hidden" value="${goodsInfo.goodsId}" name="userId" style="background-color:black; color:white;text-decoration:underline;width:30px;border-width:0px" readonly/>
				</div>
				</td>
		   </tr> 
	   
			<tr>
				<td colspan="1" style="background-color:#FFFFFF;height:55px">
				<div style="margin-left:100px;font-weight:bold">购买数量：<span ><input style="height:25px" name="goodsNumber" type="text" ></span>
				</div>
				</td>
		   </tr>    
	</table>
		
		<div style="position:relative;left:100px;"> 
	
			<input name="button2" type="button"  style="height:35px" value="立即购买" onclick="add()" src=""  width="45px" />
			<input name="button" type="submit"  style="height:35px" value="加入购物车" width="15px" />
		</div>
		
   </div>
 </div>



<div class="topmenu">
     <ul>
        <li class="first"><a class="current">宝贝详情</a></li>
    
  	</ul>
</div>
    <div class="clear"></div>
<div style="width:1000px; height:200px; background-color:#FFFFFF; border-style:thick; border-width:thick; ">

		<div style="width:700px; height:400px; background-color:#FFFFF; position:relative; left:100px; top:0px; "> 
			
			 <table width="863" height="184">
				  <tr>
					<td width="226" height="60">商品型号：<input type="text" name="goods_type_code" value="${goodsInfo.goodsTypeCode}" style="border-width:0px" readonly/>  <p>  </p></td>
					<td width="226" height="60"> 商品ID：<input type="text" name="goodsId" value="${goodsInfo.goodsId}" style="border-width:0px" readonly/>    <p>  </p> </td>
					<td width="226" height="60"> 商品名称：${goodsInfo.goodsName} <p>  </p> </td>
				  </tr>
				  
				  <tr>
					<td width="226" height="54">商品品牌：${goodsInfo.goodsPt}   <p>  </p></td>
					<td width="226" height="54"> 商品简介： ${goodsInfo.goodsText}   <p>  </p> </td>
					<td width="226" height="54"> 商品类别： <p>  </p> </td>
				  </tr>
				 
				 
				  <tr>
					<td width="226" height="53">商品卖出数：${goodsInfo.goodsBuyNumber}   <p>  </p></td>
					<td width="226" height="53"> 商品上市时间：${goodsInfo.goodsInTime} <p>  </p> </td>
					<td width="226" height="53"> 是否新品商品：${goodsInfo.goodsIsNew}  <p>  </p> </td>
				  </tr>   
			</table>

		</div>
	 
</div>



  <div class="topmenu">
      <div class="topmenu">
      <ul>
        <li class="first"><a class="current">客户评论</a></li>
    
      </ul>
</div>
  <div class="clear"></div>
  
    <div style="width:1000px; height:200px; background-color:#FFFFFF; border-style:thick; border-width:thick; ">

		<div style="width:700px; height:200px;  background-color:#FFFFF; position:relative; left:100px; top:0px; "> 
		
		

			</div>
      </div>
	</div>



      
</div>
    <div class="clear"></div>
	<div style="width:1000px; height:200px; background-color:#FFFFFF; border-style:thick; border-width:thick; ">

		<div style="width:700px; height:400px; background-color:#FFFFF; position:relative; left:100px; top:0px; "> 
	   
			    <table width="863" height="184">
				  <tr>
				  
				  	<c:forEach items="${commentsinfo}" var = "commentsinfo">
				  		
				  		<div><span>评论用户名：${commentsinfo.userId}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>评论内容：${commentsinfo.reviewText}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>评论时间：${commentsinfo.reviewTime}</span></div>
	
               	  	</c:forEach>

				  </tr>
			  </table>
	
		</div>
	 
	</div>
</div>
</form>
</html>

<%@ page language="java" import="java.util.*,com.sstore.po.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
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
	
	<style type="text/css">
			.table {
				color: #000;
				background: #fff;
				width: 99.7% !important;
				width: 80%;
			}
			
			.table td,.table th {
				border-left: 0px;
				border-top: 0px;
				padding: 0.2em;
				text-align: center;
			}
			.table tr{
				height:50px;
			}
			.table thead th {
				border: 1px solid #e0e0e0;
				border-left: 0px;
				border-top: 0px;
				text-align: left;
				font-size: 1em;
				font-weight: bold;
				background: #d7e9f5;
				text-align: center;
			}
			}
		</style>
	
  </head>
	<body>
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
		<center>
		<form action="<%=basePath %>sys/FOrderinfoAddServlet">
			<display:table name="list" class="table" pagesize="10"
				requestURI="/sys/FShoppingCartQueryServlet" export="true">
				<display:column property="goodsName" title="商品" sortable="true"></display:column>
				<display:column property="goodsPriceShop" title="单价"></display:column>
				<display:column property="goodsNumber" title="数量"></display:column>
				<display:column title="操作" value="删除" style="width:50px;"
					paramId="userId" paramProperty="userId"
					url="/sys/FShoppingCartDeleteServlet"></display:column>
			</display:table>
			<input type="submit" value="提交订单"/>
		</form>
		</center>
	<div id="wrapper">
	</body>
</html>
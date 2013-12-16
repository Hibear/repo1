<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderinfo_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.table {
	border: 1px solid #74B3DC;
	color: #000;
	background: #fff;
	width: 99.7% !important;
	width: 80%;
}

.table td,.table th {
	border: 1px solid #e0e0e0;
	border-left: 0px;
	border-top: 0px;
	padding: 0.2em;
	text-align: center;
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
</style>
<script type="text/javascript">
			function add(){
				//等同于超链接 只能提交到doGet
				window.location = "<%=basePath%>sys/OrderinfoAddServlet";
			}
			function inquire(){
				//等同于超链接 只能提交到doGet
				window.location = "<%=basePath%>sys/OrderinfoInquireServlet";
			}
		</script>

  </head>
  
  <body><center>
  			<form action="<%=basePath%>sys/OrderinfoQueryServlet" method="post">
				商品购物单ID：
				<input type="text" name="orderId" />
				<input type="submit" value="查询" onclick="inquire()"/>
				<input type="button" value="增加"  onclick="add()"/>
			</form>
			
			<display:table name="list" class="table" pagesize="10"
				requestURI="/sys/OrderinfoQueryServlet" export="true">
				<display:column property="orderId" title="订单号" sortable="true"></display:column>
				<display:column property="userId" title="会员号"></display:column>
				<display:column property="orderUserRealName" title="会员名"></display:column>
				<display:column property="orderUserAddress" title="送货地址"></display:column>
				<display:column property="orderUserPostCode" title="邮政编码"></display:column>
				<display:column property="orderUserPhone" title="联系号码"></display:column>
				<display:column property="orderUserEmail" title="邮箱"></display:column>
				<display:column property="orderGoodsSendType" title="商品发送方式"></display:column>
				<display:column property="orderTime" title="发送时间"></display:column>
				<display:column property="goodsPrice" title="商品价格"></display:column>
				<display:column property="tranFee" title="运费"></display:column>
				<display:column property="isConfirm" title="是否有效"></display:column>
				
				<display:column title="修改" value="修改" style="width:50px;"
					paramId="orderId" paramProperty="orderId"
					url="/sys/OrderinfoUpdateServlet"></display:column>
				<display:column title="删除" value="删除" style="width:50px;"
					paramId="orderId" paramProperty="orderId"
					url="/sys/OrderinfoDeleteServlet"></display:column>
			</display:table>
  		
  		
  		
  		</center>
  </body>
</html>

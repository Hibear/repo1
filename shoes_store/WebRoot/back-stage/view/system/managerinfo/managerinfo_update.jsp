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
  <form action="<%=basePath%>sys/ManagerUpdateServlet" method="post">
  		<%ManagerInfo mager = (ManagerInfo) request.getAttribute("mager");
  		 %>
  		 <input type="hidden" name="managerId" value="<%=mager.getManagerId() %>"/>
 		<center>
 		<h1>管理员信息修改</h1>
 		姓名：<input type="text" name="managerName" value="<%=mager.getManagerName() %>" /><br/>
 		<br>
 		密码：<input type="text" name="managerPwd" value="<%=mager.getManagerPwd() %>" /><br/>
 		
 		<br/>
 		<input type="submit" value="修改"/>
 		</center>
 		
  
 		
 	</form>	
  </body>
</html>

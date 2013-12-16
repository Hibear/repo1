<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合鞋网管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <frameset rows="15%,*" cols="*" frameborder="no" border="0" 

framespacing="0">
  <frame src="<%=basePath%>back-stage/view/main/top.jsp" name="topFrame" 

scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="213,*" frameborder="no" border="0" framespacing="0">
    <frame src="<%=basePath%>back-stage/view/main/left.jsp" name="leftFrame" 

scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="<%=basePath%>back-stage/view/main/mainfra.jsp" name="mainFrame" 

id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>

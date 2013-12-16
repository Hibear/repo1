<%@ page language="java"  import="java.util.*,com.sstore.po.UserInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userinfo_list.jsp' starting page</title>
    
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
   <form action="<%=basePath%>sys/UserUpdateServlet" method="post">
  		<%UserInfo user = (UserInfo) request.getAttribute("user");
  		 %>&nbsp; 
  		 <input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
 		<center><table>
 		<tr><td colspan="2">
 		<h1>会员修改</h1></td></tr>
 		<tr><td>
 		用户名：</td><td><input type="text" name="userName" value="<%=user.getUserName() %>" /></td></tr>
 		<tr><td>
 		用户密码：</td><td><input type="text" name="userPwd" value="<%=user.getUserPwd() %>" /></td></tr>
 		<tr><td>
 		用户邮箱：</td><td><input type="text" name="userEmail" value="<%=user.getUserEmail() %>" /></td></tr>
 		<tr><td>
 		用户联系电话：</td><td><input type="text" name="userPhone" value="<%=user.getUserPhone() %>" /></td></tr>
 		<tr><td>
 		用户地址：</td><td><input type="text" name="userAddress" value="<%=user.getUserAddress() %>" /></td></tr>
 		<tr><td>
 		用户是否有效：</td><td><input type="text" name="userCheck" value="<%=user.getUserCheck() %>"/></td></tr>
 		<tr><td colspan="2">
 		<input type="submit" value="修改"/></td></tr></table>
 		</center>
 		
 	</form>	
  </body>
</html>

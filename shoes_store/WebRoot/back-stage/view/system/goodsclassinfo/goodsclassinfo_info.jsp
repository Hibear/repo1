<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
   <script type="text/javascript">
		alert('${info}');
		window.location = "<%=basePath%>sys/GoodsClassQueryServlet";
	
	</script>
</html>

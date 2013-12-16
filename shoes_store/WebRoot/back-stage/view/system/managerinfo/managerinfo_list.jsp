<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>My JSP 'managerinfo_list.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
			}
		</style>
		<script type="text/javascript">
			function add(){
				//等同于超链接 只能提交到doGet
				window.location = "<%=basePath%>sys/ManagerAddServlet";
			}
		
		
		</script>


	</head>

	<body>
		<center>
			<form action="<%=basePath%>sys/ManagerQueryServlet" method="post">
				管理员ID：
				<input type="text" name="managerName" />
				<input type="submit" value="查询" />
				<input type="button" value="增加"  onclick="add()"/>
			</form>
			<display:table name="list" class="table" pagesize="10"
				requestURI="/sys/ManagerQueryServlet" export="true">
				<display:column property="managerId" title="管理员编号" sortable="true"></display:column>
				<display:column property="managerName" title="管理员姓名"></display:column>
				<display:column property="managerPwd" title="管理员密码"></display:column>
				<display:column property="managerCreateTime" title="管理员创建时间"></display:column>
				<display:column title="修改" value="修改" style="width:50px;"
					paramId="managerId" paramProperty="managerId"
					url="/sys/ManagerUpdateServlet"></display:column>
				<display:column title="删除" value="删除" style="width:50px;"
					paramId="managerId" paramProperty="managerId"
					url="/sys/ManagerDeleteServlet"></display:column>
			</display:table>
		</center>
	</body>
</html>

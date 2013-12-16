<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目管理系统 by www.865171.cn</title>
    
    <style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-image: url(img/left.gif);
	}
	-->
	</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="back-stage/css/css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="back-stage/img/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="back-stage/img/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="back-stage/img/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="back-stage/img/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="back-stage/img/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="img/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="back-stage/img/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span  name="managerName" class="left-font02">king</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="<%=basePath%>index.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  任务系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="back-stage/img/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >订单管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/OrderinfoQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('21');">订单信息查看</a></td>
				</tr>
      </table>
		<!--  任务系统结束    -->

		

		<!--  消息系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="back-stage/img/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >购物车记录表</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu18" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="<%=basePath%>sys/ShoppingcartQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('18');">购物车记录查看</a></td>
				</tr>
				
				
      </table>
		<!--  消息系统结束    -->



        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="back-stage/img/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >商品管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu1" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/GoodsinfoQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('1');">商品信息查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu4" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/GoodsPictureQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('4');">商品图片查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu2" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/ReceiptinfoQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('2');">商品进货查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu5" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/GoodsClassQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('5');">商品类别查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu3" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/CommentsQueryServlet" target="mainFrame" class="left-font03" onClick="tupian('3');">商品评论查看</a></td>
				</tr>


      </table>
		<!--  项目系统结束    -->

	  <!--  客户系统开始    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="back-stage/img/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >会员管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiaotu7" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="sys/UserQuerySerlvet" target="mainFrame" class="left-font03" onClick="tupian('7');">客户信息查看</a></td>
        </tr>
      </table>
	  <!--  人员系统结束    -->
	
     

	 <!--个人信息管理开始-->

		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img9" id="img9" src="back-stage/img/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('9');" >个人管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>

		<table id="subtree9" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				
				<tr>
				  <td width="9%" height="23" ><img id="xiaotu23" src="back-stage/img/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>sys/ManagerQueryServlet" target="mainFrame" class="left-font03" 
						onClick="tupian('23');">管理员信息</a></td>
				</tr>
      </table>
		<!--  个人信息结束    -->

	  </TD>
  </tr>
  
</table>
</body>
</html>

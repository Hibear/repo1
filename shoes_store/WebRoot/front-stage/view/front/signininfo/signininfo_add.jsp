<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="front-stage/css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<div id="wrapper">
   <div class="headerzone">
    <div class="header">
      <div class="headerText"><div id="headerText1"><input type="text"  style="width:240px; height:20px;" value="请输入查找项" /></div><div id="headerText2"><img src="front-stage/img/h1.png" border="0" /></div>
      </div>
      <div class="phone"> 欢迎来到合鞋！
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
  
  <div class="workZone">
    <div class="midBox">
      <div class="topBox">
        <div class="bottomBox">
          <div class="leftBox">
            
            <div class="leftBox1">
				<img src="front-stage/img/boypic.png"  style="margin:22px;"/>
			</div>
            
            
          </div>
          <div class="workZoneRight">
            <div class="rightBox inner">
              <div style="padding:0 15px 20px 15px;">
                
                <h1>欢迎注册！</h1>
                <div> <br />
                  <br />
                  <form action="<%=basePath%>sys/FUserSignInServlet" method="post">
                    <table width="80%">
                      <tr>
                        <td width="145" align="left" valign="top" class="body" id="userName"><strong>用户名:</strong></td>
                        <td width="280" align="left" valign="top"><input name="userName" type="text" size="40" /></td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" class="body" id="userPwd"><strong>输入密码:</strong></td>
                        <td align="left" valign="top"><input name="userPwd" type="text" size="40" /></td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" class="body" id="Address"><strong>再次输入密码: </strong></td>
                        <td align="left" valign="top"><input name="userEmailfff" type="text" size="40" /></td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" class="body" id="userEmail"><strong> Email: </strong></td>
                        <td align="left" valign="top"><input name="userEmail" type="text" size="40" /></td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" class="body" id="userPhone"><strong> 联系电话: </strong></td>
                        <td align="left" valign="top"><input name="userPhone" type="text" size="40" /></td>
                      </tr>
                       <tr>
                        <td align="left" valign="top" class="body" id="userAddress"><strong> 用户地址: </strong></td>
                        <td align="left" valign="top"><input name="userAddress" type="text" size="40" /></td>
                      </tr>
                      <tr>
                        <td align="left" valign="top" class="body" id="Comments"><strong> 用户协议: </strong></td>
                        <td align="left" valign="top"><textarea name="comments" cols="38" rows="6"></textarea></td>
                        <input name="userCheck" type="hidden" size="40" value="是" />
                      </tr>
                      <tr>
                        <td></td>
                        <td><input type="submit" name="submit" class="button" value="注册" /></td>
                      </tr>
                    </table>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="clear"></div>
        </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="footer">
  <ul style="color:#FFF;">
     Copyright (c) Sitename.com. All rights reserved. Design by Stylish From <a style=" color:#FFF;" href="http://www.cssmoban.com">cssMoban.com</a>.
    </ul>
  </div>
</div>
</body>
</html>

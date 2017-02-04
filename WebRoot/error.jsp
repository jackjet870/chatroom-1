<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
      	body{margin:0;padding:0;background:#f8f8f8;position:relative;text-align:center;}
		#message{margin:0 atuo;overflow:hidden;position:absolute;left:0;}
		.text1{width:100%;margin-top:10px;color:#333;font-size:16px;}
		.text1 a{color:#fd6411;font-size:12px;}
      </style>
  </head>
  
  <body>
    <div id="message">
		<%--<p><img style = "width:800px;height:300px;" src="<%=basePath %>/images/futian/error.jpg"/></p>--%>
        <p class="text1">当前页面出现故障， <a href="javascript:history.go(-1)"><font size = "4">点击返回上一页</font></a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
        
		 <p class="text1">若有疑问请联系我们的工程师进行解决...<br/>
  	</div>
  </body>
</html>

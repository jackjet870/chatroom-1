<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String userId = (String) session.getAttribute("userId");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>主面板</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript">
        var basePath = '<%=basePath %>';
        var userId = '<%=userId%>';
    </script>
    <script src="<%=basePath %>/js/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/js/layui/css/layui.css" media="all"/>
</head>
<body>

</body>
</html>
<script type="text/javascript" src="<%=basePath %>/js/main.js"></script>

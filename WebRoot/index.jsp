<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登陆界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript">
        var basePath = '<%=basePath %>';
    </script>
    <script src="<%=basePath %>/js/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/js/layui/css/layui.css" media="all"/>
    <script src="<%=basePath %>/js/jquery/jquery-1.8.0.min.js"></script>

</head>
<body>

<div style="margin: 0 auto;width: 400px;height: 200px;padding-top: 200px;">

    <form class="layui-form" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" id="email" name="email" lay-verify="email" required lay-verify="required"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="loginBtn">立即登陆</button>
                <span style="padding-left: 20px;">
                    <a href="javascript:registerUser()">注册</a>
                </span>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript" src="<%=basePath %>/js/index.js"></script>
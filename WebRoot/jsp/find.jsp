<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>发现</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/js/layui/css/layui.css" media="all"/>
</head>
<body>
<%--
    查找界面的宽高度需要到源码layim.js中去修改
    //修改这段代码
    find: function () {
            return t.close(ei.find.index), ei.find.index = t.open({
                type: 2,
                title: "查找",
                shade: !1,
                maxmin: !0,
                area: ["600px", "280px"],//find界面的宽度和高度
                skin: "layui-box layui-layer-border",
                resize: !1,
                content: j.base.find
            })
        }
--%>
<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this">添加好友</li>
        <li>添加群组</li>
    </ul>
    <div class="layui-tab-content" style="height: 150px;">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">请输入你要添加的好友邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" lay-verify="email" autocomplete="off" placeholder="请输入好友邮箱"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="sub_1">立即添加</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-tab-item">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">请输入你要添加的群号</label>
                    <div class="layui-input-block">
                        <input type="text" name="chatGroupId" lay-verify="number" autocomplete="off" placeholder="请输入群号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="sub_2">立即添加</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="<%=basePath %>/js/layui/layui.js"></script>
<script>

    layui.use('element', function () {
        var $ = layui.jquery;
        //Tab的切换功能，切换事件监听等，需要依赖element模块
        var element = layui.element();
    });

    layui.use('form', function () {
        var form = layui.form();
        //监听提交
        form.on('submit(sub_1)', function (data) {
            $.ajax({
                url: basePath + 'user/findUser.action',
                type: 'post',
                data: {
                    "email": data.field.email
                },
                dataType: 'json',
                success: function (data) {
                    //查询到好友相关信息后,发起添加请求
                    if (data != "falied") {
                        layui.use('layim', function (layim) {
                            //添加好友面板
                            layim.add({
                                type: 'friend', //friend：申请加好友、group：申请加群
                                username: data.userName, //好友昵称，若申请加群，参数为：groupname
                                avatar: data.avatar, //头像
                                submit: function (group, remark, index) { //一般在此执行Ajax和WS，以通知对方
                                    console.log(group); //获取选择的好友分组ID，若为添加群，则不返回值
                                    console.log(remark); //获取附加信息
                                    layer.close(index); //关闭改面板
                                }
                            });
                        });

                    } else {
                        layer.msg("未查找到该好友相关信息!");
                    }
                }
            });
            //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            return false;
        });

        form.on('submit(sub_2)', function (data) {
            $.ajax({
//                url: basePath + 'user/saveUser.action',
                type: 'post',
                data: {
                    "email": data.field.email
                },
                dataType: 'text',
                success: function (data) {
                    if (data != "falied") {

                    } else {
                        layer.msg("未查找到该群组相关信息!");
                    }
                }
            });
            //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            return false;
        });
    });

</script>
</body>
</html>

/**
 *描述: 登陆验证
 *作者: leeyom
 *时间: 2017-02-04 02:33
 */
layui.use('form', function () {
    var form = layui.form();
    form.on('submit(loginBtn)', function (data) {
        $.ajax({
            url: basePath + 'user/login.action',
            type: 'post',
            data: {
                "email": data.field.email,
                "password": data.field.password
            },
            dataType: 'text',
            success: function (data) {
                if (data = "success") {
                    window.location.href = basePath + 'jsp/main.jsp';
                } else {
                    layer.msg("登陆失败!");
                }
            }
        });
        return false;
    });
});

/**
 *描述: 注册用户
 *作者: leeyom
 *时间: 2017-02-04 02:33
 */
function registerUser() {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            type: 2,
            content: basePath + 'jsp/register.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            title: '用户注册',
            area: ['800px', '500px']
        });
    });
}
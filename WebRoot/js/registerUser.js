/**
 *描述: 提交注册表单
 *作者: leeyom
 *时间: 2017-02-04 02:34
 */
layui.use('form', function () {
    var form = layui.form();
    //监听提交
    form.on('submit(formDemo)', function (data) {
        $.ajax({
            url: basePath + 'user/saveUser.action',
            type: 'post',
            data: {
                "name": data.field.name,
                "email": data.field.email,
                "password": data.field.password,
                "sign": data.field.sign
            },
            dataType: 'text',
            success: function (data) {
                if (data = "success") {
                    //layer的alert是非阻塞式的,需要采用事件回调的形式
                    layer.alert('注册成功!', function (index) {
                        layer.close(index);
                        //先得到当前iframe层的索引
                        var index2 = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index2);
                        return false;
                    });
                } else {
                    layer.msg("注册失败!");
                }
            }
        });
        //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        return false;
    });
});


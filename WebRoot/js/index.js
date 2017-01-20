function  registerUser(){
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.open({
            type: 2,
            content: basePath+'jsp/register.jsp', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            title: '用户注册',
            area:  ['800px', '500px']
        });
    });
}
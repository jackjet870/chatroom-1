/**
 * Created by leeyom on 17/1/18.
 */
layui.use('layim', function (layim) {
    //先来个客服模式压压精
    layim.config({
        brief: false, //是否简约模式（如果true则不显示主面板）
        title:'我的LayMI',
        init: {
            url: basePath+'data/init.json' //接口地址
            ,type: 'get' //默认get，一般可不填
            ,data: {} //额外参数
        },
        members: {
            url: basePath+'data/member.json'
            ,data: {}
        }
    }).chat({
        name: '客服姐姐',
        type: 'kefu',
        avatar: 'http://tp1.sinaimg.cn/5619439268/180/40030060651/1',
        id: -2
    });
});
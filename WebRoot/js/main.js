layui.use('layim', function (layim) {
    //初始化面板
    layim.config({
        //是否简约模式（如果true则不显示主面板）
        brief: false,
        title:'我的LayMI',
        //初始化我的信息、好友列表、群组列表
        init: {
            //接口地址
            url: basePath+'panel/initPanel.action',
            //默认get，一般可不填
            type: 'get',
            //额外参数(用户id)
            data: {
                'userId':userId
            }
        }
    })
});
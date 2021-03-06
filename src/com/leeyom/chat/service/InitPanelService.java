package com.leeyom.chat.service;

import com.leeyom.chat.domain.InitPanel;

/**
 * 描述: 初始化面板
 * author:leeyom
 * Date: 17/1/19
 */
public interface InitPanelService {
    public void saveOrUpdate(InitPanel initPanel);

    /**
     * 描述: 根据id获取面板信息
     * 作者: leeyom
     * 时间: 2017-02-04 09:06
     */
    InitPanel getInitPanelById(int initPanelId);
}

package com.leeyom.chat.service;

import com.leeyom.chat.domain.PanalData;

/**
 * 描述: 面板数据
 * author:leeyom
 * Date: 17/1/19
 */
public interface PanalDataService {
    /**
     * 描述: 保存面板数据
     * 作者: leeyom
     * 时间: 2017-01-19 11:37
     */
    void saveOrUpdatePanalData(PanalData panalData);

    /**
     * 描述: 获取面板数据
     * 作者: leeyom
     * 时间: 2017-02-04 09:13
     */
    PanalData getPanalDataById(int panalDataId);
}

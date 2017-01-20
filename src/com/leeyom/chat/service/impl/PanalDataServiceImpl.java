package com.leeyom.chat.service.impl;

import com.leeyom.chat.dao.PanalDataDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.service.PanalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述: 面板数据
 * author:leeyom
 * Date: 17/1/19
 */
@Service
@Transactional
public class PanalDataServiceImpl implements PanalDataService {

    @Resource
    private PanalDataDao panalDataDao;

    /**
     * 描述: 保存面板数据
     * 作者: leeyom
     * 时间: 2017-01-19 11:37
     *
     * @param panalData
     */
    @Override
    public void saveOrUpdatePanalData(PanalData panalData) {
        panalDataDao.saveOrUpdatePanalData(panalData);
    }
}

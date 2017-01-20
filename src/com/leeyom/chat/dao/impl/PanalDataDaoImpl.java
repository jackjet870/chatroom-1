package com.leeyom.chat.dao.impl;

import com.leeyom.chat.common.BaseServiceSupport;
import com.leeyom.chat.dao.PanalDataDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.service.PanalDataService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * author:leeyom
 * Date: 17/1/19
 */
@Repository
public class PanalDataDaoImpl extends BaseServiceSupport implements PanalDataDao{

    /**
     * 描述: 保存面板数据
     * 作者: leeyom
     * 时间: 2017-01-19 11:38
     * @param panalData
     */
    @Override
    public void saveOrUpdatePanalData(PanalData panalData) {
        try {
            dao.saveOrUpdate(panalData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

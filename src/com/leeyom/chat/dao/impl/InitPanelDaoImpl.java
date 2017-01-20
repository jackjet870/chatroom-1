package com.leeyom.chat.dao.impl;

import com.leeyom.chat.common.BaseServiceSupport;
import com.leeyom.chat.dao.InitPanelDao;
import com.leeyom.chat.domain.InitPanel;
import com.leeyom.chat.domain.PanalData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * author:leeyom
 * Date: 17/1/19
 */
@Repository
public class InitPanelDaoImpl extends BaseServiceSupport implements InitPanelDao {


    @Override
    public void saveOrUpdateInitPanel(InitPanel initPanel) {
        try {
            dao.saveOrUpdate(initPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

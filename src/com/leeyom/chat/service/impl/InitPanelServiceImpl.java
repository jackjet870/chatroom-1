package com.leeyom.chat.service.impl;

import com.leeyom.chat.dao.InitPanelDao;
import com.leeyom.chat.domain.InitPanel;
import com.leeyom.chat.service.InitPanelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述: 初始化面板
 * author:leeyom
 * Date: 17/1/19
 */
@Service
@Transactional
public class InitPanelServiceImpl implements InitPanelService{

    @Resource
    private InitPanelDao initPanelDao;

    @Override
    public void saveOrUpdate(InitPanel initPanel) {
        initPanelDao.saveOrUpdateInitPanel(initPanel);
    }

    @Override
    public InitPanel getInitPanelById(int initPanelId) {

        String hql = "from InitPanel i where i.id = ?";
        return initPanelDao.getInitPanelById(hql,new Object[]{initPanelId});
    }
}

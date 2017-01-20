package com.leeyom.chat.dao.impl;

import com.leeyom.chat.base.BaseDaoImpl;
import com.leeyom.chat.common.BaseServiceSupport;
import com.leeyom.chat.dao.UserDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl extends BaseServiceSupport implements UserDao {

    /**
     * 描述: 保存或更新用户信息
     * 作者: leeyom
     * 时间: 2017-01-19 11:22
     */
    @Override
    public void saveOrUpdate(User user) {
        try {
            dao.saveOrUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

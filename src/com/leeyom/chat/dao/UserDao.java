package com.leeyom.chat.dao;

import com.leeyom.chat.base.BaseDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;


public interface UserDao {
    /**
     * 描述: 保存或更新用户信息
     * 作者: leeyom
     * 时间: 2017-01-19 11:22
     */
    public void saveOrUpdate(User user);
}

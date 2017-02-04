package com.leeyom.chat.dao;

import com.leeyom.chat.base.BaseDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;


public interface UserDao {

    public void saveOrUpdate(User user);

    User getUserInfoByEmailAndPassword(String hql, Object[] objects);
}

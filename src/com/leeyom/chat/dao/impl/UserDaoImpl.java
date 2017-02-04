package com.leeyom.chat.dao.impl;

import com.leeyom.chat.base.BaseDaoImpl;
import com.leeyom.chat.common.BaseServiceSupport;
import com.leeyom.chat.dao.UserDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseServiceSupport implements UserDao {

    @Override
    public void saveOrUpdate(User user) {
        try {
            dao.saveOrUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserInfoByEmailAndPassword(String hql, Object[] objects) {
        try {
            List<User> users = dao.getList(hql,objects);
            if (users.size()>0){
                return users.get(0);
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}

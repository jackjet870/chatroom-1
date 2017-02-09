package com.leeyom.chat.service.impl;

import com.leeyom.chat.base.BaseDaoImpl;
import com.leeyom.chat.dao.UserDao;
import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;
import com.leeyom.chat.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    /**
     * 描述: 保存或更新用户信息
     * 作者: leeyom
     * 时间: 2017-01-19 11:27
     */
    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    /**
     * 描述:获取用户信息
     * 作者: leeyom
     * 时间: 2017-02-04 03:26
     */
    @Override
    public User getUserInfoByEmailAndPassword(String email, String password) {

        String hql = "from User u where u.email = ? and u.password = ?";
        User user = userDao.getUserInfoByEmailAndPassword(hql,new Object[]{email,password});
        return user;
    }

    /**
     * 描述: 根据id获取用户信息
     * 作者: leeyom
     * 时间: 2017-02-04 08:57
     *
     * @param userId
     */
    @Override
    public User getUserInfoById(int userId) {
        String hql = "from User u where u.id = ?";
        return userDao.getUserInfoById(hql,new Object[]{userId});
    }
}

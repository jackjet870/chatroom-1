package com.leeyom.chat.service;


import com.leeyom.chat.domain.PanalData;
import com.leeyom.chat.domain.User;

public interface UserService {
    /**
     * 描述: 保存或更新用户信息
     * 作者: leeyom
     * 时间: 2017-01-19 11:27
     */
    public void saveOrUpdate(User user);

    /**
     * 描述: 获取用户信息
     * 作者: leeyom
     * 时间: 2017-02-04 03:26
     */
    User getUserInfoByEmailAndPassword(String email, String password);

    /**
     * 描述: 根据id获取用户信息
     * 作者: leeyom
     * 时间: 2017-02-04 08:57
     */
    User getUserInfoById(int userId);
}

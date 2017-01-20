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
}

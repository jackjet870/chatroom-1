package com.leeyom.chat.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 基础服务提供类
 * @author leeyom
 *
 */
public class BaseServiceSupport {
    @Resource
    protected DaoSupport dao;

	protected Logger log = LogManager.getLogger(getClass());

//	public void setDao(DaoSupport dao) {
//		this.dao = dao;
//	}
}

package com.leeyom.chat.base;

import org.junit.Test;

import com.leeyom.chat.dao.UserDao;
import com.leeyom.chat.dao.impl.UserDaoImpl;


public class BaseDaoTest {

	@Test
	public void testSave() {
		UserDao userDao = new UserDaoImpl();
	}

}

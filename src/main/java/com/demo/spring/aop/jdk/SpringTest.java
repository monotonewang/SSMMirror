package com.demo.spring.aop.jdk;

import org.junit.Test;

public class SpringTest {
	
	@Test
	public void demo1(){
		UserDao userDao = new UserDaoImpl();
		userDao.add();
		userDao.update();
	}
	
	@Test
	public void demo2(){
		// 被代理对象
		UserDao userDao = new UserDaoImpl();
		// 创建代理对象的时候传入被代理对象.
		UserDao proxy = new JDKProxy(userDao).createProxy();
		proxy.add();
		proxy.update();
	}
}

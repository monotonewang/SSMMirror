package com.demo.spring.aop.autoproxy.aspects.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 7 on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContextAspects.xml")
public class SpringTest {

	@Autowired
	@Qualifier("productDaoXML")
	private ProductDao productDao;

	@Test
	public void demo1() {
		productDao.add();
		productDao.delete();
		productDao.update();
		productDao.find();
	}
}

package com.demo.spring.aop.spring.point;

import com.demo.spring.aop.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 7 on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class SpringTest {

	@Resource(name = "orderDaoProxy")
	private OrderDao orderDao;

	@Test
	public void demo1() {
		orderDao.add();
		orderDao.delete();
		orderDao.update();
		orderDao.select();
	}
}

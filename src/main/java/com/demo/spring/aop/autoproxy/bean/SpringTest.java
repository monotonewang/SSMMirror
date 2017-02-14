package com.demo.spring.aop.autoproxy.bean;


import com.demo.spring.aop.OrderDao;
import com.demo.spring.bean.xmlorAnno.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wang on 17-1-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/applicationContext.xml")
public class SpringTest {

    @Autowired
    @Qualifier("orderDaoauto")
    public OrderDao orderDao;

    @Autowired
    @Qualifier("customerDaoauto")
    public CustomerDao customerDao;

    @Test
    public void demo1(){
		orderDao.add();
		orderDao.delete();

//		customerDao.update();
    }
}

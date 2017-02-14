package com.demo.spring.aop.autoproxy.aspects.annoation;


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
@ContextConfiguration("classpath:spring/applicationContextAspects.xml")
public class SprintTest {

    @Autowired
    @Qualifier("userDaoAspect")
    private UserDao userDao;

    @Test
    public void demo1(){
        userDao.add();
        userDao.delete();
    }
}

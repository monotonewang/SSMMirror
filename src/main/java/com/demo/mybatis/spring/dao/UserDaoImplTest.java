package com.demo.mybatis.spring.dao;

import com.demo.mybatis.spring.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WangTest on 2017/2/7.
 */
public class UserDaoImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp(){
        //创建spring容器
        applicationContext=new ClassPathXmlApplicationContext("mybatis/spring/applicationContextMyBatis.xml");
    }
    @Test
    public void testFindUserbyId(){
        UserDao userDao = (UserDao) applicationContext.getBean("myUserDao");
        User userById = userDao.findUserById(1);
        System.out.println(userById);
    }
}

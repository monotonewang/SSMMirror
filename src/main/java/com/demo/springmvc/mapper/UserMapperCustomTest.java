package com.demo.springmvc.mapper;

import com.demo.springmvc.po.ItemCustom;
import com.demo.springmvc.po.User;
import com.demo.springmvc.po.UserExample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dell on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc/applicationContext-Dao.xml")
public class UserMapperCustomTest {


    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        // 创建spring容器
        applicationContext = new ClassPathXmlApplicationContext("springmvc/applicationContext-Dao.xml");
    }

    @Test
    public void testFindUserById() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        List<User> itemsList = userMapper.selectByExample(new UserExample());
        System.out.println(itemsList);

    }

}


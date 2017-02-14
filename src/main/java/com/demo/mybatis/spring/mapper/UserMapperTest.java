package com.demo.mybatis.spring.mapper;

import com.demo.mybatis.spring.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/2/8.
 */
public class UserMapperTest {
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		// 创建spring容器
		applicationContext = new ClassPathXmlApplicationContext("mybatis/spring/applicationContextMyBatis.xml");

	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user  = userMapper.findUserById(1);
		System.out.println(user);
	}

}

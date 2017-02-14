package com.demo.mybatis.pagehelper;


import com.demo.mybatis.pagehelper.dao.UserDaoImpl;
import com.demo.mybatis.pagehelper.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 7 on 2017/2/8.
 */
public class PageHelperTest {
	private SqlSession sqlSession;

	@Before
	public void setUp() throws IOException {
		//配置全局的mybatis-config.xml
		String resource = "mybatis-config.xml";
		//获取输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSession = sqlSessionFactory.openSession();
	}

	@Test
	public void testPagerHelper() throws Exception {
		PageHelper.startPage(3, 3);
		UserDaoImpl userDao = new UserDaoImpl(sqlSession);
		List<User> list = userDao.findAllUser();
		System.out.println(list);
		PageInfo<User> userPageInfo = new PageInfo<User>(list);

		System.out.println(userPageInfo.getPageNum());
		System.out.println(userPageInfo.getPageSize());
		System.out.println(userPageInfo.getStartRow());
		System.out.println(userPageInfo);
	}
}

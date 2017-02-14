package com.demo.mybatis.dao;

import com.demo.mybatis.mapper.mapper.UserMapper;
import com.demo.mybatis.mapper.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/1/18.
 */
public class UserDaoImplTest {

	private SqlSession sqlSession;
	private UserMapper mapper;
	private UserDao userDao;

	@Before
	public void setUp() throws IOException {
		//配置全局的mybatis-config.xml
		String resource = "mybatis-config.xml";
		//获取输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSession = sqlSessionFactory.openSession();
		userDao = new UserDaoImpl(sqlSession);
	}

	@Test
	public void selectCount() throws Exception {
		Integer integer = userDao.selectCount();
		System.out.println(integer);
	}

	@Test
	public void queryUserById() throws Exception {
		int id = 1;
		User user = userDao.queryUserById(id);
		System.out.println(user);
	}

	@Test
	public List<User> findAllUser() throws Exception {
		List<User> users = userDao.findAllUser();
		System.out.println(users);
		return users;
	}

	@Test
	public void addUser() throws Exception {
		//Date date = new Date();
		//SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
		//String format = simpleDateFormat.format(date);
		//System.out.println(format);
		User user = new User(null, "zhangsan", new Date(), "1", "xi'an");
		int res = userDao.addUser(user);
		System.out.println(res);
	}

	@Test
	public void updateUser() throws Exception {
		User user = new User(null, "zhangsan", new Date(), "1", "xx");
		int res = userDao.updateUser(user);
		System.out.println(res);
	}

	@Test
	public void deleteUserById() throws Exception {
		int id = 1;
		int res = userDao.deleteUserById(id);
		System.out.println(res);
	}

}
package com.demo.mybatis.mapper;

import com.demo.mybatis.dao.UserDao;
import com.demo.mybatis.mapper.mapper.UserMapper;
import com.demo.mybatis.mapper.pojo.User;
import com.demo.mybatis.mapper.pojo.UserCustom;
import com.demo.mybatis.mapper.pojo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/1/23.
 */
public class UserMapperTest {

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
	}

	@Test
	public void selectCount() throws Exception {
		//创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int i = mapper.selectCount();
		System.out.println(i);
	}

	@Test
	public void findUserById() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(10);
		System.out.println(user);
	}

	//	select * from user where username like '%小明%'
	//模糊查询
	@Test
	public void findUserByName() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		List<User> userByName = mapper.findUserByName("%小明%");
		List<User> userByName = mapper.findUserByName("小明");//使用sql拼接
		System.out.println(userByName);
	}

	@Test
	public void findAllUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.findAllUser();
		System.out.println(users);
	}

	//mybatis 不会自动提交
	@Test
	public void insertUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.insertUser(new User(null, "mapperzhangsan", new Date(), "1", "上海浦东新区"));
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void insertUser1() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(null, "zsinsert1", new Date(), "1", "北京");
		int res = mapper.insertUser1(user);
		System.out.println(user.getId());//获取主键
		sqlSession.commit();
		sqlSession.close();
	}

	// 有外键关联的时候删除会出错
	@Test
	public void deleteUserById() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int id = 2;
		mapper.deleteUserById(id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 有外键关联的时候删除会出错
	@Test
	public void updateUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(10, "updateUser", new Date(), "1", "西安");
		mapper.updateUser(user);//传入一个user对象
		sqlSession.commit();//需要提交事务
		sqlSession.close();
	}

	//通过包装类查询用户信息
	@Test
	public void findUserList() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//把对象传递过去，
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);

		List<User> userList = mapper.findUserList(userQueryVo);

		sqlSession.close();

		System.out.println(userList);
	}

	//自定义简单查询条件，返回查询记录个数，通常使用于实现查询分页
	@Test
	public void findUserCount() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//把对象传递过去，
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);

		int res = mapper.findUserCount(userQueryVo);

		sqlSession.close();

		System.out.println(res);
	}

	//查询属性映射
	@Test
	public void findAllResultMap() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.findAllResultMap();
		sqlSession.close();
		System.out.println(users);
	}

	//动态Sql
	@Test
	public void dynamicFindUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		//把对象传递过去，
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
//		userCustom.setSex("1");
		userCustom.setUsername("小明");

		//foreach
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(22);
		userQueryVo.setIds(ids);

		userQueryVo.setUserCustom(userCustom);

		List<User> users = mapper.dynamicFindUser(userQueryVo);
		sqlSession.close();
		System.out.println(users);

	}

	//动态sql查询数量
	@Test
	public void dynamicFindCount() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//把对象传递过去，
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
//		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		int res = mapper.dynamicFindCount(userQueryVo);
		sqlSession.close();
		System.out.println(res);
	}


}

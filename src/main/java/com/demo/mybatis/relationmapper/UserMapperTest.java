package com.demo.mybatis.relationmapper;

import com.demo.mybatis.dao.UserDao;
import com.demo.mybatis.relationmapper.mapper.UserMapper;
import com.demo.mybatis.relationmapper.po.Orders;
import com.demo.mybatis.relationmapper.po.User;
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
 * Created by 7 on 2017/2/6.
 */
public class UserMapperTest {
	private SqlSession sqlSession;
	private UserMapper mapper;
	private UserDao userDao;
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		//配置全局的mybatis-config.xml
		String resource = "mybatis-config.xml";
		//获取输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构建sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSession = sqlSessionFactory.openSession();
	}

	//测试一级缓存：条件一：同一个sqlSession,相同的sql和参数
	@Test
	public void testLevelOneCache() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.testLevelOneCache(1);
		System.out.println(users);

		List<User> users1 = mapper.testLevelOneCache(1);
		System.out.println(users1);
	}

	//测试一级缓存：条件一：同一个sqlSession,相同的sql和参数
	@Test
	public void testLevelOneNoCache() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.testLevelOneCache(1);
		System.out.println(users);

		sqlSession.clearCache();//清除一级缓存
		List<User> users1 = mapper.testLevelOneCache(1);
		System.out.println(users1);
	}

	//当事务发生，缓存会该表，执行update,delete,insert语句时候，会刷新缓存
	@Test
	public void testCacheOne() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User users = mapper.testUpdateCache(1);
		System.out.println(users);

		User users1 = mapper.testUpdateCache(1);//带缓存的查询
		System.out.println(users1);

		//修改数据
		users1.setUsername("李四");
		mapper.updateUser(users1);
		sqlSession.commit();
		//重新查询会刷新缓存
		User userUpdate = mapper.testUpdateCache(1);
		System.out.println("userUpdate=" + userUpdate);
	}

	//测试二级缓存
	//Cache Hit Ration 0.5
	@Test
	public void testCacheTwo() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();

		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

		User user = mapper1.testUpdateCache(1);
		System.out.println("firstfind" + user);
		sqlSession1.close();
		//修改数据 如果flushCache设置成false，会照成脏读
		//所以，二级缓存对细粒度的控制弱
		user.setUsername("zs");
		mapper2.updateUser(user);
		sqlSession2.commit();

		User user1 = mapper2.testUpdateCache(1);
		System.out.println("refind" + user1);
		sqlSession2.close();
	}

	@Test
	public void testLazyLoading1() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		User user = mapper.lazyLoading("1000011");
		User user = mapper.lazyLoading1("1000011");
		System.out.println(user);
		user.getId();
		System.out.println(user.getId());

	}
	//<!--select orders.*,(select user.username from user where user.id=orders.user_id) username from orders-->
	@Test
	public void lazyLoadingTest2(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Orders> user = mapper.lazyLoadingTest2();
		System.out.println(user);
		for (Orders orders:user){
			User user1 = user.get(0).getUser();
			System.out.println(user1);
		}

	}
}

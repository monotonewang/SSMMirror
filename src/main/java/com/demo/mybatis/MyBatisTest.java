package com.demo.mybatis;

import com.demo.mybatis.mapper.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 7 on 2017/1/17.
 */
public class MyBatisTest {

	//每个MyBatis应用程序主要都是使用SqlSessionFactory实例的，
	// 一个SqlSessionFactory实例可以通过SqlSessionFactoryBuilder获得。
	// SqlSessionFactoryBuilder可以从一个xml配置文件或者一个预定义的配置类的实例获得。
	@Test
	public void demo1() throws IOException, CloneNotSupportedException {
		//配置全局的mybatis-config.xml
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		System.out.println(sqlSessionFactory);

		//创建一个sqlSession,用来操作数据库，进行数据的CRUD操作
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		/**
		 * 	1.mapper.xml文件必须配置mybatis-config.xml文件里
		 *	2.mapper.xml里面的namespace必须等于abc
		 *	3.mapper.xml里面必须有相应的<select id="seclctUser">标签
		 */
		User user = sqlSession.selectOne("user.selectUser", 1);
		System.out.println(user);
		sqlSession.close();
	}

}

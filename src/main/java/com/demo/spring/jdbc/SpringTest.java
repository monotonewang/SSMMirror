package com.demo.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wang on 17-1-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContextjdbc.xml")
public class SpringTest {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	/**
	 * 利用Spring默认的连接池
	 */
	@Test
	public void demo1() {
		//创建链接
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jdbctest?characterEncoding=utf8&amp;useSSL=true&amp;generateSimpleParameterMetadata=true");
		dataSource.setUsername("root");
		dataSource.setPassword("0");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("CREATE TABLE USERSpring  (id int PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR (20))");
	}

	/**
	 * 配置Spring默认的连接池
	 */
	@Test
	public void demo2() {
//		jdbcTemplate.execute("DROP TABLE IF EXISTS USERSpring ");
        jdbcTemplate.execute("CREATE TABLE USERSpring  (id int PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR (20))");
	}

}

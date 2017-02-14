package com.demo.spring.jdbc.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 7 on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContextjdbc.xml")
public class SpringTest {

	@Autowired
	@Qualifier("userDaoJdbc")
	private UserDao userDao;

	@Test
	public void add(){
		User user=new User();
		user.setName("zhangsan");
		userDao.add(user);
	}

	@Test
	public void delete(){
		int delete = userDao.delete(2);
//		System.out.println(delete);
	}

	@Test
	public void update(){
		User user=new User();
		user.setName("xxxx");
		user.setId(3);
		userDao.update(user);
	}

	@Test
	public void findByCount(){
		int i = userDao.fingByCount();
		System.out.println("count="+i);
	}

	@Test
	public void findByList(){
		List<User> byList = userDao.findByList();
		System.out.println(byList);
	}

	@Test
	public void test(){
		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
		}
		/*python
		for x in xrange(1000000):
		print x*/
	}
}

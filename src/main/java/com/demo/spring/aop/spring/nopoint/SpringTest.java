package com.demo.spring.aop.spring.nopoint;

import com.demo.spring.aop.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 7 on 2017/1/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/applicationContext.xml")
public class SpringTest {

//	@Autowired
//	@Qualifier("customerDaoAopProxy")
	@Resource(name = "customerDaoAopProxy")
	private CustomerDao customerDao;


	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
		customerDao.update();
		customerDao.select();
	}

}

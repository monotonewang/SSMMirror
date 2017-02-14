package com.demo.spring.bean.life;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/1/12.
 */
public class SpringTest {
	//测试bean的生命周期
	@Test
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
//		System.out.println(customerService);
		customerService.add();
		customerService.find();
		applicationContext.close();
	}

	public void demo2() {

	}

}

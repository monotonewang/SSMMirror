package com.demo.spring.bean.xmlorAnno;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/1/13.
 */
public class SpringTest {

	//属性使用注解，类使用xml
	@Test
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService2");
		System.out.println(customerService);
	}
}

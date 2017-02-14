package com.demo.spring.bean.config;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/1/13.
 */
public class SpringTest {
	@Test
	public void demo1(){

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Car car = (Car) context.getBean("configcar");
		System.out.println(car);
	}
}

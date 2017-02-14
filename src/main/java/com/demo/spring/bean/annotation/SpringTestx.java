package com.demo.spring.bean.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by 7 on 2017/1/12.
 */
public class SpringTestx {

	//使用注解-属性注入
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserService service= (UserService) applicationContext.getBean("annoationService");
		System.out.println(service);
		service.sayHello();
	}

}

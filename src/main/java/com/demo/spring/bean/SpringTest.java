package com.demo.spring.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/1/12.
 */
public class SpringTest {

	// 无参数的构造方法的实例化
	@Test
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		System.out.println(bean1);
	}

	//静态工厂实例化
	@Test
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
		System.out.println(bean2);
	}

	//实例化工厂
	@Test
	public void demo3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
		System.out.println(bean3);
	}

}

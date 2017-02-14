package com.demo.spring.basic;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class SpringTest {

	@Test
	// 传统方式
	public void demo1() {
		// 造成程序紧密耦合.
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello();
	}

	@Test
	// Spring开发--自己不用去创建对象，
	// IOC:控制反转:将对象的创建权,由Spring管理.
	// DI:依赖注入:在Spring创建对象的过程中,把对象依赖的属性注入到类中.
	public void demo2() {
		// 创建一个工厂类.
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("helloService");
		helloService.sayHello();
	}

	@Test
	// 加载磁盘路径下的配置文件:
	//采用绝对路径的话，程序的灵活性就很差了，所以这个方法一般不推荐
	public void demo3() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"spring/applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("helloService");
		helloService.sayHello();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void demo4(){
		// ClassPathResource  FileSystemResource
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring/applicationContext.xml"));
		HelloService helloService = (HelloService) beanFactory.getBean("userService");
		helloService.sayHello();
	}

}

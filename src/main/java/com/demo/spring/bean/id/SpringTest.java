package com.demo.spring.bean.id;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用范围
 *
 * 
 */
public class SpringTest {

	@Test
	// 测试Scope--c1和c2的地址是一样的，只被实例化一次。
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		Customer c1 = (Customer) applicationContext.getBean("customer");
		System.out.println(c1);
		
		Customer c2 = (Customer) applicationContext.getBean("customer");
		System.out.println(c2);
	}
	
	@Test
	// 测试初始化和销毁的方法
	// 执行销毁的时候,必须手动关闭工厂,而且只对scope=”singleton”有效.
	public void demo2(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		Product p1 = (Product) applicationContext.getBean("product");
		System.out.println(p1);
		applicationContext.close();//消耗方法。
	}
}

package com.demo.spring.bean.property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 7 on 2017/1/12.
 */
public class SpringTest {

	//通过构造器注入属性
	@Test
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Car car= (Car) applicationContext.getBean("car");
		System.out.println(car);
	}

	//通过setter方法注入属性
	@Test
	public void demo2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Car2 car2= (Car2) applicationContext.getBean("car2");
		Person person= (Person) applicationContext.getBean("person");
		System.out.println(person);
	}

	//集合注入
	@Test
	public void demo3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		CollectionBean collectionBean= (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}

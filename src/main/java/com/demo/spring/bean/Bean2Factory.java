package com.demo.spring.bean;

/**
 * Created by 7 on 2017/1/12.
 */
public class Bean2Factory {
	public static Bean2 getBean2(){
		System.out.println("静态工厂的获得Bean2的方法...");
		return new Bean2();
	}
}

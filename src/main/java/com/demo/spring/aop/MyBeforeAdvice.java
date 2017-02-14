package com.demo.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 7 on 2017/1/16.
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		if(method.getName().equals("add"))
		System.out.println("执行增强");
	}
}

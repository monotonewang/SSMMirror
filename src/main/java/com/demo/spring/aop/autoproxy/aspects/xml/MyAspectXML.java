package com.demo.spring.aop.autoproxy.aspects.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by 7 on 2017/1/16.
 */
public class MyAspectXML {

	public void before() {
		System.out.println("前置增强");
	}

	public void afterReturing(Object returnVal) {
		System.out.println("后置通知。。返回值=" + returnVal);
	}

	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前增强....");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("环绕后增强....");
		return result;
	}

	public void afterThrowing(Throwable e) {
		System.out.println("异常通知..." + e.getMessage());
	}

	public void after() {
		System.out.println("最终通知....");
	}
}

package com.demo.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by 7 on 2017/1/16.
 */
//定义增强
public class MyAroundAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕前增强。。。");
		Object proceed = invocation.proceed();//执行目标对象的方法
		System.out.println("环绕后增强。。。");
		return proceed;
	}
}

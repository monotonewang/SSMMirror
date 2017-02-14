package com.demo.spring.aop.autoproxy.aspects.annoation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by wang on 17-1-15.
 */
@Aspect
public class MyAspect {

	@Before("execution(* com.demo.spring.aop.autoproxy.aspects.annoation.UserDao.add(..))")
	public void before() {
		System.out.println("AspectJ before");
	}

	@AfterReturning(value = "execution(* com.demo.spring.aop.autoproxy.aspects.annoation.UserDao.add(..))", returning = "returnVal")
	public void afterReturin(Object returnVal) {
		System.out.println("后置增强....方法的返回值:" + returnVal);
	}

	@Around(value = "com.demo.spring.aop.autoproxy.aspects.annoation.MyAspect.myPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前增强....");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("环绕后增强....");
		return obj;
	}

	@AfterThrowing(value = "com.demo.spring.aop.autoproxy.aspects.annoation.MyAspect.myPointcut()", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("不好了 出异常了!!!" + e.getMessage());
	}

	@After("com.demo.spring.aop.autoproxy.aspects.annoation.MyAspect.myPointcut()")
	public void after() {
		System.out.println("最终通知...");
	}

	@Pointcut("execution(* com.demo.spring.aop.autoproxy.aspects.annoation.UserDao.delete(..))")
	private void myPointcut() {
	}
}

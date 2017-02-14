package com.demo.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by 7 on 2017/1/12.
 */

//相当于<bean id="annoationService" class="com.demo.com.demo.spring.bean.annotation.UserService">
@Component("annoationService")
@Scope("prototype")
public class UserService {

	@Value(value = "hello")
	private String info;


//	@Qualifier
//	@Resource(name = "userDaox")
//	@Resource//对象注入
	@Autowired
	private UserDao userDao;

	public void sayHello() {
		userDao.sayUserDao();
		System.out.println("Hello Spring Annotation..." + info);
	}


	@PostConstruct
	public void init(){
		System.out.println("init");
	}

	@PreDestroy
	public void dd(){
		System.out.println("destory");
	}
}

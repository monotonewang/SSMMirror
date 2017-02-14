package com.demo.spring.aop.autoproxy.aspects.annoation;

/**
 * Created by 7 on 2017/1/16.
 */
public class UserDao {
	public int add(){

		System.out.println("add");
		return 100;
	}

	public void delete(){
//		int a=1/0;//异常
		System.out.println("delete");
	}
}

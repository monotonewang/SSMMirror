package com.demo.spring.bean.annotation;

import org.springframework.stereotype.Repository;

/**
 * Created by 7 on 2017/1/13.
 */
//这里的Repository 的userDao和类名一致，首字母小写
@Repository("userDao")
public class UserDao {
	public UserDao() {
		System.out.println("this is userDao");
	}
	String sayUserDao(){
		return "UserDao";
	}
}

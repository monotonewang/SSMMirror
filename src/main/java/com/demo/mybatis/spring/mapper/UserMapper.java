package com.demo.mybatis.spring.mapper;

import com.demo.mybatis.spring.pojo.User;

/**
 * Created by 7 on 2017/2/8.
 */
public interface UserMapper {
	//根据id查询用户信息
	User findUserById(int id);
}

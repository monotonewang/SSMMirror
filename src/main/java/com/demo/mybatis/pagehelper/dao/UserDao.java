package com.demo.mybatis.pagehelper.dao;

import com.demo.mybatis.pagehelper.pojo.User;

import java.util.List;

/**
 * Created by 7 on 2017/2/8.
 */
public interface UserDao {
	List<User> findAllUser();
}

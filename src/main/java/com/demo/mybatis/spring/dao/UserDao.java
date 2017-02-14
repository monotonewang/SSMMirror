package com.demo.mybatis.spring.dao;

import com.demo.mybatis.spring.pojo.User;

/**
 * Created by 7 on 2017/1/18.
 */
public interface UserDao {


	/**
	 * 根据id查询用户信息
	 *
	 * @param id
	 * @return
	 */
	User findUserById(int id);

}

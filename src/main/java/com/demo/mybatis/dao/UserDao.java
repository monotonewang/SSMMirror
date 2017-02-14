package com.demo.mybatis.dao;

import com.demo.mybatis.mapper.pojo.User;

import java.util.List;

/**
 * Created by 7 on 2017/1/18.
 */
public interface UserDao {

	/**
	 * 查询有多少条数据
	 *
	 * @return
	 */
	Integer selectCount();

	/**
	 * 根据id查询用户信息
	 *
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	List<User> findAllUser();

	/**
	 * 添加用户信息
	 *
	 * @param user
	 */
	int addUser(User user);

	/**
	 * 修改用户信息
	 * @param user
	 */
	int updateUser(User user);

	/**
	 * 根据id删除用户信息
	 * @param id
	 */
	int deleteUserById(int id);
}

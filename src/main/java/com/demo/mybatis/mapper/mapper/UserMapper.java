package com.demo.mybatis.mapper.mapper;

import com.demo.mybatis.mapper.pojo.User;
import com.demo.mybatis.mapper.pojo.UserQueryVo;

import java.util.List;

/**
 * Created by 7 on 2017/1/18.
 */
public interface UserMapper {
	int selectCount();

	User findUserById(int id);

	List<User> findUserByName(String name);

	List<User> findAllUser();

	void insertUser(User user);

	int insertUser1(User user);//返回主键

	void deleteUserById(int id);

	void updateUser(User user);

	List<User> findUserList(UserQueryVo userQueryVo);

	int findUserCount(UserQueryVo userQueryVo);

	List<User> findAllResultMap();

	List<User> dynamicFindUser(UserQueryVo userQueryVo);

	int dynamicFindCount(UserQueryVo userQueryVo);


}

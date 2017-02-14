package com.demo.mybatis.pagehelper.dao;

import com.demo.mybatis.pagehelper.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by 7 on 2017/2/8.
 */
public class UserDaoImpl {
	private SqlSession sqlSession;

	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<User> findAllUser() {
		return sqlSession.selectList("userDao.findAllUser");
	}
}
